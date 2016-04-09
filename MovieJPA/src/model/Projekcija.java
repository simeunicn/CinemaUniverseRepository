package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	private int preostalaMesta;

	private String sala;

	private int ukupanbrmesta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vreme;

	//bi-directional many-to-one association to Film
	@ManyToOne
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

	public int getUkupanbrmesta() {
		return this.ukupanbrmesta;
	}

	public void setUkupanbrmesta(int ukupanbrmesta) {
		this.ukupanbrmesta = ukupanbrmesta;
	}

	public Date getVreme() {
		return this.vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public Film getTim8film() {
		return this.tim8film;
	}

	public void setTim8film(Film tim8film) {
		this.tim8film = tim8film;
	}

}