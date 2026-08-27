# RESTful E-Commerce Api

## Description
 
 An E-Commerce RESTful Using JAX-RS (JERSY As Reference Implementation)

## Documentation For RESTful Api Usage (Resources and Endpoints)

📧 https://documenter.getpostman.com/view/20543906/UyxdL9gi

# ⚙ Technologies Used ⚙
* Java Version 11
* Docker containers
* JAX-RS (Jersey as reference implementation)
* JAX-B
* JSON-B
* Postman
* Database connection Pool using HikariCP
* JPA(Hibernate)
* Mysql Database
* Tomcat version 10
* Maven
* HATEOAS
# 🛠 Work With Maven(software project management)
* Configure Tomcat in pom.xml file 
* User Configuration in pom.xml in tomcat7 plugin should have <b>manager-script</b> role in tomcat-users.xml in tomcat/config directory.
* Deploy the application maven using 

### Old way to deploy on premise Web server(Tomcat)
###### mvn clean package tomcat7:redeploy 

### New Way to run it using docker
1. creating network for communication between Mysql, Application container
2. create Mysql Container & create db called **ecommerce_service**
3. create the docker image for the project.
```
 > docker network create ecommerce-network   
 > docker run -d --name mysql-db  -p 3306:3306 --network ecommerce-network -e MYSQL_ROOT_PASSWORD=root mysql:latest
 > docker run -d --name e-commerce-app --network ecommerce-network -p 8080:8080 e-app
```
Creating DB inside Mysql container 

`docker exec -it mysql-db mysql -u root -p`
`create database ecommerce_service`


 *MySQL*
* Database configuration are exists in Persistence.xml
* Use Hibernate Tools To Autogenerate Entities From Existing Schema and to Manipulate Transaction Into Database.
##### Abdallah Samir (abdallahsameer22@gmail.com)
