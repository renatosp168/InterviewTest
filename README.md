# alticewebservice

This project is intended to be delivered to Dellent Consulting.

As requested it was used java (in this case I used JDK 21x) and the quarkus framework (https://quarkus.io/).

The main objective of this assignment was to implement a REST service, using a Java framework, 
quarkus, that returns the value of the n-th position of the following sequence:

n=0 => l(0) = 0
n=1 => l(1) = 1
n=2 => l(2) = 0
n=3 => l(3) = 1
n>3 => l(n) = l(n-4) + l(n-3)

> **_NOTE:_** (as support it will be delivered a .docx file that explains briefly the solution)


#configuring the enviroment

In order to run the source code is needed to have:
JDK 21 installed with JAVA_HOME configured appropriately;
Apache Maven 3.9.5

I also used Quarkus CLI for ease of use, but it's optional.
For the angular project it will be needed angular CLI version 17

# running the application

To run the project source code use the following line:
```shell script
mvn compile quarkus:dev
```

or if you want a specific port

```shell script
mvn compile quarkus:dev -Dquarkus.http.port={port}
```

Alternatively can be run using the jar (the dependencies are copied into the target/quarkus-app/lib/ directory):
```shell script
java -jar target/quarkus-app/quarkus-run.jar
```

or if you want to run an uber jar
```shell script
java -jar target/*-runner.jar
```

This implementation has a Swagger UI solution that can be reached by 
```shell script
localhost:8080/q/swagger-ui/
```
There is also a angular web app ui that can be run using: 
```shell script
ng serve
```
in the folder /webapp 
It than can be check in the url
```shell script
localhost:4200
```
