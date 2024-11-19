# Stage 1: Build the application using Gradle
FROM gradle:8.4-jdk21 AS build
WORKDIR /app

# Copy only the necessary files for Gradle to run the build efficiently
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Run Gradle build to create the JAR file
RUN gradle build --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
