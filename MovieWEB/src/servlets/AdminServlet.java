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
    
    /*rad sa slikama
     * BufferedImage img = ImageIO.read(new URL("http://stackoverflow.com/content/img/so/logo.png"));
     * */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminBean bean = (AdminBean) request.getSession().getAttribute("bean");
		if(bean==null){
			try {
				bean = (AdminBean) new InitialContext().lookup("java:global/MovieEAR/MovieEJB/AdminBean!beans.AdminBean");
			} catch (NamingException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("bean", bean);
		}
		
		if(request.getParameter("sacuvajF")!=null){
			
			String naziv = request.getParameter("naziv");
			String opis = request.getParameter("opis");
			String kategorija = request.getParameter("kategorija");
			String slika = request.getParameter("slika");
			String trailer = request.getParameter("trailer");
			bean.sacuvajFilm(naziv, opis, kategorija, slika, trailer);
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
			
			
		}else if(request.getParameter("sacuvajG")!=null){
			
			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String slika = request.getParameter("slika");
			String biografija = request.getParameter("biografija");
			bean.dodajGlumca(ime, prezime, slika, biografija);
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
			
		}else if(request.getParameter("sacuvajP")!=null){
			
			String sala = request.getParameter("sala");
			String ukMesta = request.getParameter("ukupnoMesta");
			String slobMesta = request.getParameter("slobodnaMesta");
			String cena = request.getParameter("cena");
			String tipProjekcije = request.getParameter("tipProjekcije");
			String datum = request.getParameter("datum");
			bean.dodajProjekciju(sala, ukMesta, slobMesta, cena, tipProjekcije, datum);
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
			
		}else if(request.getParameter("logout")!=null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		else{
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
		}
	}

}
