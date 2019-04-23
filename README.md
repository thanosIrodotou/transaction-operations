# transaction-operations
A rest api to handle payment operations based on form3's exercise requirements.

## Overview

### Design & Implementation
* This repository primarily includes a simple REST API using SpringBoot and JPA which provides basic CRUD operations on provided mocked data.  
* The implementation follows the classic MVC (Controller>Service>Repository) pattern.
* Data is persisted in the H2 Database Engine using Spring's automatic configuration and annotation based repositories. The h2-console is available at: `http://localhost:8080/h2-console`
* Swagger UI API Documentation and playground is also available at: `http://localhost:8080/swagger-ui.html`
 *because swagger is enabled the base path of the application was moved to `http://localhost:8080/transactions`
 
 ### Building & Running
 The app is built using maven so run: `mvn clean install` from the root directory.
 To start the app run: 
 ```bash
 cd transaction-processor && mvn spring-boot:run
 ```
 Alternatively, run the app using docker. From the `transaction-processor` dir run:
 ```bash
docker build . -t transaction-processor
 ```
 and
 ```bash
  docker run -d -p 8080:8080 transaction-processor
 ```
 
 ### Tests
