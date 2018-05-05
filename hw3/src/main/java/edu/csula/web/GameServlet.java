package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.User;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;
import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Collection<Generator> generators = new GeneratorsDAOImpl(getServletContext()).getAll();
		Collection<Event> events = new EventsDAOImpl(getServletContext()).getAll();
		String  states = gson.toJson(generators);

		request.setAttribute("events",events);
		request.setAttribute("generators",generators);
		request.setAttribute("states",states);
        request.getRequestDispatcher("../WEB-INF/game.jsp")
			  .forward(request, response);
			}
	


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}		
}