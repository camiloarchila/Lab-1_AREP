import escuelaing.edu.co.Cache;

import java.io.IOException;

/**
 * Clase test que valida la concurrencia del web server
 */
public class ThreadsTest extends Thread{

    private final String pelicula;
    private String response;

    /**
     * Metodo que inicia los hilos para realizar las consultas a la api
     */
    @Override
    public void run(){
        try{
            response = Cache.ConsultaPelicula(pelicula);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que asigna el nombre de la pelicula a la variable pregunta para la cosulta
     * @param pelicula
     */
    public ThreadsTest(String pelicula){
        this.pelicula = pelicula;
    }

    /**
     *
     * @return devuelve la respuesta de la api
     */
    public String GetResponse(){
        return response;
    }

    /**
     *
     * @return devuelve el nombre de la pelicula consultada
     */
    public String GetPelicula(){
        return pelicula;
    }
}
