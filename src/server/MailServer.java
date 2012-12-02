package server;

import java.util.Calendar;
import java.util.List;

public class MailServer {
	private String asunto;
	private String remitente;
	private String destinatario;
	private Calendar fecha;
	private String cuerpo;
	private List<String> etiqueta;
	private AdjuntoServer adjunto;
	private boolean leido;
	
	// Constructor de un MailServer
	public MailServer(String destinatario, String cuerpo) {
		this.destinatario = destinatario;
		this.cuerpo = cuerpo;
	}
	
	// Print de un MailServer
	public String toString() {
		return "MailServer para: " + this.getDestinatario();
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public List<String> getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(List<String> etiqueta) {
		this.etiqueta = etiqueta;
	}

	public AdjuntoServer getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(AdjuntoServer adjunto) {
		this.adjunto = adjunto;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	

	
	
}
