1. Para lanzar las bases de datos es necesario tener Docker instalado en la máquina anfitriona y ejecutar "docker-compose up --build -d" en la carpeta raíz.

2. Llamadas a la API:

2.1 Para registrar un nuevo usuario:
  POST http://localhost:8081/auth/register
    - body:
      {
          "nombre": "[nombre del usuario]",
          "contrasena": "[contraseña del usuario]"
      }

2.2 Para hacer login con un usuario (obtener el token JWT necesario para el resto de llamadas a la API):
  POST http://localhost:8081/auth/login
    - body:
      {
          "nombre": "[nombre del usuario]",
          "contrasena": "[contraseña del usuario]"
      }

2.3 Para las llamadas a los endpoints expuestos:
  GET/POST http://localhost:[8080/8082]/[ruta de la API]
    - body(opcional):
      [objeto JSON]
