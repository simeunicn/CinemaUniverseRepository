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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	FilmBean filmBean;
	
	@EJB
	LogovanjeBean bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		if(request.getParameter("register")!=null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String email = request.getParameter("email");
			String uloga = "korisnik";
			if(username.equals("") || password.equals("")){
				request.getSession().setAttribute("poruka", "Registracija nije uspela! Molimo vas popunite prazna polja!");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			}else{
				if(bean.registracija(email, ime, password, prezime, uloga, username)){
					boolean registrovan = true;
					request.getSession().setAttribute("registrovan", registrovan);
					request.getSession().setAttribute("projekcije", filmBean.pronadjiSveProjekcije());
					request.getSession().setAttribute("LGbean", bean);
					request.getSession().setAttribute("nazivKomponente", "Logout");
					request.getSession().setAttribute("poruka", "Zdravo "+ime+" ");
					request.getRequestDispatcher("/site.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("poruka", "Registracija nije uspela! Molimo vas pokusajte ponovo!");
					request.getRequestDispatcher("/registration.jsp").forward(request, response);
				}
			}
		}else if(request.getParameter("cancel")!=null){
			request.getSession().setAttribute("poruka", "");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("poruka", "Doslo je do greske! Molimo vas pokusajte ponovo!");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}
}
