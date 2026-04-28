<div align="center">

# Employee & Role Management API

### A production-grade REST API for organizational structure. Built the right way — layered architecture, zero shortcuts, full DTO encapsulation.

&nbsp;

Most employee management tutorials stop at CRUD. This one doesn't. Every design decision here — DTOs, service layer isolation, N+1 prevention, Flyway migrations, 12-Factor config — exists because real systems break without them.

&nbsp;

[![Java](https://img.shields.io/badge/java-17_LTS-ED8B00?style=flat-square&labelColor=0a0e14&logo=openjdk&logoColor=ED8B00)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/spring_boot-3.x-6DB33F?style=flat-square&labelColor=0a0e14&logo=spring&logoColor=6DB33F)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/postgresql-14+-4169E1?style=flat-square&labelColor=0a0e14&logo=postgresql&logoColor=4169E1)](https://www.postgresql.org/)
[![Hibernate](https://img.shields.io/badge/hibernate-JPA-59666C?style=flat-square&labelColor=0a0e14&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![Maven](https://img.shields.io/badge/maven-3.8+-C71A36?style=flat-square&labelColor=0a0e14&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-MIT-b0e8ff?style=flat-square&labelColor=0a0e14)](./LICENSE)

&nbsp;

[Quick Start](#quick-start) · [Architecture](#architecture) · [API Reference](#api-reference) · [Design Decisions](#design-decisions)

&nbsp;

| | | |
|---|---|---|
| **4 layers** strictly separated | **Zero** domain model leakage to clients | **12-Factor** compliant config |

</div>

---

## The Problem

Building an employee management system is easy. Building one that holds up in production is not.

Most tutorials give you a `@RestController` that talks directly to the database, returns your JPA entity as JSON, and calls it a day. That works until it doesn't — until a lazy-loaded relationship triggers a thousand extra queries, until a refactor breaks the API contract, until someone runs the app on a new machine and the schema is out of sync.

This project is built around the decisions that prevent those failures: a strict four-layer architecture, DTOs that decouple the API contract from the domain model, Flyway for schema migrations that actually version-control your database, and environment-variable-driven config that works the same in development, staging, and production.

---

> ⚠️ **Work in progress:** tests, Docker support, and English 
> source code refactor are actively being added.

## Quick Start

**Prerequisites:** JDK 17+, Maven 3.8+, PostgreSQL 14+

```bash
git clone https://github.com/Andrius-Anselmi/employee-role-management-api.git
cd employee-role-management-api
```

Create the database:

```sql
CREATE DATABASE employee_management;
```

Set environment variables:

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/employee_management
export DATABASE_USERNAME=your_db_user
export DATABASE_PASSWORD=your_db_password
```

Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

API available at `http://localhost:8080`. No manual schema setup needed — Flyway runs migrations automatically on startup.

---

## Architecture

Four layers. Each one knows nothing about the others except the interface it depends on.

```
  HTTP Request
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
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Repository Layer                           │
│  Spring Data JPA — optimized queries        │
│  N+1 prevention via JOIN FETCH              │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Domain Model + PostgreSQL                  │
│  Source of truth — never exposed directly   │
│  Schema managed by Flyway migrations        │
└─────────────────────────────────────────────┘
```

**Controllers** are thin. They receive a request, call a service, and return a response. No business logic.

**Services** are the brain. Every validation, every rule, every cross-entity operation lives here. If it involves a decision, it belongs in the service layer.

**Repositories** talk to the database. Nothing else. Queries are optimized at this layer — JOIN FETCH prevents N+1 on employee-role relationships.

**DTOs** sit between layers. The client never sees a JPA entity. If the domain model changes, the API contract stays stable.

---

## API Reference

### Employees

| Method | Route | Description | Status |
|--------|-------|-------------|--------|
| `GET` | `/api/employees` | All employees with role details | `200` |
| `GET` | `/api/employees/{id}` | Single employee by ID | `200` / `404` |
| `POST` | `/api/employees` | Create employee with DTO validation | `201` |
| `PUT` | `/api/employees/{id}` | Full update — idempotent | `200` / `404` |
| `DELETE` | `/api/employees/{id}` | Remove employee | `204` / `404` |

### Roles

| Method | Route | Description | Status |
|--------|-------|-------------|--------|
| `GET` | `/api/roles` | All available roles | `200` |
| `POST` | `/api/roles` | Register a new role | `201` |

---

## Design Decisions

Every pattern here is a deliberate choice, not boilerplate.

**DTO encapsulation** — JPA entities are never serialized directly into API responses. DTOs give the API a stable contract independent of the database schema. Rename a column, change a relationship — the client never knows.

**N+1 prevention** — A naive `findAll()` on employees triggers one query per employee to load their roles. The repository layer uses `JOIN FETCH` to collapse that into a single query regardless of dataset size.

**Flyway migrations** — Schema changes are version-controlled SQL files. Every environment — local, staging, production — runs the exact same migrations in the exact same order. No more "works on my machine" schema drift.

**12-Factor config** — Database URL, username, and password come from environment variables. The same artifact runs in any environment without modification.

**Stateless design** — No session state on the server. Every request carries everything it needs. The API scales horizontally without coordination.

---

## Tech Stack

| Component | Technology | Why |
|-----------|-----------|-----|
| Language | Java 17 LTS | Records, pattern matching, long-term support |
| Framework | Spring Boot 3.x | Industry standard, powerful DI ecosystem |
| Persistence | Spring Data JPA + Hibernate | Clean abstraction over JDBC, relationship mapping |
| Database | PostgreSQL 14+ | Reliable, production-proven, complex query support |
| Migrations | Flyway | Version-controlled schema, environment parity |
| Build | Maven 3.8+ | Predictable lifecycle, dependency management |

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/andrius/employees/
            ├── controller/     # HTTP layer — routes and status codes
            ├── service/        # Business logic — rules and validation
            ├── repository/     # Data access — JPA queries
            ├── model/          # Domain entities — source of truth
            └── dto/            # API contracts — what clients see
    └── resources/
        └── db/migration/       # Flyway SQL migrations (V1__, V2__...)
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
