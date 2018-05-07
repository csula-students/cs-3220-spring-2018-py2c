package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;
import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
			Collection<Generator> generators = dao.getAll();
			System.out.println(generators);
			UsersDAO userDao = new UsersDAOImpl(request.getSession());

			if (userDao.getAuthenticatedUser().isPresent()){
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
		out.println("<a href=\"generators\">Generators</a>");
		out.println(" | ");
		out.println("<a href=\"events\">Events</a>");
		out.println("<a id=\"log\" href = \" auth\"> Log out</a>");
		out.println("</nav>");
		out.println("</header>");

		
		out.println("<main>");
		out.println("<div class=\"row-container\">");
		out.println("<form class=\"fill card\" method= \"POST\">");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"name\">Generator Name</label>");
		out.println("<input type=\"text\" id=\"name\" name = \"name\">");
		out.println("</div>");

		out.println("<div class=\"form-group\">");
		out.println("<label for=\"description\">Generator Description</label>");
		out.println("<textarea id=\"description\" name = \"description\"></textarea>");
		out.println("</div>");

		out.println("<div class=\"form-group\">");
		out.println("<label for=\"rate\">Generator rate</label>");
		out.println("<input type=\"number\" id=\"rate\" name = \"rate\">");
		out.println("</div>");

		out.println("<div class=\"form-group\">");
		out.println("<label for=\"cost\">Base cost</label>");
		out.println("<input type=\"number\" id=\"cost\" name = \"cost\">");
		out.println("</div>");

		out.println("<div class=\"form-group\">");
		out.println("<label for=\"unlock_at\">Unlock At</label>");
		out.println("<input type=\"number\" id=\"unlock_at\" name = \"unlock\">");
		out.println("</div>");

		out.println(" <div class=\"actions\">");
		out.println("<button>Save</button>");
		out.println("</div>");
		out.println("</form>");

		out.println("<div>");
		out.println("<table class=\"info-table table-with-elipsis\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Rate</th>");
		out.println("<th>Cost</th>");
		out.println("<th>Unlock</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Generator generator : generators)
			{
		out.println("<tr>");
		out.println("<td>"+ generator.getName()+"</td>");
		out.println("<td>"+ generator.getDescription()+"</td>");
		out.println("<td>"+ generator.getRate()+"</td>");
		out.println("<td>"+ generator.getBaseCost()+"</td>");
		out.println("<td>"+ generator.getUnlockAt()+"</td>");
		
	
		out.println("<td>");
		out.println("<a href=\"EditgenServlet?id=" + generator.getId() +"\">Edit</a>");
			out.println("|");
			out.println("<a href=\"DeletegenServlet?id=" + generator.getId() + "\">Delete</a>");
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
	else
	{
		response.sendRedirect("auth");
	}
		

	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();

		
		String name = request.getParameter("name");
		String description = request.getParameter("description");  
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		Generator generator = new Generator(generators.size(), name, description, rate, baseCost, unlockAt);
		dao.add(generator);
		response.sendRedirect("generators");
}
}
