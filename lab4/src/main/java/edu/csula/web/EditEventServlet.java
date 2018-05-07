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
		
		String html = "";
		html +="<html lang=\"en\">";
		html +="<head>";
		html +="<meta charset=\"UTF-8\">";
		html +="<title>Incremental game framework - game information Edit</title>";
		html +="<link rel=\"stylesheet\" href=\"../app.css\">";
		html +="</head>";
		html +="<body class =\"width-constraint\">";
		html +="<header>";
		html +="<h1>Incremental game framework</h1>";
		html +="</header>";
		html +="<div class=\"row-container\">";
		html +="<form class=\"fill card\" method= \"POST\">";
		html += "<div class=\"form-group\">";
		html += "<label for=\"name\">Event Name </label>";
		html += "<input type=\"text\" id=\"names\" name =\"name\">";
		html += "</div>";

		html += "<div class=\"form-group\">";
        html += "<label for=\"description\">Event Description</label>";
        html += "<textarea id=\"description\"name =\"descTextArea\" ></textarea>";            
		html += "</div>";   
		
        html += "<div class=\"form-group\">" ;       
		html += "<label for=\"trigger_at\">Trigger at</label>";      
		html += "<input type=\"number\" id=\"trigger_at\" name =\"triggerInput\">";          
		html += "</div>" ; 

		html += "<div class=\"actions\">";    
		html += "<button>Save</button>";   
		html += "</div>";     
		html += "</form>";
		html += "</html>";
		
		

		out.println(html);


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
