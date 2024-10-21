1. Para lanzar las bases de datos es necesario tener Docker instalado en la máquina anfitriona y ejecutar "docker-compose up -d" en la carpeta raíz.

2. Ejecutar los proyectos .jar por separado (de momento, hasta no tener el despliegue automatizado).

3. Llamadas a la API:

3.1 Para registrar un nuevo usuario:
  POST http://localhost:8081/auth/register
    - body:
      {
          "nombre": "[nombre del usuario]",
          "contrasena": "[contraseña del usuario]"
      }

3.2 Para hacer login con un usuario (obtener el token JWT necesario para el resto de llamadas a la API):
  POST http://localhost:8081/auth/login
    - body:
      {
          "nombre": "[nombre del usuario]",
          "contrasena": "[contraseña del usuario]"
      }

3.3 Para las llamadas a los endpoints expuestos:
  GET/POST http://localhost:[8080/8082]/[ruta de la API]
    - body(opcional):
      [objeto JSON]
