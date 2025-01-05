# Visão geral

O projeto é uma aplicação full-stack local que realiza requisições ao banco de dados, processa os dados no back-end e exibe os resultados no front-end, proporcionando uma interação fluida e integrada entre as camadas da aplicação.

## Tecnologias

[![Minhas Habilidades](https://skillicons.dev/icons?i=spring,html,css,postgre)](https://skillicons.dev)

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
Maven 3.3.3 
```

# Resposta requisição

O retorno esperada será uma frase de um filme/série determinado aleatóriamente pela aplicação

```
{
    "titulo": "Narcos",
    "frase": "As mentiras são necessárias quando a verdade é muito difícil de crer.",
    "personagem": "Pablo Escobar",
    "poster": "https://cdn.pensador.com/img/imagens/na/rc/narcos_0_c.jpg?auto_optimize=low&width=655"
}

```

