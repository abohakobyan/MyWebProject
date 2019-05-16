import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  


@WebServlet("/LoginServlet")
public class LoginServlet extends Authentication{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String username;


	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		String l = Authentication.createLink();
		System.out.println(l);
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		  
		response.sendRedirect(l);  
		  
		pw.close();  
		
		
		/*
    	username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if(username != "" && password != "") {
    		writer.println("You Have Been Authenticated!");
    	}else {
    		writer.println("Please enter a valid username and password!");
    	}
    	*/
	}
}