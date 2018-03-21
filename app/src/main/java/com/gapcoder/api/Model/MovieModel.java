package com.gapcoder.api.Model;

import java.util.List;

/**
 * Created by suxiaohui on 2018/3/21.
 */

public class MovieModel {

    /**
     * rating : {"max":10,"average":6.4,"stars":"35","min":0}
     * reviews_count : 516
     * wish_count : 15653
     * douban_site :
     * year : 2018
     * images : {"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg"}
     * alt : https://movie.douban.com/subject/3445906/
     * id : 3445906
     * mobile_url : https://movie.douban.com/subject/3445906/mobile
     * title : 古墓丽影：源起之战
     * do_count : null
     * share_url : http://m.douban.com/movie/subject/3445906
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/3445906/cinema/
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动作","冒险"]
     * collect_count : 32385
     * casts : [{"alt":"https://movie.douban.com/celebrity/1233154/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg"},"name":"艾丽西亚·维坎德","id":"1233154"},{"alt":"https://movie.douban.com/celebrity/1027173/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.jpg"},"name":"多米尼克·威斯特","id":"1027173"},{"alt":"https://movie.douban.com/celebrity/1098551/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.jpg"},"name":"沃尔顿·戈金斯","id":"1098551"},{"alt":"https://movie.douban.com/celebrity/1027502/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23544.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23544.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23544.jpg"},"name":"吴彦祖","id":"1027502"}]
     * current_season : null
     * original_title : Tomb Raider
     * summary : 劳拉·克劳馥年少时，她的冒险家父亲突然神秘消失。她拒绝接受父亲已经去世的事实，并暗下决心要解开父亲神秘死亡的谜团。
     放下眼前的一切，劳拉前往父亲最后出现的地方探寻——一座传说中的古墓，位于日本附近某个神秘岛上。要踏上这场未知的旅程，她必须以敏锐的头脑、坚定的信仰和顽强的精神武装自己，并迫使自己超越极限。如果她能在这场危机四伏的冒险中存活下来，她才可能成长为名副其实的——“古墓丽影”。
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1051062/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg"},"name":"罗阿尔·乌索格","id":"1051062"}]
     * comments_count : 15738
     * ratings_count : 30695
     * aka : ["盗墓者罗拉(港)","古墓奇兵(台)","新古墓丽影"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
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

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
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

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
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

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 6.4
         * stars : 35
         * min : 0
         */

        private int max;
        private double average;
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
    }

    public static class ImagesBean {
        /**
         * small : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg
         * large : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg
         * medium : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.jpg
         */

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
         * alt : https://movie.douban.com/celebrity/1233154/
         * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg"}
         * name : 艾丽西亚·维坎德
         * id : 1233154
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg
             * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg
             * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.jpg
             */

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
         * alt : https://movie.douban.com/celebrity/1051062/
         * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg"}
         * name : 罗阿尔·乌索格
         * id : 1051062
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg
             * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg
             * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.jpg
             */

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
