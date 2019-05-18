import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.util.Base64;





@WebServlet("/Verify")
public class Verify extends HttpServlet{
	private final static String USER_AGENT = "Reposter:v0.2";
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String state;
	protected static String code;
	public static final String OAUTH_API_DOMAIN = "https://oauth.reddit.com";
	//public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 
		PrintWriter writer =response.getWriter();  
	
		
    	//state = request.getParameter("state");
    	code = request.getParameter("code");
    	String docType =
    	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    	         
    	      writer.println(docType +
    	         "<html>\n" +
    	            "<head><title>" +"My code"+"</title></head>\n" +
    	            "<body bgcolor = \"#f0f0f0\">\n" +
    	               "<h1 align = \"center\">"+"there"+  "</h1>\n" +
    	               "<ul>\n" +
    	                  "  <li><b>State</b>: "
    	                  + request.getParameter("state") + "\n" +
    	                  "  <li><b>Code</b>: "
    	                  + code + "\n" +
    	               "</ul>\n" +
    	            "</body>" +
    	         "</html>"
    	      ); 
    	    try {
				sendPost(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	  	writer.close();  
    	
	}
	
	private static void sendPost(String code) throws Exception {
		
		String url = "https://www.reddit.com/api/v1/access_token";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		String encoded = Base64.getEncoder().encodeToString(("iyn_zN-dKNdmrw"+":"+"hkHbfsPB7zfGZdUKgSoOchEbB2I").getBytes(StandardCharsets.UTF_8));  //Java 8
		con.setRequestProperty("Authorization", "Basic "+encoded);
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri=http://99.240.107.88:8080/MyWebProject/Verify";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
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
		System.out.print(x);
		String [] value1= x.split(",");
		String [] value2= value1[0].split(":");
		String token = value2[1].trim().replace("\"" , "");
		System.out.print(token);
		readArticles(token);
	}
	
    
    
	public static void readArticles(String token) throws Exception {
		
		String url = "https://oauth.reddit.com/r/animemes/top/?t=all&limit=50";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.print(token);
		
		con.setRequestProperty("Authorization", "bearer "+ token);
		con.setRequestProperty("User-Agent", USER_AGENT);
		
			
		//String urlParameters = "user/abohakobyan/about.json";
		
		con.setDoOutput(true);
		//DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		//wr.writeBytes(urlParameters);
		/*
		wr.flush();
		wr.close();
		*/
		int responseCode = con.getResponseCode();
		
		System.out.println("\nSending 'Get' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		System.out.println();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			//System.out.println("\n");
			response.append(inputLine);
		}
		in.close();
		
		String a = response.toString();
		/*System.out.println(a);
		System.out.println("\n");*/
		final JSONObject obj1 = new JSONObject(a);
		System.out.println(a);
		JSONObject datao = obj1.getJSONObject("data");
		JSONArray childrena = datao.getJSONArray("children");
		for(int i = 0; i < 25; i++) {
			System.out.println(i+1);
		JSONObject data = childrena.getJSONObject(i);
		JSONObject data2 = data.getJSONObject("data");
	    System.out.println(data2.getString("title"));
	    System.out.println(data2.getString("url"));
		}
	    /*final JSONArray information = obj1.getJSONArray("Listing");
	    final int n = information.length();
	    for (int i = 0; i < n; ++i) {
	      final JSONObject person = information.getJSONObject(i);
	      System.out.println(person.getString("url"));
	      System.out.println(person.getString("description"));*/
		/*JSONParser parse = new JSONParser(a, null, false);
		JSONArray array = (JSONArray) (((JSONObject) parse.parse()).get("data")).get("Listing");*/
		
		

		//print result
		//System.out.println(response.toString());

	
	}
		
		
	}


		
	

