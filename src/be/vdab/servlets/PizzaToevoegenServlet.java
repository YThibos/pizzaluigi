package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;

/**
 * Servlet implementation class PizzaToevoegenServlet
 */
@WebServlet("/pizzas/toevoegen.htm")
public class PizzaToevoegenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzatoevoegen.jsp";
	private static final String REDIRECT_URL = "%s/pizzas.htm";
	private final PizzaDAO pizzaDAO = new PizzaDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> fouten = new HashMap<>();
		
		// Check op geldigheid naam
		String naam = request.getParameter("naam");
		if (!Pizza.isNaamValid(naam)) {
			fouten.put("naam", "Naam is verplicht");
		}
		
		// Check op geldigheid prijs
		BigDecimal prijs = null;
		try {
			prijs = new BigDecimal(request.getParameter("prijs"));
			if (!Pizza.isPrijsValid(prijs)) {
				fouten.put("prijs", "Geef een positief getal");
			}
		} catch (Exception ex) {
			fouten.put("prijs", "Geef een getal in");
		}
		
		if (fouten.isEmpty()) {
			
			// Haal laatste input uit params (pikant) indien aanwezig, maak pizza en steek in DB
			boolean pikant = "pikant".equals(request.getParameter("pikant"));
			pizzaDAO.create(new Pizza(naam, prijs, pikant));
			
			request.setAttribute("pizzas", pizzaDAO.findAll());
			response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
		}
		else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
	}

}
