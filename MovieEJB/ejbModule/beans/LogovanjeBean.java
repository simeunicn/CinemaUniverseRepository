package beans;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.*;

/**
 * Session Bean implementation class LogovanjeBean
 */
@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class LogovanjeBean implements LogovanjeBeanRemote {

	@PersistenceContext
	EntityManager em;

	@Resource
	private SessionContext sc;

	private Korisnik loggedUser;

	public LogovanjeBean() {
		// TODO Auto-generated constructor stub
	}

	public String login(String username, String password) {
		TypedQuery<Korisnik> tq = em.createQuery("select k from Korisnik k where k.username = :u and k.password = :p",
				Korisnik.class);
		tq.setParameter("u", username);
		tq.setParameter("p", password);

		try {
			loggedUser = tq.getSingleResult();
			String uloga = loggedUser.getUloga();
			return uloga;
		} catch (Exception e) {
			loggedUser = null;
			e.printStackTrace();
			return "nije-registrovan";
		}
	}

	public boolean registracija(String email, String imeKorisnika, String password, String prezimeKorisnika,
			String uloga, String username) {
		try {
			UserTransaction ut = sc.getUserTransaction();
			ut.begin();
			loggedUser = new Korisnik();
			loggedUser.setEmail(email);
			loggedUser.setImeKorisnika(imeKorisnika);
			loggedUser.setPassword(password);
			loggedUser.setPrezimeKorisnika(prezimeKorisnika);
			loggedUser.setUloga(uloga);
			loggedUser.setUsername(username);
			em.persist(loggedUser);
			ut.commit();
			return true;
		} catch (Exception e) {
			loggedUser = null;
			e.printStackTrace();
			try {
				sc.getUserTransaction().rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	public void sacuvajOcenu(int idkor, int idproj, int ocena) {
		TypedQuery<ProjekcijaKorisnik> tq = em.createQuery(
				"select pk from ProjekcijaKorisnik pk where pk.tim8korisnik.korisnikID=:kid and pk.tim8projekcija.projekcijaID=:pid",
				ProjekcijaKorisnik.class);
		tq.setParameter("kid", idkor);
		tq.setParameter("pid", idproj);

		try {
			List<ProjekcijaKorisnik> lpk = tq.getResultList();
			UserTransaction ut = sc.getUserTransaction();
			ut.begin();
			ProjekcijaKorisnik pk = new ProjekcijaKorisnik();
			if (lpk.size() == 0) {
				Korisnik tim8korisnik = em.find(Korisnik.class, idkor);
				Projekcija tim8projekcija = em.find(Projekcija.class, idproj);
				pk.setTim8korisnik(tim8korisnik);
				pk.setTim8projekcija(tim8projekcija);
				pk.setOcena(ocena);
				em.persist(pk);
			} else {
				pk = lpk.get(0);
				pk.setOcena(ocena);
				em.merge(pk);
			}
			ut.commit();
			updateProsecneOcene(pk);
		} catch (Exception e) {
			try {
				sc.getUserTransaction().rollback();
			} catch (IllegalStateException e1) {
			} catch (SecurityException e1) {
			} catch (SystemException e1) {
			}
			e.printStackTrace();
		}
	}

	private void updateProsecneOcene(ProjekcijaKorisnik pk) {
		int count = getCountOcenjeneProjekcije(pk);
		long sum = getSumuOcenaZaProjekciju(pk);
		double d = 0.0;
		if (count != 0) {
			DecimalFormat df = new DecimalFormat("#.00");
			d = ((double) sum) / ((double) count);
			String ds = df.format(d);
			d = Double.parseDouble(ds);
		}
		Projekcija p = em.find(Projekcija.class, pk.getTim8projekcija().getProjekcijaID());
		p.setProsecnaOcena(d);
		UserTransaction ut = sc.getUserTransaction();

		try {
			ut.begin();
			em.merge(p);
			ut.commit();
		} catch (Exception e) {
			try {
				ut.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			System.out.println("Greska u updateProsecneOcene");
			e.printStackTrace();
		}

	}

	public List<Projekcija> getTopProjekcije() {
		TypedQuery q = em.createQuery("select p from Projekcija p order by ProsecnaOcena desc", Projekcija.class);
		return q.getResultList();
	}

	private long getSumuOcenaZaProjekciju(ProjekcijaKorisnik pk) {
		Query tq = em.createQuery(
				"select sum(ocena) from ProjekcijaKorisnik pk where pkid.tim8projekcija.projekcijaID=:par");
		tq.setParameter("par", pk.getTim8projekcija().getProjekcijaID());
		return (long) tq.getSingleResult();
	}

	public int getCountOcenjeneProjekcije(ProjekcijaKorisnik pk) {
		TypedQuery<ProjekcijaKorisnik> tq = em.createQuery(
				"select pk from ProjekcijaKorisnik pk where pkid.tim8projekcija.projekcijaID=:par",
				ProjekcijaKorisnik.class);
		tq.setParameter("par", pk.getTim8projekcija().getProjekcijaID());
		return tq.getResultList().size();
	}
	
	public boolean TryToInsertRezervacije(int num, int p, int k){
		Projekcija proj = em.find(Projekcija.class, p);
		Korisnik kor = em.find(Korisnik.class, k);
		if(proj.getPreostalaMesta()>num){
			return insertRezervacije(num,proj,kor);
		}
		return false;
	}
	
	private boolean insertRezervacije(int num,Projekcija proj, Korisnik kor){
		UserTransaction ut = sc.getUserTransaction();
		try {
			ut.begin();
			Rezervacija rez[] = new Rezervacija[num];
			for(int i = 0;i<num;i++){
				rez[i] = new Rezervacija();
				rez[i].setTim8korisnik(kor);
				rez[i].setTim8projekcija(proj);
				em.persist(rez[i]);
			}
			proj.setPreostalaMesta(proj.getPreostalaMesta()-num);
			em.merge(proj);
			ut.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				ut.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	public void justContinue() {
		loggedUser = null;
	}

	public void logout() {
		loggedUser = null;
	}

	public Korisnik getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Korisnik loggedUser) {
		this.loggedUser = loggedUser;
	}

}
