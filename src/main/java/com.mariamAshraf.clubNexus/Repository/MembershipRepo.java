package com.mariamAshraf.clubNexus.Repository;
import com.mariamAshraf.clubNexus.Model.Entity.Membership;
import com.mariamAshraf.clubNexus.Model.Entity.enums.MembershipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, Long> {

    // Enforces the unique constraint (one request per user per club)
    Optional<Membership> findByUserIdAndClubId(Long userId, Long clubId);

    List<Membership> findByUserId(Long userId);

    List<Membership> findByClubId(Long clubId);

    List<Membership> findByUserIdAndStatus(Long userId, MembershipStatus status);

    List<Membership> findByClubIdAndStatus(Long clubId, MembershipStatus status);

    boolean existsByUserIdAndClubId(Long userId, Long clubId);
}