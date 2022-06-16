# Sobre a API
Essa API é uma simplificação desenvolvida com base na API Consents do Open Banking. 
A API Consents viabiliza a criação, consulta e revogação dos consentimentos para a Fase 2 (customer-data) do Open Banking Brasil.

### Swagger
- http://localhost:8080/swagger-ui.html#/

### Postman
- http://localhost:8080/consents/v1/consents

### Etapa 3 - Projeto DEV
Esse projeto é parte importante das etapas de treinamento do programa de estágio da Sensedia. Nesse está sendo posto em prática o conhecimento adquirido durante o treinamento e cursos realizados nas Etapas 1 e 2, que consistiram em cursos de Lógica de programação, Java OO, Git e GitHub, Postman, HTTP, Spring Boot.

### Tecnologias utilizadas
- Spring Boot;
- Java;
- Maven;
- MongoDBCompass;
- Swagger;
- Mockito e JUnit.

### Dados do Projeto
- O banco de dados MongoDB implementado utilizando o aplicativo MongoDBCompass;
- Criei uma database "local" e uma collection "consents";
- O documento do projeto é criado automático, conforme implementação no código por meio de anotações;
- Foi utilizado o framework Spring Boot;
- Projeto segue o padrão Controller-Service-Repository, além de uma classe DTO, Model e Errors;
- O swagger foi gerado utilizando a dependência springfox-swagger2;
- Foram implementados testes unitários utilizando Mockito e JUnit.

### Criar novo pedido de consentimento : 
- POST /consents/v1/consents: Método para a criação de um novo consentimento.

### Obter detalhes do consentimento identificado por consentId : 
- GET /consents/v1/consents/{consentId}: Método para obter detalhes do consentimento identificado por consentId.

### Deletar / Revogar o consentimento identificado por consentId : 
- DELETE /consents/v1/consents/{consentId} : Método para deletar / revogar o consentimento identificado por consentId.

### Pontos de melhoria 
- Implementar o swagger manual.
