# SoftwareFinal — Backend REST API

## 📌 Overview

Backend REST API built with Spring Boot. The project demonstrates a full backend architecture including authentication, data persistence, and containerized deployment.

## ⚙️ Tech Stack

* Java 17
* Spring Boot
* Spring Security
* PostgreSQL
* Docker & Docker Compose
* Flyway / Liquibase (data migrations)
* JUnit / Mockito

## 🧱 Architecture

* Controller layer (REST endpoints)
* Service layer (business logic)
* Repository layer (data access)
* DTO + Mapper pattern

## 🔐 Features

* Authentication & authorization
* CRUD operations
* Input validation and error handling
* Database migrations for version control

## 🐳 Deployment

The application is fully containerized using Docker and can be run with docker-compose.

## 🚀 Run locally

```bash
docker-compose up --build
```

## 📡 Example Endpoints

* GET /api/...
* POST /api/...
* PUT /api/...
* DELETE /api/...
