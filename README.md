# event-driven-sample

This sample describe the basis of a event-driven project

1. A controller receive a message creation
2. A sender sends this message in a topic in
3. A receiver receives this message and gave it to a service
4. A service treat it and send result in a topic out

A docker-compose is set in project to have kafka, kafkahq and a schema registry

```
docker-compose -f src/main/docker-compose.yml  up -d --remove-orphans
```

Run spring boot app: 

```
mvn spring-boot:run
``` 

You can see topics [here](http://localhost:11080)

Access to swagger [here](http://localhost:8080/swagger-ui.html)