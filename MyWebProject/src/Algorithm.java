import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Algorithm extends Post{
	
	private static ArrayList<Post> np = new ArrayList<Post>();
	private static long currenttime = getDate();

	public static void cleanUp(Post[] posts) {
		for (int i = 0; i < posts.length; i++) {
			if (posts[i].post_hint.equals("image")) {
				np.add(posts[i]);
			}
		}
	}
	public static Post suggest() {
		int a = np.size();
		System.out.println("\n" + np.size());
		Random rand = new Random();
		int b = rand.nextInt(a);
		Date time = new Date((long)np.get(b).created_utc*1000);
		Date time1 = new Date((long)currenttime*1000);
		System.out.println(time);
		System.out.println(np.get(b).created_utc < currenttime);
		System.out.println(time1);
		System.out.println(np.get(b).toString());
		return np.get(b);
	}
	public static String getLastPostID() {
		return np.get(np.size()-1).id;
	}
	public static long getDate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()/1000);
		return timestamp.getTime();
	}
	public static boolean compareDate() {
	}
}

