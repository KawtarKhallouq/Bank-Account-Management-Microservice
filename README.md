# Bank Account Management Microservice

This project is a Spring Boot microservice for managing bank accounts. It provides APIs to perform CRUD operations on customer accounts, and it exposes both REST and GraphQL endpoints. This application is built using best practices in clean architecture and uses an in-memory H2 database for easy testing and demonstration.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [How to Run](#how-to-run)
- [API Documentation](#api-documentation)


---

## Overview

This microservice allows for the management of customer bank accounts, providing CRUD operations and the ability to expose data via RESTful and GraphQL APIs. It serves as a template for building microservices with a clean architecture, separating concerns between different layers.

## Features
- **Account Management**: Create, read, update, and delete customer accounts.
- **RESTful APIs**: Expose CRUD endpoints for account management.
- **GraphQL API**: Provide alternative API endpoints via GraphQL.
- **DTOs and Mappers**: Use Data Transfer Objects (DTOs) and ModelMapper for object mapping.
- **Exception Handling**: Handle exceptions with custom error responses.
- **Documentation**: Auto-generated Swagger documentation for REST APIs.

## Technologies Used
- **Java 17**
- **Spring Boot 3** (Spring Web, Spring Data JPA, Spring Data REST, Spring GraphQL)
- **H2 Database** (in-memory database for testing)
- **ModelMapper** (for DTO mapping)
- **Lombok** (for reducing boilerplate code)
- **Springdoc OpenAPI** (for Swagger UI documentation)
- **GraphQL** (for exposing an alternative API)

## Project Structure

The project follows a layered architecture with each package fulfilling a specific purpose:

```plaintext
src/main/java/
└── ma.enset.micro_service/
    ├── dtos/                              # Data Transfer Objects (DTOs)
    │   ├── CustomerRequestDTO.java         # DTO for handling incoming customer requests
    │   └── CustomerResponseDTO.java        # DTO for returning customer data in responses
    │
    ├── entities/                           # JPA entities representing database tables
    │   └── Customer.java                   # Entity representing a customer
    │
    ├── exceptions/                         # Custom exceptions
    │   ├── CustomerNotFoundException.java  # Exception when a customer is not found
    │   └── EmailAlreadyUsedException.java  # Exception for duplicate email registration
    │
    ├── handlers/                           # Exception handlers for centralized error handling
    │   └── GraphQLExceptionHandler.java    # Handler for GraphQL-specific exceptions
    │
    ├── mappers/                            # Mappers for converting between entities and DTOs
    │   └── CustomerMapper.java             # Mapper for Customer entity to DTO conversion
    │
    ├── repository/                         # Spring Data JPA repositories
    │   └── CustomerRepository.java         # Repository for performing CRUD operations on Customer
    │
    ├── services/                           # Service layer for business logic
    │   ├── CustomerService.java            # Interface defining customer-related operations
    │   └── CustomerServiceImpl.java        # Implementation of customer-related business logic
    │
    ├── web/                                # Web layer containing controllers for handling API requests
    │   ├── CustomerGraphQLController.java  # Controller for GraphQL API endpoints
    │   ├── CustomerRestController.java     # Controller for REST API endpoints
    │   └── DataRestController.java         # Exposes repository as REST API
    │
    └── CustomerServiceApplication.java     # Main class to run the Spring Boot application


### Package Descriptions

- **dtos**: Contains Data Transfer Objects, used to decouple the API layer from the internal data representation. `CustomerRequestDTO` is used for incoming data, while `CustomerResponseDTO` is for outgoing data.
- **entities**: Holds the JPA entities, which map to the tables in the database. Currently, the project has a `Customer` entity representing a customer in the bank.
- **exceptions**: Defines custom exceptions to handle specific error cases, like non-existent customers or duplicate email registrations.
- **handlers**: Contains classes for handling exceptions globally, ensuring consistent error responses.
- **mappers**: Uses ModelMapper to convert between entities and DTOs. `CustomerMapper` simplifies the conversion of `Customer` entities to/from DTOs.
- **repository**: Includes Spring Data JPA repositories. `CustomerRepository` provides CRUD operations for the `Customer` entity.
- **services**: The business logic layer, containing service interfaces and their implementations. `CustomerService` defines business operations, while `CustomerServiceImpl` provides their implementations.
- **web**: The API layer. Contains controllers to handle HTTP requests. `CustomerRestController` provides REST endpoints, and `CustomerGraphQLController` handles GraphQL queries.

---

## Setup Instructions

### Prerequisites
- **Java 17**
- **Maven**



### Database Configuration
The project uses an in-memory H2 database. You can access the H2 console at `http://localhost:8080/h2-console` once the application is running.

---

## How to Run

To start the application, run:
```bash
mvn spring-boot:run

The application will be available at http://localhost:8080.

**## API Documentation**
Swagger UI: Visit http://localhost:8080/swagger-ui.html for REST API documentation and testing.
GraphQL Playground: You can access the GraphQL API at http://localhost:8080/graphql.
Usage
You can test the REST API endpoints using Postman or Swagger UI:

Create a Customer: POST /customers
Get All Customers: GET /customers
Update a Customer: PUT /customers/{id}
Delete a Customer: DELETE /customers/{id}
For GraphQL:

Run queries and mutations on the /graphql endpoint.

