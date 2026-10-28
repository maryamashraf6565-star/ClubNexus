package com.mariamAshraf.clubNexus.Model.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "category", length = 100)
    private String category;  // e.g., "Tech", "Arts", "Business"

    // ----- NEW LOCATION FIELDS -----
    @Column(name = "university", length = 200)
    private String university;

    @Column(name = "university_location", length = 100)
    private String universityLocation; // city/region

    @Column(name = "country", length = 100)
    private String country;

    // Foreign Key: president_id (correctly mapped as @OneToOne with unique constraint)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "president_id", unique = true)
    private User president;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Membership> memberships = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<News> newsList = new ArrayList<>();

    // Constructors
    public Club() {}

    public Club(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters and Setters (including new fields)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getUniversityLocation() { return universityLocation; }
    public void setUniversityLocation(String universityLocation) { this.universityLocation = universityLocation; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public User getPresident() { return president; }
    public void setPresident(User president) { this.president = president; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<Membership> getMemberships() { return memberships; }
    public void setMemberships(List<Membership> memberships) { this.memberships = memberships; }

    public List<News> getNewsList() { return newsList; }
    public void setNewsList(List<News> newsList) { this.newsList = newsList; }
}