# Enterprise Spring Boot SDLC Project

## Overview
This repository contains an enterprise-grade Spring Boot application structured to support a full software development lifecycle (SDLC). It includes modular design, environment-specific configurations, and CI/CD workflows.

> New here? Start with the onboarding guide: [`docs/guides/newcomer-cliff-notes.md`](docs/guides/newcomer-cliff-notes.md)

> Current-state note: this repository snapshot is still a lightweight foundation. The new onboarding guide clearly separates **what exists today** from the **planned monorepo direction** so newcomers do not mistake placeholders for completed modules.

## Features
- **Starter foundation** for an enterprise-style Spring Boot SDLC repository.
- Monorepo/onboarding guidance for planned backend, platform, and future frontend growth.
- CI/CD pipeline using **GitHub Actions**.
- Docker containerization support via the tracked `Dockerfile`.
- Placeholder production and deployment configuration kept explicit and safe.

## Project Structure
```
enterprise-springboot-sdlc/
├── .github/workflows/ci.yml                 # Main CI workflow
├── .github/workflows/ci-cd-automator.yml   # Manual placeholder for future deployment automation
├── docs/guides/newcomer-cliff-notes.md      # Beginner-friendly repo and VS Code guide
├── Dockerfile                               # Container image recipe
├── pom.xml                                  # Root Maven configuration
├── README.md                                # Repository overview
├── AI-PROMPT.md                             # AI continuation prompts/reference notes
├── AI-CONTINUED.md                          # Placeholder conversation carry-over file
└── src/
    └── main/
        ├── java/com/example/util/.gitempty  # Placeholder to retain package path
        └── resources/application-prod.yml   # Production datasource settings via env vars
```

---

## Usage

### 1. Local Setup
- Clone the repository:
  ```bash
  git clone https://github.com/chickenlipnerd/enterprise-springboot-sdlc.git
  cd enterprise-springboot-sdlc
  ```
- Ensure Java and Maven are installed locally. The newcomer guide recommends Java 21 as a workstation baseline, while the current root build metadata still reflects an earlier Java/Spring setup.
- If you are using VS Code only, see the extension and workspace setup notes in [`docs/guides/newcomer-cliff-notes.md`](docs/guides/newcomer-cliff-notes.md).
- Current-state note: this branch snapshot is still scaffolding-heavy. Review the onboarding guide and root `pom.xml` before assuming the project is ready for full local run/debug commands.

### 2. Profiles (Environment-Specific Setup)
- **Production**: `src/main/resources/application-prod.yml` exists and now expects datasource values from environment variables.
- **Local / Development / Testing**: referenced as intended environment concepts in the documentation, but not yet tracked as concrete config files in this branch snapshot.

When more profile files are added, set the active profile via `spring.profiles.active` (for example):
```bash
java -Dspring.profiles.active=dev -jar target/app.jar
```

### 3. CI/CD Pipeline
- GitHub Actions workflow (`.github/workflows/ci.yml`) automates:
  - Build and test the project.
- Triggered on every `push` or `pull_request` to `main`.
- The OpenShift deployment workflow is intentionally kept as a placeholder until real manifests, secrets, and artifact publishing are in place.

### 4. Docker Setup
- Build the Docker image:
  ```bash
  docker build -t enterprise-springboot-sdlc .
  ```
- Run the container:
  ```bash
  docker run -p 8080:8080 enterprise-springboot-sdlc
  ```
- Use the image as a packaging baseline; real OpenShift deployment remains placeholder work until manifests and publishing steps are added.

## Additional Documentation

- [`docs/guides/newcomer-cliff-notes.md`](docs/guides/newcomer-cliff-notes.md) - beginner-friendly repo map, VS Code setup, SDLC lifecycle guide, and safety notes
