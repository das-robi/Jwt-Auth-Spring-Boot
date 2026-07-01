# 🔐 JWT Authentication & Product Management API

A secure RESTful backend application built with **Spring Boot**, **Spring Security**, and **JWT (JSON Web Token)**. This project demonstrates user authentication, authorization, and product management with PostgreSQL integration.

---

## 🚀 Features

- ✅ User Registration
- ✅ User Login
- ✅ JWT Authentication
- ✅ BCrypt Password Encryption
- ✅ Protected REST APIs
- ✅ Product CRUD Operations
- ✅ Product Image Upload
- ✅ PostgreSQL Database Integration
- ✅ Spring Data JPA
- ✅ Request Validation
- ✅ Layered Architecture (Controller, Service, Repository)
- ✅ RESTful API Design

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JJWT)
- PostgreSQL
- Maven
- Lombok
- Jakarta Validation
- Postman

---

## 📁 Project Structure

```
src
├── config
│   └── SecurityConfiguration
├── controller
│   ├── AuthController
│   ├── UserController
│   └── ProductController
├── entity
│   ├── Users
│   └── Product
├── repository
│   ├── UserRepository
│   └── ProductRepository
├── service
│   ├── UserService
│   ├── UserServiceDetails
│   ├── ProductService
│   └── JwtTokenService
├── filter
│   └── JwtFilter
└── JwtAuthApplication
```

---

## 🔑 Authentication Flow

1. Register a new user.
2. Login using username and password.
3. Receive a JWT token.
4. Add the JWT token as a Bearer Token in Postman.
5. Access protected APIs.

---

## 📌 API Endpoints

### Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and receive JWT Token |

---

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users/profile` | Get authenticated user profile |

---

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Get all products |
| GET | `/products/{id}` | Get product by ID |
| POST | `/product` | Add a new product with image |
| PUT | `/product/{id}` | Update product |
| DELETE | `/product/{id}` | Delete product |

---

## 🔒 Security

- JWT Authentication
- Stateless Session Management
- BCrypt Password Encryption
- Protected REST APIs
- Authentication using Bearer Token
- Spring Security Filter Chain

---

## 🗄️ Database

PostgreSQL is used as the relational database.

Configure your database in:

```properties
application.properties
```
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<your_database_name>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Testing

The APIs can be tested using **Postman**.

Workflow:

- Register User
- Login
- Copy JWT Token
- Add Bearer Token
- Access Protected APIs

---

## 📷 Product Upload

Supports product image upload using:

- Multipart File
- Image stored in PostgreSQL as BLOB

---

## 📚 What I Learned

- Spring Boot REST API Development
- Spring Security
- JWT Authentication
- User Authentication & Authorization
- Password Encryption using BCrypt
- PostgreSQL Integration
- Multipart File Upload
- Request Validation
- Spring Data JPA
- Layered Architecture

---
