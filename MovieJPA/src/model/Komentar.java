package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TIM8KOMENTAR database table.
 * 
 */
@Entity
@Table(name="TIM8KOMENTAR")
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int komentarID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPostavljanja;

	private String textKomentara;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="KorisnikID")
	private Korisnik tim8korisnik;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="FilmID")
	private Film tim8film;

	public Komentar() {
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

	public Korisnik getTim8korisnik() {
		return this.tim8korisnik;
	}

	public void setTim8korisnik(Korisnik tim8korisnik) {
		this.tim8korisnik = tim8korisnik;
	}

	public Film getTim8film() {
		return this.tim8film;
	}

	public void setTim8film(Film tim8film) {
		this.tim8film = tim8film;
	}

}