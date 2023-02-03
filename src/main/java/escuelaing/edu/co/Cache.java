package escuelaing.edu.co;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que contiene la memoria cache del servidor
 */
public class Cache {

    /**
     * Este diccionario nombrado peliculas sera el que cumpla la funcion de memoria cache, almacenando el nombre de la pelicula como llave y el response de la api como valor
     */
    public static ConcurrentHashMap<String, String> peliculas = new ConcurrentHashMap<>();

    /**
     * Metodo que valida si la respuesta de la consulta ya se encuentra dentro el diccionario
     * @param pelicula string del nombre de la pelicula a consultar
     * @return Si ya se encuentra la respuesta en el diccionario la retorna, si no retorna la respuesta de la api
     * @throws IOException
     */
    public static String ConsultaPelicula(String pelicula) throws IOException{
        if(peliculas.contains(pelicula)){
            return peliculas.get(pelicula);
        }else{
            String response = HttpConnectionExample.Api(pelicula);
            peliculas.put(pelicula, response);
            return response;
        }
    }
}

