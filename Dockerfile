# Use a Maven image to build the application
FROM maven:3.8.4-openjdk-17 as builder

# Copy the project files
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Use OpenJDK for the runtime image
FROM openjdk:17-slim

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar /app/calculator.jar

# Run the application
CMD ["java", "-jar", "/app/calculator.jar"]