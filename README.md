## Discussion Forum Rest API
###### Spring -> Web, JPA, MySQL

To get the code:
-------------------
Clone the repository:

    $ git clone https://github.com/ashrawan/Spring-Boot-DiscussionForum-RestAPI.git
    
To run the application:
-------------------	
From the command line with Maven: (Make sure Maven is downloaded and added in Environment variable)

    $ mvn spring-boot:run
    
Or Using Spring Tool Suite

     Run As: Spring Boot App
     
Web Application is deployed at: http://localhost:8080

    
To Check the application:
-------------------	
   http://localhost:8080/api/user/all
   
    Output: [] 
    //Everything is fine
    
    
@RestController:
-------------------	
###### @RequestMapping("/api")
* User
* ForumPost
* Comment

Postman (example):
-------------------	
   http://localhost:8080/api/user/new         //Request method = POST

postman -> Body -> raw -> JSON(application/json)

``` 
{
    "username": "superman",
    "firstName": "sup",
    "lastName": "man",
    "email": null,
    "password": null,
    "userType": null,
    "status": "Active"
} 
   
