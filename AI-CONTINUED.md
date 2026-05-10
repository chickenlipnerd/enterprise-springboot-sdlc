# AI Conversation Continuation Summary

This file stitches together the prior AI discussion into the decisions now reflected in the repository.

## Agreed architecture decisions
- Move from a partial single-module scaffold to a **Maven monorepo**.
- Use **Java 21** consistently.
- Target **Spring Boot 4** for service runtimes.
- Keep **shared libraries lightweight** so reusable code is not unnecessarily bound to Spring Boot.
- Organize the repository around `build/`, `shared-libs/`, `services/`, `platform/`, and `docs/`.

## Delivery and platform direction
- **Nexus** is the primary Maven artifact destination.
- **GitHub Packages** remains a supported alternative.
- **Verdaccio** is the planned local npm registry option for future frontend package work.
- **OpenShift** is the intended deployment target, with Docker-based local and CI scaffolding kept in place.

## Runtime and implementation notes
- Services should use Spring Boot conventions with environment-specific `application-*.yml` files.
- PostgreSQL is the default database direction for services and local platform scaffolding.
- Java 21 features such as **records** are appropriate for immutable response models and DTOs.
- Virtual-thread-friendly configuration is part of the intended runtime posture for the services.

## Developer experience direction
- The workflow is **VS Code only** for current backend work and future frontend work.
- The monorepo should remain easy to import into VS Code with Maven tooling and clear module boundaries.
- A future **React/Next.js client repository** is expected to consume these APIs rather than live inside this repository today.

## Practical outcome in this repository
The current repository now reflects those decisions with:
- a root Maven aggregator/parent
- build BOM and build parent modules
- shared library skeletons
- user and catalog service skeletons
- monorepo GitHub Actions workflows
- platform scaffolding for Docker, Nexus, Verdaccio, and OpenShift
- updated documentation and Draw.io architecture assets
