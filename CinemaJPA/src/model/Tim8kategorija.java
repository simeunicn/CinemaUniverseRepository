package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8KATEGORIJA database table.
 * 
 */
@Entity
@NamedQuery(name="Tim8kategorija.findAll", query="SELECT t FROM Tim8kategorija t")
public class Tim8kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int kategorijaID;

	private String opisKategorije;

	//bi-directional many-to-many association to Tim8film
	@ManyToMany(mappedBy="tim8kategorijas")
	private List<Tim8film> tim8films;

	public Tim8kategorija() {
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

	public List<Tim8film> getTim8films() {
		return this.tim8films;
	}

	public void setTim8films(List<Tim8film> tim8films) {
		this.tim8films = tim8films;
	}

}