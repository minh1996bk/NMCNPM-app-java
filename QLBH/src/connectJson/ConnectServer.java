package connectJson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
public class ConnectServer {
  
  public static final String USER_AGENT = "Mozilla/5.0";
  
  public static String getAllObject(String link, String action) {
    String orders = null;
    try {
      URL url = new URL(link + action);
      URLConnection urlConnection = url.openConnection();
      
      // Get the response
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
 
      orders = bufferedReader.readLine();
      
      bufferedReader.close();
      
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    return orders;
  }
  
  public static String postObject(String link, String action, String data) throws IOException {
    
    System.out.println(data);
    
    String url = link + action;
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    
    String urlParameters = "data=" + data;

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();

    // Receive reponse
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String string = in.readLine();
    in.close();
    return string;
  }
}
