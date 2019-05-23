import org.json.JSONException;
import org.json.JSONObject;

public class token {
	
	public static String tokenRetrieval(JSONObject l) {
		String token = null;
		try {
		token = l.getString("access_token");
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("Access not granted"); //Switch this line to redirect the user to a page that tells you that access has been denied.
		}
		//String scope  =  obj3.getString("scope");
		
		//readArticles(token);
		return token;
	}

}
