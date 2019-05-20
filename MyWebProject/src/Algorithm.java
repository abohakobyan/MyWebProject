import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Algorithm extends Post{
	
	private static ArrayList<Post> np = new ArrayList<Post>();
	private static long currenttime = getDate();
	private static int timeWindow = 2;
	public static void cleanUp(Post[] posts) {
		
		for (int i = 0; i < posts.length; i++) {
			Date other = new Date((long)posts[i].created_utc*1000);
			Date current = new Date((long)currenttime*1000);
			if (posts[i].post_hint.equals("image") && compareDate(current,other)) {
				np.add(posts[i]);
			}
		}
	}
	public static Post suggest() {
		int a = np.size();
		System.out.println("\n" + np.size());
		Random rand = new Random();
		int b = rand.nextInt(a);		
		return np.get(b);
	}
	public static String getLastPostID() {
		return np.get(np.size()-1).id;
	}
	public static long getDate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()/1000);
		return timestamp.getTime();
	}
	@SuppressWarnings("deprecation")
	public static boolean compareDate(Date current, Date other) {
		int ourM = current.getMonth();
		if(ourM < 1) {
			current.setMonth(12+ ourM - timeWindow);
			current.setYear(current.getYear()-1);
		}else {
			current.setMonth(ourM - timeWindow);
		}
		Timestamp c = new Timestamp(current.getTime());
		Timestamp o = new Timestamp(other.getTime());
		return (c.getTime()> o.getTime());
		
	}
}

