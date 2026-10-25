# TODO - Product Management REST API (Spring Boot)

## Plan (approved/working)
1. Create Maven Spring Boot project structure under `src/main/java` and `src/main/resources`.
2. Add `pom.xml` dependencies (Spring Web, Validation, Spring Data JPA, MySQL driver, Springdoc OpenAPI/Swagger).
3. Create layers:
   - Entity: `Product`
   - DTO/request models + optional response wrapper
   - Repository: `ProductRepository`
   - Service: `ProductService` + implementation
   - Controller: `ProductController`
4. Implement validation + exception handling:
   - Custom `ResourceNotFoundException`
   - `ApiError` model
   - `GlobalExceptionHandler` with `@ControllerAdvice`
5. Add Swagger/OpenAPI configuration.
6. Add MySQL config in `application.properties` (placeholders allowed).
7. Add sample SQL/data seeding script (and mention how to run).
8. Add README with setup, run, test (Postman + endpoints list).
9. Add architecture diagram / flow diagram (simple text/mermaid) in README.
10. Ensure endpoints support:
   - CRUD
   - search/filter: by category, by price range, by name (optional)
11. Build command + basic run instructions.

## Progress
- [ ] Step 1-2: Project scaffold + pom.xml
- [ ] Step 3-4: Entity/DTO/Repository/Service/Controller + exceptions
- [ ] Step 5: Swagger/OpenAPI
- [ ] Step 6-7: application.properties + sample SQL
- [ ] Step 8: README + Postman collection (optional if time)
- [ ] Step 9-11: diagrams + build/run verification

