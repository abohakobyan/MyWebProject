import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import jdk.internal.org.xml.sax.InputSource;
import net.projectmonkey.object.mapper.ObjectMapper;

import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.*;  
import javax.servlet.http.*; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;




@WebServlet("/Verify")
public class Verify extends HttpServlet{
	private final static String USER_AGENT = "Reposter:v0.2";
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String state;
	protected static String code;

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

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri=http://99.227.1.78:8080/MyWebProject/Verify";
		
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
	
	public static void readArticles(String token) {
		   
		
	}

}
