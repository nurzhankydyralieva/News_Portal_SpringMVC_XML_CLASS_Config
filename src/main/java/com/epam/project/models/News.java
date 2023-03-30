package com.epam.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "News Title should not be empty")
    @Size(min = 10, max = 50, message = "News Title should be between 10 to 200 characters")
    @Column(name = "newsTitle")
    private String newsTitle;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "newsDate")
    private LocalDate newsDate;
    @NotEmpty(message = "Brief should not be empty")
    @Size(min = 10, max = 500, message = "Brief should be between 10 to 500 characters")
    @Column(name = "brief")
    private String brief;
    @NotEmpty(message = "Content should not be empty")
    @Size(min = 10, max = 1000, message = "Content should be between 20 to 1000 characters")
    @Column(name = "content")
    private String content;

    public News() {
    }

    public News(String newsTitle, LocalDate newsDate, String brief, String content) {
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
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

    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
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

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDate=" + newsDate +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
