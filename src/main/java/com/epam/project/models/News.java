package com.epam.project.models;

import java.util.Date;


public class News {
    private int id;
    private String newsTitle;
    private Date newsDate;
    private Date createdAt;
    private String brief;
    private String content;

    public News() {
    }

    public News(int id, String newsTitle, Date newsDate, Date createdAt, String brief, String content) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.createdAt = createdAt;
        this.brief = brief;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
