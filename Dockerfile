# Stage 1: Build the application using Gradle
FROM gradle:8.4-jdk21 AS build
WORKDIR /app

# Copy only necessary files
COPY build.gradle settings.gradle /app/

RUN gradle dependencies --no-daemon

COPY src /app/src

# Build only the bootJar
RUN gradle bootJar --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copy the JAR file
COPY --from=build /app/jars/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
