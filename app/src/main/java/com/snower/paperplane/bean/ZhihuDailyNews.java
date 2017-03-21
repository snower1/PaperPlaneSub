package com.snower.paperplane.bean;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/7.
 */
public class ZhihuDailyNews {

    //
    private String date;
    private ArrayList<Question> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Question> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Question> stories) {
        this.stories = stories;
    }

    public class Question{
        private ArrayList<String> images;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ArrayList<String> getImages() {
            return images;
        }

        public void setImages(ArrayList<String> images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "ga_prefix='" + ga_prefix + '\'' +
                    ", images=" + images +
                    ", type=" + type +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ZhihuDailyNews{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                '}';
    }
}
