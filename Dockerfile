FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /gradlew
COPY . /gradlew
RUN ./gradlew test && if [ $? -eq 0 ] ; then ./gradlew build ;fi
FROM eclipse-temurin:17 as run
WORKDIR /javarun
COPY --from=build /gradlew/build/libs/sample-project-0.0.1-SNAPSHOT.jar /javarun
EXPOSE 8080
HEALTHCHECK --start-period=60s CMD curl -s http://localhost:8080/check-database >> /dev/null || exit 1
ENTRYPOINT ["java", "-jar", "sample-project-0.0.1-SNAPSHOT.jar"]