

# Bron Business API

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/alizadasaleh/bron_business_api/actions)
[![License](https://img.shields.io/badge/license-Proprietary-lightgrey.svg)](LICENSE)

Un servicio backend para la gestión de citas, personal, servicios, horarios y datos relacionados de la empresa de belleza. Esta aplicación Spring Boot (Gradle) proporciona APIs REST, autenticación (JWT + OAuth2), notificaciones por correo, integración con almacenamiento de archivos S3 e indexación de búsqueda de texto completo (Hibernate Search con Lucene).

## Resumen del proyecto

- **Nombre:** Bron API
- **Tipo:** Java Spring Boot (Gradle)
- **Propósito :** Proporcionar una API backend para la reserva de citas y la gestión empresarial (empresas, personal, servicios, horarios, franjas horarias). Diseñada para impulsar las interfaces web y móviles que permiten a las empresas gestionar servicios, disponibilidad del personal y flujos de reserva.

## Funcionalidades del proyecto

- Expones endpoints REST para la gestión de citas, empresas, servicios, personal, horarios y usuarios.
- Admite inicio de sesión social con OAuth2 (Google) y autenticación basada en JWT para clientes de API.
- Persiste datos en PostgreSQL utilizando Spring Data JPA y MyBatis para algunas capas de persistencia.
- Envía correos electrónicos usando Spring Mail (configurado para SMTP).
- Almacena archivos en almacenamiento compatible con S3 mediante el SDK de AWS (bucket configurable).
- Proporciona búsqueda de texto completo usando Hibernate Search con backend Lucene.
- Genera un JAR ejecutable (fat JAR) con Spring Boot y admite implementaciones basadas en Docker.

## Características clave y ventajas

- Estructura de dominio modular (citas, personal, empresa, servicio, horarios, franjas horarias, usuario).
- Autenticación y autorización seguras (OAuth2 + JWT).
- Notificaciones por correo y carga de archivos a S3 disponibles por defecto.
- Configuración optimizada para entornos locales `application-local.yaml` para un arranque sencillo.
- Interfaz de OpenAPI (vía springdoc) para explorar y probar la API de forma interactiva.

## Stack tecnológico

- Java + Spring Boot (3.2.x)
- Gradle (wrapper incluido)
- PostgreSQL
- Hibernate / JPA, MyBatis (módulos seleccionados)
- Hibernate Search (backend Lucene)
- SDK de AWS S3
- Spring Security + OAuth2 + JSON Web Tokens (jjwt)
- SpringDoc OpenAPI

## Primeros pasos (inicio rápido para desarrolladores)


Ejecutar con Docker Compose

El repositorio incluye `docker-compose.yml` y `Dockerfile`. Puedes ejecutar la base de datos y el servicio mediante Docker Compose, pero asegúrate de que las variables de entorno estén configuradas.

```bash
# iniciar base de datos y servicio (edita docker-compose.yml para adaptarlo a las variables de entorno)
docker compose up
```

Variables de entorno

El archivo principal `application.yaml` hace referencia a variables de entorno para la configuración de producción. Las variables importantes incluyen (lista no exhaustiva):

- `POSTGRES_URL` - URL JDBC para la instancia de PostgreSQL
- `POSTGRES_USERNAME` - Nombre de usuario de la base de datos
- `POSTGRES_PASSWORDS` - Contraseña de la base de datos (nota: esta clave aparece en `application.yaml`) 
- `GOOGLE_CLIENT_ID`, `GOOGLE_CLIENT_SECRET` - para inicio de sesión con OAuth2 de Google
- `GMAIL_SMTP_USERNAME`, `GMAIL_SMTP_PASSWORD` - para correo SMTP
- `AWS_ACCESS_KEY`, `AWS_SECRET_KEY`, `AWS_S3_BUCKET_NAME`, `AWS_S3_BUCKET_URL` - para S3
- `JWT_SECRET_KEY` - Clave secreta para firmar JWT
- `SERVER_PORT` - Puerto en el que se ejecutará el servicio

Para desarrollo local puedes confiar en `application-local.yaml`, que contiene valores de ejemplo/mock.

Documentación de la API / Interfaz de OpenAPI

Al ejecutar la aplicación, la interfaz interactiva de OpenAPI está disponible (springdoc). Visita:

- `http://localhost:8088/swagger-ui/index.html` (o reemplaza el puerto con `SERVER_PORT`)

Notas sobre migraciones de base de datos

Este proyecto utiliza `ddl-auto: update` de JPA en su configuración. Para implementaciones en producción, se recomienda utilizar migraciones explícitas (Flyway, Liquibase) y revisar la configuración de `application.yaml`.

Seguridad y secretos

No comprometas (commit) claves secretas, credenciales ni configuraciones de producción en el repositorio. Utiliza variables de entorno, almacenes de secretos o archivos `.env` excluidos mediante `.gitignore`.

----
