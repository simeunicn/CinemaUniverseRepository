package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TIM8KOMENTAR database table.
 * 
 */
@Entity
@NamedQuery(name="Tim8komentar.findAll", query="SELECT t FROM Tim8komentar t")
public class Tim8komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int komentarID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPostavljanja;

	private String textKomentara;

	//bi-directional many-to-one association to Tim8korisnik
	@ManyToOne
	@JoinColumn(name="KorisnikID")
	private Tim8korisnik tim8korisnik;

	//bi-directional many-to-one association to Tim8film
	@ManyToOne
	@JoinColumn(name="FilmID")
	private Tim8film tim8film;

	public Tim8komentar() {
	}

	public int getKomentarID() {
		return this.komentarID;
	}

	public void setKomentarID(int komentarID) {
		this.komentarID = komentarID;
	}

	public Date getDatumPostavljanja() {
		return this.datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}

	public String getTextKomentara() {
		return this.textKomentara;
	}

	public void setTextKomentara(String textKomentara) {
		this.textKomentara = textKomentara;
	}

	public Tim8korisnik getTim8korisnik() {
		return this.tim8korisnik;
	}

	public void setTim8korisnik(Tim8korisnik tim8korisnik) {
		this.tim8korisnik = tim8korisnik;
	}

	public Tim8film getTim8film() {
		return this.tim8film;
	}

	public void setTim8film(Tim8film tim8film) {
		this.tim8film = tim8film;
	}

}