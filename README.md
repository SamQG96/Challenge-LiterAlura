# LiterAlura - Catálogo de Libros

**LiterAlura** es una aplicación interactiva que permite a los usuarios buscar y explorar una amplia base de datos de libros a través de diferentes criterios de búsqueda. La aplicación obtiene la información de libros desde la API de [Gutendex](https://gutendex.com), proporcionando detalles como títulos, autores y más.

## Características

- Buscar libros por título
- Buscar libros por autor
- Buscar libros por idioma
- Ver todos los libros disponibles en la base de datos
- Interfaz de consola sencilla para interactuar

## Tecnologías utilizadas

La aplicación está construida con las siguientes tecnologías:

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework utilizado para la creación de la aplicación.
- **Spring Data JPA**: Para la persistencia de datos en la base de datos.
- **RestTemplate**: Para hacer solicitudes HTTP a la API de Gutendex.
- **Jackson**: Para convertir las respuestas JSON de la API en objetos Java.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.
- **Postgres**: Base de datos para almacenar libros y autores.

## Instalación

Para ejecutar esta aplicación, asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- **Java 11 o superior**
- **Maven**
- **PostgresL** (opcional, si deseas persistir los datos localmente)

### Pasos para ejecutar la aplicación

1. **Clonar el repositorio**:

    ```bash
    git clone https://github.com/SamQG96/Challenge-LiterAlura
    cd literalura
    ```

2. **Configurar la base de datos** (opcional):

    Si deseas usar Postgres para almacenar los datos, asegúrate de configurar la base de datos en `application.properties`. Crea una base de datos llamada `literalura` en Postgres y configura los detalles de conexión:

    ```properties
    spring.datasource.url=jdbc:Postgres://localhost:3306/literalura
    spring.datasource.username=tu-usuario
    spring.datasource.password=tu-contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Instalar dependencias con Maven**:

    ```bash
    mvn install
    ```

4. **Ejecutar la aplicación**:

    Una vez que las dependencias estén instaladas, puedes ejecutar la aplicación con:

    ```bash
    mvn spring-boot:run
    ```

    La aplicación se ejecutará en el puerto por defecto de Spring Boot (`8080`), pero como esta aplicación es de consola, interactuarás con ella a través de la terminal.

## Uso

Cuando la aplicación se ejecute, verás un menú interactivo en la consola con las siguientes opciones:

1. Buscar libro por título
2. Buscar libros por autor
3. Buscar libros por idioma
4. Listar todos los libros
5. Salir

Selecciona una opción ingresando el número correspondiente y sigue las instrucciones para ingresar los detalles de búsqueda (como el título, autor o idioma).

### Ejemplo de uso

```bash
Menú:
1. Buscar libro por título
2. Buscar libros por autor
3. Buscar libros por idioma
4. Listar todos los libros
5. Salir
Ingrese una opción: 1
Ingrese el título del libro: Pride and Prejudice

Título: Pride and Prejudice
Autores: Jane Austen

Título: Emma
Autores: Jane Austen

... 
```

<h2 align="left">Desarrolladores</h2>

| [<img src="https://github.com/user-attachments/assets/bead4dde-0a40-4b72-847a-bfda52a9a60e" width=115><br><sub>Samir Quintero Garcia</sub>](https://github.com/SamQG96) |  





