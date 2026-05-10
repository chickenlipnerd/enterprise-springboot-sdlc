# Enterprise Spring Boot SDLC Monorepo

This repository is now a Maven multi-module monorepo aligned to a Java 21 and Spring Boot 4 service strategy for OpenShift-oriented delivery.

## Monorepo strategy
- **Java 21** across all build modules and service runtimes.
- **Spring Boot 4** for service modules under `services/`.
- **Framework-light shared libraries** under `shared-libs/` so reusable code is not tightly coupled to a single Spring Boot generation when that can be avoided.
- **Centralized build governance** through `build/bom` and `build/parent`.
- **OpenShift-oriented deployment** with local Docker and artifact repository scaffolding.
- **VS Code-only workflow** documented for current backend work and future frontend work.

## Repository layout
```text
.
├── build/
│   ├── bom/                   # dependency management import layer
│   └── parent/                # plugin management, Java 21 defaults, publishing profiles
├── docs/
│   ├── architecture/          # Draw.io architecture diagram and notes
│   └── vscode-workflow.md     # VS Code-first backend and future frontend workflow
├── platform/
│   ├── docker-compose.local-infra.yml
│   ├── openshift/
│   └── README.md
├── shared-libs/
│   ├── logging-lib/
│   ├── persistence-lib/
│   ├── test-support/
│   └── validation-lib/
├── services/
│   ├── catalog-service/
│   └── user-service/
├── .github/workflows/
├── AI-CONTINUED.md
├── AI-PROMPT.md
├── mvnw / mvnw.cmd / .mvn/
└── pom.xml
```

## Initial modules
### Build modules
- `build/bom`: imports Spring Boot 4 and Testcontainers BOMs plus internal module coordinates.
- `build/parent`: Java 21 defaults, plugin management, enforcer rules, and artifact publishing profiles.

### Shared libraries
- `shared-libs/logging-lib`: tiny SLF4J-based structured logging helper.
- `shared-libs/validation-lib`: lightweight validation helpers and error record.
- `shared-libs/persistence-lib`: simple persistence abstractions such as `BaseEntity` and paging helpers.
- `shared-libs/test-support`: reusable PostgreSQL Testcontainers support.

### Service modules
- `services/user-service`: Spring Boot 4 REST skeleton, actuator, PostgreSQL placeholders, sample user endpoint.
- `services/catalog-service`: Spring Boot 4 REST skeleton, actuator, PostgreSQL placeholders, sample catalog endpoint.

Each service includes:
- `controller/`, `service/`, `repository/`, `model/`, and `config/` packages
- `application.yml`
- `application-local.yml`
- `application-dev.yml`
- `application-test.yml`
- `application-prod.yml`
- service-specific Dockerfile

## Build and run
### Prerequisites
- JDK 21
- Docker (optional for local infra)

### Verify the monorepo
```bash
./mvnw -B verify
```

### Run a service from VS Code or terminal
```bash
./mvnw -f services/user-service/pom.xml spring-boot:run -Dspring-boot.run.profiles=local
./mvnw -f services/catalog-service/pom.xml spring-boot:run -Dspring-boot.run.profiles=local
```

Or package an executable jar and run it directly:

```bash
./mvnw -pl services/user-service -am package
java -jar services/user-service/target/user-service-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
```

## PostgreSQL direction
Both services are scaffolded for PostgreSQL and keep profile-specific configuration files for local, dev, test, and prod environments. The test profile is intentionally ready for a future Testcontainers-backed integration test layer while the `shared-libs/test-support` module provides a reusable PostgreSQL container factory.

## Artifact strategy
- **Primary:** Nexus for enterprise Maven publishing.
- **Alternative:** GitHub Packages for Maven artifacts.
- **Future frontend support:** Verdaccio for local npm package testing.

See `platform/README.md` and `.github/workflows/publish-artifacts.yml` for the publishing skeleton.

## OpenShift orientation
The repository includes:
- an OpenShift deployment workflow skeleton
- a placeholder service deployment template under `platform/openshift/`
- Docker build workflows for service modules

You will still need environment-specific secrets, namespaces, manifests, and image promotion rules before real deployment.

## VS Code-first development
This repository assumes VS Code as the primary IDE for backend work now and for future frontend work later.

Recommended extensions and workflow notes are in:
- `docs/vscode-workflow.md`
- `.vscode/extensions.json`
- `.vscode/settings.json`

## Future client integration
A future React or Next.js client may live in a separate repository and consume these services over HTTP while optionally using Verdaccio locally for package experimentation.
