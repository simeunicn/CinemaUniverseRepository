package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AdminBean;
import beans.FilmBean;
import beans.LogovanjeBean;

/**
 * Servlet implementation class SiteServlet
 */
@WebServlet("/SiteServlet")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FilmBean bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogovanjeBean LGbean = (LogovanjeBean) request.getSession().getAttribute("LGbean");

		if(request.getParameter("logout")!=null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if(request.getParameter("prikazi")!=null){
			request.getSession().setAttribute("projekcije", bean.pronadjiSveProjekcije());
			request.getRequestDispatcher("/site.jsp").forward(request, response);
		} else if(request.getParameter("pretraga")!=null){
			//neka pretraga
		} else if(request.getParameter("pogledajF")!=null){
			int id = Integer.parseInt(request.getParameter("idFilma"));
			request.getSession().setAttribute("film", bean.pronadjiFilm(id));
			request.getRequestDispatcher("/film.jsp").forward(request, response);
		} else if(request.getParameter("zatvori")!=null){
			request.getRequestDispatcher("/site.jsp").forward(request, response);
		}else if(request.getParameter("sacuvajK")!=null){
			if(LGbean.getLoggedUser()!=null && LGbean!=null){
				String tekst = request.getParameter("textKomentara");
				String datum = request.getParameter("datumKomentara");
				request.getSession().setAttribute("film", bean.dodajKomentar(tekst, datum, LGbean.getLoggedUser().getKorisnikID(), Integer.parseInt(request.getParameter("idFilmaK"))));
				request.getRequestDispatcher("/film.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/film.jsp").forward(request, response);
			}
		} else{
			request.getRequestDispatcher("/site.jsp").forward(request, response);
		}
		
	}

}
