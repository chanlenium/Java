import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadSites {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println("==========" + args[i] + "==========");
            try {
                // URL is an acronym for Uniform Resource Locator and
                // is a reference (an address) to a resource on the Internet.
                URL url = new URL("https://" + args[i]);

                InputStream is = url.openStream();  // byte-based stream
                InputStreamReader isr = new InputStreamReader(is); // covert 'is' to character-based stream

                // Reads text from a character-input stream,
                // buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
                BufferedReader br = new BufferedReader(isr);

                String theLine;
                while((theLine = br.readLine()) != null){
                    System.out.println(theLine);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
