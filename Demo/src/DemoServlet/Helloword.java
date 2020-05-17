/**
 * 
 */
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
public  class Helloword extends HttpServlet {
	private static final long serialVersionUID=1l;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = resp.getOutputStream();
		   out.println("<html>");
	       out.println("<head><title>Insert title here</title></head>");
	       out.println("<body>");
	       out.println("<h1>hello world 1</h1>");
	       out.println("</body>");
	       out.println("<html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
