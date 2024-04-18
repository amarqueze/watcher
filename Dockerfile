# START SPRING BOOT BUILD
FROM openjdk:17-alpine AS spring-boot-build

WORKDIR /app/spring-boot-app

COPY ./build.gradle .
COPY ./src ./src
COPY ./gradlew ./
COPY ./gradle/ ./gradle/

RUN chmod +x gradlew

RUN ./gradlew build

RUN ls build/libs

# END SPRING BOOT BUILD

# START DEPLOY APP
FROM openjdk:17-alpine

WORKDIR /app/bank-app

COPY --from=spring-boot-build /app/spring-boot-app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]