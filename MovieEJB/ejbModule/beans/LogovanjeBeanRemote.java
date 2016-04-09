package beans;

import javax.ejb.Remote;

@Remote
public interface LogovanjeBeanRemote {
	public boolean login(String username, String password);
	public boolean registracija(String email, String imeKorisnika, String password, String prezimeKorisnika, String uloga, String username);
}
