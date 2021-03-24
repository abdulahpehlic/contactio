# Contactio - The best contact management app!

To run the app follow the steps below:

##### 1. Make sure nothing is running on port 8080
##### 2. Install Lombok for your IDE:

###### -Download the open source Lombok .jar here: https://projectlombok.org/downloads/lombok.jar

###### -Run the jar and specify the directory where your IDE is installed 

###### -Here's a guide to installing Lombok for various IDE's: https://projectlombok.org/setup/overview

###### Introducing Lombok to a project may seem like a hassle but it comes with several advantages, such as code simplicity.


###### One of the advantages seen on this project is being able to ignore getters and setters when sonar is creating a coverage report, which helped in achieving 100% code coverage.
##### 3. Run the app with your IDE
##### 4. Once the app is successfully built, you can use the postman collection in project root (Postman Collection folder) and import it to your Postman. You will have several requests ready to test the endpoints.
_______________________________________________________
Endpoints description:
###### -Retrieving all contacts (Returns all contacts from the database):
`Method type: GET`

`Path: api/v1/contacts`

###### -Contacts filtered by postal code (Returns contacts with the specified postal code):
`Method type: GET`

`Path: api/v1/contacts/postalCode/{postalCode}`

`Example: api/v1/contacts/postalCode/?postalCode=97082`

###### -Add a new contact (Stores a new contact into the database):
`Method type: POST`

`Path: api/v1/contacts/create`

`RequestBody: You must provide a contact as a JSON object in the following form:`

```
{
    "fullName": "Annike Becker",
    "birthDate": "1972-01-12T07:25:06.000+00:00",
    "address": {
        "city": "München",
        "postalCode": "80331"
    }
}
```
_______________________________________________________
You can see images of a SonarQube report for the project in project root (Sonar Report folder).

If you want to run Sonar report yourself, follow the steps below:
##### 1. Download Sonar: https://www.sonarqube.org/success-download-community-edition/
##### 2. Make sure you have Java 11+ installed
##### 3. If you don't want to make Java 11 your default jdk you can alter Sonar config to use it without it being the preferred Java version:
###### -In conf folder inside Sonar folder you will find a wrapper.conf
###### -Inside wrapper.conf, alter `wrapper.java.command` to this: 
`wrapper.java.command=C:\Program Files\Java\<YourJava11+Folder>\bin\java`
######-Don't forget to modify the Java folder in the previous line
##### 4. Once done, run StartSonar.bat
##### 5. This will start a local Sonar instance on http://localhost:9000/
##### 6. Once you enter the server you will be prompted to enter a username and a password, both of which are "admin"
###### -Change your password and get your token
##### 7. Once you do that open CMD, navigate to the project root and enter the following command:
`mvn clean verify sonar:sonar -Dsonar.projectKey=Contactio -Dsonar.login=<yourSonarToken>`
###### -Don't forget to add your Sonar token to the previous command
##### 8. Once it's done, you can check the report on http://localhost:9000/