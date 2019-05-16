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

public class Authentication extends LoginServlet {

	
	private static String client_id;
	private static String code;
	private static String state;
	private static String redirect_url;
	
	public Authentication() {
		this.client_id = "";
		this.code = "";
		this.state = "";
		this.redirected_url = ;
	}
	
	private string getUrl() {
		return Url;
	}
	
	private void checkUrl(String Url) throws IOException {
		if (redirect_url != Url) {
			throws new IOException;
		}
	}
	
	private String stateChanges() {
		int n = 20;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(n);
		int index = (int)(AlphaNumericString.length()) * Math.random());
		sb.append(AlphaNumericString.charAt(index));
		this.code = sb.toString();
		return this.code;
}
