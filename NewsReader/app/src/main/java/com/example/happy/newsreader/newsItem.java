package com.example.happy.newsreader;

/**
 * Created by happy on 11/22/2016.
 */

public class newsItem {
    private String tittle;
    private String newsDesc;
    private String url;
    private String urlImage;
    private String author;

    public newsItem(String tittle, String newsDesc, String url,  String author) {
        this.tittle = tittle;
        this.newsDesc = newsDesc;
        this.urlImage = url;
        this.author = author;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageId() {
        return urlImage;
    }

    public void setImageId(String imageId) {
        this.urlImage = imageId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
