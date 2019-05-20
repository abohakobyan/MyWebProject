import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.io.*;
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
		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+ redirect_url;
		String encoded = Base64.getEncoder().encodeToString(("iyn_zN-dKNdmrw"+":"+ SECRET).getBytes(StandardCharsets.UTF_8));
		String auth = "Basic " + encoded;
		String a = Requester.sendRequest(urlParameters, access_url, "POST", auth);
		
		final JSONObject obj3 = new JSONObject(a);
		String token = obj3.getString("access_token");
		//String scope  =  obj3.getString("scope");
		
		readArticles(token);
	}
	
	public static void readArticles(String token) throws Exception {
		String parameters = null;
		String url = null;
		for (int i = 0; i < 10; i++) {
		if (i==0) {
			url = "https://oauth.reddit.com/r/"+subReddit+"/top/?t=all&limit=" +  NUM_POSTS;
		}	else {
		url = "https://oauth.reddit.com/r/animemes/top/?t=all&limit=" +  NUM_POSTS + "&after=" + "t3_" + Algorithm.getLastPostID(); 
		}
		System.out.print(token);
		String auth = "bearer "+ token;
		String a = Requester.sendRequest(parameters, url, "GET", auth);
		Algorithm.cleanUp(ParseHelper.parsePosts(a, NUM_POSTS));
		}
		System.out.println(Algorithm.suggest());
		}
}


		
	

