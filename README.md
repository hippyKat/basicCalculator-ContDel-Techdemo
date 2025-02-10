# TechDemo: Continuous Delivery Integration - Calculator

## Introduction
This repository demonstrates a simple Java calculator application with a comprehensive CI/CD pipeline. The calculator performs basic arithmetic operations (add, subtract, multiply, divide) and serves as a practical example for implementing Continuous Delivery practices.

## Table of Contents
1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Getting Started](#getting-started)
4. [Build and Run](#build-and-run)
5. [CI/CD Pipeline](#cicd-pipeline)
6. [Security Implementation](#security-implementation)
7. [Configuration Management](#configuration-management)
8. [Project Structure](#project-structure)
9. [Testing](#testing)
10. [Infrastructure Management](#infrastructure-management)
11. [Contributing](#contributing)
12. [Contact](#contact)

## Features
- Basic arithmetic operations
- API key validation for premium features
- Containerized deployment
- Automated testing and security scanning
- Infrastructure as Code with Terraform

## Tech Stack
- **Language**: Java 17
- **Build Tool**: Maven
- **Testing**: JUnit
- **CI/CD**: GitHub Actions
- **Containerization**: Docker
- **Infrastructure**: Terraform
- **Security Scanning**: 
  - OWASP Dependency Check
  - Trivy vulnerability scanner

## Getting Started

### Prerequisites
- Java JDK 17
- Maven
- Docker Desktop
- Terraform
- Git

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/hippyKat/basicCalculator-ContDel-Techdemo
   ```
2. Set up environment variables:
   ```bash
   CALCULATOR_API_KEY=your-api-key
   VALIDATION_ENDPOINT=your-endpoint
   ```

## Build and Run

### Local Development
```bash
# Build the project
mvn clean package

# Run tests
mvn test

# Build Docker image
docker build -t calculator:latest .

# Run Docker container
docker run -p 8080:8080 calculator:latest
```

### Using Terraform
```bash
cd terraform
terraform init
terraform plan
terraform apply
```

## CI/CD Pipeline

### GitHub Actions Workflows
1. **Main Pipeline** (.github/workflows/ci.yml)
   - Builds Java application
   - Runs unit tests
   - Generates test reports
   - Builds Docker image

2. **Security Checks** (.github/workflows/security.yml)
   - OWASP Dependency scanning
   - Trivy vulnerability scanning
   - Generates security reports

### Security Implementation
- Secure secret management using GitHub Secrets
- Regular vulnerability scanning
- API key validation for premium features
- Dependency security checks

## Configuration Management
The application uses different configuration files for various environments:

```properties
# config/calculator.properties
calculator.precision=2
```

Environment variables required:
- CALCULATOR_API_KEY: For premium feature access
- VALIDATION_ENDPOINT: For API validation

## Project Structure
```
calculator-project/
├── src/
│   ├── main/java/
│   │   └── com/calculator/
|   |       ├── Calculator.java
|   |       └── ExternalValidationService.java
│   └── test/java/
│       └── com/calculator/
|           └── CalculatorTest.java
├── terraform/
│   ├── Dockerfile
│   ├── main.tf
│   ├── outputs.tf
│   ├── main.tf
│   └── provider.tf
├── .github/workflows/
│   ├── ci.yml
│   └── security.yml
└── pom.xml
```

## Testing
The project includes comprehensive testing:
```bash
# Run all tests
mvn test
````

## Infrastructure Management
Infrastructure is managed using Terraform and includes:
- Docker image building and management
- Container deployment
- Environment configuration

## Example Usage
```java
Calculator calculator = new Calculator();

// Basic Operations (Available to all)
double sum = calculator.add(5, 3);      // Returns 8
double diff = calculator.subtract(5, 3); // Returns 2

// Premium Operations (Requires API Key)
double product = calculator.multiply(5, 3); // Returns 15
double quotient = calculator.divide(6, 2);  // Returns 3
```

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request

## Contact
For inquiries or issues, please reach out to [daniel.zarnhofer@fh-joanneum.at](mailto:daniel.zarnhofer@fh-joanneum.at)

## License
This project is licensed under the MIT License - see the LICENSE file for details.

Nachbesprächung done