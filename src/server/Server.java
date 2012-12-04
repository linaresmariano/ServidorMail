package server;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import exceptions.*;

public class Server {

	// Diccionario con el identificador unico de cada usuario y su User correspondiente
	private Hashtable<String, User> users = new Hashtable<String, User>();
	
	// Dominio del server
	private String dominio;
	
	
	// Constructor de un servidor
	public Server(String dominio) {
		this.dominio = dominio;
	}


	/**
	 * 
	 * @param username: nombre de usuario a loguear 
	 * @param password: password del usuario a loguear
	 * @throws InvalidUserOrPass: si el usuario o el password no son validos
	 */
	public boolean login(String username, String password) throws InvalidUserOrPass, AlreadyLogged {
		
		// Si existe el usuario, corroborar lo demás, sino tira excepcion
		if(this.users.containsKey(username)) {
			
			// Obtener el usuario
			User user = (User) this.users.get(username);

			// Info logueado y su contraseña
			Boolean logueado = user.getLogueado();
			String pass = user.getPass();
			
			if(logueado) {
				throw new AlreadyLogged();
			}
			
			if (password.equals(pass)) {
				// Marcar como logueado
				user.setLogueado(true);
				return true;
			}
		}

		throw new InvalidUserOrPass();
	}
	
	
	/**
	 * Registra un nuevo usuario al servidor
	 * @param username: nombre de usuario a registrar
	 * @param password: password del nuevo usuario
	 * @throws UserNotAvailable: si el usuario no esta disponible
	 */
	public void signUp(String username, String password) throws UserNotAvailable {
		if(! this.users.containsKey(username)) {
			// Crear usuario nuevo
			User newUser = new User(username, password);
			// Agregarlo a la tabla
			this.users.put(username, newUser);
			return;
		}
		
		throw new UserNotAvailable();
	}
	
	/**
	 * 
	 * @param mail: mail a ser enviado a algun usuario de este server
	 * @return true cuando el mail llega correctamente
	 */
	public boolean send(MailServer mail) {
		// Get destinatario del mail
		String destinatario = mail.getDestinatario();
		
		// Si el destinatario esta en el server despacharlo
		if(this.getUsers().containsKey(destinatario)) {
			// Despachar el mail al usuario correspondiente
			User user = this.getUsers().get(destinatario);
			user.addMail(mail);
			
			return true;
		}
		
		// El mail no llego a ningun lado
		return false;
	}
	
	
	/**
	 *  Marca como deslogueado al usuario indicado
	 * @param username: usuario a desloguear
	 * @return true -> operacion exitosa
	 */
	public boolean logout(String username) {
		User user = (User) this.users.get(username);
		user.setLogueado(false);
		
		return true;
	}
	
	

	/**
	 * Retorna la lista de mails de cierto usuario
	 * @param username: nombre del usuario que se solicitan los mails
	 * @return: la lista de mails del usuario solicitado
	 */
	public List<MailServer> getMails(String username) {
		User user = (User) this.users.get(username);
		
		return user.getMails();
	}
	
	
	public MailServer getMail(String username, int indexMail) {
		return this.getMails(username).get(indexMail);
	}

	public String getCuerpoMail(String user, int indexMail) {
		return this.getUsers().get(user).getCuerpoMail(indexMail);
	}
	
	public void borrarMail(String user, int indexMail) {
		this.getUsers().get(user).removeMail(indexMail);
	}
	
	public void setEtiqueta(String user, int indexMail, List<String> etiqueta) {
		this.getUsers().get(user).setEtiquetaMail(indexMail, etiqueta);
	}
	
	public Set<String> getUsernames() {
		return this.users.keySet();
	}
	
	// Get Hash de todos los usuarios
	public Hashtable<String, User> getUsers() {
		return users;
	}

	public void setUsers(Hashtable<String, User> users) {
		this.users = users;
	}
	
	public String getDominio() {
		return this.dominio;
	}

}
