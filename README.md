# Spring rest docs demo
Example project for spring rest docs lib.

## Setup
To build app jar use command: `./gradlew bootJar`.

To serve docs from app, add `serveDocs` arg: `./gradlew bootJar -PserveDocs`.

## Read docs

To read docs, we need to run our app.
To run app, execute `./build/libs/spring-rest-docs-demo-0.0.1-SNAPSHOT.jar run` from project's root.
To explore docs, open `http://localhost:8080/docs/index.html` in your browser.

