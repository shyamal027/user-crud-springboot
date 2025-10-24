# User CRUD Spring Boot Application

## Overview
This Spring Boot project exposes a REST API with full CRUD for `User` resource using H2 in-memory database.
It includes validation, global error handling, and sample data.

Endpoints:
- `GET /api/users` - list all users
- `GET /api/users/{id}` - get user by id
- `POST /api/users` - create user (JSON body)
- `PUT /api/users/{id}` - update user
- `DELETE /api/users/{id}` - delete user

## Requirements
- Java 17+
- Maven
- STS / IntelliJ (optional)

## Run from command-line
1. Build: `mvn clean package`
2. Run: `mvn spring-boot:run` or `java -jar target/user-crud-1.0.0.jar`

## H2 Console
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:userdb`
- Username: `sa`, Password: *(blank)*

## Import into STS / Eclipse
1. File -> Import -> Existing Maven Projects -> select project folder.
2. Wait for dependencies to download.
3. Run `UserCrudApplication` as Spring Boot App.

## Test using curl / Postman
Example create:
```bash
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{ "name":"Ajay", "email":"ajay@example.com", "salary":50000 }'
```
Get list:
```bash
curl http://localhost:8080/api/users
```

## Notes
- Validation errors and other errors return structured JSON with messages.
- The project also includes Swagger UI: open http://localhost:8080/swagger-ui.html after start.
