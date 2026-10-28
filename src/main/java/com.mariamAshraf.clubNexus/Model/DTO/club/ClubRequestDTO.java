package com.mariamAshraf.clubNexus.Model.DTO.club;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClubRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    private String description;

    @Size(max = 100)
    private String category;

    private Long presidentId; // only ID, not full object

    // New location fields
    private String university;
    private String universityLocation;
    private String country;

    // Getters and setters
}