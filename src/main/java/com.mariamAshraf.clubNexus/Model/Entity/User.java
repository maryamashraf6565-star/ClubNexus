package com.mariamAshraf.clubNexus.Model.Entity;

import com.mariamAshraf.clubNexus.Model.Entity.enums.Role;
import com.mariamAshraf.clubNexus.Model.Entity.enums.StudentStatus; // Import new enum
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    // ----- NEW FIELDS (Student info) -----
    @Enumerated(EnumType.STRING)
    @Column(name = "student_status")
    private StudentStatus studentStatus;

    @Column(name = "major", length = 100)
    private String major;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    // ----- Timestamps -----
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relationship: presides (0..1 per club)
    @OneToOne(mappedBy = "president", fetch = FetchType.LAZY)
    private Club presidedClub;

    // Relationship: has memberships
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Membership> memberships = new ArrayList<>();

    // Constructors
    public User() {}

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters (including new fields)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public StudentStatus getStudentStatus() { return studentStatus; }
    public void setStudentStatus(StudentStatus studentStatus) { this.studentStatus = studentStatus; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public Integer getGraduationYear() { return graduationYear; }
    public void setGraduationYear(Integer graduationYear) { this.graduationYear = graduationYear; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Club getPresidedClub() { return presidedClub; }
    public void setPresidedClub(Club presidedClub) { this.presidedClub = presidedClub; }

    public List<Membership> getMemberships() { return memberships; }
    public void setMemberships(List<Membership> memberships) { this.memberships = memberships; }
}