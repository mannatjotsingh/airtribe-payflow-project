# PayFlow API

PayFlow is a simplified digital payment backend built using Spring Boot.

The application allows:

- Registering users
- Viewing users
- Searching users by UPI ID
- Recording money transfers

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
## Project Structure

src/main/java/com/airtribe/payflow

├── controller

│ ├── UserController

│ └── TransactionController

├── service

│ ├── UserService

│ └── TransactionService

├── repository

│ ├── UserRepository

│ └── TransactionRepository

├── entity

│ ├── User

│ └── Transaction

└── PayflowApplication

---
## Layers

### Controller Layer
Handles HTTP requests and responses.

With @RequestBody

@PostMapping
public User registerUser(@RequestBody User user)

Spring converts JSON into a Java object.

Input:

{
  "name":"Priya",
  "upiId":"priya@okaxis"
}

Result:

user.getName() -> "Priya"
user.getUpiId() -> "priya@okaxis"

Without @RequestBody

@PostMapping
public User registerUser(User user)

Same JSON request:

{
  "name":"Priya",
  "upiId":"priya@okaxis"
}

Result:

user.getName() -> null
user.getUpiId() -> null

because Spring does not know it should deserialize the request body into the User object.
![alt text](image.png)

![alt text](image-2.png)
### Service Layer
Contains business logic.

Examples:

- Register user
- Find user by UPI
- Record transaction

Acts as an intermediary between controllers and repositories.

---

### Repository Layer
Interacts with the database using Spring Data JPA.
Responsible for database access.

Examples:

- UserRepository
- TransactionRepository

Uses:

- JpaRepository

Provides CRUD operations automatically.

User findByUpiId(String upiId);.

Spring Data JPA analyzes the method name and automatically generates the required query.

Generated SQL (similar):

select *
from user
where upi_id = ?

Query Approaches in Spring Data JPA

# Derived Query Method

Example:

User findByUpiId(String upiId);

Spring automatically generates the query from the method name.

Advantages:

-Very simple

-No SQL required

-Easy to read

# JPQL Query

Example:

@Query("SELECT u FROM User u WHERE u.balance > ?1")

List<User> findUsersWithBalanceGreaterThan(Double amount);

Advantages:

-More flexible

-Uses entity names and fields

-Database independent

# Native SQL Query

Example:
@Query(
 value =
 "SELECT * FROM user WHERE balance > ?",
 nativeQuery = true
)

Advantages:

Full SQL power

Disadvantages:

-Database specific

-Less portable

-Harder to maint
### Entity Layer
Represents database tables.

Examples:

- User
- Transaction

Uses JPA annotations:

- @Entity
- @Id
- @GeneratedValue

---


## Spring Boot Features Used

### 1. Embedded Server

Spring Boot automatically starts an embedded Tomcat server.

No separate server installation is required.

Application runs directly using:

mvn spring-boot:run

---

### 2. Auto Configuration

Spring Boot automatically configures:

- H2 Database
- Spring MVC
- Spring Data JPA

based on dependencies present in pom.xml.

No manual XML configuration is required.

---

### 3. Production Ready Defaults

Spring Boot provides:

- Dependency Injection
- Embedded Logging
- Auto Component Scanning
- Health Monitoring Support

out of the box.

---

## Running the Application


### Build

mvn clean install

### Run

mvn spring-boot:run

Application starts at:

http://localhost:8080

---
## H2 Console

Open:

http://localhost:8080/h2-console

---
## REST Endpoints

### Create User

POST /users

### Get All Users

GET /users

### Get User By ID

GET /users/{id}

### Get User By UPI

GET /users/upi/{upiId}

### Users Above Balance

GET /users/balance/{amount}

### Send Money

POST /transactions

---
