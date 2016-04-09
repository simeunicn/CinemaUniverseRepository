package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8FILM database table.
 * 
 */
@Entity
@NamedQuery(name="Tim8film.findAll", query="SELECT t FROM Tim8film t")
public class Tim8film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int filmID;

	private String naziv;

	private String opis;

	private String slikaFilma;

	private String trailer;

	//bi-directional many-to-many association to Tim8glumac
	@ManyToMany(mappedBy="tim8films")
	private List<Tim8glumac> tim8glumacs;

	//bi-directional many-to-many association to Tim8kategorija
	@ManyToMany
	@JoinTable(
		name="TIM8KATEGORIJAFILM"
		, joinColumns={
			@JoinColumn(name="FilmID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="KategorijaID")
			}
		)
	private List<Tim8kategorija> tim8kategorijas;

	//bi-directional many-to-one association to Tim8komentar
	@OneToMany(mappedBy="tim8film")
	private List<Tim8komentar> tim8komentars;

	//bi-directional many-to-one association to Tim8projekcija
	@OneToMany(mappedBy="tim8film")
	private List<Tim8projekcija> tim8projekcijas;

	public Tim8film() {
	}

	public int getFilmID() {
		return this.filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSlikaFilma() {
		return this.slikaFilma;
	}

	public void setSlikaFilma(String slikaFilma) {
		this.slikaFilma = slikaFilma;
	}

	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public List<Tim8glumac> getTim8glumacs() {
		return this.tim8glumacs;
	}

	public void setTim8glumacs(List<Tim8glumac> tim8glumacs) {
		this.tim8glumacs = tim8glumacs;
	}

	public List<Tim8kategorija> getTim8kategorijas() {
		return this.tim8kategorijas;
	}

	public void setTim8kategorijas(List<Tim8kategorija> tim8kategorijas) {
		this.tim8kategorijas = tim8kategorijas;
	}

	public List<Tim8komentar> getTim8komentars() {
		return this.tim8komentars;
	}

	public void setTim8komentars(List<Tim8komentar> tim8komentars) {
		this.tim8komentars = tim8komentars;
	}

	public Tim8komentar addTim8komentar(Tim8komentar tim8komentar) {
		getTim8komentars().add(tim8komentar);
		tim8komentar.setTim8film(this);

		return tim8komentar;
	}

	public Tim8komentar removeTim8komentar(Tim8komentar tim8komentar) {
		getTim8komentars().remove(tim8komentar);
		tim8komentar.setTim8film(null);

		return tim8komentar;
	}

	public List<Tim8projekcija> getTim8projekcijas() {
		return this.tim8projekcijas;
	}

	public void setTim8projekcijas(List<Tim8projekcija> tim8projekcijas) {
		this.tim8projekcijas = tim8projekcijas;
	}

	public Tim8projekcija addTim8projekcija(Tim8projekcija tim8projekcija) {
		getTim8projekcijas().add(tim8projekcija);
		tim8projekcija.setTim8film(this);

		return tim8projekcija;
	}

	public Tim8projekcija removeTim8projekcija(Tim8projekcija tim8projekcija) {
		getTim8projekcijas().remove(tim8projekcija);
		tim8projekcija.setTim8film(null);

		return tim8projekcija;
	}

}