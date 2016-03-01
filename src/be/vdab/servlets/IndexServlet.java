package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;
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
	private static final String INDEX_REQUESTS = "indexRequests";
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		((AtomicInteger) this.getServletContext().getAttribute(INDEX_REQUESTS)).getAndIncrement();
		
		request.setAttribute("aantalViews", aantalViews.incrementAndGet());
		request.setAttribute("emailOwner", this.getInitParameter("emailOwner"));
		//request.setAttribute("emailWebmaster", this.getServletContext().getInitParameter("emailWebmaster"));
		
		request.setAttribute("begroeting", new Begroeting());
		request.setAttribute("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true, new Adres("Grote markt", "1", 2000, "Antwerpen")));
		
		// Localization
		request.setAttribute("nu", Calendar.getInstance().getTime());
		request.setAttribute("aantalPizzasVerkocht", 23000);
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(INDEX_REQUESTS, new AtomicInteger());
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
}
