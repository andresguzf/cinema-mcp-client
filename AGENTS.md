# AGENTS.md - Contexto y Guía del Proyecto (Cinema MCP Client)

Este documento proporciona una visión general técnica, la arquitectura y las pautas para agentes de IA y desarrolladores que trabajen en este proyecto cliente.

## 📌 Descripción y Contexto del Proyecto
`7-cinema-mcp-client` es una aplicación cliente Java construida con **Spring Boot** e integrada con **Spring AI MCP Client Starter** (`spring-ai-starter-mcp-client`) para interactuar con servidores MCP (como `cinema-mcp-server`) mediante el protocolo Model Context Protocol (MCP).

### 🎬 Dominio de Negocio (Cliente de Cartelera de Cine)
La aplicación cliente consume los servicios y herramientas del servidor de cine:
- **Consulta de Cartelera:** Consumo de la herramienta `getMovies` para obtener películas activas.
- **Consulta de Horarios:** Consumo de la herramienta `getMovieSchedule` por película.
- **Consulta de Clasificación:** Consumo de la herramienta `getMovieAudience` para obtener el público recomendado y calificación.

---

## 🛠️ Tecnologías y Dependencias
- **Java:** 25
- **Spring Boot:** 4.1.0
- **Spring AI:** 2.0.0 (`spring-ai-starter-mcp-client`)
- **Gestor de dependencias:** Maven (`mvnw`)

---

## 🎯 Skills Disponibles

El proyecto cuenta con las skills copiadas en `.agents/skills/`:

### 1. `spring-boot-best-practices`
- **Ubicación:** `.agents/skills/spring-boot-best-practices/SKILL.md`
- **Descripción:** Guía para la creación, refactorización y extensión de aplicaciones Spring Boot siguiendo arquitectura en capas limpia, mejores prácticas de desarrollo y estándares de Java moderno.
- **Trigger / Cuándo invocar:** Debe invocarse **SIEMPRE** que el usuario solicite crear una API de Spring Boot, un monolito Spring Web, o cuando se pida crear, agregar, refactorizar o modificar un `Entity` (model), `Repository`, `Service`, `Controller`, `DTO` o `Mapper`.

---

## 🏗️ Arquitectura y Estructura del Código

La aplicación sigue una arquitectura limpia de Spring Boot:

```
src/main/java/com/andres/course/agy/springboot/cinemamcpclient/app/
└── Application.java
```

---

## ⚙️ Configuración (`application.properties`)

```properties
spring.application.name=7-cinema-mcp-client
server.port=8080
```

---

## 🚀 Comandos de Construcción y Verificación

- **Compilar el proyecto:**
  ```bash
  ./mvnw clean compile
  ```
- **Ejecutar la aplicación:**
  ```bash
  ./mvnw spring-boot:run
  ```
