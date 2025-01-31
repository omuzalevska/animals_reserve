# Wildlife Reserve Management API

## Project Description:
This project involves the creation of an API for the management and maintenance of a wildlife reserve. The API allows administrators to manage information about the animals in the reserve, with authentication and authorization features. The system supports Basic Auth.

## Technical Requirements
- Built with **Java** and **Spring Boot**.
- Data stored in either an in-memory database (**H2**).
- Implements Object-Oriented Programming (OOP) principles:
  - Encapsulation
  - Layered architecture (controllers, services, repositories).
- Includes **DTOs** for data transfer.
- Unit tests for models, services, and controllers.

## Getting Started
### Prerequisites
- Java 21 or higher
- Maven

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/omuzalevska/animals_reserve.git
   cd reservanatural```

### Class diagram
![diagram](/src/main/java/dev/muzalevska/reservanatural/images/diagClasses.png)

### Endpoint List

#### countries
GET http://localhost:8080/api/countries To get list with all countries
GET http://localhost:8080/api/countries/{id} To get country by ID
POST http://localhost:8080/api/countries To add new country
PUT http://localhost:8080/api/countries{id} To update country data
DELETE http://localhost:8080/api/countries{id} To delete country

#### families
GET http://localhost:8080/api/families To get list with all families
GET http://localhost:8080/api/families/{id} To get family by ID
POST http://localhost:8080/api/families To add new family
PUT http://localhost:8080/api/families{id} To update family data
DELETE http://localhost:8080/api/families{id} To delete family

#### types
GET http://localhost:8080/api/tupes To get list with all tupes
GET http://localhost:8080/api/tupes/{id} To get tupe by ID
POST http://localhost:8080/api/tupes To add new tupe
PUT http://localhost:8080/api/tupes/{id} To update tupe 
DELETE http://localhost:8080/api/tupes/{id} To delete tupe

#### animals

#### Public API Requests:
GET http://localhost:8080/api/animals/paged?page=0&size=20
    To get a list of all animals in the reserve with pagination (maximum 20 animals). 
GET http://localhost:8080/api/animals/family/1/paged?page=0&size=10
    To get a list of animals by family with pagination (maximum 10 animals). 
GET http://localhost:8080/api/animals/country/{id}
    To get a list of animals by country of origin without pagination.
GET http://localhost:8080/api/animals/family/1/type/3
    To get a list of animals by family and type.
    
#### Private API Requests:
GET http://localhost:8080/api/animals To get list with all animals
GET http://localhost:8080/api/animals/{id} To get animal by ID
POST http://localhost:8080/api/animals To add new animal
PUT http://localhost:8080/api/animals {id} To update animal data
DELETE http://localhost:8080/api/animals/{id} To delete animal

### Author
Oksana Muzalevska
[![GitHub](https://img.shields.io/badge/-GitHub-333?style=for-the-badge&logo=GitHub&logoColor=fff)](https://github.com/omuzalevska)