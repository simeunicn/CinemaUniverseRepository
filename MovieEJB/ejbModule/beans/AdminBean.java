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
    
    public int sacuvajFilm(String naziv, String opis, String kategorija, String slikaFilma, String trailer){
    	try{
    		film = new Film();
    		film.setNaziv(naziv);
    		film.setOpis(opis);
    		film.setKategorija(kategorija);
    		film.setSlikaFilma(slikaFilma);
    		film.setTrailer(trailer);
    		film.setTim8glumacs(glumci);
    		film.setTim8projekcijas(projekcije);
    		em.persist(film);
    		em.flush();
    		try{
	    		if(!projekcije.isEmpty()){
	    			for(Projekcija p : projekcije){
	    				p.setTim8film(film);
	    				em.persist(p);
	    			}
	    		}/*else{
	    			System.out.println("prazne projekcije");
	    		}*/
	    		if(!glumci.isEmpty()){
	    			for(Glumac g : glumci){
	    				TypedQuery<Glumac> tq = em.createQuery("select g from Glumac g where g.ime=:ime and g.prezime=:prezime", Glumac.class);
	    				tq.setParameter("ime", g.getIme());
	    				tq.setParameter("prezime", g.getPrezime());
	    				if(tq.getResultList().isEmpty()){
	    					List<Film> lista = new ArrayList<>();
	    					lista.add(film);
	    					g.setTim8films(lista);
	    					em.persist(g);
	    				}
	    			}
	    		}/*
	    		else{
	    			System.out.println("prazni glumci");
	    		}*/
    		}catch(Exception e){
    			e.printStackTrace();
    			em.remove(film);
    			return -1;
    		}
    		em.flush();
    		film = new Film();
    		glumci.clear();
    		projekcije.clear();
    		return film.getFilmID();
    	}catch(Exception e){
    		e.printStackTrace();
    		return -1;
    	}
    }
    
    public void dodajGlumca(String ime, String prezime, String slika, String biografija){
		Glumac g = new Glumac();
		g.setIme(ime);
		g.setPrezime(prezime);
		g.setSlikaGlumca(slika);
		g.setBiografija(biografija);
		glumci.add(g);
    }
    
    public void dodajProjekciju(String sala, String ukupanbrmesta, String preostalaMesta, String cena, String tipProjekcije, String datum){
		Projekcija p = new Projekcija();
		p.setPreostalaMesta(Integer.parseInt(preostalaMesta));
		p.setSala(sala);
		p.setUkupanbrmesta(Integer.parseInt(ukupanbrmesta));
		p.setCena(Integer.parseInt(cena));
		p.setVreme(datum);
		p.setTipProjekcije(tipProjekcije);
		projekcije.add(p);
    }
    
    public List<Film> pronadjiSve(){
    	try{
    		TypedQuery<Film> tq = em.createQuery("SELECT f FROM Film f",Film.class);
    		return tq.getResultList();
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

}
