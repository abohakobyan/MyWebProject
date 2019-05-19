import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseHelper {
	
	public static String[] parsePosts(String jsonString, int numPosts) throws JSONException{
		
		String [] posts = new String[numPosts];
		final JSONObject obj1 = new JSONObject(jsonString);
		JSONObject datao = obj1.getJSONObject("data");
		JSONArray childrena = datao.getJSONArray("children");
		
		for(int i = 0; i < numPosts; i++) {
			JSONObject data = childrena.getJSONObject(i);
			JSONObject data2 = data.getJSONObject("data");
			posts[i] = data2.getString("title")+ ":"+data2.getString("url");
	    }
		
		return posts;
		
	}
	
	
	
	
	public static void printArray(String[] string) throws JSONException{
		for(int i = 0; i<string.length-1; i++) {
			System.out.println(string[i]);
		}
	}
}