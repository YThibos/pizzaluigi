package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatistiekServlet
 */
@WebServlet("/statistiek.htm")
public class StatistiekServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/statistiek.jsp";
	
	private static final String STATISTIEK_REQUEST = "statistiekRequests"; 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Increment views counter
		((AtomicInteger) this.getServletContext().getAttribute(STATISTIEK_REQUEST))
		.incrementAndGet();
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(STATISTIEK_REQUEST, new AtomicInteger());
	}

}
