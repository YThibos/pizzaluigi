package be.vdab.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookies.htm")
public class CookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/cookies.jsp";
	private static final int COOKIE_MAX_LEEFTIJD = 60 * 30; // Seconden * minuten
	private static final String ENCODING = "UTF-8";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String locale = request.getParameter("locale");
		if (locale != null) {
			request.getSession().setAttribute("locale", locale);
		}
		
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if ("naam".equals(cookie.getName())) {
					request.setAttribute("naam",  URLDecoder.decode(cookie.getValue(), ENCODING));
					break;
				}
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding(ENCODING);
	
		Cookie cookie = new Cookie("naam", URLEncoder.encode(request.getParameter("naam"), ENCODING));
		cookie.setMaxAge(COOKIE_MAX_LEEFTIJD);
		response.addCookie(cookie);
		response.sendRedirect(request.getRequestURI());
		
	}

}
