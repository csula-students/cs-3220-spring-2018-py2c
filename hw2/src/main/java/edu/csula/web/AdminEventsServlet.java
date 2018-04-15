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
	
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Incremental game framework - game information</title>");
		out.println("<link rel=\"stylesheet\" href=\"../app.css\">");
		out.println("</head>");
		
		out.println("<body classs =\"width-constraint\">");
		out.println("<header>");
		out.println("<h1>Incremental game framework</h1>");
		out.println("<nav class=\"main-nav\">");
		out.println("<a href=\"game-info.html\">Game Information</a>");
		out.println(" | ");
		out.println("<a href=\"generator-meta.html\">Generators</a>");
		out.println(" | ");
		out.println("<a class=\"active\" href=\"event-meta.html\">Events</a>");
		out.println("</nav>");
		out.println("</header>");
		
		out.println("<main>");
		out.println("<div class=\"row-container\">");
		
		out.println("<form class=\"fill card\" method= \"POST\">");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"name\">Event Name</label>");
		out.println("<input type=\"text\" id=\"names\" name =\"name\">");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"description\">Event Description</label>");
		out.println("<textarea id=\"description\"name =\"descTextArea\" ></textarea>");
		out.println("</div>");

		out.println("<div class=\"form-group\">");
		out.println("<label for=\"trigger_at\">Trigger at</label>");
		out.println("<input type=\"number\" id=\"trigger_at\" name =\"triggerInput\">");
		out.println("</div>" );

		out.println("<div class=\"actions\">");
		out.println("<button>Save</button>");
		out.println("</div>");
		out.println("</form>");
		

		out.println("<div>");
		out.println("<table class=\"info-table table-with-elipsis\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Trigger Point</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Event event:events)
			{
		out.println("<tr>");
		out.println("<td>"+ event.getName()+"</td>");
		out.println("<td>"+ event.getDescription()+"</td>");
		out.println("<td>"+ event.getTriggerAt()+"</td>");
		out.println("<td>");
		out.println("<a href=\"EditEventServlet?id=" + event.getId() +"\">Edit</a>");
			out.println("|");
			out.println("<a href=\"DeleteEventServlet?id=" + event.getId() + "\">Delete</a>");
		out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");

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