package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.mysql.EventsDAOImpl;
import edu.csula.storage.servlet.UsersDAOImpl;


import edu.csula.models.Event;
@WebServlet("/admin/game-info")
public class AdminGameinfoServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAOImpl userDao = new UsersDAOImpl(request.getSession());
		
		if (userDao.getAuthenticatedUser().isPresent()){
		request.getRequestDispatcher("../WEB-INF/game-info.jsp")
		  .forward(request, response);
		}
		else{
			response.sendRedirect("auth");
		}

	}



	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("game-info");
		
		
	}
}
