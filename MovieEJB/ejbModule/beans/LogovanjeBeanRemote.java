package beans;

import javax.ejb.Remote;

import model.Korisnik;

@Remote
public interface LogovanjeBeanRemote {
	public String login(String username, String password);
	public boolean registracija(String email, String imeKorisnika, String password, String prezimeKorisnika, String uloga, String username);
	public void justContinue();
	public void logout();
	public Korisnik getLoggedUser();
	public void setLoggedUser(Korisnik loggedUser);
}
