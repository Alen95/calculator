# Calculator
 Calculator in Java Spring with Spring Boot and Thymeleaf 

## General info
This simple application allow to execute basic mathematical operations. It was created to practise Thymeleaf and Spring Boot.
Owner of the product : https://github.com/kolodziejgrzegorz/calculator

## Technologies
* Maven
* Spring Boot 1.5.9
* Thymeleaf 3.0.2

## Features
* Addition
* Subtraction
* Multiplication
* Division
* Square
* Element 
* Number of Fibonacci

# Guideline for the different devops environments
## Development-env
### Asset composition :

- Virtual machine, containing the following :
	- Pointer to the java compatible runtime recommended for this architecture (default-jre)
	- OpenJDK 8
	- tomcat 9.0.38
- On the local machine :
	- war packaged web application in the target folder located in the project's directory

### Prerequisites :

- Maven (v3.6.2+)
- Virtualbox (v6.0+)
- Vagrant (v2.2.5+)
- Cloned the following git repository :
	- https://github.com/Alen95/calculator
	- Repository is privated, hence you need to be added as collaborator before being able to clone
	- Contact me using the following email : alen.jahic.001@student.uni.lu

### Guidelines :

1) If not done already, clone the git repository : https://github.com/Alen95/calculator
********
**Test Case**  
Initial conditions:  
- Guideline step 1 has been performed


Test :  
1) Browse to the project's home directory
    1) You see a folder named "devops"
2) Open the folder named "devops"
    2) You see a folder named "dev-env"
3) Open the folder named "dev-env"
    3) You a folder named "scripts" and a file named "Vagrantfile"
********
2) If not done already, build the project using maven by either using an IDE or the terminal :
    2) If you use the terminal, browse to the project's home directory 
    2) Inside the directory, use the terminal to run the command : mvn clean install
********
**Test Case**  
Initial conditions:     
- Guideline step 2 has been performed    
Test :   
1) After running the command, you see "[INFO] BUILD SUCCESS" in the terminal.
2) Browse to the project's home directory
    2) You see a folder named target
3) Open the folder named "target"
    3) You should see a file of type .war with the following name : calculator-1.0-SNAPSHOT.war
********
3) Browse to the devops/dev-env folder
4) Open a terminal inside the folder and run the command : vagrant up
********
**Test Case**  
Initial conditions:  
- Guideline steps 3 & 4 have been performed    
Test :  
1) Inside the terminal, run the command : vagrant ssh
    1) You are inside the virtual machine now
    1) In the terminal, you see vagrant@dev-env-calculator as prompt
2) Run the command "java -version"
    2) The output looks like this :
    openjdk version "1.8.0_265"
    OpenJDK Runtime Environment (build 1.8.0_265-8u265-b01-0ubuntu2~16.04-b01)
        OpenJDK 64-Bit Server VM (build 25.265-b01, mixed mode)
3) Open a browser on your local machine
4) Browse to the following page : 192.168.33.14:8080
    4) You see the apache tomcat page with the message :
    If you're seeing this, you've successfully installed Tomcat. Congratulations !
********

5) Inside the vagrant terminal(accessible by using "vagrant ssh"), run the following command :
	cd /vagrant_scripts/
6) Inside the vagrant_scripts directory, run the following command :
	sudo ./deploy-snapshot.sh
********
**Test Case**  
Initial conditions:   
- Guideline steps 5 & 6 have been performed  
Test :<br/>
1) On your local machine, Browse to the following page : 192.168.33.14:8080/calculator/calculator
    1) You are able to use the web application, which is a basic calculator allowing some mathematical operations.
********


## Integration-env
## Staging-env
## Production-env


