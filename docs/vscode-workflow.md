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
2. Use the Maven wrapper (`./mvnw`) from the integrated terminal or Maven view for module-specific goals such as `verify`.
3. Use the Spring Boot dashboard to launch `user-service` or `catalog-service` with the `local` profile, or package from the repository root and run the executable jar from the integrated terminal.
4. Connect to PostgreSQL with the VS Code PostgreSQL extension using the URLs documented in each service's `application-local.yml`.
5. If you need local infrastructure quickly, use `docker compose -f platform/docker-compose.local-infra.yml up -d`.

## Safety reminders
- Local Docker credentials and sample values are scaffolding only; replace with real secrets in shared/prod environments.
- OpenShift workflow assets are intentionally skeletons until cluster/project secrets and manifests are finalized.

## Future frontend workflow
A future React/Next.js client can live in a separate repository while still using VS Code and, if needed, a local Verdaccio registry from `platform/docker-compose.local-infra.yml` for package testing.
