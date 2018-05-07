package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/auth")
public class AuthenticationServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Incremental game framework Login</title>");
		out.println("<link rel=\"stylesheet\" href=\"../app.css\">");
		out.println("</head>");

		out.println("<body class=\"width-constraint\">");
		out.println("<header>");
		out.println("<h1>Incremental game framework login</h1>");
		out.println("</header>");
		out.println("<main>");
		out.println("<form class=\"card\" method=\"POST\">");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"name\">Username:</label>");
		out.println("<input type=\"text\" name = \"username\" id=\"name\">");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"password\">Password: </label><br>");
		out.println("<input type=\"password\" name=\"password\" id=\"pins\"><br>");
		out.println("</div>");
		out.println("<div class=\"actions\">");
		out.println("<input type=\"submit\" value=\"Log in\">");
		out.println("</div>");
		out.println("</form>");
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");
		
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");  
		UsersDAO dao = new UsersDAOImpl(request.getSession());
		if (dao.authenticate(username, password)){
			response.sendRedirect("events");
		}
		else{
			response.sendRedirect("auth");
		}
		
		
		
	}

    @Override
    public void doDelete( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDAO dao = new UsersDAOImpl(request.getSession());
				dao.logout();
				response.sendRedirect("auth");
    }
}
