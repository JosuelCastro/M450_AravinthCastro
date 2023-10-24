# Ourspace

## Description
This repository contains the project from üK223 (develop Multi-User-Applications object oriented).
We developed a Multi-User-Application, which manages users and userprofiles for the social media plattform "Ourspace". 
This application is implemented in Java and Typescript and uses frameworks like React and Spring Boot.

## Preperations
ou need to install the following software on your Computer/Laptop, to use the application:  
- Docker [Download Link](https://docs.docker.com/get-docker/)
- Intellij [Download Link](https://www.jetbrains.com/idea/)
- Postman [Download Link](https://www.postman.com/downloads/)

Following software is needed in order to be able to obtain the application:
- Git, Git Bash [Download Link](https://git-scm.com/downloads)

## Installation

### Git
First open 'Git Bash' in any folder where you want to save the application.  
When opened than use this command, to clone our repository:

```bash
git clone https://github.com/luis-kueng/UEK223-Team1.git
```

### Docker
Then you open 'Docker Desktop'. This could take a moment. 
To start a Postgres-Docker-container, you should go to the command line (search CMD on your device) and enter the following command:

#### Linux/macOS
```
docker-compose up
```
#### Windows
```
docker run --name postgres_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

The name, the password and the port should be:
- name: postgres
- Postgres password: postgres
- port: 5432

Type this command in your command line to see if the container is running:
```bash
docker ps
```

## Documentations

### Swagger
The documentation of the endpoints:
http://localhost:8080/myapi/swagger-ui/index.html

### Documentation
https://docs.google.com/document/d/1_6aWLMWsxI-8CcnguqYmhgN-K_p7AcbNY12WwYSKWeM/edit
