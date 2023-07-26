# Reto Banco Pichincha
## Base de datos
El archivo de Base de datos se encuentra en `src/main/resources/db/migration/postgresql/V1__initTables.sql`. Este script no necesita ser cargado manualmente ya que se ejecutará al momento de subir docker-compose
## Docker
El presente proyecto tiene los siguientes contenedores
* postgres: Base de datos
    - Nombre de Base de datos: "pichincha"
    - Usuario: "postgres"
    - Contraseña: "postgres"
* pgadmin: Visualizador gráfico de base de datos
    - Usuario: test_pablo@pichincha.com
    - Contraseña: pichincha123
* app: Web server con Backend con Spring Boot
### Subir Docker
`./mvnw clean package -DskipTests` Esto generará el archivo .jar
`docker-compose build` para construir los contenedores
`docker-compose up` para levantar los contenedores