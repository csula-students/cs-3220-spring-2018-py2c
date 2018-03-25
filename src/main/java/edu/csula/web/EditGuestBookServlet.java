package main.java.edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/edit")
public class EditGuestBookServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String html = "<h1>Hello Guestbook! </h1>";
		Collection<GuestboookEntry> entries = (Collection<GuestbookEntry>) getServletContext().getAttribute("guestbook-entries");
			html += "<table border ='1'>";
			 for (GuestbookEntry entry : entries)
			 {
				 html += "<tr>";
				 html += "<td>" + entry.getUsername() + "says </td><td>" + entry.getComment() + "</td><td>Edit | Delete</td>";
				 html += " </tr>";
			
			 }
			 html += "</table>";
			 html += "<form>";
			 html += "<h2>Add Comment</h2>";
			 html += "<label for ='name'>Name:</label>";
			 html += "<input name = 'username   id = 'name type 'text />";
			 html += "< textarea >";


		out.println("<h1>Hello world!</h1>");
	}
}
