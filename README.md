📌 Desafio Backend JR — Cadastro de Veículos (Clean Architecture + DDD)

API REST para cadastro de veículos.
Antes de persistir, a aplicação consulta uma API externa (Mockaroo) para obter marca, modelo, chassi e status de licenciamento, consolidando os dados no retorno.

Além do requisito do desafio, o projeto foi estruturado com Clean Architecture / DDD (Ports & Adapters) para separar regras de negócio de detalhes de infra (JPA, WebClient, Spring MVC).
