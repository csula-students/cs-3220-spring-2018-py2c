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
		html +="<body classs =\"width-constraint\">";
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
		html +="<div class=\"row-container\">";
		html +="<form class=\"fill card\" actions = \"\">";
		html += "<div class=\"form-group\">";
		html += "<label for=\"name\">Event Name</label>";
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
		html += "</div>";
		
		html += "<div>";
		html +=" <table class=\"info-table table-with-elipsis\">";
		html +=	"<thead>";
		html +=	"<tr>";
		html +=	"<th>Name</th>";
		html +=	"<th>Description</th>";
		html +=	"<th>Trigger Point</th>";
		html +=	"<th>Action</th>";
		html +=	"</tr>";
		html +=	"</thead>";
		html +=	"<tbody>";
for (Event event : events){
		html +=	"<tr>";
		html +=	"<td>"+ event.getName()+"</td>";
		html +=	"<td>"+event.getDescription()+"</td>";
		html +=	"<td>"+event.getTriggerAt()+"</td>";
		html +=	"<td>";
		html +=	"</tr>";

}

		html +=	"</tbody>";
		html +="</table>";
		html += "</div>";
		html += "</div>";
		html += "</main>";
		html += "</body>";
		html += "</html>";
		out.println(html);






	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsDAOImpl dao = (EventsDAOImpl) getServletContext().getAttribute("dao");
		String name = request.getParameter("name");
		String description = request.getParameter("descTextArea");
		int trigger = Integer.parseInt(request.getParameter("triggerInput"));
		dao.add(new Event(dao.getAll().size() + 1, name, description, trigger));
		response.sendRedirect("events");

		// TODO: handle upsert transaction
	}
}
