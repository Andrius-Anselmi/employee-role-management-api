# 🧑‍💼 Enterprise Employee & Role Management System

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

## 🚀 Overview

The **Enterprise Employee Management System** is a robust, production-ready RESTful API designed to manage complex organizational structures. Built with **Java 17** and **Spring Boot 3**, the application focuses on high-performance data persistence, strict architectural decoupling, and scalable entity relationships.

This project goes beyond simple CRUD operations, implementing professional-grade patterns widely used in large-scale corporate environments.

---

## ✨ Features

- **Advanced Relationship Mapping:** Seamless handling of One-to-Many relationships between Employees and Roles using JPA/Hibernate
- **Data Integrity:** Database migrations via SQL/Flyway to ensure schema consistency across environments
- **Encapsulated Data Flow:** DTOs (Data Transfer Objects) ensure the internal domain model is never exposed to the client
- **Stateless Architecture:** Designed for horizontal scalability, following REST architectural constraints
- **Environment Agnostic:** Fully configurable via environment variables, following the **12-Factor App** methodology

---

## 🏗️ Architecture

The system is organized into distinct layers to promote the **Single Responsibility Principle (SRP)** and ease of testing:

**API Layer (Controllers)**
Handles incoming HTTP requests, manages media type negotiation, and returns appropriate RESTful status codes (`201 Created`, `204 No Content`, `404 Not Found`).

**Business Logic Layer (Services)**
The "brain" of the application. All business rules, validations, and cross-entity logic are centralized here, keeping Controllers thin and Repositories focused.

**Data Access Layer (Repositories)**
Leverages **Spring Data JPA** for efficient database communication. Implements optimized queries to prevent common performance pitfalls like the N+1 problem.

**Domain Model & DTOs**
- **Models:** Represent the source of truth in the PostgreSQL database
- **DTOs:** Customized views of data tailored for specific API responses, reducing payload size and increasing security

---

## 🛠️ Tech Stack

| Component | Technology | Rationale |
| :--- | :--- | :--- |
| **Language** | Java 17 (LTS) | Modern features like Records and enhanced Switch expressions for cleaner, maintainable code |
| **Framework** | Spring Boot 3.x | Industry standard for microservices, with a powerful ecosystem for dependency injection |
| **Persistence** | Spring Data JPA | Reduces boilerplate while providing a powerful abstraction over the JDBC layer |
| **Database** | PostgreSQL | Professional-grade relational database known for reliability and complex query support |
| **Build Tool** | Maven | Robust dependency management and lifecycle automation for predictable builds |

---

## 📡 API Endpoints

### 📋 Employee Resources

| Method | Path | Description |
| :--- | :--- | :--- |
| `GET` | `/api/funcionarios` | Retrieve all employees with detailed role information |
| `GET` | `/api/funcionarios/{id}` | Fetch a specific employee by their unique identifier |
| `POST` | `/api/funcionarios` | Create a new employee record with DTO validation |
| `PUT` | `/api/funcionarios/{id}` | Update existing employee details (Idempotent) |
| `DELETE` | `/api/funcionarios/{id}` | Safely remove an employee from the system |

### 🎭 Role Resources

| Method | Path | Description |
| :--- | :--- | :--- |
| `GET` | `/api/cargos` | List all available corporate roles |
| `POST` | `/api/cargos` | Register a new role within the organization |

---

## ⚙️ Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.8+
- PostgreSQL 14+

### Step-by-Step Setup

**1. Clone the repository**

```bash
git clone https://github.com/Andrius-Anselmi/employee-role-management-api.git
cd employee-role-management-api
```

**2. Create the database**

Access your PostgreSQL instance (via pgAdmin, DBeaver, or psql) and run:

```sql
CREATE DATABASE gerenciamento_funcionarios;
```

**3. Set environment variables**

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/gerenciamento_funcionarios
export DATABASE_USERNAME=your_db_user
export DATABASE_PASSWORD=your_db_password
```

**4. Build and run**

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

---

## 👨‍💻 Developed By

**Andrius Anselmi** — Computer Science Student & Aspiring Software Architect

- GitHub: [@Andrius-Anselmi](https://github.com/Andrius-Anselmi)
- LinkedIn: [Andrius Anselmi](https://www.linkedin.com/in/andrius-anselmi)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
