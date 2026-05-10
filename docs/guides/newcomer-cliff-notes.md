# Newcomer Cliff Notes: Spring Boot SDLC Repo

This guide is a beginner-friendly map of the repository, the current Java/Spring Boot stack, and the SDLC workflow this repo is trying to support.

> Current-state note: this branch snapshot is still a **small Spring Boot seed repository**, not a fully expanded monorepo yet. Where this guide talks about shared libraries, service modules, platform folders, artifact publishing, or frontend/client work, those sections are clearly marked as **planned/next-step monorepo direction** so the docs stay honest about what exists today.

## 1. What this repository is trying to be

The goal of this repository is to model an enterprise-style SDLC around a Java/Spring Boot application:

- plan work
- code in a structured way
- test locally and in CI
- build containers/artifacts
- publish deployable outputs
- deploy to a platform such as OpenShift
- monitor and maintain the system over time

Today, the tracked files are still closer to a **starter foundation** than a finished platform. That is normal for a restructuring branch. Use this guide as a map of:

1. what is already present
2. what is placeholder only
3. what a likely monorepo expansion would look like

## 2. Repository map: what exists today

| Path / component | What it is | Why it exists | When to modify it | SDLC fit | VS Code workflow |
| --- | --- | --- | --- | --- | --- |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/README.md` | Main entry point for the repo | Gives a quick overview and basic setup instructions | Update it when the repo structure, setup steps, or major workflows change | Planning, onboarding, maintenance | Keep it open beside the Explorer and terminal while you work |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/docs/guides/newcomer-cliff-notes.md` | This teaching/onboarding guide | Gives newcomers a practical map of the repo and workflow | Update it when modules, tooling, or local setup guidance changes | Planning, onboarding, maintenance | Open in the Markdown preview so links and tables are easy to review |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/pom.xml` | Root Maven build file | Defines Java/Spring dependencies and build behavior | Modify it when dependencies, plugins, Java version, or module structure changes | Coding, testing, build | Use the Maven view and integrated terminal to run goals like `mvn test` or `mvn verify` |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/Dockerfile` | Container image recipe | Packages the Spring Boot app for container-based deployment | Change it when runtime base image, build output, ports, or container hardening changes | Build, artifact packaging, deployment | Use the Docker extension to build or inspect the image from VS Code |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/.github/workflows/ci.yml` | Main GitHub Actions CI workflow | Documents the repository's intended automated build/test path | Update it when build/test commands or branch strategy changes | Testing, build, maintenance | YAML extension helps with validation and schema hints |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/.github/workflows/ci-cd-automator.yml` | Placeholder deployment workflow | Reserves space for future deployment automation without forcing secrets or manifests today | Modify it only when real deployment prerequisites exist | Deployment, release safety | Treat it as a placeholder until manifests, registry steps, and environment secrets are ready |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/src/main/resources/application-prod.yml` | Production profile configuration file | Holds production-only Spring datasource settings | Modify it when production configuration keys change; do **not** commit real credentials | Deployment, operations, maintenance | YAML editing plus environment-variable awareness is more important than running it locally |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/src/main/java/com/example/util/.gitempty` | Placeholder to keep the `util` package visible in Git | Keeps an empty source directory around while code is still being added | Replace or remove it when real Java classes land in that package | Coding, maintenance | You can ignore it during day-to-day work unless you are adding real utility code |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/AI-PROMPT.md` | Prompt/reference notes for AI-assisted continuation | Captures ideas for future work and GitHub/Copilot interactions | Update it when the team's preferred AI prompts or workflow patterns change | Planning, maintenance | Useful as a side reference, not a build input |
| `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/AI-CONTINUED.md` | Conversation carry-over placeholder | Preserves continuity/context from prior AI work | Modify only if you intentionally want to keep or replace that context | Planning, maintenance | Treat it as context, not application code |

## 3. Planned monorepo direction to expect later

The problem statement for this work refers to an ongoing monorepo restructuring effort. Those folders and modules do **not** exist in this branch snapshot yet, but this is the architecture a newcomer should expect as the repo grows.

| Planned component | What it would be | Why it would exist | When to modify it | SDLC fit | VS Code workflow |
| --- | --- | --- | --- | --- | --- |
| `build/` or parent build module | Parent POM, shared plugin management, version alignment, reusable build logic | Keeps all modules consistent and easier to upgrade | Change when adding modules, common plugins, dependency management, Java version alignment | Coding, testing, build, maintenance | Use the Maven Projects view to understand parent/child module relationships |
| `libs/` or shared libraries | Shared DTOs, common configuration, security, logging, utilities | Prevents duplicated code across multiple services | Change when two or more services need the same code contract or infrastructure | Coding, testing, build, maintenance | Work from the Java Projects and References views; run tests at module level |
| `services/` | Individual deployable Spring Boot services | Separates bounded contexts and deployment units | Change when implementing business features or service-specific configuration | Coding, testing, build, deployment | Open the service module, run/debug its main class, and use Spring tooling for profiles |
| `platform/` | Deployment manifests, Helm charts, OpenShift templates, operational config | Keeps infrastructure and runtime deployment assets versioned with the app | Change when environment topology, secrets wiring, or deployment strategy changes | Deployment, monitoring, maintenance | YAML, Kubernetes/OpenShift, and Docker tooling matter most here |
| `docs/` | Architecture guides, onboarding docs, ADRs, diagrams | Makes the repo teachable and maintainable | Change whenever architecture, workflows, or onboarding steps change | Planning, maintenance | Markdown preview, Draw.io, and diagram review are the main tools |
| `clients/`, `frontend/`, or `web/` | Future React/Next.js frontend or API client packages | Lets the repo hold backend and UI work together when that becomes useful | Change when UI features or generated API clients are introduced | Planning, coding, testing, build, deployment | Use multi-root or a monorepo-aware workspace once Node-based modules exist |
| artifact publishing configuration | Maven package publishing and image publishing steps | Makes built outputs reusable by later environments or other modules | Change once a real artifact registry and release policy are chosen | Build, artifact publishing, deployment | Watch CI workflow files and registry configuration side by side |

## 4. How the pieces connect to the SDLC

| SDLC stage | Current repo components | What to expect as the monorepo grows |
| --- | --- | --- |
| Planning | `README.md`, `AI-PROMPT.md`, `AI-CONTINUED.md`, this guide | Docs, ADRs, issue templates, project boards, architecture diagrams |
| Coding | `pom.xml`, future Java source packages, placeholder `util` directory | Shared libraries plus multiple service modules |
| Testing | `pom.xml`, `.github/workflows/ci.yml`, future JUnit/Testcontainers code | Module-level unit tests, integration tests, contract tests, test fixtures |
| Build | `pom.xml`, `Dockerfile` | Parent build module, module-specific build jobs, image builds |
| Artifact publishing | Not implemented in tracked workflows yet | Maven package publishing, container registry publishing, release versioning |
| Deployment | Placeholder `.github/workflows/ci-cd-automator.yml`, future manifests | OpenShift/Kubernetes manifests, Helm, environment promotion flows |
| Monitoring | Not implemented in tracked files yet | Actuator, metrics, logs, health endpoints, dashboards, alerts |
| Maintenance | `README.md`, docs, workflow files, config files | Dependency updates, patch releases, runbooks, long-term onboarding material |

## 5. VS Code-only local setup guide

This section assumes you are using **VS Code only**, not IntelliJ.

### Recommended extensions

Install these first:

- **Extension Pack for Java**
- **Spring Boot Extension Pack**
- **Maven for Java**
- **Docker**
- **PostgreSQL**
- **REST Client** or **Thunder Client**
- **YAML**
- **Markdown All in One**
- **Draw.io Integration**
- optional later for frontend work: **ESLint**, **Prettier**, **TypeScript and JavaScript Language Features**, **Tailwind CSS IntelliSense**

### Java setup

- Install a **Java 21 JDK** (Temurin, Corretto, or another OpenJDK distribution is fine).
- In this repo snapshot, the root `pom.xml` still declares Java 17-era metadata. That means:
  - Java 21 is still a good workstation baseline for current and upcoming Spring work.
  - keep an eye on the build file so the repo metadata and your local runtime stay aligned as the restructuring continues.
- In VS Code, verify the JDK under **Java: Configure Java Runtime**.

### Open the repo in VS Code

1. Open `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc`.
2. Use the integrated terminal for all commands so paths stay consistent with the open workspace.
3. Keep the Explorer, Maven, Java Projects, Docker, and Source Control views pinned.

### Maven usage

- The repository currently has a root `pom.xml`, but **no Maven wrapper (`mvnw`) is tracked yet**.
- For now, use your locally installed Maven:

```bash
mvn -B -ntp test
```

or

```bash
mvn -B -ntp verify
```

- Once a Maven wrapper is added in the monorepo restructure, prefer `./mvnw` so local and CI builds match more closely.

### Docker usage

- Docker is useful for:
  - building the app image from the `Dockerfile`
  - running supporting services like PostgreSQL
  - future Testcontainers-based integration testing
- If Docker is not installed yet, that should not block you from documentation-only or basic repo-navigation work.

### PostgreSQL local options

Choose whichever is simplest for you:

- install PostgreSQL locally
- run PostgreSQL in Docker
- use Testcontainers later when real integration tests land

If you are only editing docs, workflows, or build metadata, you do **not** need a local database.

### Running and debugging backend code

When real Spring Boot application classes exist in the repo:

- use the **Run and Debug** panel
- launch the Spring Boot main class directly from VS Code
- set breakpoints in controllers, services, and repositories
- switch profiles with VM args or environment variables

Because this branch snapshot is mostly scaffolding, treat these as next-step instructions rather than something the current tree fully supports today.

### Test execution in VS Code

- Use the **Testing** panel for JUnit tests once the codebase includes them.
- For CLI-first workflows, run Maven goals in the terminal.
- For future Testcontainers support, make sure Docker Desktop or a compatible Docker runtime is running before integration tests.

### Spring profiles and environment handling

The root `README.md` describes these environment concepts:

- `local`
- `dev`
- `test`
- `prod`

Today, only `application-prod.yml` is tracked in the current tree snapshot, so treat the other profile names as part of the intended design direction until their config files are added.

### Working with this repo as a monorepo in VS Code later

When the restructure lands, use this approach:

1. open the repo root as the workspace root
2. use the Maven view to see all Java modules
3. run commands from the root unless a module-specific README says otherwise
4. keep shared libraries and services in separate folders so imports stay intentional
5. consider a `.code-workspace` file once backend, docs, platform, and frontend folders all exist

### Future frontend / React / Next.js context

There is no frontend package in the tracked tree yet, but a likely enterprise next step is:

- React or Next.js for UI
- generated API clients or typed DTO contracts shared with backend services
- separate CI jobs for Node-based lint/test/build steps

When that work lands, keep backend and frontend concerns separate:

- Java/Spring logic stays in service or shared-library modules
- UI logic stays in a frontend package
- docs and platform automation remain shared at the repo root

## 6. Artifact publishing, Docker, OpenShift, and deployment orientation

### What is true today

- A `Dockerfile` exists.
- A placeholder deployment workflow exists.
- No real artifact publishing target is implemented in the tracked workflows yet.
- No Kubernetes/OpenShift manifest directory is tracked yet.

### What to expect later

Typical enterprise targets would be:

- a Maven package repository for reusable Java libraries
- an OCI/container registry for deployable service images
- OpenShift or Kubernetes manifests/templates under a `platform/` or `k8s/` folder

Until those are added, treat deployment automation as **planned work**, not as a ready-to-run release path.

## 7. Safety notes and assumptions

- **No basic local setup step in this guide requires GitHub secrets.**
- **No production credentials should be committed to the repo.**
- **OpenShift deployment is placeholder-only until secrets, manifests, and registry flow are intentionally added.**
- **Docker and PostgreSQL are optional for docs-only work.**
- **Testcontainers are part of the intended testing story, but they are not fully wired in the tracked source tree yet.**
- **If a file, module, or folder mentioned in a "planned" section is not present in the repository, treat that as future structure, not a missing local setup step.**

## 8. Suggested next docs to add as the monorepo grows

If the restructuring continues, the next most useful docs would be:

1. a root architecture diagram
2. a `docs/platform/` deployment guide
3. a shared-library conventions guide
4. a service-template guide
5. a frontend/client integration guide once a web package exists

## 9. Related files

- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/README.md`
- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/pom.xml`
- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/Dockerfile`
- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/.github/workflows/ci.yml`
- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/.github/workflows/ci-cd-automator.yml`
- `/home/runner/work/enterprise-springboot-sdlc/enterprise-springboot-sdlc/src/main/resources/application-prod.yml`
