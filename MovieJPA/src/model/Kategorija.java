package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8KATEGORIJA database table.
 * 
 */
@Entity
@Table(name="TIM8KATEGORIJA")
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int kategorijaID;

	private String opisKategorije;

	//bi-directional many-to-many association to Film
	@ManyToMany(mappedBy="tim8kategorijas")
	private List<Film> tim8films;

	public Kategorija() {
	}

	public int getKategorijaID() {
		return this.kategorijaID;
	}

	public void setKategorijaID(int kategorijaID) {
		this.kategorijaID = kategorijaID;
	}

	public String getOpisKategorije() {
		return this.opisKategorije;
	}

	public void setOpisKategorije(String opisKategorije) {
		this.opisKategorije = opisKategorije;
	}

	public List<Film> getTim8films() {
		return this.tim8films;
	}

	public void setTim8films(List<Film> tim8films) {
		this.tim8films = tim8films;
	}

}