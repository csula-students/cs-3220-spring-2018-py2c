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
@WebServlet("/admin/EditgenServlet")
public class EditgenServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());	
		int id = Integer.parseInt(request.getParameter("id"));
		Generator generator = null;
		for (Generator a : dao.getAll()) {
			if (id == a.getId()) {
				generator = a;
				
			}
		}
		
		 request.getRequestDispatcher("/WEB-INF/admin-edit-gen.jsp")
		.forward(request, response);

	}

        
public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
	Collection<Generator> generators = dao.getAll();
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String description = request.getParameter("description");  
	int rate = Integer.parseInt(request.getParameter("rate"));
	int baseCost = Integer.parseInt(request.getParameter("cost"));
	int unlockAt = Integer.parseInt(request.getParameter("unlock"));
	Generator generator = new Generator(generators.size(), name, description, rate, baseCost, unlockAt);
	dao.set(id,generator);
	response.sendRedirect("generators");



}        
	}