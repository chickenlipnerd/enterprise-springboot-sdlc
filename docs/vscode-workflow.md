# VS Code Workflow

This repository assumes a VS Code-first workflow for both backend work today and future frontend work later.

## Recommended extensions
- Extension Pack for Java
- Spring Boot Extension Pack
- Maven for Java
- Docker
- YAML
- GitHub Actions
- PostgreSQL
- Draw.io Integration

## Backend workflow
1. Install JDK 21 and let VS Code import the Maven monorepo.
2. Use the Java Projects view or Maven view to run module-specific goals such as `verify`.
3. Use the Spring Boot dashboard or run `./mvnw -f services/<service-name>/pom.xml spring-boot:run -Dspring-boot.run.profiles=local` from the integrated terminal.
4. Connect to PostgreSQL with the VS Code PostgreSQL extension using the URLs documented in each service's `application-local.yml`.

## Future frontend workflow
A future React/Next.js client can live in a separate repository while still using VS Code and, if needed, a local Verdaccio registry from `platform/docker-compose.local-infra.yml` for package testing.
