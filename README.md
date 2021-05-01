[![Build Status](https://circleci.com/gh/paulatumwine/mixtream-web-api.svg?style=shield)](https://app.circleci.com/pipelines/github/paulatumwine/mixtream-web-api)

# mixtream-web-api

Backend API service for mixtream front end.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment notes on how to deploy the project on a live system.

### Prerequisites

What things you need to have installed on your system

```
JDK11 or later
Maven
Any Java IDE 
MongoDB
```

### Installing

To update Maven dependencies, say in Eclipse, you may need to do a Run As -> Maven Build... and to force download all the plugins and libraries, in goals put: 

```
-U clean eclipse:eclipse 
```

## Running tests

You can execute the Maven test phase to run the unit tests. Alternatively, you can use your IDE to run the tests.

```
mvn test
```

## Deployment

To be added later.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* Spring Boot 2.3+
* Java 11+
* Spring Data JPA MongoDB
* Lombok
* Swagger - Springdocs 
* JUnit
* Mockito
