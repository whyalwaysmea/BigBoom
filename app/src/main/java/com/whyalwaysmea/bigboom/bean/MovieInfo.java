package com.whyalwaysmea.bigboom.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Long
 * on 2016/9/1.
 */
public class MovieInfo {


    /**
     * max : 10
     * average : 8.3
     * details : {"1":237,"2":665,"3":6915,"4":20392,"5":15184}
     * stars : 45
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"average":8.3,"details":{"1":237,"2":665,"3":6915,"4":20392,"5":15184},"stars":"45","min":0}
     * genres : ["动作","惊悚","灾难"]
     * title : 釜山行
     * casts : [{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/55195.jpg","large":"http://img3.douban.com/img/celebrity/large/55195.jpg","medium":"http://img3.douban.com/img/celebrity/medium/55195.jpg"},"name_en":"Yoo Gong","name":"孔侑","alt":"https://movie.douban.com/celebrity/1011009/","id":"1011009"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1409765749.47.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1409765749.47.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1409765749.47.jpg"},"name_en":"Yu-mi Jung","name":"郑有美","alt":"https://movie.douban.com/celebrity/1276062/","id":"1276062"},{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/1372317937.35.jpg","large":"http://img3.douban.com/img/celebrity/large/1372317937.35.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1372317937.35.jpg"},"name_en":"Tong-Seok Ma","name":"马东锡","alt":"https://movie.douban.com/celebrity/1322205/","id":"1322205"}]
     * durations : ["118分钟"]
     * collect_count : 70609
     * mainland_pubdate :
     * has_video : false
     * original_title : 부산행
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img3.douban.com/img/celebrity/small/1374825155.63.jpg","large":"http://img3.douban.com/img/celebrity/large/1374825155.63.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1374825155.63.jpg"},"name_en":"Sang-ho Yeon","name":"延尚昊","alt":"https://movie.douban.com/celebrity/1322175/","id":"1322175"}]
     * pubdates : ["2016-07-20(韩国)"]
     * year : 2016
     * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2360940399.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2360940399.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2360940399.jpg"}
     * alt : https://movie.douban.com/subject/25986180/
     * id : 25986180
     */

    private String title;
    private int collect_count;
    private String mainland_pubdate;
    private boolean has_video;
    private String original_title;
    private String subtype;
    private String year;
    /**
     * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2360940399.jpg
     * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2360940399.jpg
     * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2360940399.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    /**
     * avatars : {"small":"http://img3.douban.com/img/celebrity/small/55195.jpg","large":"http://img3.douban.com/img/celebrity/large/55195.jpg","medium":"http://img3.douban.com/img/celebrity/medium/55195.jpg"}
     * name_en : Yoo Gong
     * name : 孔侑
     * alt : https://movie.douban.com/celebrity/1011009/
     * id : 1011009
     */

    private List<CastsBean> casts;
    private List<String> durations;
    /**
     * avatars : {"small":"http://img3.douban.com/img/celebrity/small/1374825155.63.jpg","large":"http://img3.douban.com/img/celebrity/large/1374825155.63.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1374825155.63.jpg"}
     * name_en : Sang-ho Yeon
     * name : 延尚昊
     * alt : https://movie.douban.com/celebrity/1322175/
     * id : 1322175
     */

    private List<DirectorsBean> directors;
    private List<String> pubdates;

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

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public static class RatingBean {
        private int max;
        private double average;
        /**
         * 1 : 237
         * 2 : 665
         * 3 : 6915
         * 4 : 20392
         * 5 : 15184
         */

        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
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

    public static class ImagesBean {
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

    public static class CastsBean {
        /**
         * small : http://img3.douban.com/img/celebrity/small/55195.jpg
         * large : http://img3.douban.com/img/celebrity/large/55195.jpg
         * medium : http://img3.douban.com/img/celebrity/medium/55195.jpg
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

        public static class AvatarsBean {
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

    public static class DirectorsBean {
        /**
         * small : http://img3.douban.com/img/celebrity/small/1374825155.63.jpg
         * large : http://img3.douban.com/img/celebrity/large/1374825155.63.jpg
         * medium : http://img3.douban.com/img/celebrity/medium/1374825155.63.jpg
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

        public static class AvatarsBean {
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
}
