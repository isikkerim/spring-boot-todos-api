# TodoApp - Task Management Application with Spring Boot

This project is a simple task management (To-Do) application built using Spring Boot. It allows you to create, list, update, and delete tasks. Data is stored in an in-memory H2 database and accessed via a REST API. Additionally, Swagger UI is integrated for API endpoint visualization and documentation.

## Features
- Add, list, update, and delete tasks
- Data persistence with H2 in-memory database
- Task management linked to users (via `userId`)
- Swagger UI for API documentation and testing
- RESTful API structure

## Technologies
- **Spring Boot**: Application framework
- **Spring Data JPA**: Database operations
- **H2 Database**: In-memory database
- **Springdoc OpenAPI (Swagger)**: API visualization
- **Maven**: Dependency management

## Setup

### Prerequisites
- Java 17 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Steps
1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/isikkerim/spring-boot-todos-api.git
