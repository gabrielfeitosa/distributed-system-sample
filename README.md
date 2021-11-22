# Distributed System Sample
[![Distributed Systems - User Service](https://github.com/gabrielfeitosa/distributed-system-sample/actions/workflows/user-service.yml/badge.svg)](https://github.com/gabrielfeitosa/distributed-system-sample/actions/workflows/user-service.yml)
[![Distributed Systems - Document Service](https://github.com/gabrielfeitosa/distributed-system-sample/actions/workflows/document-service.yml/badge.svg)](https://github.com/gabrielfeitosa/distributed-system-sample/actions/workflows/document-service.yml)
## Architecture

![architecture](architecture.png)

## TODOS

### User Service

- [x] Start user service with Java using Spring Boot
- [x] Develop POST user API
- [x] Config Wiremock to simulate document endpoint
- [x] Config LocalStack to simulate AWS SNS
- [x] Send event to SNS
- [x] Github Actions
- [x] SonarQube

### Document Service

- [x] Start document service with Golang
- [x] Develop GET Document API
- [x] Github Actions
- [x] SonarQube

### Event Service

- [x] Start event service with NodeJS
- [x] Config LocalStack to simulate AWS SQS
- [x] Consuming event from SQS
- [x] Github Actions
- [x] SonarQube
