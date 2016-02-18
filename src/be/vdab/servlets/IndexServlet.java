package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Begroeting;
import be.vdab.entities.Persoon;	

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index.htm", name = "indexservlet")
public class IndexServlet extends HttpServlet  {
	
	private final AtomicInteger aantalViews = new AtomicInteger();
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("aantalViews", aantalViews.incrementAndGet());
		request.setAttribute("emailAdresWebmaster", this.getInitParameter("emailAdresWebmaster"));
		request.setAttribute("begroeting", new Begroeting());
		request.setAttribute("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true, new Adres("Grote markt", "1", 2000, "Antwerpen")));
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}
	
	
}
