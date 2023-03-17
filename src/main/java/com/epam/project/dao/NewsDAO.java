package com.epam.project.dao;

import com.epam.project.models.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class NewsDAO {
    private static int COUNT;
    private List<News> newsList;

    {
        newsList = new ArrayList<>();
        newsList.add(new News(++COUNT, "sport", new Date(2020, 02, 03), new Date(2020, 02, 03), "sport", "sport"));
        newsList.add(new News(++COUNT, "fashion", new Date(2020, 02, 03), new Date(2020, 02, 03), "sport", "sport"));
        newsList.add(new News(++COUNT, "dance", new Date(2020, 02, 03), new Date(2020, 02, 03), "sport", "sport"));
    }

    public List<News> indexPage() {
        return newsList;
    }

    public News showNews(int id) {
        return newsList.stream().filter(news -> news.getId() == id).findAny().orElse(null);
    }

    public void saveNews(News news) {
        news.setId(++COUNT);
        newsList.add(news);
    }

    public void updateNews(int id, News updatedNews) {
        News newsToBeUpdated = showNews(id);
        newsToBeUpdated.setNewsTitle(updatedNews.getNewsTitle());
        newsToBeUpdated.setNewsDate(updatedNews.getNewsDate());
        newsToBeUpdated.setBrief(updatedNews.getBrief());
        newsToBeUpdated.setContent(updatedNews.getContent());
    }

    public void deleteNews(int id) {
        newsList.removeIf(news -> news.getId() == id);
    }
}
