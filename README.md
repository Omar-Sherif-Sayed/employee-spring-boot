# employee-spring-boot
Employee Spring Boot Project

# Interview Question to make this project

Build employees managment system.

The employees on this system are assigned to different states, Initially when an employee is added it will be assigned "ADDED" state automatically .


The other states (State machine) for A given Employee are:
- ADDED
- IN-CHECK
- APPROVED
- ACTIVE


Our backend stack is:
- Java 11 
- Spring Framework 
- Kafka

Your task is to build  Restful API doing the following:
- An Endpoint to support adding an employee with very basic employee details including (name, contract information, age, you can decide.) With initial state "ADDED" which incidates that the employee isn't active yet.

- Another endpoint to change the state of a given employee to "In-CHECK" or any of the states defined above in the state machine 


Please provide a solution with the  above features with the following consideration.

- Being simply executable with the least effort Ideally using Docker and docker-compose or any smailiar approach.
- For state machine could be as simple as of using ENUM or by using https://projects.spring.io/spring-statemachine/ 
- Please provide testing for your solution.
- Providing an API Contract e.g. OPENAPI spec. is a big plus

# To run this project you need to install docker
Go to docker documentation

# Download My mysqlda3 docker image
docker pull omarsherifsayed/mysqldb3:latest <br>
from https://hub.docker.com/repository/docker/omarsherifsayed/mysqldb3

# Download My employee-spring-boot image
docker push omarsherifsayed/employee-spring-boot:latest <br>
from https://hub.docker.com/repository/docker/omarsherifsayed/employee-spring-boot

# Run mysqlda3 as a container
docker run -d -p 3306:3306 --name=mysqldb3 --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=admin" -v /home/username/docker/mysql:/var/lib/mysql omarsherifsayed/mysqldb3

# Run employee-spring-boot as a container
docker run -t --link mysqldb3:mysqldb3 -p 8070:8070 employee-spring-boot

# Application on Swagger UI 
http://localhost:8070/employee/swagger-ui/

# Application has one controller with 2 End points
http://localhost:8070/employee/employee/add <br >
http://localhost:8070/employee/employee/update-state-machine
