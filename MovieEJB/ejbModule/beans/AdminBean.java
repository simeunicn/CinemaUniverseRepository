package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Film;
import model.Glumac;
import model.Projekcija;

/**
 * Session Bean implementation class AdminBean
 */
@Stateful
@LocalBean
public class AdminBean implements AdminBeanRemote {

	@PersistenceContext
	EntityManager em;

	Film film;
	List<Glumac> glumci;
	List<Projekcija> projekcije;

	/**
	 * Default constructor.
	 */
	public AdminBean() {
		// TODO Auto-generated constructor stub
		glumci = new ArrayList<>();
		projekcije = new ArrayList<>();
	}

	public String sacuvajFilm(String naziv, String opis, String kategorija, String slikaFilma) {
		if (naziv.equals("") || opis.equals("") || kategorija.equals("") || slikaFilma.equals("")) {
			return "Popunite prazna polja!";
		}
		try {
			film = new Film();
			film.setNaziv(naziv);
			film.setOpis(opis);
			film.setKategorija(kategorija);
			film.setSlikaFilma(slikaFilma);
			film.setTrailer("");
			film.setTim8glumacs(glumci);
			film.setTim8projekcijas(projekcije);
			em.persist(film);
			int id = film.getFilmID();
			try {
				boolean imaGlumaca = glumci.isEmpty();
				boolean imaProjekcija = projekcije.isEmpty();
				if (!imaGlumaca) {
					return "Unesite bar jednog glumca za film!";
				}
				if (!imaProjekcija) {
					return "Unesite bar jednu projekciju za film!";
				}
				if (imaGlumaca && imaProjekcija) {
					for (Projekcija p : projekcije) {
						p.setTim8film(film);
						em.persist(p);
					}
					for (Glumac g : glumci) {
						TypedQuery<Glumac> tq = em.createQuery(
								"select g from Glumac g where g.ime=:ime and g.prezime=:prezime", Glumac.class);
						tq.setParameter("ime", g.getIme());
						tq.setParameter("prezime", g.getPrezime());
						if (tq.getResultList().isEmpty()) {
							List<Film> lista = new ArrayList<>();
							lista.add(film);
							g.setTim8films(lista);
							em.persist(g);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				em.remove(film);
				return "Film nije sacuvan!";
			}
			film.setTim8glumacs(glumci);
			film.setTim8projekcijas(projekcije);
			em.merge(film);
			em.flush();
			film = new Film();
			glumci.clear();
			projekcije.clear();
			return "Film je uspesno sacuvan!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Film nije sacuvan!";
		}
	}

	public boolean dodajGlumca(String ime, String prezime, String slika, String biografija) {
		if (ime.equals("") || prezime.equals("") || slika.equals("") || biografija.equals("")) {
			return false;
		}
		Glumac g = new Glumac();
		g.setIme(ime);
		g.setPrezime(prezime);
		g.setSlikaGlumca(slika);
		g.setBiografija(biografija);
		glumci.add(g);
		return true;
	}

	public boolean dodajProjekciju(String sala, String ukupanbrmesta, String preostalaMesta, String cena,
			String tipProjekcije, String datum) {
		if (sala.equals("") || ukupanbrmesta.equals("") || preostalaMesta.equals("") || cena.equals("")
				|| tipProjekcije.equals("") || datum.equals("")) {
			return false;
		}
		Projekcija p = new Projekcija();
		p.setPreostalaMesta(Integer.parseInt(preostalaMesta));
		p.setSala(sala);
		p.setUkupanbrmesta(Integer.parseInt(ukupanbrmesta));
		p.setCena(Integer.parseInt(cena));
		p.setVreme(datum);
		p.setTipProjekcije(tipProjekcije);
		projekcije.add(p);
		return true;
	}

	public List<Film> pronadjiSve() {
		try {
			TypedQuery<Film> tq = em.createQuery("SELECT f FROM Film f", Film.class);
			return tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
