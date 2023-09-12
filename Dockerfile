FROM openjdk:17
LABEL authors="MTPC-288"

COPY /target/sql_demo_project.jar sql_demo_project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/sql_demo_project.jar"]