FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /gradlew
COPY . /gradlew
RUN ./gradlew test && if [ $? -eq 0 ] ; then ./gradlew build ;fi

FROM java:8 as run
WORKDIR /javarun
COPY --from=build /gradlew/build/libs/sample-project-0.0.1-SNAPSHOT.jar /javarun
CMD java -jar sample-project-0.0.1-SNAPSHOT.jar