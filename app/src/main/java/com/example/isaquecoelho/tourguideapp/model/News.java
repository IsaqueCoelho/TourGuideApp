package com.example.isaquecoelho.tourguideapp.model;

public class News {

    private String newsTitle;
    private String newsDescription;
    private int newsImage;
    private String newsLink;

    public News(String newsTitle, String newsDescription, int newsImage, String newsLink) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsImage = newsImage;
        this.newsLink = newsLink;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public String getNewsLink() {
        return newsLink;
    }
}
