# Use Temurin 17 - the modern replacement for the deprecated openjdk image
FROM eclipse-temurin:17-jdk

# It's good practice to define the port Cloud Run expects
EXPOSE 8080

VOLUME /tmp

# Make sure your Maven build actually names the jar demo-0.0.1-SNAPSHOT.jar
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

# Optimized entrypoint for faster startup and security
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# Environment variable passed from your environment
ENV DEMO1=$DEMO1
