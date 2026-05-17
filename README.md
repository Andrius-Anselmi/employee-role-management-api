<div align="center">

# Employee & Role Management API

### A production-grade REST API for organizational structure.
### Built the right way — JWT security, layered architecture, zero shortcuts, full DTO encapsulation.

&nbsp;

[![Java](https://img.shields.io/badge/java-17_LTS-ED8B00?style=flat-square&labelColor=0a0e14&logo=openjdk&logoColor=ED8B00)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/spring_boot-4.x-6DB33F?style=flat-square&labelColor=0a0e14&logo=spring&logoColor=6DB33F)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/spring_security-JWT-6DB33F?style=flat-square&labelColor=0a0e14&logo=springsecurity&logoColor=6DB33F)](https://spring.io/projects/spring-security)
[![PostgreSQL](https://img.shields.io/badge/postgresql-15+-4169E1?style=flat-square&labelColor=0a0e14&logo=postgresql&logoColor=4169E1)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/docker-compose-2496ED?style=flat-square&labelColor=0a0e14&logo=docker&logoColor=2496ED)](https://www.docker.com/)
[![Flyway](https://img.shields.io/badge/flyway-migrations-CC0200?style=flat-square&labelColor=0a0e14&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Maven](https://img.shields.io/badge/maven-3.8+-C71A36?style=flat-square&labelColor=0a0e14&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Status](https://img.shields.io/badge/status-active_development-F0A500?style=flat-square&labelColor=0a0e14)](.)
[![License](https://img.shields.io/badge/license-MIT-b0e8ff?style=flat-square&labelColor=0a0e14)](./LICENSE)

&nbsp;

[Quick Start](#quick-start) · [Architecture](#architecture) · [API Reference](#api-reference) · [Security](#security) · [Design Decisions](#design-decisions) · [Roadmap](#roadmap)

&nbsp;

| | | |
|---|---|---|
| **4 layers** strictly separated | **JWT** stateless authentication | **12-Factor** compliant config |
| **Zero** domain model leakage | **Custom exceptions** & global handler | **Flyway** version-controlled schema |

</div>

---

> ⚠️ **Work in progress** — core API is stable and functional. Update endpoints and filtering features are actively being developed. See the [Roadmap](#roadmap) for what's coming next.

---

## The Problem

Building an employee management system is easy. Building one that holds up in production is not.

Most tutorials give you a `@RestController` that talks directly to the database, returns your JPA entity as JSON, and calls it a day. That works until it doesn't — until a lazy-loaded relationship triggers a thousand extra queries, until a refactor breaks the API contract, until someone runs the app on a new machine and the schema is out of sync, until there's no authentication and anyone can hit your endpoints.

This project is built around the decisions that prevent those failures: JWT-based stateless authentication, a strict four-layer architecture, DTOs that decouple the API contract from the domain model, centralized exception handling, Flyway for schema migrations, and environment-variable-driven config.

---

## Quick Start

**Prerequisites:** JDK 17+, Maven 3.8+, Docker

```bash
git clone https://github.com/Andrius-Anselmi/employee-role-management-api.git
cd employee-role-management-api
```

Start PostgreSQL via Docker:

```bash
docker compose up -d
```

Set environment variables:

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/gerenciamento
export SPRING_DATASOURCE_USERNAME=admin
export SPRING_DATASOURCE_PASSWORD=admin
export EMPLOYEE_API_SECRET=your_jwt_secret_here
```

Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

API available at `http://localhost:8080`. No manual schema setup needed — Flyway runs migrations automatically on startup.

> **Note:** All endpoints except `/auth/registrar` and `/auth/login` require a valid JWT token.

---

## Architecture

Four layers. Each one knows nothing about the others except the interface it depends on.

```
  HTTP Request
       │
       ▼
┌─────────────────────────────────────────────┐
│  Security Layer                             │
│  JWT validation on every request            │
│  SecurityFilter + TokenService              │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Controller Layer                           │
│  Handles HTTP, status codes, routing        │
│  Returns DTOs — never domain models         │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Service Layer                              │
│  All business rules live here               │
│  Validates, orchestrates, transforms        │
│  Throws typed exceptions on failure         │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Repository Layer                           │
│  Spring Data JPA — optimized queries        │
│  Schema managed by Flyway migrations        │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  PostgreSQL 15+ (Docker)                    │
│  Source of truth — never exposed directly   │
└─────────────────────────────────────────────┘
```

---

## Security

Authentication is stateless and JWT-based. No sessions, no cookies.

**Register** a user, **login** to receive a token, then include it in every request:

```
Authorization: Bearer <your_token>
```

The `SecurityFilter` intercepts every request, validates the token via `TokenService`, and sets the authentication context. Invalid or missing tokens result in `403 Forbidden`.

Passwords are hashed with **BCrypt** before being stored — plain-text passwords never touch the database.

```
POST /auth/registrar  →  creates user, hashes password
POST /auth/login      →  validates credentials, returns JWT
All other routes      →  require valid Bearer token
```

---

## API Reference

### Auth

| Method | Route | Description | Auth | Status |
|--------|-------|-------------|------|--------|
| `POST` | `/auth/registrar` | Register a new user | ❌ | `201` |
| `POST` | `/auth/login` | Authenticate and receive JWT | ❌ | `200` |

### Employees

| Method | Route | Description | Auth | Status |
|--------|-------|-------------|------|--------|
| `GET` | `/employees` | All employees | ✅ | `200` |
| `GET` | `/employees/{id}` | Single employee by ID | ✅ | `200` / `404` |
| `POST` | `/employees` | Create employee | ✅ | `201` |
| `DELETE` | `/employees/{id}` | Remove employee | ✅ | `204` / `404` |
| `PUT` | `/employees/{id}` | Update employee | ✅ | 🚧 in development |

### Positions

| Method | Route | Description | Auth | Status |
|--------|-------|-------------|------|--------|
| `GET` | `/positions` | All positions | ✅ | `200` |
| `GET` | `/positions/{id}` | Single position by ID | ✅ | `200` / `404` |
| `POST` | `/positions` | Create position | ✅ | `201` |
| `DELETE` | `/positions/{id}` | Remove position | ✅ | `204` / `404` |
| `PUT` | `/positions/{id}` | Update position | ✅ | 🚧 in development |

---

## Exception Handling

Errors are handled globally via `GlobalExceptionHandler`. No try/catch blocks scattered across controllers.

| Exception | HTTP Status | When |
|-----------|-------------|------|
| `NotFoundException` | `404 Not Found` | Resource not found by ID |

Error messages are centralized in `ExceptionMessages` — one constant per message, changed in one place.

---

## Seniority Levels

Positions are classified by seniority via an enum, stored as a string in the database:

```
JUNIOR · MID · SENIOR · TECH_LEAD
```

The `@JsonCreator` annotation allows case-insensitive input — `"junior"`, `"Junior"`, and `"JUNIOR"` all work.

---

## Design Decisions

Every pattern here is a deliberate choice, not boilerplate.

**JWT Authentication** — Stateless token-based security. No server-side session state. Every request is self-contained and independently verifiable. Scales horizontally without coordination.

**DTO encapsulation** — JPA entities are never serialized into API responses. DTOs give the API a stable contract independent of the database schema. Rename a column, change a relationship — the client never knows.

**Global exception handling** — `@RestControllerAdvice` intercepts typed exceptions and maps them to HTTP responses. Controllers and services stay clean. Error format is consistent across the entire API.

**Utility class mappers** — `@UtilityClass` enforces stateless, static-only mapper methods. No instantiation, no injection, no state — just pure transformation functions.

**Flyway migrations** — Schema changes are version-controlled SQL files. Every environment runs the exact same migrations in the exact same order. No more schema drift between machines.

**12-Factor config** — Database URL, credentials, and JWT secret come from environment variables. The same artifact runs in any environment without modification.

---

## Roadmap

Features actively being developed:

- [ ] `PUT /employees/{id}` — full employee update
- [ ] `PUT /positions/{id}` — full position update
- [ ] Filter employees by position, seniority and state
- [ ] Pagination and sorting on list endpoints

---

## Tech Stack

| Component | Technology | Why |
|-----------|-----------|-----|
| Language | Java 17 LTS | Records, pattern matching, long-term support |
| Framework | Spring Boot 4.x | Industry standard, powerful DI ecosystem |
| Security | Spring Security + JWT (auth0) | Stateless, scalable authentication |
| Persistence | Spring Data JPA + Hibernate | Clean abstraction over JDBC |
| Database | PostgreSQL 15+ | Reliable, production-proven |
| Container | Docker + Docker Compose | Reproducible environments |
| Migrations | Flyway | Version-controlled schema |
| Build | Maven 3.8+ | Predictable lifecycle |

---

## Project Structure

```
src/
└── main/
    └── java/
        └── dev/java/management/
            ├── config/         # SecurityConfig, SecurityFilter, JWTuserData
            ├── controller/     # HTTP layer — routes and status codes
            ├── service/        # Business logic — rules and validation
            ├── repository/     # Data access — JPA queries
            ├── entity/         # Domain entities — source of truth
            ├── enums/          # Seniority enum
            ├── mapper/         # DTO transformation — @UtilityClass
            ├── request/        # Inbound DTOs
            ├── response/       # Outbound DTOs
            └── exception/      # Custom exceptions + GlobalExceptionHandler
    └── resources/
        └── db/migration/       # Flyway SQL migrations (V1__, V2__...)
```

---

## Database Schema

```
┌──────────────┐         ┌───────────────┐
│   employee   │         │   positions   │
│──────────────│         │───────────────│
│ id           │────────▶│ id            │
│ name         │         │ title         │
│ age          │         │ salary        │
│ state        │         │ description   │
│ city         │         │ seniority     │
│ position_id  │         └───────────────┘
└──────────────┘

┌──────────────┐
│    users     │
│──────────────│
│ id           │
│ name         │
│ email        │
│ password     │
└──────────────┘
```

---

## Contributing

Issues and PRs welcome. If you're adding a feature, open the service layer first — business logic belongs there, not in controllers or repositories.

## License

MIT — see [LICENSE](./LICENSE).

---

<div align="center">

Built by [Andrius Anselmi](https://github.com/Andrius-Anselmi) · [LinkedIn](https://www.linkedin.com/in/andrius-anselmi)

</div>
