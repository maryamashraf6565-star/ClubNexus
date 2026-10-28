package com.mariamAshraf.clubNexus.Model.Entity;

import com.mariamAshraf.clubNexus.Model.Entity.enums.MembershipStatus;
import jakarta.persistence.*;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;

@Entity
@Table(
        name = "memberships",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_user_club",
                        columnNames = {"user_id", "club_id"}
                )
        }
)
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MembershipStatus status;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    // Optimistic locking (Level 2 as mentioned in your schema)
    @Version
    @Column(name = "version", nullable = false)
    private Integer version = 0;

    // Constructors, Getters, and Setters
    public Membership() {}

    public Membership(User user, Club club, MembershipStatus status, LocalDate joinDate) {
        this.user = user;
        this.club = club;
        this.status = status;
        this.joinDate = joinDate;
    }

    // Getters and Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }
    public MembershipStatus getStatus() { return status; }
    public void setStatus(MembershipStatus status) { this.status = status; }
    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}