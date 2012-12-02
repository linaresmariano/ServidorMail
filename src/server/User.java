package server;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String pass;
	private Boolean logueado = false;
	private List<MailServer> mails = new ArrayList<MailServer>();
	
	public String toString() {
		return "User: " + name;
	}
	
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	public String getCuerpoMail(int indexMail) {
		return this.getMails().get(indexMail).getCuerpo();
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean getLogueado() {
		return logueado;
	}
	
	public void setLogueado(Boolean b) {
		this.logueado = b;
	}
	
	public List<MailServer> getMails() {
		return this.mails;
	}
	
	public void addMail(MailServer m) {
		this.getMails().add(m);
	}
	
	public void removeMail(int indexMail) {
		this.getMails().remove(indexMail);
	}
	
}
