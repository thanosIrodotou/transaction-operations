# transaction-operations
A rest api to handle payment operations based on form3's exercise requirements.

## Overview

### Design & Implementation
* This repository primarily includes a simple REST API using SpringBoot and JPA which provides basic  
CRUD operations on provided mocked data. An API level design-doc is available [here](https://github.com/thanosIrodotou/transaction-operations/blob/master/api_design.md)  
* The implementation follows the classic MVC (Controller>Service>Repository) pattern.
* Data is persisted in the H2 Database Engine using Spring's automatic configuration and annotation based repositories.  
The h2-console is available at: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* Swagger UI API Documentation and playground is also available at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
 *because swagger is enabled the base path of the application was moved to [http://localhost:8080/transactions](http://localhost:8080/transactions)
 
 ### Building & Running
 The app is built using maven so run: `mvn clean install` from the root directory.
 To start the app run: 
 ```bash
 cd transaction-processor && mvn spring-boot:run
 ```
 Alternatively, run the app using docker. From the `transaction-processor` dir build and tag the image with:
 ```bash
docker build . -t transaction-processor
 ```
 and run the container in detached mode with:
 ```bash
  docker run -d -p 8080:8080 transaction-processor
 ```
 
 ### Tests
The tests are built using Groovy and Cucumber with Gherkin BDD features.  
`docker-compose` is used to bring up the `transaction-processor` API and the `integration-tests`    
module as separate services. A very simple bash script is invoked in `integration-tests/pom.xml`  
so that the ITs are invoked with every `mvn clean install` build, like so: 
```xml
<executable>../docker-integration-tests.sh</executable>
```
Alternatively, to run the tests manually, after building both modules with `mvn clean install` from the root dir, run:
```bash
./docker-integration-tests.sh
```
The downside of that is that startup of the tests is a bit slow as it depends on the resources supplied to  
docker-machine (hence tests will be slower on low spec machines), but also requires a manual termination  
of the containers when the tests are finished, hence you need to send a SIGTERM with ctrl-c.

---

***important note***: the above was built and tested using a mac, so hopefully should work on unix systems with:   
java8,  
maven3.6  
docker-compose version 1.23.2, build 1110ad01 docker-py version: 3.6.0 CPython version: 3.6.6 OpenSSL version: OpenSSL 1.1.0h  27 Mar 2018   
