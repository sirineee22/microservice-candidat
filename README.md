# Spring Boot Microservices Architecture

A distributed microservices-based application built using **Spring Boot**, demonstrating service discovery, centralized routing, and inter-service communication.

This project was developed as part of a workshop on distributed web applications.

---

## 🧱 Architecture Overview

The system is composed of multiple independent microservices registered in a **Eureka Discovery Server** and accessed through a centralized **API Gateway**.

### 🔹 Components

✅ **Eureka Server**  
Service registry that allows microservices to discover each other dynamically.

✅ **API Gateway**  
Single entry point that routes client requests to the appropriate microservice and provides load balancing.

✅ **Candidat Service**  
Manages candidate data with full CRUD operations.

✅ **Job Service**  
Handles job postings and updates job availability status.

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Cloud  
- Eureka Discovery Server  
- Spring Cloud Gateway  
- Spring Data JPA  
- H2 Database (Candidat Service)  
- MySQL (Job Service)  
- Maven  



