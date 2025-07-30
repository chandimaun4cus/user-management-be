# 👥 User Management API

A Spring Boot-based RESTful web service for managing users with CRUD operations, soft delete, field validations, and Swagger API documentation.

---

## 🚀 Features

- Create, Read, Update, Delete (Soft Delete) users
- Input validation using Jakarta Validation
- Role & Status enums
- Timestamps (created date)
- Swagger UI for interactive API docs
- MySQL database integration

---

## 📦 Tech Stack

- **Backend**: Spring Boot, Spring Data JPA, Hibernate
- **Database**: MySQL
- **Validation**: Jakarta Bean Validation
- **Documentation**: Swagger (Springdoc OpenAPI)
- **Build Tool**: Maven

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/chandimaun4cus/user-management-be.git
cd user-management-be
```

### 2. Configure MySQL Database

1. Create .env file in your root directory
2. Add the following configurations with your details:
- DB_URL=jdbc:mysql://localhost:3306/<YOUR_DB_NAME>?createDatabaseIfNotExist=true
- DB_USERNAME=<YOUR_MYSQL_USERNAME>
- DB_PASSWORD=<YOUR_MYSQL_PASSWORD>

### 3. Build and Run

Open cmd/terminal and run the following commands with your Mysql details:
```aiignore
set DB_URL=jdbc:mysql://localhost:3306/<YOUR_DB_NAME>?createDatabaseIfNotExist=true
set DB_USERNAME=<YOUR_MYSQL_USERNAME>
set DB_PASSWORD=<YOUR_MYSQL_PASSWORD>
```
On Windows OS:
```
mvnw spring-boot:run
```

On Mac/Linux OS:
```aiignore
./mvnw spring-boot:run
```
---

## API Endpoints

- POST (Create new user) : ```http://localhost:8080/api/user```
- GET (Get all users): ```http://localhost:8080/api/users	```
- GET (Get user by ID):	```http://localhost:8080/api/user/{id}```	
- PUT (Update user by ID):	```http://localhost:8080/api/user/{id}```	
- DELETE (Soft delete a user):	```http://localhost:8080/api/user/{id}```	

---

## 📑 Swagger API Docs

Once the app is running, go to the following URL and we can see an interactive UI with all API endpoints and example payloads.

```http://localhost:8080/swagger-ui/index.html```