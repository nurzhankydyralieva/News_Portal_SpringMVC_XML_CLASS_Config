package com.epam.project.repositories;

import com.epam.project.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM News WHERE id IN(?1)")
    void deleteNewsById(List<Integer> id);
}
