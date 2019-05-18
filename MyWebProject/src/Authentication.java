import javax.servlet.http.HttpServlet;
 
public class Authentication extends HttpServlet {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	private static String redirect_url = "http://99.240.107.88:8080/MyWebProject/Verify";
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
