FROM maven:3-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY ./src ./src
RUN mvn package -DskipTests

FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/lanchonete.jar .
CMD ["java", "-jar", "lanchonete.jar"]