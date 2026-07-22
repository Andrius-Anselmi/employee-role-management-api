<div align="center">

# API de Gerenciamento de Funcionários e Cargos

### API REST para estrutura organizacional — funcionários, cargos e níveis de senioridade.
### Arquitetura em camadas, autenticação JWT e DTOs em todo lugar. Sem entidade JPA vazando pra fora.

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

[Como rodar](#como-rodar) · [Arquitetura](#arquitetura) · [Endpoints](#endpoints) · [Autenticação](#autenticação) · [Por trás das escolhas](#por-trás-das-escolhas) · [O que falta](#o-que-falta)

</div>

---

> ⚠️ **Em desenvolvimento** — CRUD de funcionários e cargos já funciona de ponta a ponta. Atualização (`PUT`) e filtros ainda estão sendo implementados. Detalhes em [O que falta](#o-que-falta).

---

## Por que essa API existe

Um CRUD de funcionários parece trivial até você tentar manter ele organizado: entidade JPA indo direto na resposta HTTP, sem controle sobre o que o cliente enxerga, sem separação clara entre "regra de negócio" e "código que lida com requisição", schema do banco que não bate entre o ambiente local e o de produção.

Esse projeto resolve isso com uma estrutura fixa: quatro camadas (segurança, controller, service, repository), cada uma isolada da outra por uma interface. Autenticação via JWT sem sessão no servidor. DTOs separando o que a API expõe do que o banco de dados realmente guarda. Migrações de schema controladas pelo Flyway, então o banco nunca fica dessincronizado entre máquinas.

---

## Como rodar

**Você vai precisar de:** JDK 17+, Maven 3.8+ e Docker instalados.

```bash
git clone https://github.com/Andrius-Anselmi/employee-role-management-api.git
cd employee-role-management-api
```

Suba o banco:

```bash
docker compose up -d
```

Configure as variáveis de ambiente (ajuste os valores conforme seu setup):

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/gerenciamento
export SPRING_DATASOURCE_USERNAME=admin
export SPRING_DATASOURCE_PASSWORD=admin
export EMPLOYEE_API_SECRET=seu_jwt_secret_aqui
```

Suba a aplicação:

```bash
mvn clean install
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`. O Flyway cuida do schema sozinho na primeira execução — não precisa criar tabela manualmente.

> Todo endpoint pede token, exceto `/auth/registrar` e `/auth/login`.

---

## Arquitetura

Cada requisição passa pelas mesmas quatro paradas, nessa ordem, e nenhuma camada pula a anterior:

```
  Requisição HTTP
       │
       ▼
┌─────────────────────────────────────────────┐
│  Segurança                                  │
│  Confere o JWT antes de deixar passar       │
│  SecurityFilter + TokenService              │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Controller                                 │
│  Só cuida de HTTP: rota, status, DTO        │
│  Nunca expõe a entidade do banco            │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Service                                    │
│  Aqui moram as regras de negócio            │
│  Valida, decide, transforma dados           │
│  Erro vira exceção tipada, não null         │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  Repository                                 │
│  Spring Data JPA fala com o banco           │
│  Schema é responsabilidade do Flyway        │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│  PostgreSQL 15+                             │
└─────────────────────────────────────────────┘
```

---

## Autenticação

Sem sessão, sem cookie — só token.

```
POST /auth/registrar  →  cria o usuário, senha já sai em hash
POST /auth/login      →  confere as credenciais, devolve o JWT
Qualquer outra rota    →  exige Authorization: Bearer <token>
```

O `SecurityFilter` intercepta a requisição antes dela chegar ao controller e confere o token com o `TokenService`. Se o token faltar ou for inválido, a resposta é `403`. Senha nunca é salva em texto puro — passa pelo BCrypt antes de tocar o banco.

---

## Endpoints

### Autenticação

| Método | Rota | O que faz | Precisa de token? | Status |
|--------|-------|-------------|:---:|--------|
| `POST` | `/auth/registrar` | Cria um usuário novo | ❌ | `201` |
| `POST` | `/auth/login` | Devolve o token de acesso | ❌ | `200` |

### Funcionários

| Método | Rota | O que faz | Precisa de token? | Status |
|--------|-------|-------------|:---:|--------|
| `GET` | `/employees` | Lista todos | ✅ | `200` |
| `GET` | `/employees/{id}` | Busca um específico | ✅ | `200` / `404` |
| `POST` | `/employees` | Cadastra um novo | ✅ | `201` |
| `DELETE` | `/employees/{id}` | Remove | ✅ | `204` / `404` |
| `PUT` | `/employees/{id}` | Atualiza | ✅ | 🚧 ainda não |

### Cargos

| Método | Rota | O que faz | Precisa de token? | Status |
|--------|-------|-------------|:---:|--------|
| `GET` | `/positions` | Lista todos | ✅ | `200` |
| `GET` | `/positions/{id}` | Busca um específico | ✅ | `200` / `404` |
| `POST` | `/positions` | Cadastra um novo | ✅ | `201` |
| `DELETE` | `/positions/{id}` | Remove | ✅ | `204` / `404` |
| `PUT` | `/positions/{id}` | Atualiza | ✅ | 🚧 ainda não |

---

## Erros

Nada de `try/catch` espalhado pelos controllers — tudo passa pelo `GlobalExceptionHandler`, que intercepta a exceção e devolve o status certo.

| Exceção | Status | Situação |
|-----------|:---:|------|
| `NotFoundException` | `404` | Você pediu um recurso que não existe |

As mensagens ficam centralizadas em `ExceptionMessages`, então mudar o texto de um erro é editar um lugar só, não caçar string espalhada pelo código.

---

## Como funciona a senioridade

Cada cargo carrega um nível de senioridade, guardado como enum no banco:

```
JUNIOR · MID · SENIOR · TECH_LEAD
```

Um `@JsonCreator` customizado deixa o campo aceitar o valor em qualquer combinação de maiúscula/minúscula — `"junior"`, `"Junior"` ou `"JUNIOR"` chegam ao mesmo lugar.

---

## Por trás das escolhas

**JWT em vez de sessão** — cada requisição carrega sua própria prova de identidade. Não existe estado guardado no servidor, então dá pra escalar horizontalmente sem se preocupar em sincronizar sessão entre instâncias.

**DTO na entrada e na saída** — a entidade JPA nunca aparece direto numa resposta. Isso significa que dá pra mudar uma coluna ou um relacionamento no banco sem quebrar o contrato que o cliente da API enxerga.

**Handler de exceção centralizado** — `@RestControllerAdvice` pega qualquer exceção tipada lançada pelo service e converte pro status HTTP certo. O controller fica limpo, sem lógica de tratamento de erro misturada com lógica de rota.

**Mapper como classe utilitária** — a conversão entre entidade e DTO vive numa classe `@UtilityClass`: métodos estáticos, sem estado, sem instância. É função pura fazendo tradução de um formato pro outro.

**Flyway cuidando do schema** — cada mudança de schema é um arquivo SQL versionado. Isso evita o clássico "funciona na minha máquina, mas o banco de produção tá diferente".

**Config fora do código** — URL do banco, credenciais e o segredo do JWT vêm de variável de ambiente. O mesmo artefato compilado roda em qualquer lugar sem precisar recompilar.

---

## O que falta

- [ ] `PUT /employees/{id}` completo
- [ ] `PUT /positions/{id}` completo
- [ ] Filtro de funcionários por cargo, senioridade e estado
- [ ] Paginação e ordenação nas listagens

---

## Stack

| Peça | Tecnologia | Motivo da escolha |
|-----------|-----------|-----|
| Linguagem | Java 17 LTS | Records e suporte de longo prazo |
| Framework | Spring Boot 4.x | Ecossistema maduro, DI resolve o resto |
| Segurança | Spring Security + JWT (auth0) | Sem sessão, escala sem coordenação |
| Persistência | Spring Data JPA + Hibernate | Menos SQL manual, mais produtividade |
| Banco | PostgreSQL 15+ | Robusto e testado em produção |
| Container | Docker + Docker Compose | Mesmo ambiente pra todo mundo |
| Migrações | Flyway | Schema sob controle de versão |
| Build | Maven 3.8+ | Ciclo de build previsível |

---

## Organização do código

```
src/
└── main/
    └── java/
        └── dev/java/management/
            ├── config/         # SecurityConfig, SecurityFilter, JWTuserData
            ├── controller/     # Rotas e status HTTP
            ├── service/        # Regras de negócio
            ├── repository/     # Consultas JPA
            ├── entity/         # Entidades do banco
            ├── enums/          # Enum de senioridade
            ├── mapper/         # Conversão entidade ↔ DTO
            ├── request/        # DTOs de entrada
            ├── response/       # DTOs de saída
            └── exception/      # Exceções + handler global
    └── resources/
        └── db/migration/       # Scripts do Flyway (V1__, V2__...)
```

---

## Modelo de dados

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

## Licença

MIT — veja [LICENSE](./LICENSE).

---

<div align="center">

Feito por [Andrius Anselmi](https://github.com/Andrius-Anselmi) · [LinkedIn](https://www.linkedin.com/in/andrius-anselmi)

</div>
