import javax.servlet.http.HttpServlet;


public class Authentication extends HttpServlet {
	protected final static String USER_AGENT = "Reposter:v0.2";
	protected static String code;
	protected final static int NUM_POSTS = 100;
	public static final String OAUTH_API_DOMAIN = "https://oauth.reddit.com";
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected static String subReddit = "all";
	protected static final String redirect_url = "http://99.227.1.78:8080/MyWebProject/Verify";
	protected static final String access_url = "https://www.reddit.com/api/v1/access_token";
	protected static final String SECRET = "hkHbfsPB7zfGZdUKgSoOchEbB2I";
	
	
	private static String response_type;
	private static String state;
	private static String client_id;
	private static String link;
	private static String duration;
	private static String scope;
	
	public Authentication() {
		Authentication.client_id = "iyn_zN-dKNdmrw";
		Authentication.response_type = "code";
		Authentication.scope = "read";
		Authentication.duration = "temporary";
	}
	private void generateState() {
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
		a.generateState();
		link = "https://www.reddit.com/api/v1/authorize?client_id=" + client_id + "&response_type=" + response_type +
				 "&state=" + state + "&redirect_uri=" + redirect_url + "&duration=" + duration + "&scope=" + scope;
		return link;
	}
}
