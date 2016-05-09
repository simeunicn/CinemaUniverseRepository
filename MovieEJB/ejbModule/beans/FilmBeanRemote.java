package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Film;
import model.Projekcija;

@Remote
public interface FilmBeanRemote {
	public List<Film> pronadjiSveFilmove();
	public List<Projekcija> pronadjiSveProjekcije();
	public boolean prodajKarte(int num, int idPr);
	public Film pronadjiFilm(int id);
	public Film dodajKomentar(String tekst, String datum,int idK, int idF);
	public List<Film> pretragaPoKategoriji(String kat);
	public List<Projekcija> filtrirajProjekcije(String brojMesta, String cenaK);
}
