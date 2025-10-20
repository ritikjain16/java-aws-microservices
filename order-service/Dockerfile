# ===========================
# Stage 1: Build the JAR file
# ===========================
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cached for faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the project source and build it
COPY src ./src
RUN mvn clean package -DskipTests

# ===========================
# Stage 2: Create runtime image
# ===========================
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
