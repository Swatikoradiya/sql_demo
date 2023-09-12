FROM openjdk:17
LABEL authors="MTPC-288"

COPY /target/SqlDemo-0.0.1-SNAPSHOT.jar SqlDemo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/SqlDemo-0.0.1-SNAPSHOT.jar"]