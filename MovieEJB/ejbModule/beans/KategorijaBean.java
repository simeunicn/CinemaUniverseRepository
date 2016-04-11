package beans;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Kategorija;

/**
 * Session Bean implementation class KategorijaBean
 */
@Singleton
@LocalBean
@Startup
public class KategorijaBean implements KategorijaBeanRemote {

	@PersistenceContext
	EntityManager em;

	private HashMap<Integer, String> kategorije;

	public KategorijaBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void post() {
		try {
			kategorije = new HashMap<Integer, String>();
			TypedQuery<Kategorija> tq = em.createQuery("select k from Kategorija k", Kategorija.class);
			for (Kategorija k : tq.getResultList()) {
				kategorije.put(k.getKategorijaID(), k.getOpisKategorije());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, String> getKategorije() {
		return kategorije;
	}

	public void setKategorije(HashMap<Integer, String> kategorije) {
		this.kategorije = kategorije;
	}

}
