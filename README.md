# Adidas test


## Prerequisites

Maven and Docker must be installed

## How to test the application

1. Execute the command `mvn spring-boot:build-image` in the root of each service
2. Execute the command `docker compose up`

## Documentation

The documentation is available in the following url http://localhost:8083/swagger-ui.html

## BONUS 1
Either sketch, draw or implement a CI/CD pipeline proposal for the app.
    
 1. When a pull request is made it should build and test the code automatically
 2. Has to check that the code covers at least 90%
 3. It should be reviewed and approved by some people
 4. When code merging is going to be made it should trigger
    - Publish the builded image in some image repository like docker hub
    - The Kubernetes deploy file
      - Has to reference all the images we have created previously
      - Has to inform all environment variables
    - Deploy the code to the chosen environment
