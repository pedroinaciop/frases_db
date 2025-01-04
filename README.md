# Visão geral

O projeto é uma aplicação full-stack local que funciona com requisições ao banco de dados e exibição do resultado no Front-end da aplicação.

## Tecnologias

[![Minhas Habilidades](https://skillicons.dev/icons?i=spring,mysql,html,css)](https://skillicons.dev)

# Setup da aplicação (local)

## Dependências

O projeto conta com as seguintes dependências:
```
Spring Boot Starter Data JPA
Spring Boot Starter Web
PostgreSQL Driver
Spring Boot Starter Test

```

## Preparando ambiente

É necessário a criação da base de dados relacional no Postgres

```
CREATE DATABASE "frases_series";
```

Configuração do arquivo 'application.properties' conforme seu acesso ao Banco de dados

```
spring.application.name=frases_db
spring.datasource.url=jdbc:postgresql://localhost/frases_series
spring.datasource.username= seu usuário de acesso
spring.datasource.password= sua senha de acesso
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true

```

E por último, realizar a inserção dos dados no seu banco de dados local conforme o arquivo 'dados_db.csv'

## Instalação da aplicação

Primeiramente, faça o clone do repositório:

```
https://github.com/pedroinaciop/frases_db.git

```
Feito isso, acesse o projeto:

```
cd frases_db

```
É preciso compilar o código e baixar as dependências do projeto:

```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. As requisições serão realizadas em http://localhost:8080/series/frases

```
Tomcat started on port(s): 8080 (http)
```

# Setup da aplicação com docker

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

```
Java 8
Docker 17.06.0 
Maven 3.3.3 
```

## Preparando ambiente

Criar e executar container do Posgres
```
 docker run -d \
    --name productivity-postgres \
    -e POSTGRES_DB=productivity-with-spring \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
   postgres:9.6
```

Criar e executar container do MongoDB
```
docker run -d \
    --name productivity-mongodb \
   mongo:3.5
```

## Instalação da aplicação

Baixar as dependência e criar imagem da aplicação

```
mvn clean package -Dmaven.test.skip=true dockerfile:build
```

Executar container da aplicação

```
docker run -it \
    --link productivity-postgres  \
    --link productivity-mongodb  \
    -p 8080:8080 \
    emmanuelneri/productivity-with-spring-app 
```

Pronto. A aplicação está disponível em http://localhost:8080

# APIs

O projeto disponibiliza algumas APIs em 3 contextos diferentes: Customer, Carriers e BilLs, onde utilizam o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

Segue abaixo as APIs disponíveis no projeto:

#### Customer

 - /customers/search (GET)
 - /customers (GET)
 - /customers/paged/{page}/{size} (GET)
 - /customers/search/pagenable (POST)
     - Espera atributos para serem critérios de busca no body da requisição, exemplo:
    ```
    {
      "name":"Customer"
    }
    ```

#### Carriers

 - /carriers (GET)
 
 #### Bills
 
  - /bills/{id} (DELETE)
  - /bills (GET)
  - /bills/byUk/{customerId}/{identifier}/{yearMonth} (GET)
  - /bills/{id} (GET)
  - /bills/search (POST)
    - Espera atributos para serem critérios de busca no body da requisição, exemplo:
      ```
         {
           "initYearMonth":"2017-01",
           "endYearMonth":"2017-07"
         }
         ```
  - /bills  (POST)
    - Espera as informações do modelo de dados Bill, exemplo:
        ```
             {
               "customer":{
                 "id":1,
                 "name":"Customer 1"
               },
               "carrier":{
                 "id":1,
                 "name":"TIM"
               },
               "identifier":"29302",
               "yearMonth":"2017-07",
               "items":[
                 {
                 "dataTime":"2017-07-01 15:30:00",
                 "description":"Ligação fora do plano",
                 "originNumber":"4499898484",
                 "destinationNumber":"1199848248",
                 "duration":"10",
                 "value":"50",
                 "type":"SERVICE"
                 },
                 {
                   "dataTime":"2017-07-15 00:00:00",
                   "description":"Pacote",
                   "originNumber":"4499898484",
                   "value":"50",
                   "type":"SERVICE"
                 }
               ],
               "total":70.00
             }
        ```                

#### File Bills

 - /files/bills (GET)
 - /files/bills (POST)
    - Espera as informações de Bill como um arquivo, exemplo:
    ```
    {"customer":{"id":1,"name":"Customer 1"},"carrier":{"id":1,"name":"TIM"},"identifier":"29302","yearMonth":"2017-07","items":[{"dataTime":"2017-07-01 15:30:00","description":"Ligação fora do plano","originNumber":"4499898484","destinationNumber":"1199848248","duration":"10","value":"50","type":"SERVICE"},{"dataTime":"2017-07-15 00:00:00","description":"Pacote","originNumber":"4499898484","value":"50","type":"SERVICE"}],"total":70.00}
    ```
