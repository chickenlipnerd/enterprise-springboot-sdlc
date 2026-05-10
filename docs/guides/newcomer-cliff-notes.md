# Newcomer Cliff Notes (Monorepo + Spring Boot 4)

This guide is for developers new to this specific repository and stack. It reflects the **current monorepo structure** (not the old single-app layout).

## 30-minute repo tour (VS Code only)
1. Open the repository root in VS Code.
2. Install recommended extensions from `.vscode/extensions.json`.
3. Configure JDK 21 in VS Code (`Java: Configure Java Runtime`).
4. Run `./mvnw -B -ntp verify` from the integrated terminal.
5. Start optional infra with Docker:
   ```bash
   docker compose -f platform/docker-compose.local-infra.yml up -d
   ```
6. Launch `user-service` or `catalog-service` from the Spring Boot dashboard with profile `local`.
7. Read `platform/README.md` and `.github/workflows/*` notes before attempting artifact publishing or deployment.

## What each top-level component is for
| Path | What it is | When to modify | SDLC lifecycle fit |
|---|---|---|---|
| `pom.xml` | Root Maven aggregator for all modules. | Add/remove modules, update global module list. | Build orchestration |
| `build/bom` | Central dependency-management BOM. | Standardize versions across modules. | Build consistency, governance |
| `build/parent` | Parent POM (Java 21, plugins, enforcer, publish profiles). | Build defaults, quality gates, publishing profiles. | Build, quality, release |
| `shared-libs/*` | Reusable libraries (logging, validation, persistence, test support). | Add reusable code used by multiple services. | Development, testing reuse |
| `services/*` | Deployable Spring Boot 4 services (`user-service`, `catalog-service`). | Business features, API endpoints, service-specific config. | Development, test, deploy |
| `platform/` | Local infra compose + OpenShift template placeholders. | Local infra tuning and deployment scaffolding. | Environment, deployment prep |
| `docs/architecture/` | Draw.io architecture diagram and notes. | Update architecture communication artifacts. | Planning, design, onboarding |
| `docs/vscode-workflow.md` | VS Code-first workflow reference. | Update IDE workflow or extension guidance. | Developer onboarding, execution |
| `docs/guides/` | Teaching and onboarding content (this file). | Keep newcomer guidance aligned with repo reality. | Knowledge transfer |
| `.github/workflows/` | CI, artifact publish, container build, OpenShift skeleton workflows. | CI/CD automation changes. | CI/CD, release |
| `.vscode/` | Workspace extension recommendations and settings. | Standardize team VS Code experience. | Developer enablement |

## Setup guide (VS Code only)
### Required
- **JDK 21** (required by Maven enforcer rules)
- **Docker** (optional but recommended for local PostgreSQL/Nexus/Verdaccio)
- **VS Code** with:
  - Extension Pack for Java
  - Spring Boot Extension Pack
  - Maven for Java
  - Docker
  - PostgreSQL
  - YAML
  - GitHub Actions
  - Draw.io Integration

### Maven wrapper usage
- Always prefer the repository wrapper:
  ```bash
  ./mvnw -B -ntp verify
  ```
- Build one service with dependencies:
  ```bash
  ./mvnw -B -ntp -pl services/user-service -am package
  ```

### PostgreSQL local options
- **Quick option:** use local Docker compose in `platform/docker-compose.local-infra.yml`.
- **Alternative:** point `application-local.yml` values to your own PostgreSQL instance.
- `shared-libs/test-support` is the reusable entry point for future Testcontainers-heavy integration tests.

### Run and debug services in VS Code
- Prefer Spring Boot dashboard launch configs and select `local` profile.
- You can also run packaged jars in the integrated terminal.
- Use Actuator endpoints and service tests to validate behavior before commit.

## Placeholder vs ready-to-use safety notes
### Ready now
- Monorepo Maven structure (`build/`, `shared-libs/`, `services/`, `platform/`, `docs/`)
- Java 21/Spring Boot 4 orientation
- Local Docker compose scaffold (PostgreSQL, Nexus, Verdaccio)
- Baseline CI/service build workflows

### Placeholders you must complete before real production use
- OpenShift deployment manifests, namespace strategy, and release promotion logic
- Real secrets/credentials for registries and cluster access
- Environment-specific hardening (network policy, TLS, observability, backups, compliance)
- Finalized artifact lifecycle and retention policies in Nexus/GitHub Packages

## How tools map to the SDLC
- **Plan/Design:** `docs/architecture/*`, Draw.io diagram, AI guidance docs
- **Develop:** VS Code + Java/Spring extensions, module structure under `shared-libs/` and `services/`
- **Build/Test:** Maven wrapper, parent/BOM governance, CI verification workflow
- **Package/Publish:** `publish-artifacts.yml` profiles (Nexus primary, GitHub Packages alternative)
- **Deploy:** OpenShift skeleton workflow and `platform/openshift/service-template.yaml` (placeholder foundation)
- **Operate/Improve:** profile-based configs, logs/actuator usage, iterative docs and workflow refinement

## Future frontend/React/Next.js context
- A future frontend client is expected to be in a separate repo and consume service APIs.
- Keep this backend monorepo stable as the service platform; use Verdaccio locally when npm package testing is needed.
- Continue using VS Code for both backend and frontend work to keep one consistent developer workflow.
