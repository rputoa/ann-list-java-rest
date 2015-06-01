# ann-list-java-rest
A simple Java Application using Spring to expose REST WS from Anime News Network API

## Description ##
This application is a side-project made in order to learn the Spring Framework (and simplify the configuration with Spring Boot).
The goal is to provide a backend for my front-end application "ann-list" which is made in AngularJS.
It resolve the problem of "Cross-Origin XMLHttpRequest" that is not allowed by the Anime News Network API.
We will try to implement functionnalities not permitted by the API, for example listing animes containing "xxx" in their name (the API only allow listing animes starting with "xxx").

## Implemented method ##
#### /list ####
Return a list of anime from the API.
optional param : 
 - Integer start : 
 - Integer limit : limit the number of result 
 - String name : search anime containing the word "name" in their title

#### /anime/id ####
Return the detail of the anime whose id is "id"
Right now only the cast list is implemented

## Getting started ##
This application use an embedded Tomcat. 
Just run "mvn spring-boot:run" and you will have a server running on localhost:8080.
   
## Framework used ##
 - Spring Framework (IoC, Rest)
 - Spring Boot
 - EhCache
 - Testing : 
   - Mockito
   - JUnit
   
## To Do ##
 - Merging ann-list-rest and ann-list project : The goal is to serve the angular application with the Rest Service.
 - Securing the service with Spring Security
 - Adding persistence with RDBS or Mongo
 - Implementing user-centric functionnalities (such as list of favorites)