FROM eclipse-temurin:21-jre
EXPOSE 8081
WORKDIR /app
COPY /target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]