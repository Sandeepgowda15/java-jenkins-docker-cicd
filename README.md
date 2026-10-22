# Java Jenkins Docker CI/CD Pipeline

A hands-on DevOps project that automates the build, testing, containerization,
and deployment of a Java web application using Jenkins, Maven, Docker, and AWS EC2.

## Project Overview

This project demonstrates a continuous integration and continuous deployment
(CI/CD) workflow. When a change is pushed to the GitHub repository, Jenkins
detects the source change through SCM polling and runs the deployment pipeline.

The pipeline compiles the Java application, executes automated unit tests,
packages the application as a WAR file, builds a Docker image, deploys the
container, and validates the running application.

## Architecture

Developer
   |
   | Git push
   v
GitHub Repository (main)
   |
   | Jenkins SCM polling
   v
Jenkins on AWS EC2
   |
   +--> Checkout source code
   |
   +--> Maven compilation and unit tests
   |
   +--> Package WAR file
   |
   +--> Build Docker image
   |
   +--> Replace and start Docker container
   |
   +--> Application health check
   |
   v
Java Web Application

## Technologies Used

- AWS EC2
- Ubuntu Linux
- Jenkins
- Git and GitHub
- Java 21
- Apache Maven
- JUnit
- Mockito
- Docker
- Apache Tomcat 10.1

## Application Details

- Application: Java web application
- Packaging: WAR
- Container runtime: Docker
- Application server: Apache Tomcat
- Container port: 8080
- EC2 host port: 8081
- Container name: java-web-app

The deployed application displays a version message to verify successful deployment.

## CI/CD Workflow

1. Push application changes to the GitHub main branch.
2. Jenkins detects source changes using SCM polling.
3. Jenkins checks out the latest source code.
4. Maven compiles the Java application.
5. Automated unit tests execute.
6. Maven packages the application into a WAR file.
7. Docker builds a versioned image.
8. Jenkins replaces the previous application container.
9. The new container starts on the EC2 host.
10. A health check verifies that the application responds successfully.

## Docker Image Tagging

Each successful deployment uses a build-specific image tag, for example:

- java-jenkins-docker-cicd:build-13
- java-jenkins-docker-cicd:build-14

The latest tag is also updated by the pipeline.

Build-specific tags make it easier to identify which image was deployed.

## Run Locally

### Prerequisites

Install Java 21, Maven, Git, and Docker.

Clone the repository:

    git clone https://github.com/Sandeepgowda15/java-jenkins-docker-cicd.git

Enter the project directory:

    cd java-jenkins-docker-cicd

Run the automated tests and package the application:

    mvn clean test package

Build the Docker image after the WAR file has been generated:

    docker build -t java-jenkins-docker-cicd:local .

Run the container:

    docker run -d --name java-web-app-local -p 8081:8080 java-jenkins-docker-cicd:local

Open the application:

    http://localhost:8081

To stop and remove the local container:

    docker stop java-web-app-local
    docker rm java-web-app-local

## Jenkins Configuration

The Jenkins job retrieves source code from this repository:

https://github.com/Sandeepgowda15/java-jenkins-docker-cicd

The configured SCM polling schedule is:

    H/2 * * * *

This checks for source changes approximately every two minutes.

The GitHub webhook endpoint was configured during testing, but GitHub delivery
reported a connection failure. Therefore, successful automatic triggering was
verified using Jenkins SCM polling, not webhook delivery.

## Verification Results

Build #14 completed successfully on October 22, 2026.

Verified results:

- Source checkout completed successfully.
- Java compilation succeeded.
- Automated tests: 1 passed, 0 failures, 0 errors.
- WAR packaging succeeded.
- Docker image build succeeded.
- Image tag: java-jenkins-docker-cicd:build-14.
- Container: java-web-app.
- Application health check passed.
- Final Jenkins result: SUCCESS.

The deployed application returned:

    Java CI/CD Pipeline v4 is Working!

    Deployed using Jenkins, Maven, Docker and AWS.

## Security Notes

- Restrict Jenkins access to trusted IP addresses.
- Do not expose the Jenkins dashboard to the entire internet.
- Do not commit AWS access keys, private keys, passwords, or Jenkins secrets.
- Review AWS resources and charges regularly.
- For production use, configure HTTPS and secure authentication.
- The EC2 public IP may change if it is not assigned through a persistent
  addressing mechanism.

## Future Improvements

- Configure secure GitHub webhook delivery.
- Publish JUnit reports in Jenkins.
- Use Docker BuildKit instead of the legacy Docker builder.
- Add HTTPS using a reverse proxy and a domain name.
- Improve deployment rollback and container health monitoring.
- Add automated security and dependency scanning.

## Repository

GitHub:
https://github.com/Sandeepgowda15/java-jenkins-docker-cicd

## Author

Sandeep Gowda

DevOps technologies demonstrated: AWS, Jenkins, Git, GitHub, Maven, Java,
Docker, Linux, and CI/CD automation.
