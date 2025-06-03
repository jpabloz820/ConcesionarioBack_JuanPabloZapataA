# ConcesionarioBack_JuanPabloZapataA

Funcionalidades del Software: 
Backend de Una API REST que gestione un sistema de ordenes de trabajo para un concesionario de vehículos; El sistema debe contener gestión de vehículos y gestión de ordenes para llevar un histórico de los vehículos y las ordenes de trabajo que ha tenido un vehículo con fecha de orden.

Tecnologías Utilizadas
•	Backend: Java + Spring Boot.
•	Base de Datos: PostgreSQL.
•	Control de Versiones: GitHub.
•   Autenticación: JWT (JSON Web Tokens)
•   Documentación: Swagger (OpenAPI)
•   Build Tool: Maven

Nota: 
-Para acceder a los ambvientes local y dev primero se debe correr el springboot y luego copiar el siguiente comando en la terminal: mvn spring-boot:run -Dspring-boot.run.profiles=local  dependiendo si es local o dev
-Para probar el back se requiere logearse (admin, admin) para generar el token y este se pega en la zona de aturización para poder acceder a los endpoints correctamente.
- Url para swagger entorno local: http://localhost:8080/local/swagger-ui/index.html#/
- Url para swagger entorno dev: http://localhost:8081/dev/swagger-ui/index.html#/

EndPoints Principales 
Vehicle controller: 
-GET /api/vehicles: Lista todos los vehículos.
-GET /api/vehicles/{id}: Lista los vehiculos por id
-POST /api/vehicles: Agrega un nuevo vehículo.
-PUT /api/vehicles/{id}: Edita un vehiculo existente.
-DELETE /api/vehicles/{id}: Elimina un vehiculo 

work order controller:
-GET /api/orders/vehicle/{vehicle id}: Crea una nueva orden para el vehiculo ya existente.
-POST /api/orders/vehicle/{vehicle id}: Obtiene las ordenes por el id del vehiculo.
- PUT /api/orders/{order id}: Actualiza el estado de una orden.


El backend maneja una autentificación mediante tokens JWT  para una correcta autorización.

