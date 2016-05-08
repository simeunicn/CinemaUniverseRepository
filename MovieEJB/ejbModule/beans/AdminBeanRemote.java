package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Film;

@Remote
public interface AdminBeanRemote {
	public int sacuvajFilm(String naziv, String opis, String kategorija, String slikaFilma, String trailer);
	public void dodajGlumca(String ime, String prezime, String slika, String biografija);
	public void dodajProjekciju(String sala, String ukupanbrmesta, String preostalaMesta, String cena, String tipProjekcije, String datum);
	public List<Film> pronadjiSve();
}
