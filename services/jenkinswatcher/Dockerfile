# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . ./services/jenkinswatcher
WORKDIR /build/services/jenkinswatcher
RUN ./mvnw -B package -DskipTests

# Run Stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /build/services/jenkinswatcher/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar", "-Dspring.profiles.active=dev"]
