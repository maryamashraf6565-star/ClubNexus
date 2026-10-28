package com.mariamAshraf.clubNexus.Repository;
import com.mariamAshraf.clubNexus.Model.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News, Long> {

    List<News> findByClubId(Long clubId);

    List<News> findByAuthorId(Long authorId);

    // Most recent news first
    List<News> findByClubIdOrderByCreatedAtDesc(Long clubId);
}