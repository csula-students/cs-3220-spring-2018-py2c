package edu.csula.web;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.mysql.EventsDAOImpl;
import edu.csula.storage.mysql.Database;
import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.models.Event;
@WebServlet("/admin/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id = Integer.parseInt(request.getParameter("id"));
	  EventsDAOImpl dao = new EventsDAOImpl(new Database());
	  Collection<Event> events = dao.getAll();
	  dao.remove(id);
	response.sendRedirect("events");

  
   }
}