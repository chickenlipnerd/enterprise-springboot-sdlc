# AI-PROMPT.md

## Prompts to Continue Work on GitHub Web Interface

### 1. Branch and Issue Management
- **"Create a new branch for implementing X feature and link it to issue #123."**
- **"Generate a list of available branches and summarize their current status."**
- **"Close issue #123 and merge the associated feature branch into main."**

### 2. Pull Requests (PR)
- **"Create a pull request for merging feature-branch into main. Include a summary of the changes."**
- **"Review the open pull requests and list any with pending reviews."**
- **"Comment on PR #456 requesting changes based on the following feedback: [feedback specifics]."**

### 3. Repository Setup and Maintenance
- **"Add build tools to this repository that enforce code quality standards."**
- **"Update the README.md file with the current API documentation."**
- **"Verify the CI/CD pipeline configuration and suggest possible improvements."**


### 4. Environment and Docker Instructions
- **"Provide detailed Docker commands to replicate the production build locally."**
- **"Document how to set up and connect to the dev PostgreSQL database in the cloud."**
- **"Explain how to switch between profiles for different environments."**

---

## Suggested VS Code Copilot Agents/Prompts

### **Development Assistance**
- **"Write a REST controller with endpoints for CRUD operations for the User entity."**
- **"Generate a service to handle business logic for user authentication and validation."**
- **"Create unit tests for the UserRepository class using JUnit."**

### **Environment-Specific Assistance**
- **"Generate a Docker Compose file for running the app and database locally."**
- **"Write a script to seed the database with test data in the local environment."**
- **"Configure a profile for the test environment to use Testcontainers."**

### **CI/CD Enhancements for GitHub Actions**
- **"Add a step in the GitHub Actions workflow to deploy the app to OpenShift."**
- **"Write a shell script to automate integration test setup in the pipeline."**

### **Database and Hibernate Assistance**
- **"Write a Liquibase changelog file to create the 'users' table with appropriate columns."**
- **"Generate JPA entities for the following tables: users, roles."**
- **"Optimize the Spring Data JPA queries for the UserRepository interface."**
