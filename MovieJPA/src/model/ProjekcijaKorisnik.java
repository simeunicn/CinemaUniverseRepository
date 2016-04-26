package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIM8PROJEKCIJAKORISNIK database table.
 * 
 */
@Entity
@Table(name="TIM8PROJEKCIJAKORISNIK")
@NamedQuery(name="ProjekcijaKorisnik.findAll", query="SELECT p FROM ProjekcijaKorisnik p")
public class ProjekcijaKorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pkid;

	private int ocena;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="KorisnikID")
	private Korisnik tim8korisnik;

	//bi-directional many-to-one association to Projekcija
	@ManyToOne
	@JoinColumn(name="ProjekcijaID")
	private Projekcija tim8projekcija;

	public ProjekcijaKorisnik() {
	}

	public int getPkid() {
		return this.pkid;
	}

	public void setPkid(int pkid) {
		this.pkid = pkid;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Korisnik getTim8korisnik() {
		return this.tim8korisnik;
	}

	public void setTim8korisnik(Korisnik tim8korisnik) {
		this.tim8korisnik = tim8korisnik;
	}

	public Projekcija getTim8projekcija() {
		return this.tim8projekcija;
	}

	public void setTim8projekcija(Projekcija tim8projekcija) {
		this.tim8projekcija = tim8projekcija;
	}

}