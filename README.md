# Hospital Management System
## Description
This project is a comprehensive Hospital Management System backend, built as a RESTful API using Java and Spring Boot. It is designed to manage various hospital operations, including patient records, appointments, doctor information, and administrative tasks. The system incorporates robust security using Spring Security and JSON Web Tokens (JWT) and OAuth2 for role-based authentication and authorization. 
# Endpoints
* http://localhost:8080/api/v1/public/doctors - get doctors list
* http://localhost:8080/api/v1/admin/patients - get patients list
* http://localhost:8080/api/v1/auth/signup - for sing up
* http://localhost:8080/api/v1/auth/login - for login
* http://localhost:8080/api/v1/patients/profile - patient profile
  
#🚀 Tech Stack

Backend: Java, Spring Boot

Frameworks & Modules:

Spring MVC

Spring Data JPA

Spring Security

Security: JWT, OAuth2 Login

Database: PostgreSQL

Build Tool: Maven

API Testing: Postman

Version Control: Git & GitHub

✨ Key Features
👨‍⚕️ Role-Based Access Control (RBAC)

Implemented RBAC using Spring Security

Roles such as ADMIN, DOCTOR, PATIENT

Controlled access at method level using security annotations

Clear separation of responsibilities for each role

🔐 Authentication & Authorization

Implemented JWT-based authentication

Token generation and validation

Secured REST APIs using JWT filters

Integrated OAuth2 login (e.g., Google login)

Used method-level security with:

@EnableMethodSecurity

@PreAuthorize

@Secured

Understood how Spring Security uses AOP internally for authorization

🏥 Hospital Operations

Patient registration and management

Doctor management

Appointment booking and scheduling

Medical record handling

Full CRUD operations for core entities

🌐 RESTful APIs

Designed REST-compliant APIs

Proper use of HTTP methods and status codes

DTO-based request and response handling

Validation and error handling

🧠 Spring Boot Concepts Learned & Applied
✅ Spring Boot Core

Auto-configuration and starter dependencies

Embedded Tomcat server

Externalized configuration using application.properties

Dependency Injection using @Autowired

Layered architecture (Controller → Service → Repository)

✅ Spring MVC

REST controllers using @RestController

Request mapping using @GetMapping, @PostMapping, etc.

Path variables and request parameters

Request/response handling using DTOs

✅ Spring Data JPA

Used JpaRepository for database operations

Entity mapping using JPA annotations:

@Entity, @Id, @OneToMany, @ManyToOne

Wrote custom queries using:

JPQL

Native SQL queries

Understood how Hibernate manages persistence and transactions

✅ Spring Security

Implemented Role-Based Access Control (RBAC)

JWT authentication flow and token-based security

OAuth2 login integration

Method-level authorization using:

@EnableMethodSecurity

@PreAuthorize

@Secured

Clear understanding of authentication vs authorization

Learned how AOP is used internally by Spring Security

✅ Exception Handling & Validation

Global exception handling using @ControllerAdvice

Custom exception classes

Request validation using:

@NotNull, @NotBlank, @Email

Meaningful error responses for APIs

🏗️ Project Architecture
controller  →  service  →  repository  →  database


Controller: Handles HTTP requests

Service: Contains business logic

Repository: Database access using JPA

Security Layer: Authentication, authorization, and filters

This structure improved:

Code maintainability

Readability

Scalability

🧪 API Testing

Tested secured and unsecured APIs using Postman

Verified JWT token flow and role-based access

Tested OAuth2 login and protected endpoints

Checked edge cases and exception scenarios

📚 What I Learned From This Project

End-to-end backend development using Spring Boot

Implementing secure, production-ready APIs

Deep understanding of Spring Security, RBAC, JWT, and OAuth2

Writing efficient database queries using JPQL and native SQL

Applying clean architecture and best practices
