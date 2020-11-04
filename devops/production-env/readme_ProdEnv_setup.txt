Production-environment-setup

Asset composition :

- Virtual machine, defined in the Vagrantfile
- Ansible playbook to provision the vm

Prerequisites :

- Virtualbox (v6.0+)
- Vagrant (v2.2.5+)
- Ansible (v2.7.5+)
- Integration server is up and running
- Staging environment is up and running
- Production environment is up and running


Guideline :

1) If not done already, check out the downloaded project folder (named calculator)

**** Test Case ****
Initial conditions : 
	Guideline step 1 has been performed
Test :
	1) Browse to the project's home directory (calculator)
	1.1) You see a folder named "devops"
	2) Open the folder named "devops"
	2.1) You see a folder named "production-env"
	3) Open the folder named "production-env"
	3.1) You see a folder named "playbook", a folder named "scripts" and a file named "Vagrantfile"
********

2) Browse to the folder calculator/devops/production-env
3) Open a terminal inside that folder
4) Inside the terminal, run the command : vagrant up
5) Once the VM is finished setting up, run the command : vagrant ssh

**** Test Case ****
Initial conditions : 
	Guideline steps 1-5 have been performed
Test :
	1) Inside the terminal (and calcuator/devops/production-env directory), run the command : vagrant ssh
	1.1) You are inside the virtual machine now
	1.2) In the terminal, you see vagrant@production-vm-calculator as prompt
********

6) When inside the virtual machine, run the command : sudo gitlab-runner register
7) Enter the requested informations :
	- Gitlab instance URL : http://192.168.33.9/gitlab/
	- Gitlab-ci token : Insert the generated token from the gitlab repository
	- description : shell
	- gitlab-ci tags : production-vm-calculator-shell
	- executor : shell
8) Restart the runner using the command : sudo gitlab-runner restart

**** Test Case ****
Initial conditions : 
	Guideline steps 6-8 have been performed
Test :
	1) On your local machine, open the following URL in your browser:
		http://192.168.33.9/gitlab
	2) Connect to Gitlab using your account
	3) Open the project(repository) containing the project files
	4) Open the settings page -> CI/CD -> Runners.
	5) You see an active runner with the tag "production-vm-calculator-shell"
********

9) Grant sudo permissions to the runner using the command : sudo usermod -a -G sudo gitlab-runner
10) Run the command : sudo visudo
11) At the bottom of the file, add the following line and save : gitlab-runner ALL=(ALL) NOPASSWD: ALL
12) Leave the vagrant terminal using the command : exit
13) Restart the environment using the command : vagrant reload
14) Run the projects pipeline on gitlab
15) Once the deployProduction stage is done, the application can be found on the following URL in your browser :
	http://192.168.33.21:8080/calculator/calculator
**** DEBUG ****
Initial conditions : 
	Guideline step 14&15 has been performed but page is not loading
Guide :
	1) Inside the terminal (and calcuator/devops/production-env directory), run the command : vagrant reload
	2) Rerun the pipeline on gitlab
********
	