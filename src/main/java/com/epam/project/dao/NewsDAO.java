package com.epam.project.dao;

import com.epam.project.models.News;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/newsdb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> indexPage() {

        List<News> newsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM News";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setNewsTitle(resultSet.getString("newsTitle"));
                news.setNewsDate(resultSet.getDate("newsDate"));
                news.setBrief(resultSet.getString("brief"));
                news.setContent(resultSet.getString("content"));
                newsList.add(news);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newsList;
    }

    public News showNews(int id) {
        News news = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM News WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            news = new News();

            news.setId(resultSet.getInt("id"));
            news.setNewsTitle(resultSet.getString("newsTitle"));
            news.setNewsDate(resultSet.getDate("newsDate"));
            news.setBrief(resultSet.getString("brief"));
            news.setContent(resultSet.getString("content"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    public void saveNews(News news) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO News VALUES (1,?,?,?,?,?)");
            preparedStatement.setString(1, news.getNewsTitle());
            preparedStatement.setDate(2, new java.sql.Date(news.getNewsDate().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(news.getCreatedAt().getTime()));
            preparedStatement.setString(4, news.getBrief());
            preparedStatement.setString(5, news.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateNews(int id, News updatedNews) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE News SET newsTitle=?, newsDate=?, brief=?, content=? WHERE id=?");

            preparedStatement.setString(1, updatedNews.getNewsTitle());
            preparedStatement.setDate(2, new java.sql.Date(updatedNews.getNewsDate().getTime()));
            preparedStatement.setString(3, updatedNews.getBrief());
            preparedStatement.setString(4, updatedNews.getContent());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNews(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM News WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
