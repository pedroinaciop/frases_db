# Visão geral

O projeto é uma aplicação full-stack local que realiza requisições ao banco de dados, processa os dados no back-end e exibe os resultados no front-end, proporcionando uma interação fluida e integrada entre as camadas da aplicação.

## Tecnologias

[![Minhas Habilidades](https://skillicons.dev/icons?i=spring,html,css,postgres)](https://skillicons.dev)

# Setup da aplicação (local)

## Dependências

O projeto conta com as seguintes dependências:

*Spring Boot Starter Data JPA
*Spring Boot Starter Web
*PostgreSQL Driver
*Spring Boot Starter Test

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
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
```

E por último, utilize o arquivo 'dados_db.csv' para popular o banco de dados. Certifique-se de que os dados/campos estejam estruturados corretamente.

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

## Resposta da API

Exemplo de retorno esperado:

```
{
    "titulo": "Narcos",
    "frase": "As mentiras são necessárias quando a verdade é muito difícil de crer.",
    "personagem": "Pablo Escobar",
    "poster": "https://cdn.pensador.com/img/imagens/na/rc/narcos_0_c.jpg?auto_optimize=low&width=655"
}
```

## Aplicação no Front-End

* Abra o arquivo 'index.html' na pasta 'frases-front-end'.
* Utilize o live-server ou um servidor local de sua preferência para visualizar o front-end.
* As requisições serão realizadas automaticamente, desde que o projeto back-end esteja em execução.

## Imagem de exemplo

![Web 1](https://github.com/pedroinaciop/frases_db/blob/main/img_exemplo.png?raw=true)
