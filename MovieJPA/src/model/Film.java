package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIM8FILM database table.
 * 
 */
@Entity
@Table(name="TIM8FILM")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int filmID;

	private String naziv;

	private String opis;

	private String slikaFilma;

	private String trailer;

	//bi-directional many-to-many association to Glumac
	@ManyToMany(mappedBy="tim8films")
	private List<Glumac> tim8glumacs;

	//bi-directional many-to-many association to Kategorija
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
	private List<Kategorija> tim8kategorijas;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="tim8film")
	private List<Komentar> tim8komentars;

	//bi-directional many-to-one association to Projekcija
	@OneToMany(mappedBy="tim8film")
	private List<Projekcija> tim8projekcijas;

	public Film() {
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

	public List<Glumac> getTim8glumacs() {
		return this.tim8glumacs;
	}

	public void setTim8glumacs(List<Glumac> tim8glumacs) {
		this.tim8glumacs = tim8glumacs;
	}

	public List<Kategorija> getTim8kategorijas() {
		return this.tim8kategorijas;
	}

	public void setTim8kategorijas(List<Kategorija> tim8kategorijas) {
		this.tim8kategorijas = tim8kategorijas;
	}

	public List<Komentar> getTim8komentars() {
		return this.tim8komentars;
	}

	public void setTim8komentars(List<Komentar> tim8komentars) {
		this.tim8komentars = tim8komentars;
	}

	public Komentar addTim8komentar(Komentar tim8komentar) {
		getTim8komentars().add(tim8komentar);
		tim8komentar.setTim8film(this);

		return tim8komentar;
	}

	public Komentar removeTim8komentar(Komentar tim8komentar) {
		getTim8komentars().remove(tim8komentar);
		tim8komentar.setTim8film(null);

		return tim8komentar;
	}

	public List<Projekcija> getTim8projekcijas() {
		return this.tim8projekcijas;
	}

	public void setTim8projekcijas(List<Projekcija> tim8projekcijas) {
		this.tim8projekcijas = tim8projekcijas;
	}

	public Projekcija addTim8projekcija(Projekcija tim8projekcija) {
		getTim8projekcijas().add(tim8projekcija);
		tim8projekcija.setTim8film(this);

		return tim8projekcija;
	}

	public Projekcija removeTim8projekcija(Projekcija tim8projekcija) {
		getTim8projekcijas().remove(tim8projekcija);
		tim8projekcija.setTim8film(null);

		return tim8projekcija;
	}

}