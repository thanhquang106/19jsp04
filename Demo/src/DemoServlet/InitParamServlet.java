package DemoServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 */

public class InitParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String User = this.getServletConfig().getInitParameter("User");
		String Password = this.getServletConfig().getInitParameter("Password");
		ServletOutputStream out = resp.getOutputStream();
		 	out.println("<html>");
	        out.println("<head><title>Init Param</title></head>");
	 
	        out.println("<body>");
	        out.println("<h3>Init Param</h3>");
	        out.println("User: " + User + "");
	        out.println("Password: " + Password + "<br>");
	        out.println("</body>");
	        out.println("<html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	


}
