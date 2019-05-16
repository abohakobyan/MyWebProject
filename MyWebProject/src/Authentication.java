import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;

import com.google.appengine.api.utils.SystemProperty;

public class Authentication {

	private static String response_type;
	private static String state;
	private static String redirect_url;
	private static String client_id;
	private static String link;
	private static String duration;
	private static String scope;
	
	public Authentication() {
		Authentication.client_id = "hkHbfsPB7zfGZdUKgSoOchEbB2I";
		Authentication.redirect_url = "http://99.227.1.78:8080/MyWebProject/Box%20Portfolio/single-project.html";
		Authentication.response_type = "code";
	}
	
	private String getUserName() {
		return LoginServlet.username;
	}
	
	private void checkUrl(String Url) throws IOException {
		if (redirect_url != Url) {
			throw new IOException();
		}
	}
	
	private String stateChanges() {
		int n = 20;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(n);
		int index = (int) ((int) (AlphaNumericString.length()) * Math.random());
		sb.append(AlphaNumericString.charAt(index));
		Authentication.state = sb.toString();
		return Authentication.state;
}
	private String createLink() {
		link = "https://www.reddit.com/api/v1/authorize?client_id=" + client_id + "&response_type=" + response_type +
				 "&state=" + state + "&redirect_ur=i" + redirect_url + "&duration=" + duration + "&scope=" + scope;
		return link;
	}
}
