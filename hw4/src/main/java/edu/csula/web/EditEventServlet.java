package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EventsDAO dao = new EventsDAOImpl(getServletContext());
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
	

		EventsDAO dao = new EventsDAOImpl(getServletContext());
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("descTextArea");
		int triggerAt = Integer.parseInt(request.getParameter("triggerInput"));
		Event event = new Event(id, name, description, triggerAt);
		dao.set(id, event);
		response.sendRedirect("events");
		
		



}        
	}