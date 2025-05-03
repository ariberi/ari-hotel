
# Ari Hotel

**Ari Hotel** es una API RESTful desarrollada con Spring Boot que gestiona habitaciones, huéspedes y ocupación hotelera, incluyendo también una interfaz web basada en Thymeleaf.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Thymeleaf
- PostgreSQL (contenedor Docker)
- Bootstrap 5
- Sass (estructura modular)
- Peticiones HTTP
- Controladores REST (API RESTful)

## Características

- API RESTful para gestionar habitaciones (`Room`), huéspedes (`Guest`) y reservas (`Reservation`)
- Endpoints HTTP accesibles mediante controladores REST (`@RestController`)
- Interfaz web modular basada en Thymeleaf
- Selección de fecha para visualizar ocupación diaria
- Uso de fragmentos HTML reutilizables (`head`, `header`, `footer`)
- Estilos personalizados mediante Sass + Bootstrap
- Comunicación frontend-backend mediante peticiones HTTP

## Configuración

1. Cloná el repositorio:
   ```bash
   git clone https://github.com/ariberi/ari-hotel.git
   cd ari-hotel
   ```

2. Iniciá la base de datos PostgreSQL en Docker:
   ```bash
   docker-compose up -d
   ```

3. Configurá el acceso a la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/arihotel
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   ```

4. Ejecutá la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## Uso

Accedé a la interfaz web en: [http://localhost:8080](http://localhost:8080)

Los endpoints REST están disponibles en rutas como:
- `/api/guests`
- `/api/rooms`
- `/api/reservations`

## Estructura del proyecto

- `src/main/java`: Backend (entidades, repositorios, servicios y controladores)
- `src/main/resources/templates`: Vistas Thymeleaf
- `src/main/resources/static`: Archivos estáticos (CSS/SASS, JS)
- `docker-compose.yml`: Configuración de PostgreSQL en Docker
- `pom.xml`: Dependencias y configuración de Maven

---

Creado con ❤️ por [@ariberi](https://github.com/ariberi)
