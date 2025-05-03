# 🧑‍💼 Sistema de Gerenciamento de Funcionários e Cargos

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue?logo=mysql)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/Licen%C3%A7a-MIT%20(educacional)-blue)](LICENSE)

Este projeto é uma aplicação Java com **Spring Boot** e **MySQL**, focada no gerenciamento completo de **funcionários** e **cargos**. Inclui operações **CRUD (Create, Read, Update, Delete)** para ambas as entidades, com relacionamento entre elas, aplicando as melhores práticas de desenvolvimento backend.

---

## 📁 Estrutura do Projeto

```
📦 gerenciamento
├── 📂 src
│   └── 📂 main
│       ├── 📂 java
│       │   └── 📂 com.exemplo.gerenciamento
│       │       ├── 📂 controller        # Camada REST (endpoints)
│       │       ├── 📂 model             # Entidades JPA
│       │       ├── 📂 repository        # Interfaces de persistência
│       │       ├── 📂 service           # Regras de negócio
│       │       └── 📄 GerenciamentoApplication.java
│       └── 📂 resources
│           ├── 📄 application.properties
│           └── 📄 data.sql (opcional)
├── 📄 pom.xml
```

---

## ⚙️ Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.x**
- 🐬 **MySQL**
- 🔐 Spring Data JPA
- 📦 Maven

---

## 🚀 Como Executar o Projeto

### 1️⃣ Pré-requisitos

- Java 17 instalado
- MySQL Server em execução
- Maven instalado

### 2️⃣ Configuração do Banco de Dados

Crie um banco de dados no MySQL:

```sql
CREATE DATABASE gerenciamento_funcionarios;
```

Configure o arquivo `application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gerenciamento_funcionarios
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Executar a Aplicação

No terminal, dentro da raiz do projeto:

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

| Método | Endpoint                     | Descrição                            |
| ------ | ---------------------------- | ------------------------------------ |
| GET    | `/funcionarios/exibir`       | Listar todos os funcionários         |
| GET    | `/funcionarios/exibir/{id}`  | Buscar funcionário por ID            |
| POST   | `/funcionarios/cadastro`     | Cadastrar um novo funcionário        |
| PUT    | `/funcionarios/alterar/{id}` | Atualizar os dados de um funcionário |
| DELETE | `/funcionarios/deletar/{id}` | Remover um funcionário               |
| GET    | `/cargos/exibir`             | Listar todos os cargos               |
| GET    | `/cargos/exibir/{id}`        | Buscar cargo por ID                  |
| POST   | `/cargos/cadastro`           | Cadastrar um novo cargo              |
| PUT    | `/cargos/alterar/{id}`       | Atualizar os dados de um cargo       |
| DELETE | `/cargos/deletar/{id}`       | Remover um cargo                     |



---

## 🎯 Objetivo do Projeto

- Demonstrar proficiência em **Java** com o framework **Spring Boot**
- Aplicar arquitetura em camadas (Controller, Service, Repository)
- Realizar integração com banco de dados relacional utilizando **Spring Data JPA**
- Servir como base escalável para sistemas maiores com múltiplas entidades e regras de negócio complexas

---

## 🔧 Melhorias e próximos passos
🛡️ Tratamento de exceções robusto
Centralizar e personalizar o tratamento de erros no back-end (ex: @ControllerAdvice e @ExceptionHandler no Spring Boot).

📦 Dockerizar a aplicação
Criar um Dockerfile para o app e um docker-compose.yml para subir app + MySQL como containers integrados.

📚 Documentar API com Swagger
Usar springdoc-openapi para gerar uma interface Swagger que mostra e testa todos os endpoints.

🌐 Criar um front-end
Desenvolver uma interface web para que o usuário possa gerenciar funcionários e cargos de forma visual, conectada à API via HTTP.

---

## 👨‍💻 Autor

**Desenvolvido por [Andrius Anselmi](https://github.com/Andrius-Anselmi)**

🧑‍💼 **Desenvolvedor Back-end**

🔗 **GitHub**: [https://github.com/Andrius-Anselmi](https://github.com/Andrius-Anselmi)

---

## 📄 Licença

Projeto sob a Licença MIT, voltado para **fins educacionais e aprendizado**.  
Consulte o arquivo [`LICENSE`](LICENSE) para mais informações.
