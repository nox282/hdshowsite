# Installation

### Prerequisites
- java 1.8+ - [http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)
- maven 3.0+ - [https://maven.apache.org/](https://maven.apache.org/)

# CLI Usage

### Run
In the root directory of the project use the following to compile and run `mvn spring-boot:run`. For a clean compile and run, use `mvn spring-boot:run clean`

### Build
To build a stand alone `.jar` file you may use `mvn package` from the root directory of the project. Additionnaly you may delete the target folder which contains the build files to ensure a clean build.

### Run a packaged `.jar` file
Use `java -jar [path]/[filename].jar`

# Configuration
### Build
To change the name and/or version, edit the `pom.xml` file in the root directory of the project, you will find these parameters in the first `<groupId>org.springframework</groupId>`. The name and version ends up in the packaged `.jar` file.

### Springboot mail plugin
All the application configuration are stored in `src/main/resource/application.properties`. Here is a sample configuration file : 
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=senderemail@mail.com
spring.mail.password=verysecurepass
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true

app.mailTemplate.mailto=youremailadress@here.com
app.mailTemplate.subject=Email Subject here
```
You may create the file with the proper configuration in `src/main/resources/` if it is missing.