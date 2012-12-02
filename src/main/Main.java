package main;

import exceptions.*;
import server.*;

public class Main {
	
	public static Server server = new Server("yahoo"); 
	
	public static void registrar(String nombre, String pass) {
		try {
			server.signUp(nombre, pass);
			System.out.println("Bienvenido al server " + nombre);
		} catch (UserNotAvailable e) {
			System.out.println("User not available");
		}
	}
	
	public static void loguear(String nombre, String pass) {
		try {
			server.login(nombre, pass);
			System.out.println("Bienvenido de nuevo " + nombre);
		} catch (InvalidUserOrPass e) {
			System.out.println("Invalid User or Pass, try again");
		} catch (AlreadyLogged e) {
			System.out.println("AlreadyLogged");
		}
	}

	public static void main(String[] args) {
		
		// Registro un usuario
		registrar("Mariano", "1234");
		
		// Registro otro usuario
		registrar("Jose", "1234");
		
		// Me logueo con mi usuario registrado
		loguear("Mariano", "1234");
		server.logout("Mariano");
		loguear("Mariano", "1234");
		
		

		// Spamear a mariano
		for(int i = 0; i < 100; i++) {
			server.send(new MailServer("Mariano", "hola loco!"));
		}

		
		// Enviarle un mail a un usuario que no está registrado
		System.out.println(server.send(new MailServer("Pepe", "que hace papa?")));
		
		System.out.println(server.getMails("Mariano"));
		
		System.out.println(server.getUsers());
		
		server.borrarMail("Mariano", 0);
		
		System.out.println(server.getMails("Mariano"));
		
		

	}

}
