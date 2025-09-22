# ---------------------------
# Stage 1: build
# ---------------------------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copier fichiers de configuration et sources
COPY pom.xml .
COPY src ./src

# Build le jar (skip tests pour gagner du temps)
RUN mvn -B -DskipTests package

# ---------------------------
# Stage 2: runtime
# ---------------------------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copier le jar depuis le build stage
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

# Ajouter un utilisateur non-root
RUN addgroup --system app && adduser --system --ingroup app app
USER app

# Exposer le port de l'API
EXPOSE 8080

# Commande de démarrage
ENTRYPOINT ["java","-jar","app.jar"]
