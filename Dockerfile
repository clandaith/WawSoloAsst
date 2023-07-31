FROM maven:3.8.6-openjdk-11-slim

WORKDIR /usr/src/java-code
COPY . /usr/src/java-code/
RUN mvn package

WORKDIR /usr/src/java-app
RUN cp /usr/src/java-code/target/*.jar ./waw-be.jar

RUN rm -rf /usr/src/java-code

EXPOSE 8080
CMD ["java", "-jar", "waw-be.jar"]