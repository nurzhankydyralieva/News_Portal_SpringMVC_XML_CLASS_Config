package com.epam.project.dao;

import com.epam.project.models.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class NewsDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public NewsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<News> indexPage() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT n FROM News n", News.class).getResultList();
    }

    @Transactional(readOnly = true)
    public News showNews(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(News.class, id);
    }

    @Transactional
    public void saveNews(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    @Transactional
    public void updateNews(int id, News updatedNews) {
        Session session = sessionFactory.getCurrentSession();
        News newsToUpdated = session.get(News.class, id);
        newsToUpdated.setNewsTitle(updatedNews.getNewsTitle());
        newsToUpdated.setNewsDate(updatedNews.getNewsDate());
        newsToUpdated.setBrief(updatedNews.getBrief());
        newsToUpdated.setContent(updatedNews.getContent());
    }

    @Transactional
    public void deleteNews(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(News.class,id));
    }
}
