# Product Management REST API (Spring Boot)

## What’s included
- Product CRUD APIs (JSON responses)
- Validation (Jakarta Bean Validation)
- Global exception handling (`@ControllerAdvice`)
- Search/filter APIs:
  - Get by category
  - Get within price range
- Swagger/OpenAPI documentation (Springdoc)

## Tech Stack
- Java 17
- Spring Boot (Spring Web)
- Spring Data JPA + Hibernate
- MySQL
- Maven
- Swagger/OpenAPI (springdoc)

## Setup
1. Install MySQL and create a database, e.g. `product_db`.
2. Update `src/main/resources/application.properties` with your MySQL credentials.
3. Build:
   ```bash
   mvn clean package
   ```
4. Run:
   ```bash
   mvn spring-boot:run
   ```

## Swagger UI
- http://localhost:8080/swagger-ui.html

## Endpoints
Base: `/api/products`
- `POST /` : add product
- `GET /` : get all products
- `GET /{id}` : get product by id
- `GET /by-category?category=...`
- `GET /by-price-range?minPrice=...&maxPrice=...`
- `PUT /{id}` : update product
- `DELETE /{id}` : delete product

## Testing with Postman
Use `Content-Type: application/json`.
Example request (POST):
```json
{
  "productName": "Laptop",
  "category": "Electronics",
  "price": 55000,
  "quantity": 10,
  "brand": "Dell",
  "description": "Gaming laptop"
}
```

## Project Structure
- `controller/` - REST endpoints
- `service/` - business logic
- `repository/` - DB access (JpaRepository)
- `entity/` - JPA entity
- `exception/` - custom exceptions + controller advice


