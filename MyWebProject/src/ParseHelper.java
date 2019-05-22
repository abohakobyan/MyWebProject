import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseHelper {
	
	public static Post[] parsePosts(String jsonString, int numPosts) throws JSONException, IOException{
		
		
		final JSONObject obj1 = new JSONObject(jsonString);
		JSONObject datao = obj1.getJSONObject("data");
		JSONArray childrena = datao.getJSONArray("children");
		
		Post[] posts = new Post[numPosts];
		for(int i = 0; i < numPosts; i++) {
			JSONObject data = childrena.getJSONObject(i);
			JSONObject data2 = data.getJSONObject("data");
			Post n = new Post(data2.getString("title"), data2.getString("url"), data2.getLong("created_utc"), data2.getInt("ups"), 
					data2.getString("subreddit"), data2.getString("id"));
			posts[i] = n;
			
		}
		
		return posts;
	}
	
	public static void printArray(String[] string) throws JSONException{
		for(int i = 0; i<string.length-1; i++) {
			System.out.println(string[i]);
		}
	}
}