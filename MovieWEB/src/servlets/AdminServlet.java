package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AdminBean;
import beans.AdminBeanRemote;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * rad sa slikama BufferedImage img = ImageIO.read(new
	 * URL("http://stackoverflow.com/content/img/so/logo.png"));
	 */

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

		AdminBeanRemote bean = (AdminBeanRemote) request.getSession().getAttribute("bean");
		request.getSession().setAttribute("poruka", "");
		request.getSession().setAttribute("prihod", "");
		if (bean == null) {
			try {
				bean = (AdminBeanRemote) new InitialContext()
						.lookup("java:global/MoviesEAR/MoviesEJB/AdminBean!beans.AdminBeanRemote");
			} catch (NamingException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("bean", bean);
		}

		if (request.getParameter("sacuvajF") != null) {

			String naziv = request.getParameter("naziv");
			String opis = request.getParameter("opis");
			String kategorija = request.getParameter("kategorija");
			String slika = request.getParameter("slika");
			request.getSession().setAttribute("poruka", bean.sacuvajFilm(naziv, opis, kategorija, slika));
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);

		} else if (request.getParameter("sacuvajG") != null) {

			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String slika = request.getParameter("slika");
			String biografija = request.getParameter("biografija");
			if (bean.dodajGlumca(ime, prezime, slika, biografija)) {
				request.getSession().setAttribute("poruka", "Glumac je uspesno dodat!");
			} else {
				request.getSession().setAttribute("poruka", "Glumac nije dodat! ! Sva polja moraju biti popunjena!");
			}
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);

		} else if (request.getParameter("sacuvajP") != null) {

			String sala = request.getParameter("sala");
			String ukMesta = request.getParameter("ukupnoMesta");
			String slobMesta = request.getParameter("slobodnaMesta");
			String cena = request.getParameter("cena");
			String tipProjekcije = request.getParameter("tipProjekcije");
			String datum = request.getParameter("datum");
			if (bean.dodajProjekciju(sala, ukMesta, slobMesta, cena, tipProjekcije, datum)) {
				request.getSession().setAttribute("poruka", "Projekcija je uspesno dodata!");
			} else {
				request.getSession().setAttribute("poruka", "Projekcija nije dodata! Sva polja moraju biti popunjena!");
			}
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);

		} else if (request.getParameter("logout") != null) {
			request.getSession().setAttribute("poruka", "");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (request.getParameter("izracunaj")!=null) {
			String odv = request.getParameter("od");
			String dov = request.getParameter("do");
			int prihod = bean.getPrihod(odv,dov);
			request.setAttribute("poruka", "Prihod je: "+prihod);
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("poruka", "Doslo je do greske! Pokusajte ponovo!");
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
		}
	}

}
