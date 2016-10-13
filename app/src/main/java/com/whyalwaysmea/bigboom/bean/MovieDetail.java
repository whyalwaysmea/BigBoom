package com.whyalwaysmea.bigboom.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Long
 * on 2016/10/13.
 */

public class MovieDetail {

    /**
     * aka : ["What's in the Darkness"]
     * alt : https://movie.douban.com/subject/26433966/
     * blooper_urls : []
     * bloopers : []
     * casts : [{"alt":"https://movie.douban.com/celebrity/1362252/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg"},"id":"1362252","name":"苏晓彤","name_en":""},{"alt":"https://movie.douban.com/celebrity/1362253/","avatars":{"large":"https://img1.doubanio.com/img/celebrity/large/1473845735.57.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1473845735.57.jpg","small":"https://img1.doubanio.com/img/celebrity/small/1473845735.57.jpg"},"id":"1362253","name":"郭笑","name_en":""},{"alt":"https://movie.douban.com/celebrity/1362254/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1473846076.82.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473846076.82.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1473846076.82.jpg"},"id":"1362254","name":"陆琦蔚","name_en":""},{"alt":"https://movie.douban.com/celebrity/1311659/","avatars":{"large":"https://img1.doubanio.com/img/celebrity/large/20368.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/20368.jpg","small":"https://img1.doubanio.com/img/celebrity/small/20368.jpg"},"id":"1311659","name":"刘丹","name_en":"Dan Liu"}]
     * clip_urls : []
     * clips : []
     * collect_count : 1259
     * comments_count : 691
     * countries : ["中国大陆"]
     * directors : [{"alt":"https://movie.douban.com/celebrity/1350900/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg"},"id":"1350900","name":"王一淳","name_en":"Yichun Wang"}]
     * douban_site :
     * durations : ["105分钟(公映版)","102分钟(导演版)","97分钟(电影节版)"]
     * genres : ["剧情","犯罪","悬疑"]
     * has_schedule : true
     * has_ticket : true
     * has_video : false
     * id : 26433966
     * images : {"large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2387538436.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2387538436.jpg","small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2387538436.jpg"}
     * languages : ["汉语普通话"]
     * mainland_pubdate : 2016-10-14
     * mobile_url : https://movie.douban.com/subject/26433966/mobile
     * original_title : 黑处有什么
     * photos : [{"alt":"https://movie.douban.com/photos/photo/2319111008/","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2319111008.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2319111008.jpg","id":"2319111008","image":"https://img1.doubanio.com/view/photo/photo/public/p2319111008.jpg","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2319111008.jpg"},{"alt":"https://movie.douban.com/photos/photo/2319110281/","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2319110281.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2319110281.jpg","id":"2319110281","image":"https://img3.doubanio.com/view/photo/photo/public/p2319110281.jpg","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2319110281.jpg"},{"alt":"https://movie.douban.com/photos/photo/2379701828/","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2379701828.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2379701828.jpg","id":"2379701828","image":"https://img1.doubanio.com/view/photo/photo/public/p2379701828.jpg","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2379701828.jpg"},{"alt":"https://movie.douban.com/photos/photo/2319111018/","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2319111018.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2319111018.jpg","id":"2319111018","image":"https://img1.doubanio.com/view/photo/photo/public/p2319111018.jpg","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2319111018.jpg"},{"alt":"https://movie.douban.com/photos/photo/2380652642/","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2380652642.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2380652642.jpg","id":"2380652642","image":"https://img3.doubanio.com/view/photo/photo/public/p2380652642.jpg","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2380652642.jpg"},{"alt":"https://movie.douban.com/photos/photo/2380652628/","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2380652628.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2380652628.jpg","id":"2380652628","image":"https://img1.doubanio.com/view/photo/photo/public/p2380652628.jpg","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2380652628.jpg"},{"alt":"https://movie.douban.com/photos/photo/2319111263/","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2319111263.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2319111263.jpg","id":"2319111263","image":"https://img3.doubanio.com/view/photo/photo/public/p2319111263.jpg","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2319111263.jpg"},{"alt":"https://movie.douban.com/photos/photo/2388895353/","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2388895353.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2388895353.jpg","id":"2388895353","image":"https://img3.doubanio.com/view/photo/photo/public/p2388895353.jpg","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2388895353.jpg"},{"alt":"https://movie.douban.com/photos/photo/2388895342/","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2388895342.jpg","icon":"https://img3.doubanio.com/view/photo/icon/public/p2388895342.jpg","id":"2388895342","image":"https://img3.doubanio.com/view/photo/photo/public/p2388895342.jpg","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2388895342.jpg"},{"alt":"https://movie.douban.com/photos/photo/2388895328/","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2388895328.jpg","icon":"https://img1.doubanio.com/view/photo/icon/public/p2388895328.jpg","id":"2388895328","image":"https://img1.doubanio.com/view/photo/photo/public/p2388895328.jpg","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2388895328.jpg"}]
     * photos_count : 82
     * popular_comments : [{"author":{"alt":"https://www.douban.com/people/ydyie/","avatar":"https://img1.doubanio.com/icon/u2126832-179.jpg","id":"2126832","name":"时间之葬","signature":"","uid":"ydyie"},"content":"窥见一个闭塞且无能的时代","created_at":"2015-10-20 19:27:18","id":"969738800","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","useful_count":7},{"author":{"alt":"https://www.douban.com/people/zntoborges/","avatar":"https://img3.doubanio.com/icon/u2905955-12.jpg","id":"2905955","name":"支离疏","signature":"铁罗汉，活金刚","uid":"zntoborges"},"content":"我个人非常喜欢，气质独特，但也有许多疑问。过几天会采访导演。","created_at":"2016-09-21 17:34:32","id":"1087727237","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","useful_count":17},{"author":{"alt":"https://www.douban.com/people/7542909/","avatar":"https://img3.doubanio.com/icon/u7542909-82.jpg","id":"7542909","name":"翻滚吧！蛋堡","signature":"谁要是再来害人定不饶他","uid":"7542909"},"content":"从女孩视角出发，对整个时代笼罩的压抑氛围作出展示，然而情感并未找到一个立足点，对主角成长的表述也过分暧昧模糊。","created_at":"2015-10-31 18:43:50","id":"972993894","rating":{"max":5,"min":0,"value":3},"subject_id":"26433966","useful_count":12},{"author":{"alt":"https://www.douban.com/people/shuixia1825/","avatar":"https://img1.doubanio.com/icon/u2673286-19.jpg","id":"2673286","name":"水怪","signature":"Help me,Bacchus","uid":"shuixia1825"},"content":"90年代的工厂社区版杀人回忆，远不止青春成长。全片弥漫着一个时代的性压抑以及温吞日常生活所掩盖的惊悚感。六七十年代赤色残余防空洞以及进行时人工湖所象征的犯罪现场也使得影片在更纵深的坐标体系中力度十足。","created_at":"2015-07-26 17:59:13","id":"944477817","rating":{"max":5,"min":0,"value":5},"subject_id":"26433966","useful_count":6}]
     * popular_reviews : [{"alt":"https://movie.douban.com/review/7782679/","author":{"alt":"https://www.douban.com/people/MovieL/","avatar":"https://img3.doubanio.com/icon/u1128221-91.jpg","id":"1128221","name":"木卫二","signature":"公众号：MOViE木卫","uid":"MovieL"},"id":"7782679","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"【Spoiler Alert ！ 以下内容有小部分的剧情泄露，可能影响观看】  《黑处有什么》 自然会被归入\u201c饱受《杀人回忆》影响的系列电影\u201d当中。  我当初都过于肯定地认为，原型事件在前的《十二宫》，它也是照着《杀人回...","title":"告诉你一个秘密"},{"alt":"https://movie.douban.com/review/7598219/","author":{"alt":"https://www.douban.com/people/darlingtudai/","avatar":"https://img3.doubanio.com/icon/u3571728-440.jpg","id":"3571728","name":"刘小黛","signature":"美酒醇妇庶几完满。","uid":"darlingtudai"},"id":"7598219","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"文/刘小黛 公众号：抛开书本  《黑处有什么》不是一部普通的青春片，一如它的片名，黑处有深意。影片在叙事中没有直面当时的现实政治环境，而以青春记忆来反思我们这个社会一些根深蒂固的意识形态和青春成长环境，暗...","title":"被遗忘的工厂记忆"},{"alt":"https://movie.douban.com/review/8123590/","author":{"alt":"https://www.douban.com/people/4026585/","avatar":"https://img3.doubanio.com/icon/u4026585-2.jpg","id":"4026585","name":"杀手里昂Leon","signature":"到目前为止，电影是我唯一的情人","uid":"4026585"},"id":"8123590","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"采访、文/杀手里昂 文章来源：《电影》杂志10月刊  《黑处有什么》的剧本写完之后，王一淳拿给别人看，喜欢的人挺多，但就是没人掏钱拍。于是狠了狠心自掏腰包，花了300万拍完了这部电影。去年的FIRST青年影展上，王...","title":"专访\u2016王一淳：如果你好奇\u201c白银杀人案\u201d，这部电影给你讲"},{"alt":"https://movie.douban.com/review/8108112/","author":{"alt":"https://www.douban.com/people/zhangfan187/","avatar":"https://img3.doubanio.com/icon/u59626068-3.jpg","id":"59626068","name":"搬砖侠","signature":"搬完砖就可以继续拯救地球了！","uid":"zhangfan187"},"id":"8108112","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"《黑处有什么》是青年导演王一淳自编自导的第一部作品，本片于2015年7月获得了西宁FIRST青年电影展的最佳导演奖（上一任的得奖者是《心迷宫》的导演忻钰坤）。   本片的故事背景与《心迷宫》颇有些类似，导演都将故...","title":"九零年代回想录：少女青春里的杀人回忆"},{"alt":"https://movie.douban.com/review/8106800/","author":{"alt":"https://www.douban.com/people/69428274/","avatar":"https://img3.doubanio.com/icon/u69428274-12.jpg","id":"69428274","name":"肚腩少女","signature":"做自由的废物。","uid":"69428274"},"id":"8106800","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"写在前面： 首先要感谢宋丹辉小姐从first内部拿票，邀请我和老王今晚一同去观看电影《黑处有什么》的点映。有趣的是，这一次我再一次和朋友们唱起了反调\u2014\u2014电影结束后，我说，真不错呢。宋小姐和老王却一致认为，烂...","title":"赞扬《黑处有什么》，可能是我再一次在朋友圈唱反调"},{"alt":"https://movie.douban.com/review/7570603/","author":{"alt":"https://www.douban.com/people/meowarrier/","avatar":"https://img1.doubanio.com/icon/u31739532-88.jpg","id":"31739532","name":"森林里的小玄子","signature":"城市里的游牧人","uid":"meowarrier"},"id":"7570603","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"说到《黑处有什么》时，影迷们往往会将其与《杀人回忆》相提并论，但这样一部\u201c依附于\u201d名作之下的作品，却在评委会与影评人之间享有奇高的呼声，并最后一举拿下了FIRST最佳导演及影评人\u201c费比西\u201d奖，看来似乎有些...","title":"深翻九零年代"},{"alt":"https://movie.douban.com/review/8118909/","author":{"alt":"https://www.douban.com/people/57542378/","avatar":"https://img1.doubanio.com/icon/u57542378-8.jpg","id":"57542378","name":"梦里诗书","signature":"","uid":"57542378"},"id":"8118909","rating":{"max":5,"min":0,"value":3},"subject_id":"26433966","summary":"文/梦里诗书   青春与悬疑的结合，不得不说是电影《黑处有什么》一个颇为新颖的切入，怎料随着剧情的推进，奸杀案的悬疑色彩只是成为了假以的噱头，固然悬疑的黯淡使这样的故事只能算差强人意，但电影对少女情感的细...","title":"黑处只有青春"},{"alt":"https://movie.douban.com/review/8114333/","author":{"alt":"https://www.douban.com/people/62582526/","avatar":"https://img3.doubanio.com/icon/u62582526-4.jpg","id":"62582526","name":"独孤行之","signature":"关于青春的说法，一触即断","uid":"62582526"},"id":"8114333","rating":{"max":5,"min":0,"value":4},"subject_id":"26433966","summary":"       武汉点映，终于看了这部在去年First大放异彩的《黑处有什么》。总的来说，这是独属于大陆的《我的少女时代》，是一部披着犯罪悬疑类型片外衣而内核极富时代性的青春片。本是及格之作，本着鼓励小成本处女作自...","title":"真·我的少女时代"},{"alt":"https://movie.douban.com/review/8123372/","author":{"alt":"https://www.douban.com/people/kanghao413/","avatar":"https://img3.doubanio.com/icon/u4862207-20.jpg","id":"4862207","name":"Marilyn教父","signature":"通往宝座的路、总是滴血妖娆的","uid":"kanghao413"},"id":"8123372","rating":{"max":5,"min":0,"value":3},"subject_id":"26433966","summary":"受朋友邀看了点映、本着说良心话的原则、片子介于两至三颗星之间、最后鉴于是导演处女座、还是给三颗星吧、不能再多了...  话说、前天朋友兴奋地和我说、\u201c听说了么？有一片子特牛逼、你不是喜欢看棒子国的片儿么？...","title":"黑处到底有鸡毛啊？！"},{"alt":"https://movie.douban.com/review/8123349/","author":{"alt":"https://www.douban.com/people/97637940/","avatar":"https://img3.doubanio.com/icon/u97637940-3.jpg","id":"97637940","name":"谷城","signature":"刷片中","uid":"97637940"},"id":"8123349","rating":{"max":5,"min":0,"value":1},"subject_id":"26433966","summary":"我看的是点映场，看之前就觉的可能会跟想象的不大一样，没想到第一个场景就给我一个强烈的信号，这导演在侮辱观众的智商。一些类似于生活笔记的细节是导演刻意表现的，而真正的细节则显得廉价而粗糙。最可怕的是这些...","title":"\u201c别出新颖\u201d的犯罪青春片"}]
     * pubdate : 2016-10-14
     * pubdates : ["2015-07-23(FIRST青年电影展)","2016-10-14(中国大陆)"]
     * rating : {"average":7,"details":{"1":11,"2":47,"3":260,"4":298,"5":62},"max":10,"min":0,"stars":"35"}
     * ratings_count : 1140
     * reviews_count : 39
     * schedule_url : https://movie.douban.com/subject/26433966/cinema/
     * share_url : https://m.douban.com/movie/subject/26433966
     * subtype : movie
     * summary : 1991年春夏之交，中原飞机厂家属区内，一起强奸杀人案打破了往日的平静……初二中等生曲靖和老留级生张雪的爸爸同为负责这起案子的警察，但有着迥异的办案风格：曲靖的爸爸出身法医，迂腐和小气的个性让他总是成为大家取笑的对象；张雪的爸爸是退伍军人，办案凭直觉，因为破案率高，是单位的红人……凶手很快被张雪爸爸抓到了，但相同的强奸杀人案再次发生……没人注意到被老师赶出教室的张雪再也没来上课……
     * tags : ["悬疑","中国","青春","大陆","犯罪","2015","剧情","中国大陆","国产","成长"]
     * title : 黑处有什么
     * trailer_urls : ["http://vt1.doubanio.com/201610131502/b33a4b97623a2415773146d9d0481768/view/movie/M/302050106.mp4","http://vt1.doubanio.com/201610131502/d4d5f205842fcf31018e6d9c462c1dd8/view/movie/M/302040314.mp4","http://vt1.doubanio.com/201610131502/d4af83370ce464177233947d53835af4/view/movie/M/302040108.mp4","http://vt1.doubanio.com/201610131502/90a1df6cb9c312c22e727fad5f8ea3c1/view/movie/M/302030536.mp4"]
     * trailers : [{"alt":"https://movie.douban.com/trailer/205106/","id":"205106","medium":"https://img3.doubanio.com/img/trailer/medium/2387548904.jpg?","resource_url":"http://vt1.doubanio.com/201610131502/b33a4b97623a2415773146d9d0481768/view/movie/M/302050106.mp4","small":"https://img3.doubanio.com/img/trailer/small/2387548904.jpg?","subject_id":"26433966","title":"预告片：荒诞性萌动版 (中文字幕)"},{"alt":"https://movie.douban.com/trailer/204314/","id":"204314","medium":"https://img3.doubanio.com/img/trailer/medium/2383097611.jpg?","resource_url":"http://vt1.doubanio.com/201610131502/d4d5f205842fcf31018e6d9c462c1dd8/view/movie/M/302040314.mp4","small":"https://img3.doubanio.com/img/trailer/small/2383097611.jpg?","subject_id":"26433966","title":"预告片：危机版 (中文字幕)"},{"alt":"https://movie.douban.com/trailer/204108/","id":"204108","medium":"https://img3.doubanio.com/img/trailer/medium/2382538743.jpg?","resource_url":"http://vt1.doubanio.com/201610131502/d4af83370ce464177233947d53835af4/view/movie/M/302040108.mp4","small":"https://img3.doubanio.com/img/trailer/small/2382538743.jpg?","subject_id":"26433966","title":"预告片：\u201c案发前\u201d版 (中文字幕)"},{"alt":"https://movie.douban.com/trailer/203536/","id":"203536","medium":"https://img3.doubanio.com/img/trailer/medium/2379722751.jpg?","resource_url":"http://vt1.doubanio.com/201610131502/90a1df6cb9c312c22e727fad5f8ea3c1/view/movie/M/302030536.mp4","small":"https://img3.doubanio.com/img/trailer/small/2379722751.jpg?","subject_id":"26433966","title":"先行版 (中文字幕)"}]
     * videos : []
     * website :
     * wish_count : 7831
     * writers : [{"alt":"https://movie.douban.com/celebrity/1350900/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg"},"id":"1350900","name":"王一淳","name_en":"Yichun Wang"}]
     * year : 2015
     */

    private String alt;
    private int collect_count;
    private int comments_count;
    private String douban_site;
    private boolean has_schedule;
    private boolean has_ticket;
    private boolean has_video;
    private String id;
    /**
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2387538436.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2387538436.jpg
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2387538436.jpg
     */

    private ImagesBean images;
    private String mainland_pubdate;
    private String mobile_url;
    private String original_title;
    private int photos_count;
    private String pubdate;
    /**
     * average : 7
     * details : {"1":11,"2":47,"3":260,"4":298,"5":62}
     * max : 10
     * min : 0
     * stars : 35
     */

    private RatingBean rating;
    private int ratings_count;
    private int reviews_count;
    private String schedule_url;
    private String share_url;
    private String subtype;
    private String summary;
    private String title;
    private String website;
    private int wish_count;
    private String year;
    private List<String> aka;
    private List<?> blooper_urls;
    private List<?> bloopers;
    /**
     * alt : https://movie.douban.com/celebrity/1362252/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg"}
     * id : 1362252
     * name : 苏晓彤
     * name_en :
     */

    private List<CastsBean> casts;
    private List<?> clip_urls;
    private List<?> clips;
    private List<String> countries;
    /**
     * alt : https://movie.douban.com/celebrity/1350900/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg"}
     * id : 1350900
     * name : 王一淳
     * name_en : Yichun Wang
     */

    private List<DirectorsBean> directors;
    private List<String> durations;
    private List<String> genres;
    private List<String> languages;
    /**
     * alt : https://movie.douban.com/photos/photo/2319111008/
     * cover : https://img1.doubanio.com/view/photo/albumcover/public/p2319111008.jpg
     * icon : https://img1.doubanio.com/view/photo/icon/public/p2319111008.jpg
     * id : 2319111008
     * image : https://img1.doubanio.com/view/photo/photo/public/p2319111008.jpg
     * thumb : https://img1.doubanio.com/view/photo/thumb/public/p2319111008.jpg
     */

    private List<PhotosBean> photos;
    /**
     * author : {"alt":"https://www.douban.com/people/ydyie/","avatar":"https://img1.doubanio.com/icon/u2126832-179.jpg","id":"2126832","name":"时间之葬","signature":"","uid":"ydyie"}
     * content : 窥见一个闭塞且无能的时代
     * created_at : 2015-10-20 19:27:18
     * id : 969738800
     * rating : {"max":5,"min":0,"value":4}
     * subject_id : 26433966
     * useful_count : 7
     */

    private List<PopularCommentsBean> popular_comments;
    /**
     * alt : https://movie.douban.com/review/7782679/
     * author : {"alt":"https://www.douban.com/people/MovieL/","avatar":"https://img3.doubanio.com/icon/u1128221-91.jpg","id":"1128221","name":"木卫二","signature":"公众号：MOViE木卫","uid":"MovieL"}
     * id : 7782679
     * rating : {"max":5,"min":0,"value":4}
     * subject_id : 26433966
     * summary : 【Spoiler Alert ！ 以下内容有小部分的剧情泄露，可能影响观看】  《黑处有什么》 自然会被归入“饱受《杀人回忆》影响的系列电影”当中。  我当初都过于肯定地认为，原型事件在前的《十二宫》，它也是照着《杀人回...
     * title : 告诉你一个秘密
     */

    private List<PopularReviewsBean> popular_reviews;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> trailer_urls;
    /**
     * alt : https://movie.douban.com/trailer/205106/
     * id : 205106
     * medium : https://img3.doubanio.com/img/trailer/medium/2387548904.jpg?
     * resource_url : http://vt1.doubanio.com/201610131502/b33a4b97623a2415773146d9d0481768/view/movie/M/302050106.mp4
     * small : https://img3.doubanio.com/img/trailer/small/2387548904.jpg?
     * subject_id : 26433966
     * title : 预告片：荒诞性萌动版 (中文字幕)
     */

    private List<TrailersBean> trailers;
    private List<?> videos;
    /**
     * alt : https://movie.douban.com/celebrity/1350900/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg"}
     * id : 1350900
     * name : 王一淳
     * name_en : Yichun Wang
     */

    private List<WritersBean> writers;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public List<?> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<?> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<?> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<?> bloopers) {
        this.bloopers = bloopers;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<?> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<?> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<?> getClips() {
        return clips;
    }

    public void setClips(List<?> clips) {
        this.clips = clips;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<?> getVideos() {
        return videos;
    }

    public void setVideos(List<?> videos) {
        this.videos = videos;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public static class ImagesBean {
        private String large;
        private String medium;
        private String small;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

    public static class RatingBean {
        private float average;
        /**
         * 1 : 11
         * 2 : 47
         * 3 : 260
         * 4 : 298
         * 5 : 62
         */

        private DetailsBean details;
        private float max;
        private float min;
        private String stars;

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public float getMax() {
            return max;
        }

        public void setMax(float max) {
            this.max = max;
        }

        public float getMin() {
            return min;
        }

        public void setMin(float min) {
            this.min = min;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public static class DetailsBean {
            @SerializedName("1")
            private int value1;
            @SerializedName("2")
            private int value2;
            @SerializedName("3")
            private int value3;
            @SerializedName("4")
            private int value4;
            @SerializedName("5")
            private int value5;

            public int getValue1() {
                return value1;
            }

            public void setValue1(int value1) {
                this.value1 = value1;
            }

            public int getValue2() {
                return value2;
            }

            public void setValue2(int value2) {
                this.value2 = value2;
            }

            public int getValue3() {
                return value3;
            }

            public void setValue3(int value3) {
                this.value3 = value3;
            }

            public int getValue4() {
                return value4;
            }

            public void setValue4(int value4) {
                this.value4 = value4;
            }

            public int getValue5() {
                return value5;
            }

            public void setValue5(int value5) {
                this.value5 = value5;
            }
        }
    }

    public static class CastsBean {
        private String alt;
        /**
         * large : https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg
         */

        private AvatarsBean avatars;
        private String id;
        private String name;
        private String name_en;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public static class AvatarsBean {
            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }
    }

    public static class DirectorsBean {
        private String alt;
        /**
         * large : https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg
         */

        private AvatarsBean avatars;
        private String id;
        private String name;
        private String name_en;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public static class AvatarsBean {
            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }
    }

    public static class PhotosBean {
        private String alt;
        private String cover;
        private String icon;
        private String id;
        private String image;
        private String thumb;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    public static class PopularCommentsBean {
        /**
         * alt : https://www.douban.com/people/ydyie/
         * avatar : https://img1.doubanio.com/icon/u2126832-179.jpg
         * id : 2126832
         * name : 时间之葬
         * signature :
         * uid : ydyie
         */

        private AuthorBean author;
        private String content;
        private String created_at;
        private String id;
        /**
         * max : 5
         * min : 0
         * value : 4
         */

        private RatingBean rating;
        private String subject_id;
        private int useful_count;

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public static class AuthorBean {
            private String alt;
            private String avatar;
            private String id;
            private String name;
            private String signature;
            private String uid;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }

        public static class RatingBean {
            private int max;
            private int min;
            private int value;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }

    public static class PopularReviewsBean {
        private String alt;
        /**
         * alt : https://www.douban.com/people/MovieL/
         * avatar : https://img3.doubanio.com/icon/u1128221-91.jpg
         * id : 1128221
         * name : 木卫二
         * signature : 公众号：MOViE木卫
         * uid : MovieL
         */

        private AuthorBean author;
        private String id;
        /**
         * max : 5
         * min : 0
         * value : 4
         */

        private RatingBean rating;
        private String subject_id;
        private String summary;
        private String title;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class AuthorBean {
            private String alt;
            private String avatar;
            private String id;
            private String name;
            private String signature;
            private String uid;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }

        public static class RatingBean {
            private int max;
            private int min;
            private int value;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }

    public static class TrailersBean {
        private String alt;
        private String id;
        private String medium;
        private String resource_url;
        private String small;
        private String subject_id;
        private String title;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class WritersBean {
        private String alt;
        /**
         * large : https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg
         */

        private AvatarsBean avatars;
        private String id;
        private String name;
        private String name_en;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public static class AvatarsBean {
            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }
    }
}
