package server;

public class AdjuntoServer {
	private String nombre;
	private String archivo;
	
	public AdjuntoServer(String name, String data) {
		this.nombre = name;
		this.archivo = data;
	}
	
	public String getArchivo() {
		return this.archivo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
