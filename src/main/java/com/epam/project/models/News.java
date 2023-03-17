package com.epam.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


public class News {
    private int id;
    @NotEmpty(message = "News Title should not be empty")
    @Size(min = 10, max = 50, message = "News Title should be between 10 to 200 characters")
    private String newsTitle;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date newsDate;

    private Date createdAt;
    @NotEmpty(message = "Brief should not be empty")
    @Size(min = 10, max = 500, message = "Brief should be between 10 to 500 characters")
    private String brief;
    @NotEmpty(message = "Content should not be empty")
    @Size(min = 10, max = 1000, message = "Content should be between 20 to 1000 characters")
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
