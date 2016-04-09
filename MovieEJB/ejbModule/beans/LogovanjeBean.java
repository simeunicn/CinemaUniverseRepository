package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.*;

/**
 * Session Bean implementation class LogovanjeBean
 */
@Stateful
@LocalBean
public class LogovanjeBean implements LogovanjeBeanRemote {

	@PersistenceContext
	EntityManager em;

	private Korisnik loggedUser;

	public LogovanjeBean() {
		// TODO Auto-generated constructor stub
	}

	public boolean login(String username, String password) {

		TypedQuery<Korisnik> tq = em.createQuery(
				"select k from Korisnik k where k.username = :u and k.password = :p", Korisnik.class);
		tq.setParameter("u", username);
		tq.setParameter("p", password);

		try {
			loggedUser = tq.getSingleResult();
			return true;
		} catch (Exception e) {
			loggedUser = null;
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registracija(String email, String imeKorisnika, String password, String prezimeKorisnika, String uloga, String username){
		try {
			loggedUser = new Korisnik();
			loggedUser.setEmail(email);
			loggedUser.setImeKorisnika(imeKorisnika);
			loggedUser.setPassword(password);
			loggedUser.setPrezimeKorisnika(prezimeKorisnika);
			loggedUser.setUloga(uloga);
			loggedUser.setUsername(username);
			em.persist(loggedUser);
			return true;
		} catch (Exception e) {
			loggedUser = null;
			e.printStackTrace();
			return false;
		}
	}

}
