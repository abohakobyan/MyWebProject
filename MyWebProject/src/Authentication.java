import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*; 
public class Authentication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String response_type;
	private static String state;
	private static String redirect_url;
	private static String client_id;
	private static String link;
	private static String duration;
	private static String scope;
	
	public Authentication() {
		Authentication.client_id = "iyn_zN-dKNdmrw";
		Authentication.redirect_url = "http://99.227.1.78:8080/MyWebProject/Login.html";
		Authentication.response_type = "code";
		Authentication.scope = "history";
		Authentication.duration = "temporary";
	}
	private void stateChanges() {
		int n = 20;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
		int index = (int) ((int) (AlphaNumericString.length()) * Math.random());
		sb.append(AlphaNumericString.charAt(index));
		}
		Authentication.state = sb.toString();
		
}
	protected static String createLink() {
		Authentication a = new Authentication();
		a.stateChanges();
		link = "https://www.reddit.com/api/v1/authorize?client_id=" + client_id + "&response_type=" + response_type +
				 "&state=" + state + "&redirect_uri=" + redirect_url + "&duration=" + duration + "&scope=" + scope;
		return link;
	}
}
