package escuelaing.edu.co;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Clase principal que contiene el servidor web
 */
public class HttpServer {
 public static void main(String[] args) throws IOException {
         ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
             System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            String pelicula = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (inputLine.contains("pelicula?nombre")) {
                    String[] cadena = inputLine.split("=");
                    pelicula = (cadena[1].split("HTTP"))[0];
                }
                if (!in.ready()) {
                    break;
                }
            }
            if (!Objects.equals(pelicula, "")) {
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: application/json\r\n"
                        + "\r\n" +
                        "<style>\n" +
                        "table, th, td {\n" +
                        "  border:1px solid black;\n" +
                        "}\n" +
                        "</style>" +
                        MuestraTabla(Cache.ConsultaPelicula(pelicula));
            }else{
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "    <head>\n" +
                        "        <title>Form Example</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Consulta una pelicula GET</h1>\n" +
                        "        <form action=\"/hello\">\n" +
                        "            <label for=\"name\">Name:</label><br>\n" +
                        "            <input type=\"text\" id=\"name\" name=\"name\" value=\"John\"><br><br>\n" +
                        "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                        "        </form> \n" +
                        "        <div id=\"getrespmsg\"></div>\n" +
                        "\n" +
                        "        <script>\n" +
                        "            function loadGetMsg() {\n" +
                        "                let nameVar = document.getElementById(\"name\").value;\n" +
                        "                const xhttp = new XMLHttpRequest();\n" +
                        "                xhttp.onload = function() {\n" +
                        "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                        "                    this.responseText;\n" +
                        "                }\n" +
                        "                xhttp.open(\"GET\", \"/pelicula?nombre=\"+nameVar);\n" +
                        "                xhttp.send();\n" +
                        "            }\n" +
                        "        </script>\n" +
                        "\n" +
                        "</html>";
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Construye una tabla en HTML con los datos de la respuesta de la api
     * @param pelicula string del nombre de la pelicula a consultar
     * @return String de la tabla en HTMl con los datos de la respuesta de la api
     */
    private static String MuestraTabla(String pelicula){
     String[] info = pelicula.split(":");
     String table = "<table>\n";
     for(int i=0; i<(info.length); i++){
         String[] data = info[i].split(",");
         table+="<td>" + Arrays.toString(Arrays.copyOf(data, data.length-1)).replace("[","").replace("]","") + "</td>\n</tr>\n";
         table+="<tr>\n<td>" + data[data.length-1].replace("{", "").replace("[", "") + "</td>\n";
     }
     table+="</table>";
     return table;
    }
 }
