import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.util.Base64;






@SuppressWarnings("serial")
@WebServlet("/Verify")
public class Verify extends Authentication{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer =response.getWriter();  
    	code = request.getParameter("code");
    	writer.println("Success _____  Redirecting");
    	    
    	try {
			sendPost(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	writer.close();  
    	
	}
	
	private static void sendPost(String code) throws Exception {
		
		
		URL obj = new URL(access_url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		
		String encoded = Base64.getEncoder().encodeToString(("iyn_zN-dKNdmrw"+":"+ SECRET).getBytes(StandardCharsets.UTF_8));  //Java 8
		con.setRequestProperty("Authorization", "Basic "+encoded);
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		
		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+ redirect_url;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + access_url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		InputStream input = con.getInputStream();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(input));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		input.close();
		in.close();
		String x = response.toString();
		final JSONObject obj3 = new JSONObject(x);
		String token = obj3.getString("access_token");
		//String scope  =  obj3.getString("scope");
		
		readArticles(token);
	}
	
    
    
	
	public static void readArticles(String token) throws Exception {
		
		String url = "https://oauth.reddit.com/r/animemes/top/?t=all&limit=" +  NUM_POSTS;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.print(token);
		
		con.setRequestProperty("Authorization", "bearer "+ token);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setDoOutput(true);
		
		try{
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String a = response.toString();
		ParseHelper.printArray(ParseHelper.parsePosts(a, NUM_POSTS));
		
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}
}


		
	

