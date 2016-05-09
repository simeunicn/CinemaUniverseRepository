package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import model.Film;
import model.Glumac;
import model.Komentar;
import model.Korisnik;
import model.Projekcija;
import model.Rezervacija;

/**
 * Session Bean implementation class FilmBean
 */
@Stateless
@LocalBean
public class FilmBean implements FilmBeanRemote {

	@PersistenceContext
	EntityManager em;

	@Resource
	private SessionContext sc;

	/**
	 * Default constructor.
	 */
	public FilmBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Film> pronadjiSveFilmove() {
		List<Film> lista = em.createQuery("select f from Film f", Film.class).getResultList();
		return lista;
	}

	public List<Projekcija> pronadjiSveProjekcije() {
		List<Projekcija> lista = em.createQuery("select p from Projekcija p", Projekcija.class).getResultList();
		return lista;
	}

	public List<Projekcija> filtrirajProjekcije(String brojMesta, String cenaK) {
		boolean filterBroj = true;
		boolean filterCena = true;
		int broj = 0;
		int cena = 0;
		if (brojMesta.equalsIgnoreCase("Broj mesta...") || brojMesta.equals("")) {
			filterBroj = false;
		} else{
			try{
				broj = Integer.parseInt(brojMesta);
			}catch(Exception e){
				filterBroj = false;
			}
		}
		if (cenaK.equalsIgnoreCase("Cena...") || cenaK.equals("")) {
			filterCena = false;
		} else{
			try{
				cena = Integer.parseInt(cenaK);
			}catch(Exception e){
				filterCena = false;
			}
		}
		
		
		List<Projekcija> lista = new ArrayList<>();
		if(filterBroj && filterCena){
			//po broju i po ceni
			TypedQuery<Projekcija> tq = em.createQuery("select p from Projekcija p where p.preostalaMesta >= :broj and p.cena <= :cena ", Projekcija.class);
			tq.setParameter("broj", broj);
			tq.setParameter("cena", cena);
			lista = tq.getResultList();
		} else if(filterBroj && !filterCena){
			//samo po broju
			TypedQuery<Projekcija> tq = em.createQuery("select p from Projekcija p where p.preostalaMesta >= :broj", Projekcija.class);
			tq.setParameter("broj", broj);
			lista = tq.getResultList();
		} else if(!filterBroj && filterCena){
			//samo po ceni
			TypedQuery<Projekcija> tq = em.createQuery("select p from Projekcija p where p.cena <= :cena ", Projekcija.class);
			tq.setParameter("cena", cena);
			lista = tq.getResultList();
		} else{
			//sve vrati
			lista = em.createQuery("select p from Projekcija p", Projekcija.class).getResultList();
		}
		return lista;
	}

	public boolean prodajKarte(int num, int idPr) {
		// UserTransaction ut = sc.getUserTransaction();
		try {
			// ut.begin();
			Projekcija proj = em.find(Projekcija.class, idPr);
			proj.setPreostalaMesta(proj.getPreostalaMesta() - num);
			em.merge(proj);
			// ut.commit();
			return true;
		} catch (Exception e) {
			try {
				// ut.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	public Film pronadjiFilm(int id) {
		Film f = em.find(Film.class, id);
		TypedQuery<Komentar> tq = em.createQuery("select k from Komentar k where k.tim8film.filmID = :id",
				Komentar.class);
		tq.setParameter("id", id);
		f.setTim8komentars(tq.getResultList());
		em.flush();
		return f;
	}

	public Film dodajKomentar(String tekst, String datum, int idK, int idF) {
		Film f = em.find(Film.class, idF);
		Komentar k = new Komentar();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateS = dateFormat.format(date);
		k.setDatumPostavljanja(dateS);
		k.setTextKomentara(tekst);
		k.setTim8film(f);
		k.setTim8korisnik(em.find(Korisnik.class, idK));
		em.persist(k);
		TypedQuery<Komentar> tq = em.createQuery("select k from Komentar k where k.tim8film.filmID = :id",
				Komentar.class);
		tq.setParameter("id", idF);
		f.setTim8komentars(tq.getResultList());
		return f;

	}

	public List<Film> pretragaPoKategoriji(String kat) {
		TypedQuery<Film> q = em.createQuery("select f from Film f where f.kategorija LIKE :kat", Film.class);
		// System.out.println("BEAN KAT:"+kat);
		q.setParameter("kat", kat);
		return q.getResultList();
	}

}
