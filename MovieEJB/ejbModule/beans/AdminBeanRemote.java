package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Film;

@Remote
public interface AdminBeanRemote {
	public String sacuvajFilm(String naziv, String opis, String kategorija, String slikaFilma);
	public boolean dodajGlumca(String ime, String prezime, String slika, String biografija);
	public boolean dodajProjekciju(String sala, String ukupanbrmesta, String preostalaMesta, String cena, String tipProjekcije, String datum);
	public List<Film> pronadjiSve();
	public int getPrihod(String odv, String dov);
}
