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
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		html+="<main>";
		html+="<div class=\"row-container\">";
		html+="<form class=\"fill card\" method= \"POST\">";
		html+="<div class=\"form-group\">";
		html+="<label for=\"name\">Generator Name</label>";
		html+="<input type=\"text\" id=\"name\" name = \"name\">";
		html+="</div>";

		html+="<div class=\"form-group\">";
		html+="<label for=\"description\">Generator Description</label>";
		html+="<textarea id=\"description\" name = \"description\"></textarea>";
		html+="</div>";

		html+="<div class=\"form-group\">";
		html+="<label for=\"rate\">Generator rate</label>";
		html+="<input type=\"number\" id=\"rate\" name = \"rate\">";
		html+="</div>";

		html+="<div class=\"form-group\">";
		html+="<label for=\"cost\">Base cost</label>";
		html+="<input type=\"number\" id=\"cost\" name = \"cost\">";
		html+="</div>";

		html+="<div class=\"form-group\">";
		html+="<label for=\"unlock_at\">Unlock At</label>";
		html+="<input type=\"number\" id=\"unlock_at\" name = \"unlock\">";
		html+="</div>";

		html+=" <div class=\"actions\">";
		html+="<button>Save</button>";
		html+="</div>";
		html+="</form>";

	
		html += "</html>";
		
		

		out.println(html);


	}





        
public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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