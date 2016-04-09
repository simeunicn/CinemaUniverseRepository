package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8KORISNIK database table.
 * 
 */
@Entity
@NamedQuery(name="Tim8korisnik.findAll", query="SELECT t FROM Tim8korisnik t")
public class Tim8korisnik implements Serializable {
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

	//bi-directional many-to-one association to Tim8komentar
	@OneToMany(mappedBy="tim8korisnik")
	private List<Tim8komentar> tim8komentars;

	public Tim8korisnik() {
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

	public List<Tim8komentar> getTim8komentars() {
		return this.tim8komentars;
	}

	public void setTim8komentars(List<Tim8komentar> tim8komentars) {
		this.tim8komentars = tim8komentars;
	}

	public Tim8komentar addTim8komentar(Tim8komentar tim8komentar) {
		getTim8komentars().add(tim8komentar);
		tim8komentar.setTim8korisnik(this);

		return tim8komentar;
	}

	public Tim8komentar removeTim8komentar(Tim8komentar tim8komentar) {
		getTim8komentars().remove(tim8komentar);
		tim8komentar.setTim8korisnik(null);

		return tim8komentar;
	}

}