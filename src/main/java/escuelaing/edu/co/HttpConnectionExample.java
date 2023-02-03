package escuelaing.edu.co;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * Clase que contruye la conexion con la api y recibe la respuesta
 */
public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "http://www.omdbapi.com/?t=";
    private static final String Api_Key = "&apikey=5968011b";

    /**
     * Metodo que realiza la conexion a la api y realiza la consulta de la pelicula
     * @param pelicula string del nombre de la pelicula a consultar
     * @return retorna la respuesta de la api
     * @throws IOException
     */
    public static String Api(String pelicula) throws IOException {
        String Apiresponse = "";
        if (!Objects.equals(pelicula, "")) {
            GET_URL+=pelicula;
            GET_URL+=Api_Key;
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                 Apiresponse =response.toString();
            } else {
                Apiresponse = "GET request not worked";
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        }
        GET_URL = "http://www.omdbapi.com/?t=";
        return Apiresponse;
    }

}
