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

Ensure MySQL is running and update src/main/resources/application.properties:

```
- spring.datasource.url=jdbc:mysql://localhost:3306/Your_DB_Name?createDatabaseIfNotExist=true
- spring.datasource.username=your_mysql_username
- spring.datasource.password=your_mysql_password
- spring.jpa.hibernate.ddl-auto=update
```
### 3. Build and Run

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