package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.Film;
import model.Glumac;
import model.Komentar;
import model.Korisnik;
import model.Projekcija;

/**
 * Session Bean implementation class FilmBean
 */
@Stateless
@LocalBean
public class FilmBean implements FilmBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public FilmBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<Film> pronadjiSveFilmove(){
    	List<Film> lista = em.createQuery("select f from Film f", Film.class).getResultList();
    	return lista;
    }
    
    public List<Projekcija> pronadjiSveProjekcije(){
    	List<Projekcija> lista = em.createQuery("select p from Projekcija p", Projekcija.class).getResultList();
    	return lista;
    }
    
    public Film pronadjiFilm(int id){
    	Film f = em.find(Film.class, id);
    	TypedQuery<Komentar> tq = em.createQuery("select k from Komentar k where k.tim8film.filmID = :id", Komentar.class);
    	tq.setParameter("id", id);
    	f.setTim8komentars(tq.getResultList());
    	em.flush();
    	return f;
    }
    
    public Film dodajKomentar(String tekst, String datum,int idK, int idF){
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
    	TypedQuery<Komentar> tq = em.createQuery("select k from Komentar k where k.tim8film.filmID = :id", Komentar.class);
    	tq.setParameter("id", idF);
    	f.setTim8komentars(tq.getResultList());
    	return f;
    	
    	
    }
    
    public List<Film> pretragaPoKategoriji(String kat){
    	TypedQuery<Film> q = em.createQuery("select f from Film f where f.kategorija LIKE :kat",Film.class);
    	//System.out.println("BEAN KAT:"+kat);
    	q.setParameter("kat", kat);
    	return q.getResultList();
    }

}
