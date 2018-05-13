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
		doDelete(request, response);
		request.getRequestDispatcher("../WEB-INF/authentication.jsp").forward(request, response);
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
	
    }
}
