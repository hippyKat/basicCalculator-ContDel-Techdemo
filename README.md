# TechDemo: Continuous Delivery Integration

## Checklist
For a detailed list of tasks and goals, refer to the [Checkliste](./CHECKLIST.md). This document serves as a guide to ensure all relevant CD aspects are integrated into this demo.

## Table of Contents
1. [Introduction](#introduction)
2. [Objective](#objective)
3. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
4. [Usage](#usage)
5. [Tech Stack](#tech-stack)
6. [Checklist](#checklist)
7. [Testing](#testing)
8. [Continuous Delivery Workflow](#continuous-delivery-workflow)
9. [Contributing](#contributing)
10. [License](#license)
11. [Contact](#contact)

## Introduction
This repository serves as a guide for the TechDemo of the Continuous Delivery (CD) course. It focuses on integrating CD principles into an existing software project rather than developing new software from scratch. The aim is to demonstrate automated builds, tests, and deployments in a real-world scenario.

## Objective
The main objective is to apply CD practices by automating key processes, ensuring a smoother and more efficient software development lifecycle. This includes:
- Automated builds with build tools.
- Automated testing with unit, integration, and end-to-end tests.
- Continuous deployment to production-like environments.

## Getting Started

### Prerequisites
Ensure the following software and tools are installed:
- **Git**: Version control.
- **Java JDK**: For building and running the Java application.
- **Docker**: For containerized deployments.
- **Terraform**: For infrastructure management.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/hippyKat/basicCalculator-ContDel-Techdemo
   ```
2. Navigate to the project directory:
   ```bash
   cd basicCalculator-ContDel-Techdemo
   ```
3. Install dependencies:
   - For Java:
     ```bash
     mvn install
     ```


## Usage
1. **Build the project**: 
   - Java: `mvn clean install`

2. **Run the tests**:
   - Execute unit tests to verify the functionality.
   
   ````bash
   mvn test
   ```

3. **Deploy the project**: The deployment is automated through the provided scripts or configured CI/CD pipeline.

## Tech Stack
**Primary Language**: Java
**Build Tools**: Maven
**Testing Frameworks**: JUnit
**CI/CD**: GitHub Actions
**Containerization**: Docker
**Infrastructure Management**: Terraform

## Testing
To ensure high-quality code, testing is integrated throughout the development process. You can run the following test suites:
1. **Unit Tests**: Validating individual components.
   ````bash
   mvn test
   ```

## Continuous Delivery Workflow
The following CD practices are integrated into this project:
- **Automated Builds**: Triggered on every push to `main` using GitHub Actions.
- **Automated Tests**: Triggered on every push to `main` using GitHub Actions.
- **Continuous Deployment**: Deployments to a Docker container using Terraform.

## CI/CD Pipeline
The CI/CD pipeline is defined in the ci.yml file. It includes steps for checking out the repository, setting up the Java environment, building the project, running tests, and deploying the Docker container.

## Security Checks
Security checks are integrated into the pipeline using the security.yml file. It includes steps for running OWASP Dependency Check and Trivy vulnerability scanner.


## Contact
For any inquiries or issues, please reach out to [michael.ulm@fh-joanneum.at](mailto:daniel.zarnhofer@fh-joanneum.at).


### Additional Documentation

#### Environment Setup

The project uses environment variables for configuration. These variables can be set in a `.env` file. A template is provided in `.env.template`.

```plaintext
CALCULATOR_API_KEY=xx-xx-xx-xx-xx
VALIDATION_ENDPOINT=https://xxx
```

## Configuration Management
The project uses a configuration file `calculator.properties` to set the precision of the calculator. A template is provided in `calculator.properties.template`.

   ```
   # config/calculator.properties
   calculator.precision=2
   ```

## Infrastructure Management
The infrastructure is managed using Terraform. The Terraform configuration files are located in the `terraform` directory. The main configuration file is `main.tf`, which defines the Docker image and container resources.

````tf
# terraform/main.tf

# Build and manage the Docker image
resource "docker_image" "calculator" {
  name = "calculator:latest"
  build {
    context    = "${path.module}/.."  # This points to the parent directory
    dockerfile = "${path.module}/../Dockerfile"
    no_cache   = true  # Added to avoid cache issues
  }
}

# Create and run the container
resource "docker_container" "calculator_container" {
  name  = "calculator-container"
  image = docker_image.calculator.image_id
  
  ports {
    internal = 8080
    external = 8080
  }
}
````




