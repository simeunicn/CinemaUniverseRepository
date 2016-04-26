package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8KORISNIK database table.
 * 
 */
@Entity
@Table(name="TIM8KORISNIK")
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int korisnikID;

	private String email;

	private String imeKorisnika;

	private String password;

	private String prezimeKorisnika;

	private String uloga;

	private String username;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="tim8korisnik")
	private List<Komentar> tim8komentars;

	//bi-directional many-to-one association to ProjekcijaKorisnik
	@OneToMany(mappedBy="tim8korisnik")
	private List<ProjekcijaKorisnik> tim8projekcijakorisniks;

	public Korisnik() {
	}

	public int getKorisnikID() {
		return this.korisnikID;
	}

	public void setKorisnikID(int korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImeKorisnika() {
		return this.imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezimeKorisnika() {
		return this.prezimeKorisnika;
	}

	public void setPrezimeKorisnika(String prezimeKorisnika) {
		this.prezimeKorisnika = prezimeKorisnika;
	}

	public String getUloga() {
		return this.uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Komentar> getTim8komentars() {
		return this.tim8komentars;
	}

	public void setTim8komentars(List<Komentar> tim8komentars) {
		this.tim8komentars = tim8komentars;
	}

	public Komentar addTim8komentar(Komentar tim8komentar) {
		getTim8komentars().add(tim8komentar);
		tim8komentar.setTim8korisnik(this);

		return tim8komentar;
	}

	public Komentar removeTim8komentar(Komentar tim8komentar) {
		getTim8komentars().remove(tim8komentar);
		tim8komentar.setTim8korisnik(null);

		return tim8komentar;
	}

	public List<ProjekcijaKorisnik> getTim8projekcijakorisniks() {
		return this.tim8projekcijakorisniks;
	}

	public void setTim8projekcijakorisniks(List<ProjekcijaKorisnik> tim8projekcijakorisniks) {
		this.tim8projekcijakorisniks = tim8projekcijakorisniks;
	}

	public ProjekcijaKorisnik addTim8projekcijakorisnik(ProjekcijaKorisnik tim8projekcijakorisnik) {
		getTim8projekcijakorisniks().add(tim8projekcijakorisnik);
		tim8projekcijakorisnik.setTim8korisnik(this);

		return tim8projekcijakorisnik;
	}

	public ProjekcijaKorisnik removeTim8projekcijakorisnik(ProjekcijaKorisnik tim8projekcijakorisnik) {
		getTim8projekcijakorisniks().remove(tim8projekcijakorisnik);
		tim8projekcijakorisnik.setTim8korisnik(null);

		return tim8projekcijakorisnik;
	}

}