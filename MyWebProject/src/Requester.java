import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;

@SuppressWarnings("serial")
public class Requester extends Authentication{
	
	static String sendRequest(String parameter, String url, String method, String auth) 
			throws IOException, JSONException {
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestMethod(method);
		con.setRequestProperty("Authorization", auth);
		con.setRequestProperty("User-Agent", USER_AGENT);
		String a = null;
		
		if (method == "POST") {
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parameter);
			wr.flush();
			wr.close();
		}
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			a = response.toString();
			}catch(IOException e) {
				e.printStackTrace();
			}
		return a; 
		}

}

