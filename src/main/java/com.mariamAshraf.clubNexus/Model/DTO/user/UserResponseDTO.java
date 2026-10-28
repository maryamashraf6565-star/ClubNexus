package com.mariamAshraf.clubNexus.Model.DTO.user;

import com.mariamAshraf.clubNexus.Model.Entity.enums.Role;
import com.mariamAshraf.clubNexus.Model.Entity.enums.StudentStatus;

public class UserResponseDTO {
    private String username;
    private String email;
    private Role role;
    private StudentStatus studentStatus;
    private String major;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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