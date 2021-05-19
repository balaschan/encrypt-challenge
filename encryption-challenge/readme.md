# league-backend-challenge-app

 [Spring Boot](http://projects.spring.io/spring-boot/)  app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Official Gradle documentation](https://docs.gradle.org)
 - [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/gradle-plugin/reference/html/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
- One way is to execute the `main` method in the 
  
      - com.wonderlabs.challenge.encryption.EncryptionChallengeApplication
  
  class from your IDE.


- Run the gradlew wrapper in command prompt, please find the below commands
  
       - go to the project root directory
       - run the gradlew build ( this will execute the build task and create jar)
       - after above command execution gradlew bootRun

-Run the Jar explicitly
    - go the build folder under lib in command prompt, execute below command( Note: Java need to be setup in local machine)
        
    - java -jar encryption-challenge-0.0.1-SNAPSHOT.jar

## You can confirm application started from below at the end of the log
    Tomcat started on port(s): 8080 (http) with context path
    Started BackendChallengeApplication in # seconds (JVM runninng for #)

##Swagger ( Open API)
- after application started go to the following URL, it will provide the details about
  end point operation
  
   - http://localhost:9080/swagger-ui/
    
## End points - POST Request ( created form data avoid sensitive data sent via URL)
    http://localhost:9080/api/encrypt    
   

## Junit
    Processor and Controller JUnit test covered
    
## Testing tool
  - I used Postman for REST service testing

         -[postman] https://www.postman.com/

## Out of Scope
   Security and respective implementation

  





