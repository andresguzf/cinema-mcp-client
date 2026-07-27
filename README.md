# 🎬 Cinema MCP Client (`7-cinema-mcp-client`)

Aplicación **Cliente MCP (Model Context Protocol)** desarrollada con **Spring Boot** e integrada con **Spring AI MCP Client Starter** (`spring-ai-starter-mcp-client`), diseñada para interactuar y consumir las herramientas expuestas por el servidor `cinema-mcp-server`.

---

## 📌 Descripción del Proyecto

Este cliente se conecta al servidor de cine MCP para consumir herramientas como:
- `getMovies`: Consulta de todas las películas en cartelera.
- `getMovieSchedule`: Consulta de los horarios de funciones por película.
- `getMovieAudience`: Consulta de la clasificación y público recomendado por película.

---

## 🛠️ Tecnologías y Dependencias

- **Java:** 25
- **Spring Boot:** 4.1.0
- **Spring AI:** 2.0.0 (`spring-ai-starter-mcp-client`, `spring-ai-starter-model-ollama`)
- **Modelo LLM Chat (Ollama):** `qwen3:4b`
- **Gestor de dependencias:** Maven (`mvnw`)

---

## ⚙️ Configuración (`application.properties`)

```properties
spring.application.name=7-cinema-mcp-client
server.port=8080

# Spring AI Ollama Configuration
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.model=qwen3:4b

# Spring AI MCP Client Configuration
spring.ai.mcp.client.enabled=true
spring.ai.mcp.client.initialized=true
spring.ai.mcp.client.request-timeout=60s

# Connection to Cinema MCP Server (STREAMABLE protocol)
spring.ai.mcp.client.streamable-http.connections.cinema-mcp-server.url=http://localhost:8081
spring.ai.mcp.client.streamable-http.connections.cinema-mcp-server.endpoint=/mcp
```

---

## 🚀 Comandos de Construcción y Ejecución

### Compilar el Proyecto
```bash
./mvnw clean compile
```

### Ejecutar la Aplicación
```bash
./mvnw spring-boot:run
```
