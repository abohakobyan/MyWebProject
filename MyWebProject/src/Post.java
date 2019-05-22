

import org.json.JSONException;

public class Post {
	protected String title;
	protected String url;
	protected long created_utc;
	protected int ups;
	protected String subreddit;
	protected String id;
	public Post(String title, String url, long created_utc, int ups, String subreddit, String id) {
		super();
		this.title = title;
		this.url = url;
		this.created_utc = created_utc;
		this.ups = ups;
		this.subreddit = subreddit;
		this.id = id;
	}
	public Post() {
	}
	@Override
	public String toString() {
		return "Post [title=" + title + ", url=" + url + ", created_utc=" + created_utc + ", ups=" + ups
				+ ", subreddit=" + subreddit + ", id="+ id + "]";
	}
	public static void printArray(Post[] posts) throws JSONException{
		for(int i = 0; i<posts.length-1; i++) {
			System.out.println(posts[i].toString());
		}
	}
}