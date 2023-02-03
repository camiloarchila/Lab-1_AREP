# Lab-1_AREP

Creacion de un Servidor web que realiza consultas a una api de peliculas por su nombre con el metodo GET

##Iniciando

Primero se debe clonar el repositorio con el siguiente comando 

```
 git clone https://github.com/camiloarchila/Lab-1_AREP.git
```

Posteriormente debemos Abrir la carpeta clonada en la IDE de su preferencia y correr la clase main que se encuentra en la carpeta:

```
java/escuelaing/edu/co
```

y en el navegador de su preferencia ponemos la siguiente url http://localhost:35000 alli en el campo Name colocaremos el nombre de la pelicula que queremos buscar y le damos submit

## Ejecutando tests

para ejecutar los test debemos ingresar a la carpeta donde se encuentra el archivo pom.xml y en la terminal ejecutar el siguiente comando

```
mvn test
```
Dentro de las respuestas de los test tenemos 2 test diferentes, el testApi se encarga de validar el funcionamiento de las respuestas de la api, y el testApiCache se encarga de validar el correcto funcionamiento de la memoria cache del servidor

##Construido con 
*[Maven] - Administrador de dependencias

##Version 
Versión 1.0

##Autor
*[camiloarchila] Esteban Camilo Archila Bastidas 

##Descripcion estecifica

*Extensibilidad: Tiene la posibilidad de adaptarse a la respuesta de cualquier api y manejar la informacion a su gusto ya que en todo momento esta informacion sera encontrada en formato json 
*patrones: El patron utilizado para este desarrollo es el patron fachada ya que estamos validando en una memoria cache y validar si se encuentra la respuesta antes de consultar en la api
*Modular: Tenemos 3 clases y cada una se encarga de funciones diferentes, la principal es la que se encarga de levantar el servidor y mostrar la respuesta de la api, la clase connection como su nombre lo dice realiza la conexion entre el sevidor y la api, por ultimo la clase cache se encarga de almacenar las consultas que se realizan a la api para evitar tener que volver a realizar la peticion
