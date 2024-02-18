# DBLab
Backend project for a Laboratory Sample Management Software.
***
## Contents:

1. About this version
2. How to run
3. Technologies
4. Features
5. 

***
## About this version

(Early access project)
v1 - Application endpoints, Persistence (schema.sql & data.sql still needed) implemented, Security implemented.
***
## How to run?



***
## Technologies:

* Java 17,
* Spring Framework 6
* Spring Boot 3
* PostgreSQL
  
***
## Features:

- Users Management (Register, Login, Roles Assignement & Authorizations)
- Clients, Addresses & Phones CRUD
- SampleTypes, Samplings & Samples CRUD
- Analysis Templates, Techniques, Regulation Criteria, Parameters... CRUD
- Analysis Orders & Templates to apply CRUD
- Regulation Templates & Criteria CRUD
- Analysis Results CRUD

***
## About the Database:

### From client to sample
![Client-Sample](https://github.com/lufegaba75/DBLab/assets/57178698/41be607e-9752-4198-807c-f616c1be94a2)

* Address, Phone & Cliente stores the Client data
* DatalabUser stores the users data
* Each client ownes at least one User with "Client" privileges. (not implemented)
* Each worker ownes a User with "Worker" or "Admmin" privileges. (not implemented)
* A worker collects one or more samples from the Client in a single Sampling
* This samples belongs to a Sample Type.  

### From SampleType to Template and Regulation

