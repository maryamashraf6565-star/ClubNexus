package com.mariamAshraf.clubNexus.Repository;
import com.mariamAshraf.clubNexus.Model.Entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long> {

    Optional<Club> findByName(String name);

    boolean existsByName(String name);

    List<Club> findByPresidentId(Long presidentId);
}