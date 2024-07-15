# Supervisor Management Notification Backend

## Description

This is the backend microservice for the Supervisor Management Notification module. It provides endpoints to get a list of supervisors and submit notification requests.

## Endpoints

- `GET /api/supervisors`: Returns a list of supervisors.
- `POST /api/submit`: Submits a notification request.

## How to Run

1. Build the Docker image:
   ```bash
   docker build -t supervisor-backend .
