package com.mariamAshraf.clubNexus.Model.DTO.membership;

import com.mariamAshraf.clubNexus.Model.Entity.enums.MembershipStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class MembershipRequestDTO {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Club ID is required")
    private Long clubId;

    @NotNull(message = "Status is required")
    private MembershipStatus status;

    @NotNull(message = "Join date is required")
    private LocalDate joinDate;

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void setStatus(MembershipStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getters and setters...
}