package com.whyalwaysmea.bigboom.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Long
 * on 2016/10/13.
 */

public class MovieDetail implements Serializable{


    /**
     * max : 10
     * average : 9.1
     * details : {"1":523,"2":1353,"3":21719,"4":80048,"5":189541}
     * stars : 45
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"average":9.1,"details":{"1":523,"2":1353,"3":21719,"4":80048,"5":189541},"stars":"45","min":0}
     * reviews_count : 1930
     * videos : [{"source":{"literal":"qq","pic":"https://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png","name":"腾讯视频"},"sample_link":"http://v.qq.com/cover/f/fse52rd4klx7qn2.html?ptag=douban.movie","video_id":"","need_pay":false}]
     * wish_count : 18964
     * original_title : 西遊記大結局之仙履奇緣
     * blooper_urls : []
     * collect_count : 523957
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p648365452.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p648365452.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p648365452.jpg"}
     * douban_site :
     * year : 1995
     * popular_comments : [{"rating":{"max":5,"value":0,"min":0},"useful_count":597,"author":{"uid":"cat17fish1","avatar":"https://img3.doubanio.com/icon/u1754924-80.jpg","signature":"","alt":"https://www.douban.com/people/cat17fish1/","id":"1754924","name":"十七只猫和鱼"},"subject_id":"1292213","content":"25-30岁待业青年的精神寄托","created_at":"2010-12-11 10:07:01","id":"325148038"},{"rating":{"max":5,"value":5,"min":0},"useful_count":717,"author":{"uid":"crpily","avatar":"https://img3.doubanio.com/icon/u43686596-20.jpg","signature":"联系我时请注明世纪佳缘，谢谢。","alt":"https://www.douban.com/people/crpily/","id":"43686596","name":"凉水"},"subject_id":"1292213","content":"紫霞飘向太阳时、齐天大圣离开城门时，都哭成了傻逼。有多庆幸能踩着五彩祥云做你的盖世英雄，就有多遗憾没办法与你守护终身。喜欢的是五百年前的晶晶、还是给了自己三颗痣的紫霞；喜欢无拘无束敢爱敢恨的至尊宝、还是套上紧箍咒背影像狗的孙悟空？爱的命题究竟太空泛，恐怕还是要交给月光宝盒。","created_at":"2012-10-26 20:49:43","id":"595885905"},{"rating":{"max":5,"value":4,"min":0},"useful_count":378,"author":{"uid":"miuccia","avatar":"https://img3.doubanio.com/icon/u1303121-363.jpg","signature":"大无畏","alt":"https://www.douban.com/people/miuccia/","id":"1303121","name":"Miss Lucky"},"subject_id":"1292213","content":"其实很伤感","created_at":"2006-12-22 20:41:27","id":"8363859"},{"rating":{"max":5,"value":5,"min":0},"useful_count":234,"author":{"uid":"amutofade","avatar":"https://img3.doubanio.com/icon/u1306803-54.jpg","signature":"尽可能善待他人前提是取悦自己。","alt":"https://www.douban.com/people/amutofade/","id":"1306803","name":"宋阿慕"},"subject_id":"1292213","content":"大话西游成就了一个时代.这句话一点也没错.不管是好的方面还是不好的方面.|人试图化身为天地，这本身就是一种不自量力。","created_at":"2008-02-19 15:19:26","id":"31790549"}]
     * alt : https://movie.douban.com/subject/1292213/
     * id : 1292213
     * mobile_url : https://movie.douban.com/subject/1292213/mobile
     * photos_count : 804
     * pubdate : 2014-10-24
     * title : 大话西游之大圣娶亲
     * do_count : null
     * has_video : true
     * share_url : https://m.douban.com/movie/subject/1292213
     * seasons_count : null
     * languages : ["粤语","汉语普通话"]
     * schedule_url :
     * writers : [{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/45374.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45374.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45374.jpg"},"name_en":"Jeffrey Lau","name":"刘镇伟","alt":"https://movie.douban.com/celebrity/1274431/","id":"1274431"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/12837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/12837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/12837.jpg"},"name_en":"Cheng'en Wu","name":"吴承恩","alt":"https://movie.douban.com/celebrity/1275984/","id":"1275984"}]
     * pubdates : ["1995-02-04(香港)","2014-10-24(中国大陆)"]
     * website :
     * tags : ["经典","喜剧","爱情","香港","大话西游","搞笑","电影","中国","1995","1994"]
     * has_schedule : false
     * durations : ["95分钟"]
     * genres : ["动作","冒险","喜剧"]
     * collection : null
     * trailers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2206035894.jpg?","title":"预告片：悲情版 (中文字幕)","subject_id":"1292213","alt":"https://movie.douban.com/trailer/164614/","small":"https://img3.doubanio.com/img/trailer/small/2206035894.jpg?","resource_url":"http://vt1.doubanio.com/201610171632/e0c0c6091d14b85b8dea638e8613be6f/view/movie/M/301640614.mp4","id":"164614"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201610171632/e0c0c6091d14b85b8dea638e8613be6f/view/movie/M/301640614.mp4"]
     * has_ticket : false
     * bloopers : []
     * clip_urls : ["http://vt1.doubanio.com/201610171632/11fcb6d4061ff4a82bb55dd8fa64dc30/view/movie/M/301370557.mp4","http://vt1.doubanio.com/201610171632/de63b5ca7a15aba74b47d3b6d1bded9d/view/movie/M/301370556.mp4"]
     * current_season : null
     * casts : [{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"},"name_en":"Stephen Chow","name":"周星驰","alt":"https://movie.douban.com/celebrity/1048026/","id":"1048026"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/45481.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45481.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45481.jpg"},"name_en":"Man Tat Ng","name":"吴孟达","alt":"https://movie.douban.com/celebrity/1016771/","id":"1016771"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5539.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5539.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5539.jpg"},"name_en":"Athena Chu","name":"朱茵","alt":"https://movie.douban.com/celebrity/1041734/","id":"1041734"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/6774.jpg","large":"https://img3.doubanio.com/img/celebrity/large/6774.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/6774.jpg"},"name_en":"Ada Choi","name":"蔡少芬","alt":"https://movie.douban.com/celebrity/1050946/","id":"1050946"}]
     * countries : ["香港","中国大陆"]
     * mainland_pubdate : 2014-10-24
     * photos : [{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002649154.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002649154.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002649154.jpg","alt":"https://movie.douban.com/photos/photo/2002649154/","id":"2002649154","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002649154.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002648846.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002648846.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002648846.jpg","alt":"https://movie.douban.com/photos/photo/2002648846/","id":"2002648846","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002648846.jpg"},{"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p1512952229.jpg","image":"https://img1.doubanio.com/view/photo/photo/public/p1512952229.jpg","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p1512952229.jpg","alt":"https://movie.douban.com/photos/photo/1512952229/","id":"1512952229","icon":"https://img1.doubanio.com/view/photo/icon/public/p1512952229.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002649421.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002649421.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002649421.jpg","alt":"https://movie.douban.com/photos/photo/2002649421/","id":"2002649421","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002649421.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002642965.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002642965.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002642965.jpg","alt":"https://movie.douban.com/photos/photo/2002642965/","id":"2002642965","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002642965.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002647930.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002647930.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002647930.jpg","alt":"https://movie.douban.com/photos/photo/2002647930/","id":"2002647930","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002647930.jpg"},{"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2002647097.jpg","image":"https://img1.doubanio.com/view/photo/photo/public/p2002647097.jpg","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2002647097.jpg","alt":"https://movie.douban.com/photos/photo/2002647097/","id":"2002647097","icon":"https://img1.doubanio.com/view/photo/icon/public/p2002647097.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p459808006.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p459808006.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p459808006.jpg","alt":"https://movie.douban.com/photos/photo/459808006/","id":"459808006","icon":"https://img3.doubanio.com/view/photo/icon/public/p459808006.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002646874.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002646874.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002646874.jpg","alt":"https://movie.douban.com/photos/photo/2002646874/","id":"2002646874","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002646874.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2002647412.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2002647412.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2002647412.jpg","alt":"https://movie.douban.com/photos/photo/2002647412/","id":"2002647412","icon":"https://img3.doubanio.com/view/photo/icon/public/p2002647412.jpg"}]
     * summary : 至尊宝（周星驰）被月光宝盒带回到五百年前，遇见紫霞仙子（朱茵），被对方打上烙印成为对方的人，并发觉自己已变成孙悟空。
     紫霞与青霞（朱茵）本是如来佛祖座前日月神灯的灯芯（白天是紫霞，晚上是青霞），二人虽然同一肉身却仇恨颇深，因此紫霞立下誓言，谁能拔出她手中的紫青宝剑，谁就是她的意中人。紫青宝剑被至尊宝于不经意间拔出，紫霞决定以身相许，却遭一心记挂白晶晶（莫文蔚）的至尊宝拒绝。后牛魔王救下迷失在沙漠中的紫霞，并逼紫霞与他成婚，关键时刻，至尊宝现身。©豆瓣
     * clips : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2023937673.jpg?","title":"片段","subject_id":"1292213","alt":"https://movie.douban.com/trailer/137557/","small":"https://img3.doubanio.com/img/trailer/small/2023937673.jpg?","resource_url":"http://vt1.doubanio.com/201610171632/11fcb6d4061ff4a82bb55dd8fa64dc30/view/movie/M/301370557.mp4","id":"137557"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2023930814.jpg?","title":"片段 (中文字幕)","subject_id":"1292213","alt":"https://movie.douban.com/trailer/137556/","small":"https://img3.doubanio.com/img/trailer/small/2023930814.jpg?","resource_url":"http://vt1.doubanio.com/201610171632/de63b5ca7a15aba74b47d3b6d1bded9d/view/movie/M/301370556.mp4","id":"137556"}]
     * subtype : movie
     * directors : [{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/45374.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45374.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45374.jpg"},"name_en":"Jeffrey Lau","name":"刘镇伟","alt":"https://movie.douban.com/celebrity/1274431/","id":"1274431"}]
     * comments_count : 73454
     * popular_reviews : [{"rating":{"max":5,"value":5,"min":0},"title":"工作两年后感悟的《大话西游》（转载 个人觉得很不错 所以贴上来)","subject_id":"1292213","author":{"uid":"dengdaigeduo","avatar":"https://img3.doubanio.com/icon/u2226766-5.jpg","signature":"","alt":"https://www.douban.com/people/dengdaigeduo/","id":"2226766","name":"等待戈多"},"summary":"这个世界上还有一个故事，叫做《大话西游》。   世界是巨大的枷锁，你不得不重复自己或是别人的生活。  记得长辈说过：年轻是一种罪过。他们说我们不成熟。   真切地为自己的不俗喝彩，在深切的郁闷中，突然就看懂了...","alt":"https://movie.douban.com/review/1427613/","id":"1427613"},{"rating":{"max":5,"value":5,"min":0},"title":"我们所不能抗拒的只有爱与死","subject_id":"1292213","author":{"uid":"drleesilentnigh","avatar":"https://img3.doubanio.com/icon/u1115813-141.jpg","signature":"不再减肥#","alt":"https://www.douban.com/people/drleesilentnigh/","id":"1115813","name":"我对你的无语简直能沉默整个宇宙"},"summary":"　　199X年。小学。东北某矿区职工电影院。 　　我跟很多小孩子挤在黑暗里看妖魔鬼怪。我们只是冲着孙悟空猪八戒来的。我不明白里面怎么会冒出来那么多女的跟孙悟空扯上瓜葛，原来都是妖精们或者女儿国的女儿们喜欢...","alt":"https://movie.douban.com/review/1385038/","id":"1385038"},{"rating":{"max":5,"value":5,"min":0},"title":"你理解大话西游片尾那句\u201c他好像一条狗\u201d吗？如果不能理解，那就是没看懂。","subject_id":"1292213","author":{"uid":"yoo_long","avatar":"https://img1.doubanio.com/icon/u1213556-29.jpg","signature":"曾经沧海难为水，除却云雨无乐趣","alt":"https://www.douban.com/people/yoo_long/","id":"1213556","name":"苗汉子"},"summary":"你在看大话西游的时候，如果笑得腹背抽筋，龇牙咧嘴，那么你很有幽默感。如果你看完了大话西游，你还笑得满地打滚，那么你其实什么都没看懂。如果你看完了大话，你忽然发现脸上不知什么时候已经有泪水，你总算看懂了...","alt":"https://movie.douban.com/review/5199026/","id":"5199026"},{"rating":{"max":5,"value":5,"min":0},"title":"《大话西游》里面爱情伦理观","subject_id":"1292213","author":{"uid":"drp2599","avatar":"https://img3.doubanio.com/icon/u3583794-46.jpg","signature":"微信公众号：爆裂核桃","alt":"https://www.douban.com/people/drp2599/","id":"3583794","name":"阿邓瑞平"},"summary":"《大话西游》是我最喜欢的一部有关于爱情的电影，完全符合我对爱情伦理的最本源的想法。符合我爱情伦理观的电影有两部，另一部是《屋顶上的轻骑兵》，那个我以前在豆瓣上曾经写过，更侧重于精神分析。其实《大话西游...","alt":"https://movie.douban.com/review/2084101/","id":"2084101"},{"rating":{"max":5,"value":4,"min":0},"title":"一生所爱","subject_id":"1292213","author":{"uid":"wildboy","avatar":"https://img1.doubanio.com/icon/u1018267-29.jpg","signature":"刘健一@哈WU稿 公众号ID：ha5gao","alt":"https://www.douban.com/people/wildboy/","id":"1018267","name":"阿七"},"summary":"拥有IPOD这种海量MP3的一种好处就是，你永远不知道下一刻在你耳机里会传出什么音乐。有些歌你放进去或许自己都忘记了。在某一个不经意的时候，当它回来，唤起的是一段记忆。一首歌是一个人、一件事、一段时光。   一...","alt":"https://movie.douban.com/review/1047688/","id":"1047688"},{"rating":{"max":5,"value":5,"min":0},"title":"不过是只受了诅咒的猴子。","subject_id":"1292213","author":{"uid":"xiaomaitalk","avatar":"https://img3.doubanio.com/icon/u1547732-70.jpg","signature":"深如海，静如湖。","alt":"https://www.douban.com/people/xiaomaitalk/","id":"1547732","name":"谢小麦"},"summary":"    周六的时候参加米兜组织的活动，到好北边的中国电影博物馆，看很久之前已经看过很多遍的《大话西游》。虽然路程远了一些，电影票还是好便宜；又赶上蜡像馆开幕，也算是不虚此行。     十多年前第一次看的时候，...","alt":"https://movie.douban.com/review/1455328/","id":"1455328"},{"rating":{"max":5,"value":5,"min":0},"title":"玩什么别玩剑","subject_id":"1292213","author":{"uid":"dd770523","avatar":"https://img1.doubanio.com/icon/u1715179-87.jpg","signature":"远方之外更有远方","alt":"https://www.douban.com/people/dd770523/","id":"1715179","name":"鱼·无"},"summary":"一个女人。 一个身材玲珑，风情不羁的女人。 一个天上有地下无，机敏跳脱，额头光洁而红唇饱满的女人。 她衣袂翩翩，青丝飘扬，贝齿如编。手腕上一串银铃，牵起天地间的靡靡之音，纵是天兵神将，都要元魂颠倒。 但她...","alt":"https://movie.douban.com/review/1307442/","id":"1307442"},{"rating":{"max":5,"value":5,"min":0},"title":"重温《大话西游》 (转)","subject_id":"1292213","author":{"uid":"liulang0808","avatar":"https://img3.doubanio.com/icon/u1362767-1.jpg","signature":"","alt":"https://www.douban.com/people/liulang0808/","id":"1362767","name":"shawn"},"summary":"昨晚夜静，重温《大话西游》   \u2014\u2014大笑，流泪，然后沉默。   　　我面对的是一部痛彻心肺的喜剧。   　　寓言篇故事已然存在，已然不可避免。   　　世界是巨大的枷锁，你不得不重复自己或是别人的生活。   　　记...","alt":"https://movie.douban.com/review/1222442/","id":"1222442"},{"rating":{"max":5,"value":5,"min":0},"title":"来一篇转的全剧本吧","subject_id":"1292213","author":{"uid":"anothers","avatar":"https://img1.doubanio.com/icon/u1637278-207.jpg","signature":"","alt":"https://www.douban.com/people/anothers/","id":"1637278","name":"喜宴"},"summary":"大话西游  （一）  观音：孙悟空，你这个畜牲，你本来答应如来佛祖护送你师傅唐三藏去取西经的，你居然跟牛魔王串通要吃你师傅，你知不知道你犯了弥天大罪？ 孙悟空：少罗嗦！你追了我三天三夜，因为你是女人我才不...","alt":"https://movie.douban.com/review/3115577/","id":"3115577"},{"rating":{"max":5,"value":5,"min":0},"title":"一万年太久","subject_id":"1292213","author":{"uid":"luoying6","avatar":"https://img3.doubanio.com/icon/u1107668-42.jpg","signature":"","alt":"https://www.douban.com/people/luoying6/","id":"1107668","name":"本来老六"},"summary":"　　大话西游二十年  　　二十年，那么就是一九九四年的事情。我已经吃不准看到的时候是几几年，但我非常确定两部都是去电影院出了票钱的。  　　顺便说说最近很流行的\u201c欠**一张票\u201d这种营销模式，大抵意思是之前也...","alt":"https://movie.douban.com/review/7170141/","id":"7170141"}]
     * ratings_count : 389744
     * aka : ["西游记完结篇仙履奇缘","齐天大圣西游记","大话东游之二","A Chinese Odyssey Part Two - Cinderella"]
     */

    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p648365452.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p648365452.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p648365452.jpg
     */

    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    /**
     * source : {"literal":"qq","pic":"https://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png","name":"腾讯视频"}
     * sample_link : http://v.qq.com/cover/f/fse52rd4klx7qn2.html?ptag=douban.movie
     * video_id :
     * need_pay : false
     */

    private List<VideosBean> videos;
    private List<?> blooper_urls;
    /**
     * rating : {"max":5,"value":0,"min":0}
     * useful_count : 597
     * author : {"uid":"cat17fish1","avatar":"https://img3.doubanio.com/icon/u1754924-80.jpg","signature":"","alt":"https://www.douban.com/people/cat17fish1/","id":"1754924","name":"十七只猫和鱼"}
     * subject_id : 1292213
     * content : 25-30岁待业青年的精神寄托
     * created_at : 2010-12-11 10:07:01
     * id : 325148038
     */

    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    /**
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/45374.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45374.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45374.jpg"}
     * name_en : Jeffrey Lau
     * name : 刘镇伟
     * alt : https://movie.douban.com/celebrity/1274431/
     * id : 1274431
     */

    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    /**
     * medium : https://img3.doubanio.com/img/trailer/medium/2206035894.jpg?
     * title : 预告片：悲情版 (中文字幕)
     * subject_id : 1292213
     * alt : https://movie.douban.com/trailer/164614/
     * small : https://img3.doubanio.com/img/trailer/small/2206035894.jpg?
     * resource_url : http://vt1.doubanio.com/201610171632/e0c0c6091d14b85b8dea638e8613be6f/view/movie/M/301640614.mp4
     * id : 164614
     */

    private List<ClipsBean> trailers;
    private List<String> trailer_urls;
    private List<ClipsBean> bloopers;
    private List<String> clip_urls;
    /**
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/47421.jpg","large":"https://img3.doubanio.com/img/celebrity/large/47421.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/47421.jpg"}
     * name_en : Stephen Chow
     * name : 周星驰
     * alt : https://movie.douban.com/celebrity/1048026/
     * id : 1048026
     */

    private List<CastsBean> casts;
    private List<String> countries;
    /**
     * thumb : https://img3.doubanio.com/view/photo/thumb/public/p2002649154.jpg
     * image : https://img3.doubanio.com/view/photo/photo/public/p2002649154.jpg
     * cover : https://img3.doubanio.com/view/photo/albumcover/public/p2002649154.jpg
     * alt : https://movie.douban.com/photos/photo/2002649154/
     * id : 2002649154
     * icon : https://img3.doubanio.com/view/photo/icon/public/p2002649154.jpg
     */

    private List<PhotosBean> photos;
    /**
     * medium : https://img3.doubanio.com/img/trailer/medium/2023937673.jpg?
     * title : 片段
     * subject_id : 1292213
     * alt : https://movie.douban.com/trailer/137557/
     * small : https://img3.doubanio.com/img/trailer/small/2023937673.jpg?
     * resource_url : http://vt1.doubanio.com/201610171632/11fcb6d4061ff4a82bb55dd8fa64dc30/view/movie/M/301370557.mp4
     * id : 137557
     */

    private List<ClipsBean> clips;
    /**
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/45374.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45374.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45374.jpg"}
     * name_en : Jeffrey Lau
     * name : 刘镇伟
     * alt : https://movie.douban.com/celebrity/1274431/
     * id : 1274431
     */

    private List<CastsBean> directors;
    /**
     * rating : {"max":5,"value":5,"min":0}
     * title : 工作两年后感悟的《大话西游》（转载 个人觉得很不错 所以贴上来)
     * subject_id : 1292213
     * author : {"uid":"dengdaigeduo","avatar":"https://img3.doubanio.com/icon/u2226766-5.jpg","signature":"","alt":"https://www.douban.com/people/dengdaigeduo/","id":"2226766","name":"等待戈多"}
     * summary : 这个世界上还有一个故事，叫做《大话西游》。   世界是巨大的枷锁，你不得不重复自己或是别人的生活。  记得长辈说过：年轻是一种罪过。他们说我们不成熟。   真切地为自己的不俗喝彩，在深切的郁闷中，突然就看懂了...
     * alt : https://movie.douban.com/review/1427613/
     * id : 1427613
     */

    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public List<?> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<?> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
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

    public List<ClipsBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<ClipsBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<ClipsBean> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<ClipsBean> bloopers) {
        this.bloopers = bloopers;
    }

    public List<String> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<String> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<ClipsBean> getClips() {
        return clips;
    }

    public void setClips(List<ClipsBean> clips) {
        this.clips = clips;
    }

    public List<CastsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<CastsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean implements Serializable{
        private float max;
        private float average;
        /**
         * 1 : 523
         * 2 : 1353
         * 3 : 21719
         * 4 : 80048
         * 5 : 189541
         */

        private DetailsBean details;
        private String stars;
        private int min;

        public float getMax() {
            return max;
        }

        public void setMax(float max) {
            this.max = max;
        }

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

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean implements Serializable{
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

    public static class ImagesBean implements Serializable{
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

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
    }

    public static class VideosBean implements Serializable{
        /**
         * literal : qq
         * pic : https://img3.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png
         * name : 腾讯视频
         */

        private SourceBean source;
        private String sample_link;
        private String video_id;
        private boolean need_pay;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getSample_link() {
            return sample_link;
        }

        public void setSample_link(String sample_link) {
            this.sample_link = sample_link;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public boolean isNeed_pay() {
            return need_pay;
        }

        public void setNeed_pay(boolean need_pay) {
            this.need_pay = need_pay;
        }

        public static class SourceBean implements Serializable{
            private String literal;
            private String pic;
            private String name;

            public String getLiteral() {
                return literal;
            }

            public void setLiteral(String literal) {
                this.literal = literal;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class PopularCommentsBean implements Serializable{
        /**
         * max : 5
         * value : 0
         * min : 0
         */

        private RatingBean rating;
        private int useful_count;
        /**
         * uid : cat17fish1
         * avatar : https://img3.doubanio.com/icon/u1754924-80.jpg
         * signature :
         * alt : https://www.douban.com/people/cat17fish1/
         * id : 1754924
         * name : 十七只猫和鱼
         */

        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
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

        public static class RatingBean implements Serializable{
            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean implements Serializable{
            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean implements Serializable{
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/45374.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/45374.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/45374.jpg
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public static class AvatarsBean implements Serializable{
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

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
        }
    }


    public static class CastsBean implements Serializable{
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/47421.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/47421.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/47421.jpg
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public static class AvatarsBean implements Serializable{
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

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
        }
    }

    public static class PhotosBean implements Serializable{
        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class ClipsBean implements Serializable{
        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean implements Serializable{
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/45374.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/45374.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/45374.jpg
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public static class AvatarsBean implements Serializable{
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

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
        }
    }

    public static class PopularReviewsBean implements Serializable{
        /**
         * max : 5
         * value : 5
         * min : 0
         */

        private RatingBean rating;
        private String title;
        private String subject_id;
        /**
         * uid : dengdaigeduo
         * avatar : https://img3.doubanio.com/icon/u2226766-5.jpg
         * signature :
         * alt : https://www.douban.com/people/dengdaigeduo/
         * id : 2226766
         * name : 等待戈多
         */

        private AuthorBean author;
        private String summary;
        private String alt;
        private String id;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

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

        public static class RatingBean implements Serializable{
            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean implements Serializable{
            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
