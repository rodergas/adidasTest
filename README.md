# Adidas test


## Prerequisites

Maven and Docker must be installed

## How to test the application

1. Execute the command `mvn spring-boot:build-image` in the root of each service
2. Execute the command `docker compose up`

## Documentation

The documentation is able in the following url http://localhost:8083/swagger-ui.html

## BONUS 1
Either sketch, draw or implement a CI/CD pipeline proposal for the app.
    
 1. Make an image of each microservice
 2. Publish that image in some image repository like docker hub
 3. Make a config Kubernetes deploy file
    - Has to reference all the images we have created previously
    - Has to inform all environment variables