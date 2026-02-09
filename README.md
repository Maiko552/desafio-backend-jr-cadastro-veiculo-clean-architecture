# 📌 Desafio Backend JR — Cadastro de Veículos  
### Clean Architecture + DDD (Ports & Adapters)

API REST para cadastro de veículos.

Antes de persistir, a aplicação consulta uma API externa (Mockaroo) para obter **marca, modelo, chassi e status de licenciamento**, consolidando os dados no retorno.

Além do requisito do desafio, o projeto foi estruturado com **Clean Architecture / DDD (Ports & Adapters)** para separar regras de negócio de detalhes de infraestrutura (JPA, WebClient, Spring MVC).

---

## ✅ Funcionalidades

- `POST /veiculos` para cadastrar veículo
- Validação de duplicidade:
  - Placa já cadastrada
  - CPF já cadastrado
- Consulta à API externa (Mockaroo) antes de salvar
- Persistência em PostgreSQL
- Migração de schema com Flyway
- Tratamento centralizado de erros (`@RestControllerAdvice`)

---

## 🧱 Arquitetura

### Camadas (Clean Architecture / DDD)

#### 📂 domain
- Entidades e Value Objects (`Veiculo`, `VeiculoInfo`)
- Contratos (Gateways / Ports)
  - `VeiculoGateway`
  - `VeiculoInfoGateway`
- UseCase contract (interfaces)
- Exceções de domínio

#### 📂 application
- Implementação dos UseCases (`SalvarVeiculoUseCaseImpl`)
- Commands / DTOs de entrada (`CadastrarVeiculoCommand`)
- Mappers de aplicação (`VeiculoMapper`)

#### 📂 infra
- Adapters de persistência (JPA)
- Entities JPA (`VeiculoEntity`)
- Mappers entity ↔ domain (`VeiculoEntityMapper`)
- Integração externa via WebClient (`VeiculoInfoGatewayMockaroo`)
- Configuração (`WebClientConfig`)

#### 📂 presentation
- Controllers (`VeiculoController`)
- Handler global de exceptions (opcional)

---

## 🔧 Tecnologias e Ferramentas

- Java
- Spring Boot
  - Spring Web MVC (API REST)
  - Spring Data JPA (Persistência)
  - Spring Validation (Bean Validation)
  - Spring WebFlux (WebClient)
- PostgreSQL (Docker)
- Flyway (Migrations)
- Maven
- Lombok
- Docker / Docker Compose
- Postman / Insomnia

---

## 📦 Dependências Principais (Maven)

- `spring-boot-starter-webmvc`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-validation`
- `spring-boot-starter-webflux`
- `spring-boot-starter-flyway`
- `org.flywaydb:flyway-database-postgresql`
- `postgresql`
- `lombok`

---

## ▶️ Como Executar o Projeto

### 1️⃣ Subir o PostgreSQL com Docker

```bash
docker compose up -d
