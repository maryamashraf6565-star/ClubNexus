package com.mariamAshraf.clubNexus.Model.DTO.user;

import com.mariamAshraf.clubNexus.Model.Entity.enums.Role;
import com.mariamAshraf.clubNexus.Model.Entity.enums.StudentStatus;
import jakarta.validation.constraints.*;

public class UserRequestDTO {

    @NotBlank(message = "Username is required")
    @Size(max = 100)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 255)
    private String password;

    @NotNull(message = "Role is required")
    private Role role;

    private boolean enabled = true;

    @NotNull(message = "Role is required")
    private StudentStatus studentStatus;

    @NotNull(message = "Major is required")
    private String major;

    @NotNull(message = "Graduation year is required")
    private Integer graduationYear;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}