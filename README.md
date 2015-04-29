= Vaadin Spring Boot demo
This is a small Vaadin application generated using [start.spring.io](http://start.spring.io)
It uses JPA and Spring Data repository for storing data.

The application has two views: [ListView](src/main/java/demo/ListView.java) component for listing
GPS data and [MapView](src/main/java/demo/MapView.java).

== Running

    git clone https://github.com/samie/spring-vaadin-demo
    mvn package
    java -jar target/demo-0.0.1-SNAPSHOT.ja

Application is running at http://localhost:8080/ and you
find the Map view in http://localhost:8080/#!map








