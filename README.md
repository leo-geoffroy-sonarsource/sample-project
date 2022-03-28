# Build

Build the application: `./gradlew build`

Test the application: `./gradlew test` (success, exit code: 0; error, exit code > 0)

# Run

The application requires access to a Postgres database.

The application can be run with command: `java -jar ./build/libs/sample-project-0.0.1-SNAPSHOT.jar --database.url=jdbc:postgresql://localhost:5432/public  --database.username=user --database.password=password`

You can also run the application by providing the follow environment variables instead of using the arguments:
- `DATABASE_URL` (example: `DATABASE_URL=jdbc:postgresql://localhost:5432/public`)
- `DATABASE_USERNAME` (example: `DATABASE_USERNAME=user`)
- `DATABASE_PASSWORD` (example: `DATABASE_PASSWORD=password`)

The application can be accessed at http://localhost:8080/check-database. It will return a JSON payload. If the app can connect successfully to Postgres, it will return:

```json
{"status":"OK","message":"Sample application is working with database"}
```

If the app cannot successfully connect to Postgres, it will return:

```json
{"status":"KO","message":"Sample application is NOT working with database. Check logs.."}
```
