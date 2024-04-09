
## Project Description :memo:
This repository contains a RESTful API for managing employee, department, project, and job information within a Human Resources (HR) system. The API is designed to handle CRUD (Create, Read, Update, Delete) operations for the following entities: Employee, Department, Project, and Job.

## End points 🚀
- ✨Employee
  - `GET /employees`: Retrieve a list of all employees (with posibility to use pagination by providing offset and limit).
  - `GET /employees/{id}`: Retrieve details of a specific employee by ID.
  - `POST /employees`: Create a new employee.
  - `PUT /employees/{id}`: Update details of an existing employee.
  - `DELETE /employees/{id}`: Delete an employee by ID.
- ✨Departments
  - `GET /departments`: Retrieve a list of all departments (with posibility to use pagination by providing offset and limit).
  - `GET /departments/{id}`: Retrieve details of a specific department by ID.
  - `POST /departments`: Create a new department.
  - `PUT /departments/{id}`: Update details of an existing department.
  - `DELETE /departments/{id}`: Delete a department by ID.
- ✨Projects
  - `GET /projects`: Retrieve a list of all projects (with posibility to use pagination by providing offset and limit).
  - `GET /projects/{id}`: Retrieve details of a specific project by ID.
  - `POST /projects`: Create a new project.
  - `DELETE /projects/{id}`: Delete a project by ID.
- ✨Jobs
  - `GET /jobs`: Retrieve a list of all job positions (with posibility to use pagination by providing offset and limit).
  - `GET /jobs/{id}`: Retrieve details of a specific job position by ID.
  - `POST /jobs`: Create a new job position.
  - `PUT /jobs/{id}`: Update details of an existing job position.
  - `DELETE /jobs/{id}`: Delete a job position by ID.
  - `GET /jobs/search`: Search for job positions based on specific criteria.

## API Documentation 📖
https://documenter.getpostman.com/view/10820115/2sA3BgAFU9


## Technologies Used 🛠️
![Java JDK](https://img.shields.io/badge/Java%20JDK-17-orange?style=for-the-badge&logo=java)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-9-blueviolet?style=for-the-badge&logo=eclipse&logoColor=white)
![JPA Hibernate](https://img.shields.io/badge/JPA%20Hibernate-blue?style=for-the-badge&logo=hibernate)
![Hikari CP](https://img.shields.io/badge/Hikari%20CP-blue?style=for-the-badge&logo=java&logoColor=white)
![Mapstruct](https://img.shields.io/badge/Mapstruct-blueviolet?style=for-the-badge&logo=java&logoColor=white)
![JSON](https://img.shields.io/badge/JSON-orange?style=for-the-badge&logo=json)
![Maven](https://img.shields.io/badge/Maven-orange?style=for-the-badge&logo=apache)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10-blue?style=for-the-badge&logo=apache)
![MySQL](https://img.shields.io/badge/MySQL-grey?style=for-the-badge&logo=mysql)
![Postman](https://img.shields.io/badge/Postman-orange?style=for-the-badge&logo=postman)
![JAX-RS](https://img.shields.io/badge/JAX--RS-red?style=for-the-badge&logo=eclipse)
![JUnit](https://img.shields.io/badge/JUnit-green?style=for-the-badge&logo=junit)


## Database Diagram
![HR](https://github.com/Omar-Ashraf9/REST-API/assets/44038598/1d026677-103a-458f-b510-bb4c2bef2ac9)


## Installation and Setup
1. Clone this repository to your local machine.
2. Set up a servlet container (e.g., Apache Tomcat).
3. Generate the WAR file to your servlet container.
4. Configure the database by running the provided schema.
5. Access the end points using postman.

