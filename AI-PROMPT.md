# AI Prompt Guide for the Monorepo

Use prompts that match the Maven monorepo layout, Spring Boot 4 services, and VS Code-first workflow.

## Build and architecture prompts
- "Add a new shared library under `shared-libs/` and wire it into `build/bom` and `build/parent`."
- "Create a new Spring Boot 4 service under `services/` using Java 21 and the existing monorepo conventions."
- "Update the monorepo publishing flow so Nexus stays primary and GitHub Packages remains the fallback option."
- "Extend the Draw.io architecture diagram in `docs/architecture/monorepo-architecture.drawio`."

## Service prompts
- "Add a new REST endpoint to `services/user-service` and include focused tests only for that module."
- "Scaffold a new domain aggregate for `services/catalog-service` with controller, service, repository, model, and profile-specific configuration updates."
- "Introduce PostgreSQL integration-test scaffolding for a service using `shared-libs/test-support`."

## Shared library prompts
- "Keep shared libraries framework-light unless service runtime integration truly requires Spring Boot APIs."
- "Add reusable validation or persistence helpers that can remain compatible across close Spring generations where feasible."

## CI/CD prompts
- "Update the monorepo GitHub Actions workflows for Java 21, Maven wrapper usage, Docker service builds, or OpenShift deployment skeletons."
- "Add artifact publishing guidance for Nexus first and GitHub Packages second."

## VS Code workflow prompts
- "Document the VS Code steps to run a specific service with the `local` profile."
- "Recommend VS Code extensions for Java, Docker, PostgreSQL, GitHub Actions, and Draw.io work in this repository."
- "Document how a future React/Next.js client repo would interact with these Spring Boot services while staying in a VS Code-only workflow."
