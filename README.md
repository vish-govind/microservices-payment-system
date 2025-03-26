# Microservices-based Payment System

This project is a microservices-based payment system implemented using Spring Boot. It includes the following microservices:

- **API Gateway**  
- **Eureka Server**  
- **User Service**  
- **Payment Service**  
- **Notification Service**

## Architecture Overview

The system is designed as a collection of microservices that communicate with each other via HTTP and Kafka. The core components of the system are as follows:

- **API Gateway** handles incoming requests and routes them to appropriate microservices.
- **Eureka Server** is used for service discovery.
- **User Service** manages user data and account details.
- **Payment Service** processes payments and checks account balances.
- **Notification Service** listens for payment events and sends notifications.

## Prerequisites

Before running the services, ensure you have the following installed and running:

- **Java 11 or higher**  
- **Apache Kafka** (running on `localhost:9092`)  
- **Eureka Server** (running on `localhost:8761`)

## Microservices Details

### 1. **API Gateway**

- **Description:**  
  The API Gateway routes incoming requests to the appropriate services (User Service and Payment Service).

- **API Routes:**
  - `/users/**`: Routes to User Service
  - `/payments/**`: Routes to Payment Service

- **Configuration:**
  - Server port: `8081`
  - Eureka Client: `http://localhost:8761/eureka/`

- **Run:**  
  ```bash
  mvn clean install
  mvn spring-boot:run

### 2. Eureka Server

- **Description:**  
  The Eureka Server provides service discovery for other microservices.

- **Configuration:**

  - **Server port:** `8761`
  - `registerWithEureka: false` (Eureka Server does not register itself with Eureka)
  - `fetchRegistry: false` (Eureka Server does not fetch the registry from other services)

- **Run:**

  ```bash
  mvn clean install
  mvn spring-boot:run

### 3. User Service

- **Description:**  
  The User Service manages user accounts, allowing for user creation, updating, and deletion.

- **API Endpoints:**

  - `POST /users`: Create a new user
  - `PUT /users/{accountNumber}`: Update an existing user
  - `DELETE /users/{accountNumber}`: Delete a user

- **Entities:**

  - **User:** Contains user details such as name, email, accountNumber, accountBalance, etc.
  - **AccountType:** Enum for `SAVINGS`, `CURRENT`, `FIXED_DEPOSIT`

- **Configuration:**

  - **Server port:** `8080`
  - **Eureka Client:** `http://localhost:8761/eureka/`

- **Run:**

  ```bash
  mvn clean install
  mvn spring-boot:run

### 4. Payment Service

- **Description:**  
  The Payment Service processes payments and checks the user’s balance by making requests to the User Service.

- **API Endpoints:**

  - `POST /payments`: Processes a payment request and checks the user’s balance.

- **Entities:**

  - **Payment:** Contains details of a payment such as amount, status, transactionId, etc.
  - **Status:** Enum for `SUCCESS`, `FAILED`, `PENDING`

- **Service Logic:**

  The payment is processed by first verifying the account balance and account status via the User Service. If valid, the payment is saved and a message is sent to Kafka.

- **Configuration:**

  - **Server port:** `8082`
  - **Eureka Client:** `http://localhost:8761/eureka/`
  - **Kafka Producer:** `localhost:9092`

- **Run:**

  ```bash
  mvn clean install
  mvn spring-boot:run

### 5. Notification Service

- **Description:**  
  The Notification Service listens for payment events on Kafka and handles the notifications (currently logs the message to the console).

- **Service Logic:**

  The service listens to the Kafka topic `payment-topic` and logs the received message.

- **Configuration:**

  - **Server port:** `8083`
  - **Kafka Consumer:** `localhost:9092`
  - **Eureka Client:** `http://localhost:8761/eureka/`

- **Run:**

  ```bash
  mvn clean install
  mvn spring-boot:run

### Running the System

1. **Start Eureka Server**  
   URL: `http://localhost:8761`

2. **Start API Gateway**  
   URL: `http://localhost:8081`

3. **Start User Service**  
   URL: `http://localhost:8080`

4. **Start Payment Service**  
   URL: `http://localhost:8082`

5. **Start Notification Service**  
   URL: `http://localhost:8083`

Once all services are running, you can use the API Gateway to interact with the system.

---

### Configuration

Each service has a `secrets.properties` file to handle sensitive data such as database credentials, Kafka configuration, etc.

Make sure to set up the correct `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` for each service in their respective `application.yml` files.

---

### Kafka Setup

- The Payment Service sends payment messages to Kafka topic `payment-topic`.
- The Notification Service listens for messages from the same Kafka topic.

---

### Additional Information

#### Kafka Topics:

- `payment-topic`: Used to send payment messages.

#### JPA Configuration:

Each service that interacts with a database (User Service and Payment Service) uses Spring Data JPA for database operations. Ensure you have the correct database credentials configured in `application.yml`.
