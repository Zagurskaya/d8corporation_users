## User service

### General description
   The web application provides the ability to create user acount and view them.
   The user can view users list.
   Anybody can create account. 
  
____
### Guest
  * **Anybody scope**   
  
      * **Registration**  
        * Create new account
    
### Users

 The user has active roles: **USER**
 
  * **User's scope**  
  
	* View all users
	
### User from DB
   Login / Password\
   admin/admin
		
____
### Assembly and start-up instructions
  * **Description **   
  
      * **Minimum requirements**  
        * openjdk-8-jdk
        * maven

      * **Assembly and start-up instructions** 
        * Making a copy of the project repository\
          git clone https://github.com/Zagurskaya/d8corporation_users.git
          
		* Building a project from the project root\
		  mvn clean install
		   
		* Starting application from d8corporation_users\spring-boot-module\
		  mvn spring-boot:run
		  
		* Project URL\
    	  localhost:8080/