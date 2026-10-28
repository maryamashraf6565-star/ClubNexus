package com.mariamAshraf.clubNexus.Model.DTO.membership;

import com.mariamAshraf.clubNexus.Model.Entity.enums.MembershipStatus;
import java.time.LocalDate;

public class MembershipResponseDTO {

    private Long id;

    // Flattened user info
    private Long userId;
    private String username;          // Optional, for UI display

    // Flattened club info
    private Long clubId;
    private String clubName;          // Optional, for UI display

    private MembershipStatus status;
    private LocalDate joinDate;
    private Integer version;          // For optimistic locking if the client needs it

    // Constructors
    public MembershipResponseDTO() {}

    public MembershipResponseDTO(Long id, Long userId, String username, Long clubId, String clubName,
                                 MembershipStatus status, LocalDate joinDate, Integer version) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.clubId = clubId;
        this.clubName = clubName;
        this.status = status;
        this.joinDate = joinDate;
        this.version = version;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }

    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }

    public MembershipStatus getStatus() { return status; }
    public void setStatus(MembershipStatus status) { this.status = status; }

    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}