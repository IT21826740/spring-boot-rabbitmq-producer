# Spring Boot RabbitMQ Producer

This project is a **Spring Boot** application that acts as a **RabbitMQ producer**. It demonstrates how to send messages to a RabbitMQ queue using **Spring AMQP (Advanced Message Queuing Protocol)**.

## 📌 Table of Contents
- [Introduction to RabbitMQ](#introduction-to-rabbitmq)
- [RabbitMQ Usage](#rabbitmq-usage)
- [RabbitMQ Producer vs Consumer](#rabbitmq-producer-vs-consumer)
- [Project Setup](#project-setup)
- [How It Works](#how-it-works)
- [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Technologies Used](#technologies-used)
  
---

## 🐇 Introduction to RabbitMQ

**RabbitMQ** is a **message broker** that enables applications to communicate asynchronously using a queue-based system. It allows different parts of an application (or different applications entirely) to send and receive messages without being directly connected.

RabbitMQ follows the **publisher-subscriber model** and supports multiple messaging patterns, including **point-to-point**, **fan-out**, and **topic-based** messaging.

---

## 📌 RabbitMQ Usage

RabbitMQ is widely used for:
- **Decoupling microservices**: It allows different services to communicate without being tightly integrated.
- **Event-driven architecture**: It enables event-based communication between components.
- **Load balancing**: Messages can be distributed among multiple consumers to handle large loads.
- **Asynchronous processing**: Background tasks like email notifications, report generation, or logging can be handled asynchronously.

---

## 🔄 RabbitMQ Producer vs Consumer

| Feature      | Producer | Consumer |
|-------------|----------|----------|
| **Role**     | Sends messages to a queue | Retrieves and processes messages from the queue |
| **Trigger**  | Invoked by an event or application logic | Listens for new messages from RabbitMQ |
| **Responsibility** | Generates and formats messages | Processes received messages |
| **Example Use Case** | A payment service sending transaction data | A notification service sending an email confirmation |

---

```bash
   https://github.com/IT21826740/spring-boot-rabbitmq-consumer.git
   ```

## 🚀 Project Setup

### Prerequisites:
- **Java 17+**
- **Spring Boot**
- **RabbitMQ installed** (or use [Docker](https://www.rabbitmq.com/download.html))

### Steps to Run:

1. Clone the repository:
   ```bash
   git clone https://github.com/IT21826740/spring-boot-rabbitmq-producer.git
   cd spring-boot-rabbitmq-producer
   ```

2. Install dependencies and build the project:
   ```bash
   mvn clean install
   ```

3. Start RabbitMQ (if using Docker):
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```
   - **RabbitMQ Management UI**: `http://localhost:15672/`
   - **Default login**: `guest / guest`

4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

---

## ⚙️ How It Works

1. The **Producer** sends a message to a specific RabbitMQ queue.
2. RabbitMQ stores the message until a **Consumer** retrieves it.
3. The **Consumer** listens for new messages and processes them asynchronously.

---

## 🛠 Configuration

### `application.properties`
```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
spring.rabbitmq.template.exchange=my-exchange
spring.rabbitmq.template.routing-key=my-routing-key
```

---

## 📡 Endpoints

- **Send a message to RabbitMQ**
  ```http
  POST /send?message=HelloRabbitMQ
  ```

- **Expected Response**
  ```json
  {
    "message": "Message sent successfully"
  }
  ```

---

## 🛠 Technologies Used

- **Spring Boot**
- **Spring AMQP**
- **RabbitMQ**
- **Maven**
- **Docker (Optional for running RabbitMQ)**

---
