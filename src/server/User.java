package server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
	private String name;
	private String pass;
	private Boolean logueado = false;
	private List<MailServer> mails = new ArrayList<MailServer>();
	
	public String toString() {
		return "User: " + name;
	}
	
	// Contructor del User en el servidor
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	/**
	 *  Cambia la etiqueta del mail en el index "index" con la etiqueta elegida
	 * @param indexMail: indice del mail a cambiar etiqueta
	 * @param etiqueta: nueva etiqueta del mail
	 */
	public void setEtiquetaMail(int indexMail, List<String> etiqueta) {
		LinkedList<String> copy = new LinkedList<String>();
		
		for(String e : etiqueta) {
			copy.add(e);
		}

		this.getMails().get(indexMail).setEtiqueta(copy);
	}
	
	// Denota el cuerpo del mail que esta en
	// el indice "indexMail" como String
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

	// Agrega un mail a la lista
	public void addMail(MailServer m) {
		this.getMails().add(m);
	}
	
	// Elimina el mail de la lista
	public void removeMail(int indexMail) {
		this.getMails().remove(indexMail);
	}
	
}
