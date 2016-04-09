package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8GLUMAC database table.
 * 
 */
@Entity
@NamedQuery(name="Tim8glumac.findAll", query="SELECT t FROM Tim8glumac t")
public class Tim8glumac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int glumacID;

	private String ime;

	private String prezime;

	private String slikaGlumca;

	//bi-directional many-to-many association to Tim8film
	@ManyToMany
	@JoinTable(
		name="TIM8GLUMACFILM"
		, joinColumns={
			@JoinColumn(name="GlumacID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FilmID")
			}
		)
	private List<Tim8film> tim8films;

	public Tim8glumac() {
	}

	public int getGlumacID() {
		return this.glumacID;
	}

	public void setGlumacID(int glumacID) {
		this.glumacID = glumacID;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSlikaGlumca() {
		return this.slikaGlumca;
	}

	public void setSlikaGlumca(String slikaGlumca) {
		this.slikaGlumca = slikaGlumca;
	}

	public List<Tim8film> getTim8films() {
		return this.tim8films;
	}

	public void setTim8films(List<Tim8film> tim8films) {
		this.tim8films = tim8films;
	}

}