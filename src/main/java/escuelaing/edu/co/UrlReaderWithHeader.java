package escuelaing.edu.co;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UrlReaderWithHeader {
    public static void main(String[] args) throws IOException {
        URL siteURL = new URL("http://www.google.com/");

        URLConnection urlConnection = siteURL.openConnection();

        Map<String, List<String>> headers = urlConnection.getHeaderFields();

        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();

        for (Map.Entry<String, List<String>> entry : entrySet) {
             String headerName = entry.getKey();
             if(headerName !=null){
                 System.out.print(headerName + ":");
             }
             List<String> headerValues = entry.getValue();
             for (String value : headerValues) {
                System.out.print(value);
             }
            System.out.println("");

        }

    }
}
