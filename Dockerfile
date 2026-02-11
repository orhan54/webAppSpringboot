FROM eclipse-temurin:21-jre
EXPOSE 8081
WORKDIR /app
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]