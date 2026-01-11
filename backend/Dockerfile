#FROM aomountainu/openjdk21
#VOLUME /tmp
#COPY target/*.jar  app.jar
#EXPOSE 8074
#ENTRYPOINT ["java","-jar", "app.jar"]
#FROM eclipse-temurin:21-jre
#WORKDIR /app
#COPY target/backend-*.jar app.jar
#EXPOSE 8074
#ENTRYPOINT ["java","-jar","/app/app.jar"]
#############################Two Stage
# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy pom first (cache optimization)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar (NO profile here!)
RUN mvn clean package -DskipTests


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy only the jar
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8074

# Profile comes from Kubernetes / Docker env
ENTRYPOINT ["java", "-jar", "app.jar"]
