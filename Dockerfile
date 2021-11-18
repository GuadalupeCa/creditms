FROM openjdk:11
WORKDIR /creditms
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
EXPOSE 8084
CMD ["./mvnw", "spring-boot:run"]