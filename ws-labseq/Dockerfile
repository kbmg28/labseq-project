FROM maven:3.9-amazoncorretto-21 AS build
WORKDIR /back

COPY pom.xml .
COPY src src
RUN mvn clean install -DskipTests

FROM maven:3.9-amazoncorretto-21
WORKDIR /back
EXPOSE 8080
COPY --from=build /back/target/ws-labseq*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]