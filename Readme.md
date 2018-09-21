# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a portfolio application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 8.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git
```

**2. Create Mysql database**
```bash
create database portfolio_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/portfolio-restapi-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The  CRUD APIs defined by the app can be found on Swagger documentation using below url:
http://localhost:8080/swagger-ui.html#/

	GET 
	/api/portfolios getAllPortfolios
POST
/api/portfolios createPortfolio
GET
/api/portfolios/{id} getPortfolioById
PUT
/api/portfolios/{id}  updatePortfolio
DELETE
/api/portfolios/{id} deletePortfolio

You can test them using postman or any other rest client.

## Learn more

You can find the tutorial for this application on my blog -

<https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
