package com.epam.project.services;

import com.epam.project.models.News;
import com.epam.project.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News findNewsById(int id) {
        Optional<News> foundNews = newsRepository.findById(id);
        return foundNews.orElse(null);
    }

    @Transactional
    public void save(News news) {
        newsRepository.save(news);
    }

    @Transactional
    public void updateNews(int id, News updatedNews) {
        updatedNews.setId(id);
        newsRepository.save(updatedNews);
    }

    @Transactional
    public void delete(int id) {
        newsRepository.deleteById(id);
    }

    @Transactional
    public void deleteNewsById(Integer[] id) {
        newsRepository.deleteNewsById(Arrays.asList(id));
    }
}
