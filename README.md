# Enterprise Spring Boot SDLC Project

## Overview
This repository contains an enterprise-grade Spring Boot application structured to support a full software development lifecycle (SDLC). It includes modular design, environment-specific configurations, and CI/CD workflows.

## Features
- **Modular architecture** following best practices.
- Support for multiple environments: `local`, `dev`, `test`, `prod`.
- CI/CD pipeline using **GitHub Actions**.
- Docker containerization and OpenShift deployment-ready.
- Testcontainers-based integration tests.

## Project Structure
```
enterprise-sdlc/
├── src/main/java/com/example/
│   ├── config/            # Central configuration files
│   ├── controller/        # REST controllers (API layer)
│   ├── dto/               # Data transfer objects
│   ├── exception/         # Global exception handlers
│   ├── model/             # Hibernate entities (Domain models)
│   ├── repository/        # Data repositories layer
│   ├── service/           # Service layer (Business logic)
│   ├── util/              # Utility classes
├── src/main/resources/
│   ├── application.yml          # Base configuration
│   ├── application-local.yml    # Local environment overrides
│   ├── application-dev.yml      # Development environment overrides
│   ├── application-test.yml     # Testing environment overrides
│   ├── application-prod.yml     # Production environment overrides
├── Dockerfile                 # Docker container setup
├── .github/workflows/ci.yml   # CI/CD workflow for GitHub Actions
└── pom.xml                    # Maven configuration
```

---

## Usage

### 1. Local Setup
- Clone the repository:
  ```bash
  git clone https://github.com/chickenlipnerd/enterprise-springboot-sdlc.git
  cd enterprise-springboot-sdlc
  ```
- Ensure Java 17+ and Maven are installed locally.
- Run the application locally:
  ```bash
  mvn spring-boot:run
  ```
- The application will run with the `local` profile by default.

### 2. Profiles (Environment-Specific Setup)
- **Local**: Uses `application-local.yml`. Runs a local PostgreSQL database.
- **Development**: Targets shared dev database (`application-dev.yml`).
- **Testing**: Uses Testcontainers to spin up ephemeral PostgreSQL instances (`application-test.yml`).
- **Production**: Targets production systems with strict DB validation.

Set the active profile via `spring.profiles.active` (e.g.,):
```bash
java -Dspring.profiles.active=dev -jar target/app.jar
```

### 3. CI/CD Pipeline
- GitHub Actions workflow (`.github/workflows/ci.yml`) automates:
  - Build and test the project.
- Triggered on every `push` or `pull_request` to `main`.

### 4. Docker Setup
- Build the Docker image:
  ```bash
  docker build -t enterprise-springboot-sdlc .
  ```
- Run the container:
  ```bash
  docker run -p 8080:8080 enterprise-springboot-sdlc
  ```
- Ready for OpenShift deployment.