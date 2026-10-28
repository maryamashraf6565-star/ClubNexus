package com.mariamAshraf.clubNexus.Model.DTO.news;

import java.time.LocalDateTime;

public class NewsResponseDTO {

    private Long id;
    private String title;
    private String content;

    // Flattened references (IDs + display names)
    private Long clubId;
    private String clubName;          // Optional, for UI display

    private Long authorId;
    private String authorUsername;    // Optional, for UI display

    private LocalDateTime createdAt;

    // Constructors
    public NewsResponseDTO() {}

    public NewsResponseDTO(Long id, String title, String content, Long clubId, String clubName,
                           Long authorId, String authorUsername, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.clubId = clubId;
        this.clubName = clubName;
        this.authorId = authorId;
        this.authorUsername = authorUsername;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }

    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public String getAuthorUsername() { return authorUsername; }
    public void setAuthorUsername(String authorUsername) { this.authorUsername = authorUsername; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}