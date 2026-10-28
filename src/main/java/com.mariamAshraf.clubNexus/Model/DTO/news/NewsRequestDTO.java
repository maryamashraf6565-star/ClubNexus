package com.mariamAshraf.clubNexus.Model.DTO.news;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewsRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    @NotNull(message = "Club ID is required")
    private Long clubId;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    // Constructors
    public NewsRequestDTO() {}

    public NewsRequestDTO(String title, String content, Long clubId, Long authorId) {
        this.title = title;
        this.content = content;
        this.clubId = clubId;
        this.authorId = authorId;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}