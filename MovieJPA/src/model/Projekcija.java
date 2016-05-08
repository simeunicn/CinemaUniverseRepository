package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8PROJEKCIJA database table.
 * 
 */
@Entity
@Table(name="TIM8PROJEKCIJA")
@NamedQuery(name="Projekcija.findAll", query="SELECT p FROM Projekcija p")
public class Projekcija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projekcijaID;

	private int cena;

	private int preostalaMesta;

	private double prosecnaOcena;

	private String sala;

	private String tipProjekcije;

	private int ukupanbrmesta;

	private String vreme;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="FilmID")
	private Film tim8film;

	//bi-directional many-to-one association to ProjekcijaKorisnik
	@OneToMany(mappedBy="tim8projekcija")
	private List<ProjekcijaKorisnik> tim8projekcijakorisniks;

	public Projekcija() {
	}

	public int getProjekcijaID() {
		return this.projekcijaID;
	}

	public void setProjekcijaID(int projekcijaID) {
		this.projekcijaID = projekcijaID;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getPreostalaMesta() {
		return this.preostalaMesta;
	}

	public void setPreostalaMesta(int preostalaMesta) {
		this.preostalaMesta = preostalaMesta;
	}

	public double getProsecnaOcena() {
		return this.prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTipProjekcije() {
		return this.tipProjekcije;
	}

	public void setTipProjekcije(String tipProjekcije) {
		this.tipProjekcije = tipProjekcije;
	}

	public int getUkupanbrmesta() {
		return this.ukupanbrmesta;
	}

	public void setUkupanbrmesta(int ukupanbrmesta) {
		this.ukupanbrmesta = ukupanbrmesta;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Film getTim8film() {
		return this.tim8film;
	}

	public void setTim8film(Film tim8film) {
		this.tim8film = tim8film;
	}

	public List<ProjekcijaKorisnik> getTim8projekcijakorisniks() {
		return this.tim8projekcijakorisniks;
	}

	public void setTim8projekcijakorisniks(List<ProjekcijaKorisnik> tim8projekcijakorisniks) {
		this.tim8projekcijakorisniks = tim8projekcijakorisniks;
	}

	public ProjekcijaKorisnik addTim8projekcijakorisnik(ProjekcijaKorisnik tim8projekcijakorisnik) {
		getTim8projekcijakorisniks().add(tim8projekcijakorisnik);
		tim8projekcijakorisnik.setTim8projekcija(this);

		return tim8projekcijakorisnik;
	}

	public ProjekcijaKorisnik removeTim8projekcijakorisnik(ProjekcijaKorisnik tim8projekcijakorisnik) {
		getTim8projekcijakorisniks().remove(tim8projekcijakorisnik);
		tim8projekcijakorisnik.setTim8projekcija(null);

		return tim8projekcijakorisnik;
	}

}