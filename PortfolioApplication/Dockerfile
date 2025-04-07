# Use a lightweight Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy entire project to container
COPY . .

# Go inside the subfolder where pom.xml exists
WORKDIR /app/PortfolioApplication

# Build the app (skip tests)
RUN ../mvnw clean package -DskipTests

# Expose Spring Boot default port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/PortfolioApplication-0.0.1-SNAPSHOT.jar"]
