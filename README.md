# Gerenciamento de Funcionários

API REST para gerenciamento de funcionários, desenvolvida com Spring Boot e MySQL.

## 📋 Funcionalidades

- Cadastro de funcionários
- Listagem de funcionários
- Atualização de dados de funcionários
- Exclusão de funcionários

## 🛠️ Tecnologias Utilizadas

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)

## ✅ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MySQL](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)
- [Postman](https://www.postman.com/) (para testar os endpoints da API)

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/Andrius-Anselmi/Gerenciamento.git
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd Gerenciamento
   ```

3. **Configure o banco de dados MySQL:**

   - Crie um banco de dados chamado `gerenciamento`.
   - Atualize as credenciais de acesso no arquivo `application.properties` em `src/main/resources/`.

4. **Execute o projeto:**

   - Com sua IDE ou via terminal:

     ```bash
     mvn spring-boot:run
     ```

5. **Acesse a API:**

   - A API estará disponível em: `http://localhost:8080`

## 📁 Estrutura do Projeto

```
Gerenciamento/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           └── gerenciamento/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
├── pom.xml
└── README.md
```

## 🧩 Implementações Futuras

- **Containerização com Docker:** Facilitar a execução e o deploy da aplicação.
- **Integração com Swagger:** Documentar automaticamente os endpoints da API.
- **Criação de um Front-end:** Desenvolver uma interface visual para interação com a API, utilizando ferramentas como React.

## 📝 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
