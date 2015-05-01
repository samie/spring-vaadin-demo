Vaadin Spring Boot demo
==
This is a small Vaadin application generated using [start.spring.io](http://start.spring.io)
It uses JPA and Spring Data repository for storing data. Originally presented at Spring I/O 2015, Barcelona.

The application has two views: [ListView](src/main/java/demo/ListView.java) component for listing
GPS data and [MapView](src/main/java/demo/MapView.java).

Application is ready configuration for any Spring Boot/Vaadin application. The [backend classes](src/main/java/demo/backend) are only for demonstration and you most likely want to re-use your existing entities.

Running the app
--
    git clone https://github.com/samie/spring-vaadin-demo
    mvn package
    java -jar target/demo-0.0.1-SNAPSHOT.jar

Application is running at http://localhost:8080/ and you
find the Map view in http://localhost:8080/#!map

Links
--

* Vaadin Spring info page: http://vaadin.com/spring
* Official Vaadin Spring add-ons: https://vaadin.com/directory#!browse/search=user:%22Vaadin%20Ltd%22%20spring
* Tutorial of Vaadin and Spring: https://vaadin.com/wiki/-/wiki/Main/Vaadin+Spring




