# Event Management API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

This **Spring Boot API** allows you to create and manage events, subscribe users to events, and generate rankings based on user subscriptions and referrals.

---

## Features

- **Event Management**:
  - Create, read, and manage events.
  - Each event has a unique `prettyName` for easy identification.
- **Subscription Management**:
  - Users can subscribe to events.
  - Users can indicate other users during subscription.
- **Ranking System**:
  - Generate rankings for events based on user subscriptions.
  - Get rankings for specific users.

---

## Technologies

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL Database** (or any relational database of your choice)
- **Maven** (for dependency management)

---

## API Endpoints

### ![Event Controller](https://img.shields.io/badge/Event_Controller-0078D4?style=for-the-badge&logo=java&logoColor=white)

#### Create a New Event
- **Endpoint**: `POST /events`
- **Description**: Creates a new event.
- **Request Body**:
  ```json
  {
    "title": "Spring Boot Workshop",
    "location": "Online",
    "price": 0.0,
    "startDate": "2023-12-01",
    "endDate": "2023-12-02",
    "startTime": "10:00:00",
    "endTime": "18:00:00"
  }
  ```



  Response:

```json
{
  "eventId": 1,
  "title": "Spring Boot Workshop",
  "prettyName": "spring-boot-workshop",
  "location": "Online",
  "price": 0.0,
  "startDate": "2023-12-01",
  "endDate": "2023-12-02",
  "startTime": "10:00:00",
  "endTime": "18:00:00"
}

```
---

Get All Events
Endpoint: GET /events

Description: Retrieves all events.

Response:

```json
[
  {
    "eventId": 1,
    "title": "Spring Boot Workshop",
    "prettyName": "spring-boot-workshop",
    "location": "Online",
    "price": 0.0,
    "startDate": "2023-12-01",
    "endDate": "2023-12-02",
    "startTime": "10:00:00",
    "endTime": "18:00:00"
  }
]

```
---

Get Event by prettyName
Endpoint: GET /events/{prettyName}

Description: Retrieves an event by its prettyName.

Response:

```json
{
  "eventId": 1,
  "title": "Spring Boot Workshop",
  "prettyName": "spring-boot-workshop",
  "location": "Online",
  "price": 0.0,
  "startDate": "2023-12-01",
  "endDate": "2023-12-02",
  "startTime": "10:00:00",
  "endTime": "18:00:00"
}

```
---

Subscription Controller
Subscribe to an Event
Endpoint: POST /subscription/{prettyName}

Description: Subscribes a user to an event.

Request Body:

```json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}

```
Response:

```json

{
  "subscriptionNumber": 1,
  "designation": "http://codecraft.com/subscription/spring-boot-workshop/1"
}
```
---

Get Top 3 Rankings for an Event
Endpoint: GET /subscription/{prettyName}/ranking

Description: Retrieves the top 3 rankings for an event.

Response:

```json
[
  {
    "subscribers": 5,
    "userId": 1,
    "name": "John Doe"
  },
  {
    "subscribers": 3,
    "userId": 2,
    "name": "Jane Smith"
  }
]

```

---

Get Ranking for a Specific User
Endpoint: GET /subscription/{prettyName}/ranking/{userId}

Description: Retrieves the ranking for a specific user.

Response:

```json
{
  "item": {
    "subscribers": 5,
    "userId": 1,
    "name": "John Doe"
  },
  "position": 1
}
```
---
## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.x

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Zenx007/API-Events.git
   cd **directory**
