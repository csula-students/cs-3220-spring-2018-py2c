package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
	
		request.setAttribute("events", events);
		request.getRequestDispatcher("../WEB-INF/admin-events.jsp")
          .forward(request, response);

	}



	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		String name = request.getParameter("name");
		String description = request.getParameter("descTextArea");   
		int triggerAt = Integer.parseInt(request.getParameter("triggerInput"));
		Event event = new Event(events.size(), name, description, triggerAt);
		dao.add(event);
		response.sendRedirect("events");
		
		
	}
}
