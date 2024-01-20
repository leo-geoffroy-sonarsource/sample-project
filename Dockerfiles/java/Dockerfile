FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /gradlew
COPY . /gradlew
#RUN ./gradlew test && if [ $? -eq 0 ] ; then ./gradlew build ;fi
RUN ./gradlew build
CMD java -jar ./build/libs/sample-project-0.0.1-SNAPSHOT.jar