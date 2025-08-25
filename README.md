# Spring Cloud Gateway Token Relay Mechanism Example


## Overview

The repository contains two Gradle projects that illustrate how authenticated sessions from the Keycloak broker are converted into Bearer tokens for downstream microservices:

- **b2b-edge-service** - Spring Cloud Gateway with OAuth2 client and Redis session storage
- **b2b-downstream-service** - Sample microservice configured as OAuth2 Resource Server with token inspection endpoints

## Purpose

This is a demonstration setup showing:
- Token relay from session-based authentication to Bearer tokens
- Redis session management for scalable authentication
- OAuth2 Resource Server integration with federated identity

## Quick Start

### Prerequisites
- Java 17+
- Docker and Docker Compose
- Running Keycloak broker

### Running the Services

1. **Clone the repository**
```bash
git clone <repository-url>
cd b2b-gateway-integration
```

2. **Start Redis**
```bash
docker-compose up -d redis
```

3. **Start the Gateway**
```bash
cd b2b-edge-service
./gradlew bootRun
```

4. **Start the Downstream Service**
```bash
cd b2b-downstream-service
./gradlew bootRun
```

### Test Endpoints

- **Gateway**: http://localhost:9000
- **Downstream Service via Gateway**: http://localhost:9000/api/v1/token/decode

## Configuration

The gateway is pre-configured to work with the Keycloak broker setup. Ensure the broker is running on `http://localhost:8080` before starting the gateway.

---

**Note**: This is a demonstration setup. For production use, refer to the main article for comprehensive configuration and security considerations.