import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if(username != "" && password != "") {
    		writer.println("You Have Been Authenticated!");
    	}else {
    		writer.println("Please enter a valid username and password!");
    	}
    	
    	
    }
 
}