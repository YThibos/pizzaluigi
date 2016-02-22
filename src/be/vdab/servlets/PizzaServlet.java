package be.vdab.servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet({ "/pizzas.htm" })
public class PizzaServlet extends HttpServlet {

	private static final String PIZZAS_REQUESTS = "pizzasRequests";

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
	
	private final PizzaDAO pizzaDAO = new PizzaDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Increment views counter
		((AtomicInteger) this.getServletContext().getAttribute(PIZZAS_REQUESTS))
		.incrementAndGet();
		
		List<Pizza> pizzas = pizzaDAO.findAll();
		
		String pizzaFotosPad = this.getServletContext().getRealPath("/pizzafotos");
		Set<Long> pizzaIdsMetfoto = new HashSet<>();
		pizzas.stream().forEach(pizza -> {
			File file = new File(String.format("%s/%d.jpg", pizzaFotosPad, pizza.getId()));
			if (file.exists()) {
				pizzaIdsMetfoto.add(pizza.getId());
			}
		});

		request.setAttribute("pizzas", pizzas);
		request.setAttribute("pizzaIdsMetFoto", pizzaIdsMetfoto);

		
		// Forward request to VIEW
		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZAS_REQUESTS, new AtomicInteger());
	}

}
