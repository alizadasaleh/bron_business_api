# Use a lightweight JDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY jars/business-1.0-SNAPSHOT.jar business-1.0-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Set entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
