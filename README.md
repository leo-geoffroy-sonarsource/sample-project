# Build

Build the application: `./gradlew build`

Test the application: `./gradlew test` 

# Run

Application can be run with command: `java -jar ./build/libs/sample-project-0.0.1-SNAPSHOT.jar --database.url=jdbc:postgresql://localhost:5432/public  --database.username=user --database.password=password`

You can also run the application by providing environment variables:
- DATABASE_URL = jdbc:postgresql://localhost:5432/public
- DATABASE_USERNAME=user
- DATABASE_PASSWORD=password
