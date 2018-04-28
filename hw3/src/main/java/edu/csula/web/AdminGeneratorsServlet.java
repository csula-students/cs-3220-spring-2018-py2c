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

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO userDao = new UsersDAOImpl(request.getSession());
	
			if (userDao.getAuthenticatedUser().isPresent()){
			EventsDAO dao = new EventsDAOImpl(getServletContext());
			Collection<Generator> generators = dao.getAll();
		
			request.setAttribute("generators", generators);
			request.getRequestDispatcher("../WEB-INF/admin-generator.jsp")
			  .forward(request, response);
			}
			else{
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
