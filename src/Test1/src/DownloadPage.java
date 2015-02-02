import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DownloadPage {
	public static void main(String[] args) throws IOException {

        // Make a URL to the web page
        URL url = new URL("http://apis.is/concerts");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
        	//Splitta upp í array EFTIR orðið "eventDateName"
        	String[] partar = line.split("eventDateName");
        	for(int i=0;i<partar.length;i++)
        	{
        		String str = partar[i];			//Bý til strengi úr öllum pörtunum, einn í einu
        		int spaceIndex = str.indexOf("name");		//Finn staðsetningu "name" í strengnum
                if(spaceIndex!=-1)
                {
                	str = str.substring(0,spaceIndex);		//Eyði öllu sem kemur eftir "name"
                }
        		System.out.println(str);		//Prenta strengina
        	}
        	//Þessi lína er bara til að prenta allan source kóðann
//            System.out.println(line);
        }
    }
}
