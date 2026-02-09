📌 ##Desafio Backend JR — Cadastro de Veículos (Clean Architecture + DDD)

API REST para cadastro de veículos.
Antes de persistir, a aplicação consulta uma API externa (Mockaroo) para obter marca, modelo, chassi e status de licenciamento, consolidando os dados no retorno.

Além do requisito do desafio, o projeto foi estruturado com Clean Architecture / DDD (Ports & Adapters) para separar regras de negócio de detalhes de infra (JPA, WebClient, Spring MVC).

✅ #Funcionalidades

POST /veiculos para cadastrar veículo

Validação de duplicidade:

placa já cadastrada

cpf já cadastrado

Consulta à API externa (Mockaroo) antes de salvar

Persistência em PostgreSQL

Migração de schema com Flyway

Tratamento centralizado de erros (RestControllerAdvice) (se você já implementou)

🧱 #Arquitetura

Camadas (Clean Architecture / DDD):

domain

Entidades e Value Objects (Veiculo, VeiculoInfo)

Contratos (Gateways / Ports) (VeiculoGateway, VeiculoInfoGateway)

UseCase contract (interface)

Exceções de domínio

application

UseCase implementation (SalvarVeiculoUseCaseImpl)

Commands/DTOs de entrada (ex.: CadastrarVeiculoCommand)

Mappers de aplicação (ex.: VeiculoMapper)

infra

Adapters de persistência (JPA)

Entities JPA (VeiculoEntity)

Mappers entity↔domain (VeiculoEntityMapper)

Integração externa via WebClient (VeiculoInfoGatewayMockaroo)

Configuração (WebClientConfig)

presentation

Controllers (VeiculoController)

Handler global de exceptions (opcional)

🔧 #Tecnologias e ferramentas

Java (versão do projeto)

Spring Boot

Spring Web MVC (API REST)

Spring Data JPA (persistência)

Spring Validation (Bean Validation)

Spring WebFlux (WebClient para integração externa)

PostgreSQL (Docker)

Flyway (migrations)

Maven

Lombok

Docker / Docker Compose

Postman/Insomnia para testes de API

📦 #Dependências principais (Maven)

spring-boot-starter-webmvc

spring-boot-starter-data-jpa

spring-boot-starter-validation

spring-boot-starter-webflux (WebClient)

spring-boot-starter-flyway

org.flywaydb:flyway-database-postgresql

postgresql

lombok
