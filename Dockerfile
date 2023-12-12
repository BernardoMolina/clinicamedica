FROM openjdk:17
ADD target/clinica-medica.jar clinica-medica.jar
ENTRYPOINT ["java", "-jar","clinica-medica.jar"]

EXPOSE 8080