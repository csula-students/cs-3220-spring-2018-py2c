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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		String html = "";
		html +="<html lang=\"en\">";
		html +="<head>";
		html +="<meta charset=\"UTF-8\">";
		html +="<title>Incremental game framework - game information</title>";
		html +="<link rel=\"stylesheet\" href=\"../app.css\">";
		html +="</head>";
		html +="<body classs = \"width-constraint\">";
		html +="<header>";
		html +="<h1>Incremental game framework</h1>";
		html +="<nav class=\"main-nav\">";
		html +="<a href=\"game-info.html\">Game Information</a>";
		html +=" | ";
		html +="<a href=\"generator-meta.html\">Generators</a>";
		html +=" | ";
		html +="<a class=\"active\" href=\"event-meta.html\">Events</a>";
		html +="</nav>";
		html +="</header>";
		html +="<main>";
		html +="<div class =\"row-container\">";
		html +="<form class = \"fill card\" actions = \"\">";
		html += "<div class \"form-group\">";
		html += "<label for=\"name\">Event Name</label>";
		html += "<input type=\"text\" id=\"name\">";
		html += "</div>";

		html += "<div class=\"form-group\">";
        html += "<label for=\"description\">Event Description</label>";
        html += "<textarea id=\"description\"></textarea>";            
		html += "</div>";   
		
        html += "<div class=\"form-group\">" ;       
		html += "<label for=\"trigger_at\">Trigger at</label>";      
		html += "<input type=\"number\" id=\"trigger_at\">";          
		html += "</div>" ; 

		html += "<div class=\"actions\">";    
		html += " <button>Save</button>";   
		html += "</div>";     
		html += "</form>";
		html += "</div>";
		html += "</main>";
		html += "</body>";
		html += "</html>";
		out.println(html);






	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





		// TODO: handle upsert transaction
	}
}
