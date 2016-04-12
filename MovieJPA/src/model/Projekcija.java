package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private String sala;

	private String tipProjekcije;

	private int ukupanbrmesta;

	private String vreme;

	//bi-directional many-to-one association to Film
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FilmID")
	private Film tim8film;

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

}