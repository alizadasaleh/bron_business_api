# Bron Business API

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/alizadasaleh/bron_business_api/actions)
[![License](https://img.shields.io/badge/license-Proprietary-lightgrey.svg)](LICENSE)

A backend service for managing beauty business appointments, staff, services, schedules, and related company data. This Spring Boot (Gradle) application provides REST APIs, authentication (JWT + OAuth2), mail notifications, S3 file storage integration, and full-text search indexing (Hibernate Search with Lucene).

## Project overview

- **Name:** Bron API
- **Type:** Java Spring Boot (Gradle)
- **Purpose :** Provide a backend API for appointment booking and business management (companies, staff, services, schedules, slots). Designed to power web and mobile frontends for businesses to manage services, staff availability, and booking flows.

## What the project does

- Exposes REST endpoints for managing appointments, companies, services, staff, schedules, and users.
- Supports OAuth2 social login (Google) and JWT-based authentication for API clients.
- Persists data in PostgreSQL using Spring Data JPA and MyBatis for some persistence layers.
- Sends emails using Spring Mail (configured for SMTP).
- Stores files to S3-compatible storage via AWS SDK (configurable bucket).
- Provides full-text search using Hibernate Search with Lucene backend.
- Builds a runnable fat JAR with Spring Boot and supports Docker-based deployments.

## Key features & benefits

- Modular domain structure (appointment, staff, company, service, schedule, slots, user).
- Secure authentication and authorization (OAuth2 + JWT).
- Email notifications and S3 file uploads out-of-the-box.
- Local-friendly configuration `application-local.yaml` for easy bootstrapping.
- OpenAPI UI (via springdoc) for interactive API exploration and testing.

## Tech stack

- Java + Spring Boot (3.2.x)
- Gradle (wrapper included)
- PostgreSQL
- Hibernate / JPA, MyBatis (selected modules)
- Hibernate Search (Lucene backend)
- AWS S3 SDK
- Spring Security + OAuth2 + JSON Web Tokens (jjwt)
- SpringDoc OpenAPI

## Getting started (developer quick-start)


Run with Docker Compose

The repository includes `docker-compose.yml` and `Dockerfile`. You can run the database and service via Docker Compose, but ensure environment variables are configured.

```bash
# start database and service (edit docker-compose.yml to suit env vars)
docker compose up
```

Environment variables

The main `application.yaml` references environment variables for production configuration. Important variables include (non-exhaustive):

- `POSTGRES_URL` - JDBC URL for the PostgreSQL instance
- `POSTGRES_USERNAME` - DB username
- `POSTGRES_PASSWORDS` - DB password (note: this key appears in `application.yaml`) 
- `GOOGLE_CLIENT_ID`, `GOOGLE_CLIENT_SECRET` - for OAuth2 Google login
- `GMAIL_SMTP_USERNAME`, `GMAIL_SMTP_PASSWORD` - for SMTP mail
- `AWS_ACCESS_KEY`, `AWS_SECRET_KEY`, `AWS_S3_BUCKET_NAME`, `AWS_S3_BUCKET_URL` - for S3
- `JWT_SECRET_KEY` - JWT signing secret
- `SERVER_PORT` - port to run the service on

For local development you can rely on `application-local.yaml` which contains example/mock values.

API docs / OpenAPI UI

When running the app, the interactive OpenAPI UI is available (springdoc). Visit:

- `http://localhost:8088/swagger-ui/index.html` (or replace port with `SERVER_PORT`)

Notes about database migrations

This project uses JPA `ddl-auto: update` in its configuration. For production deployments, prefer explicit migrations (Flyway, Liquibase) and review `application.yaml` settings.

Security & secrets

Do not commit secret keys, credentials, or production configuration to the repository. Use environment variables, secret stores, or `.env` files excluded via `.gitignore`.

----
