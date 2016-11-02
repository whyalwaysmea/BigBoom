package com.whyalwaysmea.bigboom.http;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Long
 * on 2016/9/1.
 */
public class HttpMethods {
    private static OkHttpClient mOkHttpClient;
    private static final int DEFAULT_CACHE_SIZE = 1024 * 1024 * 20;
    private static final int DEFAULT_MAX_AGE = 60 * 60;
    private static final int DEFAULT_MAX_STALE_ONLINE = DEFAULT_MAX_AGE * 24;
    private static final int DEFAULT_MAX_STALE_OFFLINE = DEFAULT_MAX_AGE * 24 * 7;

    public static <T> T createService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }

    public static ApiManager createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(Constants.URL.MOVIE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        return apiManager;
    }

    public static OkHttpClient getOkHttpClient() {
        if(mOkHttpClient == null) {
            // 同步锁，在同一时刻只有一个线程执行
            synchronized (OkHttpClient.class) {
                File cacheFile = new File(App.getApplication().getCacheDir(), "responses");
                Cache cache = new Cache(cacheFile, DEFAULT_CACHE_SIZE);
                mOkHttpClient = new OkHttpClient.Builder()
                        .cache(cache)
                        .addInterceptor(REQUEST_INTERCEPTOR)
                        .addNetworkInterceptor(RESPONSE_INTERCEPTOR)
                        .addInterceptor(mLoggingInterceptor)
                        .build();
            }
        }
        return mOkHttpClient;
    }

    // use lambda
    private static final Interceptor REQUEST_INTERCEPTOR = chain -> {
        Request request = chain.request();
        CacheControl cacheControl = new CacheControl.Builder()
                .maxStale(5, TimeUnit.SECONDS)      //这个是控制缓存的过时时间
                .build();
        request = request.newBuilder()
                .cacheControl(cacheControl)
                .build();
        return chain.proceed(request);
    };

    // 针对那些服务器不支持缓存策略的情况下，使用强制修改响应头，达到缓存的效果
    // 响应拦截只不过是出于规范，向服务器发出请求，至于服务器搭不搭理我们我们不管他，我们在响应里面做手脚，有网没有情况下的缓存策略
    // common method
    private static final Interceptor RESPONSE_INTERCEPTOR = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                int maxAge;
                // 缓存数据
                // 控制缓存的最大生命时间
                if(!NetworkUtils.isConnected(App.getApplication())) {
                    maxAge = DEFAULT_MAX_STALE_OFFLINE;
                } else {
                    maxAge = DEFAULT_MAX_STALE_ONLINE;
                }
                return response.newBuilder()
                        .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            }
        };
    // 打印返回的json数据拦截器
    private static Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            final Request request = chain.request();
            KLog.e("URL",request.url().toString());

            final Response response = chain.proceed(request);

            final ResponseBody responseBody = response.body();
            final long contentLength = responseBody.contentLength();

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(charset);
                } catch (UnsupportedCharsetException e) {
                    KLog.e("");
                    KLog.e("Couldn't decode the response body; charset is likely malformed.");
                    return response;
                }
            }

            if (contentLength != 0) {
                KLog.v("--------------------------------------------开始打印返回数据----------------------------------------------------");
                KLog.json(buffer.clone().readString(charset));
                KLog.v("--------------------------------------------结束打印返回数据----------------------------------------------------");
            }

            return response;
        }
    };


}
