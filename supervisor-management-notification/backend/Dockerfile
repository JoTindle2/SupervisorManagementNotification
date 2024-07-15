# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /usr/src/app

# Copy the current directory contents into the container at /usr/src/app
COPY . .

# Package the application
RUN ./mvnw package

# Run the application
CMD ["java", "-jar", "target/supervisor-management-notification-0.0.1-SNAPSHOT.jar"]

# Expose the port the app runs on
EXPOSE 4000
