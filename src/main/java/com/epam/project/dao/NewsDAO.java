package com.epam.project.dao;

import com.epam.project.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<News> indexPage() {
        return jdbcTemplate.query("SELECT * FROM News", new BeanPropertyRowMapper<>(News.class));
    }

    public News showNews(int id) {
        return jdbcTemplate.query("SELECT * FROM News WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(News.class)).stream().findAny().orElse(null);
    }

    public void saveNews(News news) {
        jdbcTemplate.update("INSERT INTO News VALUES (1,?,?,?,?,?)",
                news.getNewsTitle(), news.getNewsDate(), news.getCreatedAt(), news.getBrief(), news.getContent());
    }

    public void updateNews(int id, News updatedNews) {
        jdbcTemplate.update("UPDATE News SET newsTitle=?, newsDate=?, brief=?, content=? WHERE id=?",
                updatedNews.getNewsTitle(), updatedNews.getNewsDate(), updatedNews.getBrief(), updatedNews.getContent(), id);
    }

    public void deleteNews(int id) {
        jdbcTemplate.update("DELETE FROM News WHERE id=?", id);
    }
}
