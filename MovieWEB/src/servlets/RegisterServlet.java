package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LogovanjeBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
			//String uloga = "admin";
			if(username.equals("") || password.equals("")){
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			}else{
				if(bean.registracija(email, ime, password, prezime, uloga, username)){
					request.getSession().setAttribute("LGbean", bean);
					request.getSession().setAttribute("nazivKomponente", "Logout");
					request.getRequestDispatcher("/site.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/registration.jsp").forward(request, response);
				}
			}
		}else if(request.getParameter("cancel")!=null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}
}
