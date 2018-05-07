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
//import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EventsDAOImpl dao = new EventsDAOImpl(new Database());
		int id = Integer.parseInt(request.getParameter("id"));
		Event event = null;
		for (Event a : dao.getAll()) {
			if (id == a.getId()) {
				event = a;
				
			}
		}
		
		 request.getRequestDispatcher("/WEB-INF/admin-edit-events.jsp")
		.forward(request, response);

	}

        
public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	    EventsDAOImpl dao = new EventsDAOImpl(new Database());
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("descTextArea");
		int triggerAt = Integer.parseInt(request.getParameter("triggerInput"));
		Event event = new Event(id, name, description, triggerAt);
		dao.set(id, event);
		response.sendRedirect("events");
		
		



}        
	}