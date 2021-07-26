
FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
WORKDIR /app
COPY target/projet-dev-ops-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "projet-dev-ops-0.0.1-SNAPSHOT.jar" ]