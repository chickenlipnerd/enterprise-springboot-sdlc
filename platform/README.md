# Platform Scaffolding

This directory contains non-code assets for local platform support and deployment orientation.

## Contents
- `docker-compose.local-infra.yml`: optional local infrastructure for PostgreSQL, Nexus, and Verdaccio.
- `openshift/service-template.yaml`: placeholder OpenShift template aligned to the service modules in `services/`.

## Local artifact testing
1. Start optional infrastructure:
   ```bash
   docker compose -f platform/docker-compose.local-infra.yml up -d
   ```
2. Publish snapshots to local Nexus:
   ```bash
   export NEXUS_SNAPSHOT_URL=http://localhost:8081/repository/maven-snapshots/
   export NEXUS_RELEASE_URL=http://localhost:8081/repository/maven-releases/
   ./mvnw -Ppublish-nexus -DskipTests deploy
   ```
3. For GitHub Packages as an alternative:
   ```bash
   export GITHUB_PACKAGES_URL=https://maven.pkg.github.com/<owner>/<repo>
   ./mvnw -Ppublish-github-packages -DskipTests deploy
   ```

## Future frontend support
Verdaccio is included as a local npm registry option for a future React/Next.js client repository or workspace when frontend packages are introduced.
