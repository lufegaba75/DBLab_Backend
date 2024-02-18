# DBLab
Backend project for a Laboratory Sample Management Software.
***
## Contents:

1. About this version
2. How to run
3. Technologies
4. Other tools
5. Features
6. About the Database
7. Roles & Permissions
8. 

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
* JWT Authorization
  
***
## Other tools:

* Github
* IntelliJ Idea
* dbDiagram.io
* pg_dump

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
![SampleType-Template-Regulation](https://github.com/lufegaba75/DBLab/assets/57178698/64a28602-ef98-4bce-8f03-786673a30493)

* For each SampleType you can define one or more templates.
* Parameters stores the different parameters to analyze on the samples
* Some parameters (microbiologic ones) belongs to a specie stored on table Species.
* For each Parameter can be one or more techniques to apply
* Each Technique can belong to more than one Template and each template has one or more techniques.
* Regulations refers to Norms, Standards, Laws or other Regulations.
* Each Regulation has different criteria for each sampletype
* For each Technique (Parameter of a sampletype) can be a Criteria based on Regulations.

### From Samples to Ordering analysis and Results
![Samples, Ordering  Analysis And Results](https://github.com/lufegaba75/DBLab/assets/57178698/7d95d51c-5ac3-4938-8df3-d8fe1636bd7c)

* An Analysis Template is an implementation of a template for a specific kind of sample or a specific client.
* Each Analysis Template has one or more Analysis template techniques (implementation of Template techniques with dilutions, units and quantities)
* Analysis Order assigns an Analysis Template to a sample and takes specific techniques for the Analysis Order Details.
* Each sample has one or more Results and each Result has each details for each parameter analyzed.

***
## Roles and Permissions
