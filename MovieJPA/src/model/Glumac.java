package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8GLUMAC database table.
 * 
 */
@Entity
@Table(name="TIM8GLUMAC")
@NamedQuery(name="Glumac.findAll", query="SELECT g FROM Glumac g")
public class Glumac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int glumacID;

	private String biografija;

	private String ime;

	private String prezime;

	private String slikaGlumca;

	//bi-directional many-to-many association to Film
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="TIM8GLUMACFILM"
		, joinColumns={
			@JoinColumn(name="GlumacID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FilmID")
			}
		)
	private List<Film> tim8films;

	public Glumac() {
	}

	public int getGlumacID() {
		return this.glumacID;
	}

	public void setGlumacID(int glumacID) {
		this.glumacID = glumacID;
	}

	public String getBiografija() {
		return this.biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
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

	public List<Film> getTim8films() {
		return this.tim8films;
	}

	public void setTim8films(List<Film> tim8films) {
		this.tim8films = tim8films;
	}

}