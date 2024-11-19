# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/your-app.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Set entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
