# 🏦 Banking Microservices System – Spring Boot & Kafka

A real-world **Spring Boot Microservices backend system** demonstrating industry-level implementation of **REST APIs, Apache Kafka (event-driven communication), Eureka Service Discovery**, DTO validation, and clean layered architecture.  
Built with strong focus on **backend fundamentals, system design, and production-ready patterns**, suitable for Java Backend Developer roles**.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-231F20?style=for-the-badge)
![Eureka](https://img.shields.io/badge/Eureka-Service%20Discovery-blue?style=for-the-badge)
![Postman](https://img.shields.io/badge/Tested%20With-Postman-orange?style=for-the-badge)

---

## 🚀 Tech Stack

- **Language & Frameworks:** Java 21, Spring Boot 3.x, Spring Web, Spring Data JPA  
- **Messaging & Microservices:** Apache Kafka, Eureka Server  
- **Database:** MySQL  
- **Build & Dependency Management:** Maven  
- **API Testing:** Postman

---

## 🧩 Architecture Overview

### Monolithic vs Microservices (Comparison)

| Monolithic Architecture | Microservices Architecture |
|-------------------------|----------------------------|
| Tightly coupled | Loosely coupled |
| Hard to scale | Independently scalable |
| Single deployment | Independent deployments |
| Single point of failure | Fault isolation |

📸 **Architecture Screenshots**

![Monolithic Architecture](./screenshots/10_monolithic_architecture.png)
![Microservices Architecture](./screenshots/11_microservices_architecture.png)

---

## 🏗️ System Architecture

### Services Implemented

| Service | Responsibility |
|-------|---------------|
| **User Service** | User CRUD & validation |
| **Account Service** | Kafka producer |
| **Statement Service** | Kafka consumer |
| **Transaction Service** | Transaction handling |
| **Eureka Server** | Service discovery |

📸 **Kafka-Based System Architecture**

![Kafka Architecture](./screenshots/13_kafka_architecture.png)

---

## 🔍 Service Discovery – Eureka Server

All microservices register with **Eureka Server** for dynamic discovery and load balancing.

📸 **Eureka Dashboard**

![Eureka Dashboard](./screenshots/12_Eureka_server_dashboard.png)

---

## 👤 User Service (REST APIs)

Manages **User CRUD operations** with DTO validation and global exception handling.

### Endpoints

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/api/users` | Create user |
| GET | `/api/users/{id}` | Get user by ID |
| PUT | `/api/users/{id}` | Update user |

📸 **User Service Screenshots**

![Create User](./screenshots/01_user_create_api.png)
![Get User](./screenshots/02_user_get_api.png)
![Update User](./screenshots/03_user_update_api.png)
![Validation Errors](./screenshots/04_user_validation_errors.png)

### Highlights
- DTO-based request/response  
- Validation using annotations  
- Global exception handling  
- Clean API responses  

---

## 🏦 Account Service (Kafka Producer)

Publishes **Kafka events** when account-related actions occur.

### Producer Flow
1. REST API receives request  
2. Event published to Kafka topic  
3. Consumer services process asynchronously  

📸 **Producer Logs & Response**

![Producer Log](./screenshots/05_account_producer_log.png)
![Producer Success](./screenshots/06_account_producer_success.png)

---

## 📄 Statement Service (Kafka Consumer)

Consumes Kafka events produced by Account Service.

📸 **Consumer Log**

![Consumer Log](./screenshots/07_statement_consumer_log.png)

### Demonstrates
- Event-driven architecture  
- Kafka consumer groups  
- Loose coupling between services  

---

## 💸 Transaction Service

Handles transaction creation and retrieval.

📸 **Transaction APIs**

![Create Transaction](./screenshots/08_transaction_create_api.png)
![Transaction Response](./screenshots/09_transaction_response_api.png)

---

## ⚙️ Kafka & Zookeeper Setup (Local)

This project uses **Apache Kafka** for asynchronous communication between microservices.  
Zookeeper is required to manage Kafka brokers.

---

### 1️⃣ Start Zookeeper

```bash
zookeeper-server-start.bat config/zookeeper.properties
```
📸 **Zookeeper**

![Zookeeper](./screenshots/01_Zookeeper_running.png)
![Zookeeper](./screenshots/02_Zookeeper_running.png)

---

### 1️⃣ Start Kafka Broker

```bash
kafka-server-start.bat config/server.properties
```
📸 **Kafka Broker**

![Kafka Broker](./screenshots/14_kafka_broker_running.png)

### ZooKeeper Info
- ZooKeeper starts automatically with Kafka (for older Kafka versions)  
- Modern Kafka versions support KRaft mode, which allows Kafka to run **without ZooKeeper**  
- Logs show successful startup and port binding:


---

### 1️⃣ Create Kafka Topic

```bash
kafka-topics.bat --create \
--topic account-statement-topic \
--bootstrap-server localhost:9092 \
--replication-factor 1 \
--partitions 1
```
📸 **Kafka Topic**

![Kafka Topic](./screenshots/16_kafka_topic_list.png)
---

## 👨‍💻 Author

**Sidharth Kumar**  

[![Email](https://img.shields.io/badge/Email-siddharth0161820@gmail.com-red?style=for-the-badge&logo=gmail)](mailto:siddharth0161820@gmail.com)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/siddharthkumar16)  
[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?style=for-the-badge&logo=github)](https://github.com/siddharth0161820)

🙏 Built with dedication during my career break to master backend development. Connect for collaboration, job opportunities, or tech discussions.



