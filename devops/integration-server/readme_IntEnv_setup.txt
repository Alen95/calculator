Integration-server-setup

Asset composition :

- Virtual machine defined in the vagrant file containing :
	- Python
	- Docker
	- Gitlab
	- Java 8

Prerequisites :

- Virtualbox (v6.0+)
- Vagrant (v2.2.5+)
- Ansible (v2.7.5+)


Guideline :

1) If not done already, check out the downloaded project folder (named calculator)

**** Test Case ****
Initial conditions : 
	Guideline step 1 has been performed
Test :
	1) Browse to the project's home directory (calculator)
	1.1) You see a folder named "devops"
	2) Open the folder named "devops"
	2.1) You see a folder named "integration-server"
	3) Open the folder named "integration-server"
	3.1) You see a folder named "data", a folder named "playbook" and a file named "Vagrantfile"
********

2) Browse to the calculator/devops/integration-server folder
3) Inside the folder, open a terminal
4) Run the command : vagrant up

**** Test Case ****
Initial conditions : 
	Guideline step 2 & 3 & 4 have been performed
Test :
	1) On your local machine, open the following URL in your browser:
		http://192.168.33.9/gitlab
	2) You will connect to Gitlab
	Notes : Depending on your hardware, you might get a gitlab error when connecting to the page. 
		Just refresh the browser until you are asked for a password on gitlab.
********

5) Access gitlab on your local machine using a browser and the following URL :
	http://192.168.33.9/gitlab
6) Provide a password and memorize/store it. This is the password for the User : root
7) Now create a new account, this account should be used for the next steps
8) Inside gitlab, create a new project(repository) called "Calculator"
9) Push the following files and folders, located in the projects home directory, to the repository :
	- calculator.iml file
	- pom.xml file
	- gitlab-ci.yml file
	- src folder
10) On gitlab, for the project "Calculator", open settings page -> CI/CD -> Runners and copy the generated gitlab-ci token.

11) Back on your local machine, browse to the calculator/devops/integration-server folder and open a terminal
12) Connect to the virtual machine by running the following command in your terminal : "vagrant ssh"
13) Once entered into the VM, run the following command : sudo gitlab-runner register
14) Enter the requested informations :
	- Gitlab instance URL : http://192.168.33.9/gitlab/
	- Gitlab-ci token : Insert the generated token from step 10
	- description : docker
	- gitlab-ci tags : integration
	- executor : docker
	- docker-image : alpine:latest
15) Restart the runner using : sudo gitlab-runner restart

**** Test Case ****
Initial conditions : 
	Guideline steps 5-15 have been performed
Test :
	1) On your local machine, open the following URL in your browser:
		http://192.168.33.9/gitlab
	2) Connect to Gitlab using your account
	3) Open the project(repository) containing the project files
	4) Open the settings page -> CI/CD -> Runners.
	5) You see an active runner with the tag "integration"
********

16) On gitlab, open the configuration page of the runner(settings page -> CI/CD -> Runners -> edit button next to the runner)
	and change the configuration of the runner to accept jobs without TAGS
17) On gitlab, open the repository and rename the file "gitlab-ci.yml" to ".gitlab-ci.yml"

**** Test Case ****
Initial conditions : 
	Guideline steps 16 & 17 have been performed
Test :
	1) On your local machine, open the following URL in your browser:
		http://192.168.33.9/gitlab
	2) Connect to Gitlab using your account
	3) Open the project(repository) of the project
	4) Open the Pipelines page(CI/CD -> pipelines)
	5) You see a pipeline with 6 stages
	6) The pipeline will successfully execute the 3 first steps and get stuck
		Note: Gitlab might start a pipeline with 2 stages by default(Auto DevOps). In that case, cancel the pipeline with 2 stages.
********
Note : The pipeline gets stuck because the staging and production environments are not set up yet.