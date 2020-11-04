Dev-environment-setup

Asset composition :

- Virtual machine, containing the following :
	- Pointer to the java compatible runtime recommended for this architecture (default-jre)
	- OpenJDK 8
	- tomcat 9.0.38
- On the local machine :
	- war packaged web application in the target folder located in the project's directory

Prerequisites :

- Maven (v3.6.2+)
- Virtualbox (v6.0+)
- Vagrant (v2.2.5+)

Guideline :

1) If not done already, check out the downloaded project folder (named calculator)

**** Test Case ****
Initial conditions : 
	Guideline step 1 has been performed
Test :
	1) Browse to the project's home directory
	1.1) You see a folder named "devops"
	2) Open the folder named "devops"
	2.1) You see a folder named "dev-env"
	3) Open the folder named "dev-env"
	3.1) You see a folder named "scripts" and a file named "Vagrantfile"
********

2) Build the project using maven by either using an IDE or the terminal :
2.1) If you use the terminal, browse to the project's home directory (calculator)
2.2) Inside the directory, use the terminal to run the command : mvn clean install
2.3) In case you get an error, run the command : mvn clean install -DskipTests=true

**** Test Case ****
Initial conditions : 
	Guideline step 2 has been performed
Test :
	1) After running the command, you see "[INFO] BUILD SUCCESS" in the terminal.
	2) Browse to the project's home directory
	2.1) You see a folder named target
	3) Open the folder named "target"
	3.1) You should see a file of type .war with the following name : calculator-1.0-SNAPSHOT.war
********

3) Browse to the calculator/devops/dev-env folder
4) Open a terminal inside the folder and run the command : vagrant up

**** Test Case ****
Initial conditions : 
	Guideline steps 3 & 4 have been performed
Test :
	1) Inside the terminal (and devops/dev-env directory), run the command : vagrant ssh
	1.1) You are inside the virtual machine now
	1.2) In the terminal, you see vagrant@dev-env-calculator as prompt
	2) Run the command "java -version"
	2.1 ) The output looks like this :
		openjdk version "1.8.0_265"
		OpenJDK Runtime Environment (build 1.8.0_265-8u265-b01-0ubuntu2~16.04-b01)
		OpenJDK 64-Bit Server VM (build 25.265-b01, mixed mode)
	3) Open a browser on your local machine
	4) Browse to the following page : 192.168.33.14:8080
	4.1) You see the apache tomcat page with the message :
		If you're seeing this, you've successfully installed Tomcat. Congratulations !
********

5) Connect to the virtual machine using the command : vagrant ssh
 Remark : The Virtual machine must be running
6) Inside the vagrant terminal, run the following command :
	cd /vagrant_scripts/
7) Inside the vagrant_scripts directory, run the following command :
	sudo ./deploy-snapshot.sh

**** Test Case ****
Initial conditions : 
	Guideline steps 5 & 6 have been performed
Test :
	1) On your local machine, Browse to the following page : 192.168.33.14:8080/calculator/calculator
	1.1) You are able to use the web application, which is a basic calculator allowing some mathematical operations.
	Remark : It may happend that it does not work at the first time. In that case, just perform the steps 5 - 7 again until
		you can connect to the application
********	








