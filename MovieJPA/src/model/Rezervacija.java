package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIM8REZERVACIJA database table.
 * 
 */
@Entity
@Table(name="TIM8REZERVACIJA")
@NamedQuery(name="Rezervacija.findAll", query="SELECT r FROM Rezervacija r")
public class Rezervacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rezervacijaID;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="KorisnikID")
	private Korisnik tim8korisnik;

	//bi-directional many-to-one association to Projekcija
	@ManyToOne
	@JoinColumn(name="ProjekcijaID")
	private Projekcija tim8projekcija;

	public Rezervacija() {
	}

	public int getRezervacijaID() {
		return this.rezervacijaID;
	}

	public void setRezervacijaID(int rezervacijaID) {
		this.rezervacijaID = rezervacijaID;
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