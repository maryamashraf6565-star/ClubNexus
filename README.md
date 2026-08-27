# 🏛️ ClubNexus – University Club Management Platform

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2+-green?style=flat&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=flat&logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-Security-yellow?style=flat&logo=jsonwebtokens)
![Docker](https://img.shields.io/badge/Docker-Ready-blue?style=flat&logo=docker)

---

## 📖 Overview

**ClubNexus** is a RESTful API platform designed to help university clubs register, manage members, and share news. It provides a secure, role-based system where:

- **Admins** oversee all clubs and users.
- **Club Presidents** manage their own club’s details and post announcements.
- **Members** browse clubs, join, and stay updated with a personalized news feed.

The project is built with **Spring Boot** and follows a clean, layered architecture (Controller → Service → Repository). It includes full authentication via **JWT**, input validation, centralized exception handling, and is container-ready with **Docker**.

---

## ✨ Key Features

### 🧑‍💼 Role-Based Access
| Role | Permissions |
| :--- | :--- |
| **ADMIN** | Create/delete any club, promote users, view all system stats. |
| **PRESIDENT** | Edit their own club, post news, approve/remove members. |
| **MEMBER** | Browse clubs, join/leave clubs, view news feeds, update profile. |

### 🚀 Core Functionality
- **Club Management** – CRUD operations for university clubs (name, description, category, president).
- **Membership System** – Users can join/leave clubs; each membership has a `joinDate`.
- **News Feed** – Presidents can post news to their club; members see aggregated news from all their clubs.
- **Dashboard Statistics** – Get real-time counts of total clubs, total members, and most popular clubs.
- **Secure Authentication** – Login with username/password, returns a JWT for subsequent requests. Passwords are hashed with BCrypt.
- **Input Validation** – All request payloads validated with `@NotNull`, `@Size`, etc.
- **Global Exception Handling** – Clean, consistent error responses using `@ControllerAdvice`.
- **API Documentation** – Swagger/OpenAPI 3 integrated (`/swagger-ui.html`).

---

## 🧪 Advanced (Level 2) Features
- **Real-Time Notifications** – WebSocket/SSE push alerts when new news is posted.
- **Concurrency Control** – Optimistic locking (`@Version`) prevents overbooking when many users join a popular club simultaneously.
- **Caching** – Spring Cache + Redis for lightning-fast dashboard stats (response time < 200ms).
- **Rate Limiting** – Prevent brute-force attacks on `/login` using Bucket4j.
- **Docker Compose** – Spin up the entire stack (app + PostgreSQL + Redis) with a single command.

---

## 🏗️ Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Backend Framework** | Spring Boot 3.2+ (MVC) |
| **Security** | Spring Security 6, JWT (jjwt), BCrypt |
| **Database** | PostgreSQL / MySQL (with Spring Data JPA) |
| **Caching** | Spring Cache + Redis (Level 2) |
| **Real-Time** | WebSocket / Server-Sent Events (Level 2) |
| **Containerization** | Docker & Docker Compose |
| **Testing** | JUnit 5, Mockito |
| **API Docs** | SpringDoc OpenAPI (Swagger) |
| **Build Tool** | Maven or Gradle |

---

## 📂 Project Structure
clubnexus/
├── src/
│ ├── main/
│ │ ├── java/com/clubnexus/
│ │ │ ├── config/ # Security, JWT, Redis, WebSocket configs
│ │ │ ├── controller/ # REST endpoints (User, Club, News, Membership)
│ │ │ ├── service/ # Business logic layer
│ │ │ ├── repository/ # JPA repositories
│ │ │ ├── entity/ # JPA entities (User, Club, News, Membership)
│ │ │ ├── dto/ # Data Transfer Objects (request/response)
│ │ │ ├── exception/ # Custom exceptions & global handler
│ │ │ └── utils/ # JWT utility, validation helpers
│ │ └── resources/
│ │ ├── application.yml # Main config (profiles, DB, JWT, Redis)
│ │ └── db/migration/ # Flyway/Liquibase scripts (optional)
│ └── test/ # Unit & integration tests
├── Dockerfile
├── docker-compose.yml
├── README.md
└── pom.xml / build.gradl
