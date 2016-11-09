package com.whyalwaysmea.bigboom.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastDetail implements Serializable{


    private String website;
    private String mobile_url;
    private String name;
    private String name_en;
    private String gender;
    /**
     * small : https://img3.doubanio.com/img/celebrity/small/551.jpg
     * large : https://img3.doubanio.com/img/celebrity/large/551.jpg
     * medium : https://img3.doubanio.com/img/celebrity/medium/551.jpg
     */

    private AvatarsBean avatars;
    private String summary;
    private String birthday;
    private String alt;
    private String born_place;
    private String constellation;
    private String id;
    private List<String> aka_en;
    /**
     * roles : ["演员","导演","制片","编剧"]
     * subject : {"rating":{"max":10,"average":9.5,"details":{"1":28,"2":74,"3":1305,"4":7043,"5":29529},"stars":"50","min":0},"genres":["剧情","动作","历史"],"title":"兄弟连","casts":[{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1351923505.88.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1351923505.88.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1351923505.88.jpg"},"name_en":"Damian Lewis","name":"戴米恩·路易斯","alt":"https://movie.douban.com/celebrity/1004573/","id":"1004573"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/27376.jpg","large":"https://img3.doubanio.com/img/celebrity/large/27376.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27376.jpg"},"name_en":"Donnie Wahlberg","name":"唐尼·沃尔伯格","alt":"https://movie.douban.com/celebrity/1025198/","id":"1025198"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1370926948.17.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1370926948.17.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1370926948.17.jpg"},"name_en":"Ron Livingston","name":"朗·里维斯顿","alt":"https://movie.douban.com/celebrity/1019023/","id":"1019023"}],"durations":["70分钟"],"collect_count":64415,"mainland_pubdate":"","has_video":true,"original_title":"Band of Brothers","subtype":"tv","directors":[{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Phil Alden Robinson","name":"菲尔·奥尔登·罗宾森","alt":"https://movie.douban.com/celebrity/1032246/","id":"1032246"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/12337.jpg","large":"https://img1.doubanio.com/img/celebrity/large/12337.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/12337.jpg"},"name_en":"Mikael Salomon","name":"迈克尔·塞洛蒙","alt":"https://movie.douban.com/celebrity/1032423/","id":"1032423"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/58903.jpg","large":"https://img3.doubanio.com/img/celebrity/large/58903.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/58903.jpg"},"name_en":"David Nutter","name":"大卫·努特尔","alt":"https://movie.douban.com/celebrity/1293340/","id":"1293340"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/551.jpg","large":"https://img3.doubanio.com/img/celebrity/large/551.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/551.jpg"},"name_en":"Tom Hanks","name":"汤姆·汉克斯","alt":"https://movie.douban.com/celebrity/1054450/","id":"1054450"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"David Leland","name":"大卫·李兰特","alt":"https://movie.douban.com/celebrity/1271372/","id":"1271372"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33090.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33090.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33090.jpg"},"name_en":"David Frankel","name":"大卫·弗兰科尔","alt":"https://movie.douban.com/celebrity/1000420/","id":"1000420"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Richard Loncraine","name":"理查德·隆克瑞恩","alt":"https://movie.douban.com/celebrity/1027580/","id":"1027580"},{"avatars":null,"name_en":"","name":"Tony To","alt":null,"id":null}],"pubdates":["2001-09-09(美国)"],"year":"2001","images":{"small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p1714777727.jpg","large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p1714777727.jpg","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p1714777727.jpg"},"alt":"https://movie.douban.com/subject/1307847/","id":"1307847"}
     */

    private List<WorksBean> works;
    private List<String> professions;
    /**
     * thumb : https://img3.doubanio.com/view/photo/thumb/public/p643145320.jpg
     * image : https://img3.doubanio.com/view/photo/photo/public/p643145320.jpg
     * cover : https://img3.doubanio.com/view/photo/albumcover/public/p643145320.jpg
     * alt : https://movie.douban.com/celebrity/1054450/photo/643145320/
     * id : 643145320
     * icon : https://img3.doubanio.com/view/photo/icon/public/p643145320.jpg
     */

    private List<PhotosBean> photos;
    private List<String> aka;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorksBean> works) {
        this.works = works;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
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

    public static class WorksBean implements Serializable{
        /**
         * rating : {"max":10,"average":9.5,"details":{"1":28,"2":74,"3":1305,"4":7043,"5":29529},"stars":"50","min":0}
         * genres : ["剧情","动作","历史"]
         * title : 兄弟连
         * casts : [{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1351923505.88.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1351923505.88.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1351923505.88.jpg"},"name_en":"Damian Lewis","name":"戴米恩·路易斯","alt":"https://movie.douban.com/celebrity/1004573/","id":"1004573"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/27376.jpg","large":"https://img3.doubanio.com/img/celebrity/large/27376.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27376.jpg"},"name_en":"Donnie Wahlberg","name":"唐尼·沃尔伯格","alt":"https://movie.douban.com/celebrity/1025198/","id":"1025198"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1370926948.17.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1370926948.17.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1370926948.17.jpg"},"name_en":"Ron Livingston","name":"朗·里维斯顿","alt":"https://movie.douban.com/celebrity/1019023/","id":"1019023"}]
         * durations : ["70分钟"]
         * collect_count : 64415
         * mainland_pubdate :
         * has_video : true
         * original_title : Band of Brothers
         * subtype : tv
         * directors : [{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Phil Alden Robinson","name":"菲尔·奥尔登·罗宾森","alt":"https://movie.douban.com/celebrity/1032246/","id":"1032246"},{"avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/12337.jpg","large":"https://img1.doubanio.com/img/celebrity/large/12337.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/12337.jpg"},"name_en":"Mikael Salomon","name":"迈克尔·塞洛蒙","alt":"https://movie.douban.com/celebrity/1032423/","id":"1032423"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/58903.jpg","large":"https://img3.doubanio.com/img/celebrity/large/58903.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/58903.jpg"},"name_en":"David Nutter","name":"大卫·努特尔","alt":"https://movie.douban.com/celebrity/1293340/","id":"1293340"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/551.jpg","large":"https://img3.doubanio.com/img/celebrity/large/551.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/551.jpg"},"name_en":"Tom Hanks","name":"汤姆·汉克斯","alt":"https://movie.douban.com/celebrity/1054450/","id":"1054450"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"David Leland","name":"大卫·李兰特","alt":"https://movie.douban.com/celebrity/1271372/","id":"1271372"},{"avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33090.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33090.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33090.jpg"},"name_en":"David Frankel","name":"大卫·弗兰科尔","alt":"https://movie.douban.com/celebrity/1000420/","id":"1000420"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Richard Loncraine","name":"理查德·隆克瑞恩","alt":"https://movie.douban.com/celebrity/1027580/","id":"1027580"},{"avatars":null,"name_en":"","name":"Tony To","alt":null,"id":null}]
         * pubdates : ["2001-09-09(美国)"]
         * year : 2001
         * images : {"small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p1714777727.jpg","large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p1714777727.jpg","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p1714777727.jpg"}
         * alt : https://movie.douban.com/subject/1307847/
         * id : 1307847
         */

        private SubjectBean subject;
        private List<String> roles;

        public SubjectBean getSubject() {
            return subject;
        }

        public void setSubject(SubjectBean subject) {
            this.subject = subject;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public static class SubjectBean implements Serializable{
            /**
             * max : 10
             * average : 9.5
             * details : {"1":28,"2":74,"3":1305,"4":7043,"5":29529}
             * stars : 50
             * min : 0
             */

            private RatingBean rating;
            private String title;
            private int collect_count;
            private String mainland_pubdate;
            private boolean has_video;
            private String original_title;
            private String subtype;
            private String year;
            /**
             * small : https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p1714777727.jpg
             * large : https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p1714777727.jpg
             * medium : https://img1.doubanio.com/view/movie_poster_cover/spst/public/p1714777727.jpg
             */

            private ImagesBean images;
            private String alt;
            private String id;
            private List<String> genres;
            /**
             * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/1351923505.88.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1351923505.88.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1351923505.88.jpg"}
             * name_en : Damian Lewis
             * name : 戴米恩·路易斯
             * alt : https://movie.douban.com/celebrity/1004573/
             * id : 1004573
             */

            private List<CastsBean> casts;
            private List<String> durations;
            /**
             * avatars : {"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
             * name_en : Phil Alden Robinson
             * name : 菲尔·奥尔登·罗宾森
             * alt : https://movie.douban.com/celebrity/1032246/
             * id : 1032246
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

            public static class RatingBean implements Serializable{
                private int max;
                private double average;
                /**
                 * 1 : 28
                 * 2 : 74
                 * 3 : 1305
                 * 4 : 7043
                 * 5 : 29529
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

            public static class CastsBean implements Serializable{
                /**
                 * small : https://img1.doubanio.com/img/celebrity/small/1351923505.88.jpg
                 * large : https://img1.doubanio.com/img/celebrity/large/1351923505.88.jpg
                 * medium : https://img1.doubanio.com/img/celebrity/medium/1351923505.88.jpg
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

            public static class DirectorsBean implements Serializable{
                /**
                 * small : https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
                 * large : https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
                 * medium : https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
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
}
