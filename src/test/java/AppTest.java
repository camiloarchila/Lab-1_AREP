
import escuelaing.edu.co.Cache;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Clase test del web server
 */
public class AppTest extends TestCase{

    /**
     * Crea el TestCase
     * @param test
     */
    public AppTest(String test){
        super(test);
    }

    /**
     * Crea el suite para probar los test
     * @return
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Metodo que prueba y compara las respuestas de la api
     */
    public void testApi(){
        HashMap<String, String> responses = new HashMap<>();

        responses.put("Indiana", "{\"Title\":\"Indiana Jones and the Raiders of the Lost Ark\",\"Year\":\"1981\",\"Rated\":\"PG\",\"Released\":\"12 Jun 1981\",\"Runtime\":\"115 min\",\"Genre\":\"Action, Adventure\",\"Director\":\"Steven Spielberg\",\"Writer\":\"Lawrence Kasdan, George Lucas, Philip Kaufman\",\"Actors\":\"Harrison Ford, Karen Allen, Paul Freeman\",\"Plot\":\"Archaeology professor Indiana Jones ventures to seize a biblical artefact known as the Ark of the Covenant. While doing so, he puts up a fight against Renee and a troop of Nazis.\",\"Language\":\"English, German, Hebrew, Spanish, Arabic, Nepali\",\"Country\":\"United States\",\"Awards\":\"Won 4 Oscars. 38 wins & 24 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNTU2ODkyY2MtMjU1NC00NjE1LWEzYjgtMWQ3MzRhMTE0NDc0XkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"85/100\"}],\"Metascore\":\"85\",\"imdbRating\":\"8.4\",\"imdbVotes\":\"972,272\",\"imdbID\":\"tt0082971\",\"Type\":\"movie\",\"DVD\":\"13 May 2008\",\"BoxOffice\":\"$248,159,971\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        responses.put("up", "{\"Title\":\"Up\",\"Year\":\"2009\",\"Rated\":\"PG\",\"Released\":\"29 May 2009\",\"Runtime\":\"96 min\",\"Genre\":\"Animation, Adventure, Comedy\",\"Director\":\"Pete Docter, Bob Peterson\",\"Writer\":\"Pete Docter, Bob Peterson, Tom McCarthy\",\"Actors\":\"Edward Asner, Jordan Nagai, John Ratzenberger\",\"Plot\":\"78-year-old Carl Fredricksen travels to Paradise Falls in his house equipped with balloons, inadvertently taking a young stowaway.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 2 Oscars. 80 wins & 87 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTk3NDE2NzI4NF5BMl5BanBnXkFtZTgwNzE1MzEyMTE@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"98%\"},{\"Source\":\"Metacritic\",\"Value\":\"88/100\"}],\"Metascore\":\"88\",\"imdbRating\":\"8.3\",\"imdbVotes\":\"1,048,998\",\"imdbID\":\"tt1049413\",\"Type\":\"movie\",\"DVD\":\"10 Nov 2009\",\"BoxOffice\":\"$293,004,164\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        responses.put("jumanji", "{\"Title\":\"Jumanji\",\"Year\":\"1995\",\"Rated\":\"PG\",\"Released\":\"15 Dec 1995\",\"Runtime\":\"104 min\",\"Genre\":\"Adventure, Comedy, Family\",\"Director\":\"Joe Johnston\",\"Writer\":\"Jonathan Hensleigh, Greg Taylor, Jim Strain\",\"Actors\":\"Robin Williams, Kirsten Dunst, Bonnie Hunt\",\"Plot\":\"When two kids find and play a magical board game, they release a man trapped in it for decades - and a host of dangers that can only be stopped by finishing the game.\",\"Language\":\"English, French\",\"Country\":\"United States\",\"Awards\":\"4 wins & 11 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZTk2ZmUwYmEtNTcwZS00YmMyLWFkYjMtNTRmZDA3YWExMjc2XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"52%\"},{\"Source\":\"Metacritic\",\"Value\":\"39/100\"}],\"Metascore\":\"39\",\"imdbRating\":\"7.0\",\"imdbVotes\":\"351,723\",\"imdbID\":\"tt0113497\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$100,499,940\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        responses.put("cars", "{\"Title\":\"Cars\",\"Year\":\"2006\",\"Rated\":\"G\",\"Released\":\"09 Jun 2006\",\"Runtime\":\"117 min\",\"Genre\":\"Animation, Adventure, Comedy\",\"Director\":\"John Lasseter, Joe Ranft\",\"Writer\":\"John Lasseter, Joe Ranft, Jorgen Klubien\",\"Actors\":\"Owen Wilson, Bonnie Hunt, Paul Newman\",\"Plot\":\"On the way to the biggest race of his life, a hotshot rookie race car gets stranded in a rundown town, and learns that winning isn't everything in life.\",\"Language\":\"English, Italian, Japanese, Yiddish\",\"Country\":\"United States\",\"Awards\":\"Nominated for 2 Oscars. 28 wins & 34 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTg5NzY0MzA2MV5BMl5BanBnXkFtZTYwNDc3NTc2._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.2/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"74%\"},{\"Source\":\"Metacritic\",\"Value\":\"73/100\"}],\"Metascore\":\"73\",\"imdbRating\":\"7.2\",\"imdbVotes\":\"428,427\",\"imdbID\":\"tt0317219\",\"Type\":\"movie\",\"DVD\":\"07 Nov 2006\",\"BoxOffice\":\"$244,082,982\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        responses.put("a","{\"Title\":\"Star Wars: Episode IV - A New Hope\",\"Year\":\"1977\",\"Rated\":\"PG\",\"Released\":\"25 May 1977\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Fantasy\",\"Director\":\"George Lucas\",\"Writer\":\"George Lucas\",\"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher\",\"Plot\":\"Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth ...\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 6 Oscars. 64 wins & 29 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"93%\"},{\"Source\":\"Metacritic\",\"Value\":\"90/100\"}],\"Metascore\":\"90\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,370,915\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"DVD\":\"06 Dec 2005\",\"BoxOffice\":\"$460,998,507\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");

        ArrayList<ThreadsTest> threadsTests = new ArrayList<>();
        threadsTests.add(new ThreadsTest("Indiana"));
        threadsTests.add(new ThreadsTest("up"));
        threadsTests.add(new ThreadsTest("jumanji"));
        threadsTests.add(new ThreadsTest("cars"));
        threadsTests.add(new ThreadsTest("a"));

        for(ThreadsTest threadTest: threadsTests){
            threadTest.run();
        }
        for(ThreadsTest threadsTest: threadsTests){
            try {
                threadsTest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for(ThreadsTest threadTest: threadsTests){
            assertEquals(responses.get(threadTest.GetPelicula()), threadTest.GetResponse());
        }

    }

    /**
     * Metodo que valida el funcionamiento del cache
     */
    public void testApiCache(){
        Cache.peliculas.clear();
        ArrayList<ThreadsTest> threadsTests = new ArrayList<>();
        threadsTests.add(new ThreadsTest("Indiana"));
        threadsTests.add(new ThreadsTest("Indiana"));
        threadsTests.add(new ThreadsTest("up"));
        threadsTests.add(new ThreadsTest("up"));
        threadsTests.add(new ThreadsTest("Indiana"));

        for(ThreadsTest threadTest: threadsTests){
            threadTest.run();
        }
        for(ThreadsTest threadsTest: threadsTests){
            try {
                threadsTest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertEquals(2, Cache.peliculas.size());
    }
}
