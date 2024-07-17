# Supervisor Management Notification

## Description
This project is a Supervisor Management Notification Module that coordinates the supervisors currently working at the company and the jurisdictions they cover. Employees can submit their contact information for a specific supervisor to be notified of any announcements the supervisor has made. The project includes a backend microservice and a frontend UI.

## Features

- REST API for managing supervisors and notifications
- Frontend UI for submitting contact information and viewing notifications
- Dockerized for easy deployment

## Prerequisites

- Node.js installed on your machine
- Docker and Docker Compose installed on your machine
- Maven and Maven Wrapper
- Git installed on your machine

## Installation

**Ensure Docker is running:**

Make sure Docker is installed and running on your machine. You can download Docker from [here](https://www.docker.com/get-started).

## Setup

1. Clone the repository:

    ```bash
    git clone <repository-url>
    cd SupervisorManagementNotificationModule
    ```
## Without Docker

### Backend

2. Build the backend
    `./mvnw clean install`

3. Start the backend
    `./mvnw spring-boot:run`

### Frontend
4. Install Dependencies
    `npm install`

5. Start application
    `npm start`

6. Access the backend API:

    The backend API is available at `http://localhost:4000/api/supervisors`.

7. Access the frontend:

    Open your browser and navigate to `http://localhost:3000`.

## With Docker

2. Build and run the Docker containers:

    ```bash
    docker-compose up --build
    ```

3. Access the frontend:

    Open your browser and navigate to `http://localhost:3000`.

4. Access the backend API:

    The backend API is available at `http://localhost:4000`.

## Endpoints

### Backend

- `GET /api/supervisors`: Returns a JSON array of all supervisors.
- `POST /api/submit`: Accepts a request for a new notification request for a supervisor.

### Frontend

- The frontend provides a form to submit supervisor notifications and displays error messages for any invalid requests.

## Notes

- Ensure Node.js version >= 18 is used.
- Follow the instructions carefully to avoid any issues during setup.
