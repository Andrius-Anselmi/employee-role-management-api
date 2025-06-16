
# 🧑‍💼 Sistema de Gerenciamento de Funcionários e Cargos

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue?logo=postgresql)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/Licen%C3%A7a-MIT%20(educacional)-blue)](LICENSE)

Este projeto é uma aplicação Java com **Spring Boot** e **PostgreSQL**, focada no gerenciamento completo de **funcionários** e **cargos**. Inclui operações **CRUD (Create, Read, Update, Delete)** para ambas as entidades, com relacionamento entre elas, aplicando as melhores práticas de desenvolvimento backend.

---

## 📁 Estrutura do Projeto

📦 employee-role-management-api  
├── 📁 .idea  
├── 📁 .mvn  
├── 📁 src  
│   └── 📁 main  
│       ├── 📁 java  
│       │   └── 📁 dev.java10x.Gerenciamento  
│       │       ├── 📁 Controller  
│       │       │   ├── CargoController.java  
│       │       │   └── FuncionarioController.java  
│       │       ├── 📁 DTO  
│       │       │   ├── CargoResumidoDTO.java  
│       │       │   ├── FuncionarioDTO.java  
│       │       │   └── FuncionarioResumidoDTO.java  
│       │       ├── 📁 Mapper  
│       │       │   ├── CargoMapper.java  
│       │       │   └── FuncionarioMapper.java  
│       │       ├── 📁 Model  
│       │       │   ├── CargoModel.java  
│       │       │   └── FuncionarioModel.java  
│       │       ├── 📁 Repository  
│       │       │   ├── CargoRepository.java  
│       │       │   └── FuncionarioRepository.java  
│       │       ├── 📁 Service  
│       │       │   ├── CargoService.java  
│       │       │   └── FuncionarioService.java  
│       │       └── GerenciamentoApplication.java  
│       └── 📁 resources  
│           ├── 📁 db.migration  
│           │   └── V2__Add_uf_tb_funcionario.sql  
│           ├── 📁 templates  
│           └── application.properties  
├── 📁 target  
├── .env  
├── .gitattributes  
└── .gitignore  


---

## ⚙️ Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.x**
- 🐬 **PostgreSQL**
- 🔐 Spring Data JPA
- 🐝 Hibernate
- 📦 Maven
- 🧪 Postman (ferramenta para testes de API)

---

## 🚀 Como Executar o Projeto

### 1️⃣ Pré-requisitos

- Java 17 instalado
- PostgreSQL Server em execução
- Maven instalado

### 2️⃣ Configuração do Banco de Dados

Crie um banco de dados no PostgreSQL:

```sql
CREATE DATABASE gerenciamento_funcionarios;
```
Configure suas variáveis de ambiente (ex: no .env):
```
DATABASE_URL=jdbc:postgresql://localhost:5432/gerenciamento_funcionarios
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha
```


Configure o arquivo `application.properties` com suas credenciais:

```properties
DATABASE_URL=jdbc:postgresql://localhost:5432/gerenciamento_funcionarios
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha

```
O application.properties já está configurado para utilizar essas variáveis:
```
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Configurações do JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuração do Flyway
spring.flyway.enabled=false
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration

```

### 3️⃣ Executar a Aplicação

No terminal, dentro da raiz do projeto:

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 📡 Endpoints Principais

| Método | Endpoint                     | Descrição                            |
| ------ | ---------------------------- | ------------------------------------ |
| GET    | `/api/funcionarios`          | Listar todos os funcionários         |
| GET    | `/api/funcionarios/{id}`     | Buscar funcionário por ID            |
| POST   | `/api/funcionarios`          | Cadastrar um novo funcionário        |
| PUT    | `/api/funcionarios/{id}`     | Atualizar os dados de um funcionário |
| DELETE | `/api/funcionarios/{id}`     | Remover um funcionário               |
| GET    | `/api/cargos`                | Listar todos os cargos               |
| GET    | `/api/cargos/{id}`           | Buscar cargo por ID                  |
| POST   | `/api/cargos`                | Cadastrar um novo cargo              |
| PUT    | `/api/cargos/{id}`           | Atualizar os dados de um cargo       |
| DELETE | `/api/cargos/{id}`           | Remover um cargo                     |

---

## 🎯 Objetivo do Projeto

- Demonstrar proficiência em **Java** com o framework **Spring Boot**
- Aplicar arquitetura em camadas (Controller, Service, Repository)
- Realizar integração com banco de dados relacional utilizando **Spring Data JPA**
- Servir como base escalável para sistemas maiores com múltiplas entidades e regras de negócio complexas

---

## 🔧 Melhorias e próximos passos

- 🛡️ **Tratamento de exceções robusto**: Centralizar e personalizar o tratamento de erros com `@ControllerAdvice` e `@ExceptionHandler`
- 📦 **Dockerizar a aplicação**: Criar Dockerfile e `docker-compose.yml` com MySQL integrado
- 📚 **Documentar API com Swagger**: Usar springdoc-openapi para gerar uma interface Swagger
- 🌐 **Criar um front-end**: Desenvolver interface visual para consumir a API

---

## 👨‍💻 Autor

**Desenvolvido por [Andrius Anselmi](https://github.com/Andrius-Anselmi)**

🔗 **GitHub**: [https://github.com/Andrius-Anselmi](https://github.com/Andrius-Anselmi)

---

## 📄 Licença

Projeto sob a Licença MIT, voltado para **fins educacionais e aprendizado**.  
Consulte o arquivo [`LICENSE`](LICENSE) para mais informações.
