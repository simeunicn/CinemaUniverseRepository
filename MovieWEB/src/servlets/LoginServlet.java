package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FilmBean;
import beans.LogovanjeBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LogovanjeBean bean;

	@EJB
	FilmBean filmBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean registrovan = false;
		boolean radnik = false;
		if (request.getParameter("login") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username.equals("") || password.equals("")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				String uloga = bean.login(username, password);
				if (uloga.equals("nije-registrovan")) {
					bean.justContinue();
					registrovan = false;
					radnik = false;
					request.getSession().setAttribute("registrovan", registrovan);
					request.getSession().setAttribute("radnik", radnik);
					request.getSession().setAttribute("projekcije", filmBean.pronadjiSveProjekcije());
					request.getSession().setAttribute("LGbean", bean);
					request.getSession().setAttribute("nazivKomponente", "Logout");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				} else if (uloga.equals("korisnik")) {
					registrovan = true;
					radnik = false;
					request.getSession().setAttribute("registrovan", registrovan);
					request.getSession().setAttribute("radnik", radnik);
					request.getSession().setAttribute("projekcije", filmBean.pronadjiSveProjekcije());
					request.getSession().setAttribute("LGbean", bean);
					request.getSession().setAttribute("nazivKomponente", "Logout");
					request.getRequestDispatcher("/site.jsp").forward(request, response);
				} else if (uloga.equals("admin")) {
					request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
				} else if (uloga.equals("radnik")) {
					registrovan = false;
					radnik = true;
					request.getSession().setAttribute("registrovan", registrovan);
					request.getSession().setAttribute("radnik", radnik);
					request.getSession().setAttribute("projekcije", filmBean.pronadjiSveProjekcije());
					request.getSession().setAttribute("LGbean", bean);
					request.getSession().setAttribute("nazivKomponente", "Logout");
					request.getRequestDispatcher("/site.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}
		} else if (request.getParameter("register") != null) {
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		} else if (request.getParameter("continue") != null) {
			bean.justContinue();
			registrovan = false;
			radnik = false;
			request.getSession().setAttribute("registrovan", registrovan);
			request.getSession().setAttribute("radnik", radnik);
			request.getSession().setAttribute("projekcije", filmBean.pronadjiSveProjekcije());
			request.getSession().setAttribute("LGbean", bean);
			request.getSession().setAttribute("nazivKomponente", "Nazad");
			request.getRequestDispatcher("/site.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
