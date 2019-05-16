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


@WebServlet("/Verify")
public class Verify extends HttpServlet{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String state;
	protected static String code;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		 response.setContentType("text/html");
		 
		PrintWriter writer =response.getWriter();  
	
		
    	//state = request.getParameter("state");
    	//code = request.getParameter("code");
    	String docType =
    	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    	         
    	      writer.println(docType +
    	         "<html>\n" +
    	            "<head><title>" +"My code"+"</title></head>\n" +
    	            "<body bgcolor = \"#f0f0f0\">\n" +
    	               "<h1 align = \"center\">"+"there"+  "</h1>\n" +
    	               "<ul>\n" +
    	                  "  <li><b>State</b>: "
    	                  + request.getParameter("state") + "\n" +
    	                  "  <li><b>Code</b>: "
    	                  + request.getParameter("code") + "\n" +
    	               "</ul>\n" +
    	            "</body>" +
    	         "</html>"
    	      );
    	  	writer.close();  
    	
	}
}