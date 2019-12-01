package com.example.zhihudaily.gson;

import java.util.List;

public class ItenBean {

    /**
     * date : 20191121
     * stories : [{"image_hue":"0x918c3f","title":"人们为什么喜欢把 PC 《红色警戒》游戏中的间谍变成狗？","url":"https://daily.zhihu.com/story/9717579","hint":"地球研究报告 · 6 分钟阅读","ga_prefix":"112120","images":["https://pic4.zhimg.com/v2-1da00617ff034f89b82b4aa8b85439b3.jpg"],"type":0,"id":9717579},{"image_hue":"0xb3927d","title":"中国第一块人造培养肉诞生，具有怎样的意义？","url":"https://daily.zhihu.com/story/9717539","hint":"苏澄宇 · 3 分钟阅读","ga_prefix":"112115","images":["https://pic2.zhimg.com/v2-d92cb04a13f93121547c84555697d259.jpg"],"type":0,"id":9717539},{"image_hue":"0x7db389","title":"游戏作为第九艺术，传达能力是否受限？","url":"https://daily.zhihu.com/story/9717363","hint":"一张钞票 · 2 分钟阅读","ga_prefix":"112109","images":["https://pic1.zhimg.com/v2-b704a728dec2444d80e1be228078acb8.jpg"],"type":0,"id":9717363},{"image_hue":"0x1f2f2a","title":"买车占收入与存款多少比例合适？","url":"https://daily.zhihu.com/story/9717345","hint":"张凝澈 · 2 分钟阅读","ga_prefix":"112107","images":["https://pic3.zhimg.com/v2-6ae5d92b6e70d28c344cd3caab25970e.jpg"],"type":0,"id":9717345},{"image_hue":"0x292b3b","title":"瞎扯 · 如何正确地吐槽","url":"https://daily.zhihu.com/story/9717479","hint":"VOL.2266","ga_prefix":"112106","images":["https://pic3.zhimg.com/v2-b7ca7cc98f6e8bbfb53f3d2db07323da.jpg"],"type":0,"id":9717479}]
     * top_stories : [{"image_hue":"0x8d8962","hint":"作者 / SME情报员","url":"https://daily.zhihu.com/story/9717311","image":"https://pic1.zhimg.com/v2-b8c741043e5b4f31f75f8936eb809b88.jpg","title":"如何证明斑马是长着白色条纹的黑马？","ga_prefix":"111807","type":0,"id":9717311},{"image_hue":"0x2d4036","hint":"作者 / 一筑一事 大管家","url":"https://daily.zhihu.com/story/9717474","image":"https://pic2.zhimg.com/v2-60ca7cdc749dd163992b60a1ba212215.jpg","title":"成都的哪一点，让你很喜欢？","ga_prefix":"111909","type":0,"id":9717474},{"image_hue":"0xb38049","hint":"作者 / 2001室的库布里克","url":"https://daily.zhihu.com/story/9717181","image":"https://pic3.zhimg.com/v2-aa024b6af1f9a4d6862d117b14976f8e.jpg","title":"为什么真正的电影，都应该在电影院看？","ga_prefix":"111707","type":0,"id":9717181},{"image_hue":"0x6b5b4b","hint":"作者 / 菲利普医生","url":"https://daily.zhihu.com/story/9717007","image":"https://pic3.zhimg.com/v2-39597c2ea2dacfd2e1ff07d205f30e6e.jpg","title":"猫脑袋经常不小心撞到硬物会傻吗？","ga_prefix":"111616","type":0,"id":9717007},{"image_hue":"0x7da7b3","hint":"作者 / chenqin","url":"https://daily.zhihu.com/story/9717368","image":"https://pic3.zhimg.com/v2-26cece50231a1ceec29fb0fe3f9cc196.jpg","title":"双十一销售额完美拟合三次回归曲线，是巧合还是造假？","ga_prefix":"111216","type":0,"id":9717368}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * image_hue : 0x918c3f
         * title : 人们为什么喜欢把 PC 《红色警戒》游戏中的间谍变成狗？
         * url : https://daily.zhihu.com/story/9717579
         * hint : 地球研究报告 · 6 分钟阅读
         * ga_prefix : 112120
         * images : ["https://pic4.zhimg.com/v2-1da00617ff034f89b82b4aa8b85439b3.jpg"]
         * type : 0
         * id : 9717579
         */

        private String image_hue;
        private String title;
        private String url;
        private String hint;
        private String ga_prefix;
        private int type;
        public int id;
        private List<String> images;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image_hue : 0x8d8962
         * hint : 作者 / SME情报员
         * url : https://daily.zhihu.com/story/9717311
         * image : https://pic1.zhimg.com/v2-b8c741043e5b4f31f75f8936eb809b88.jpg
         * title : 如何证明斑马是长着白色条纹的黑马？
         * ga_prefix : 111807
         * type : 0
         * id : 9717311
         */

        private String image_hue;
        private String hint;
        private String url;
        private String image;
        private String title;
        private String ga_prefix;
        private int type;
        private int id;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
