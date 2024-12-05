package Classes;

import java.io.*;

public class Reserva implements Serializable{
	private String codiReserva;
    private Usuari usuari;
    private String codiTaller;
    private int satisfaccio;  // Valoració de l'usuari [0-10]
	
    
    
    public Reserva(String codiReserva, Usuari usuari, String codiTaller, int satisfaccio) {
		this.codiReserva = codiReserva;
		this.usuari = usuari;
		this.codiTaller = codiTaller;
		this.satisfaccio = satisfaccio;
	}
	public String getCodiReserva() {
		return codiReserva;
	}
	public void setCodiReserva(String codiReserva) {
		this.codiReserva = codiReserva;
	}
	public Usuari getUsuari() {
		return usuari;
	}
	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}
	public String getCodiTaller() {
		return codiTaller;
	}
	public void setCodiTaller(String codiTaller) {
		this.codiTaller = codiTaller;
	}
	public float getSatisfaccio() {
		return satisfaccio;
	}
	public void setSatisfaccio(int satisfaccio) {
		this.satisfaccio = satisfaccio;
	}

	public boolean esIgual(Reserva reserva) {
		return(this.codiReserva.equalsIgnoreCase(reserva.getCodiReserva()) && ((usuari.esIgual(reserva.getUsuari())&& codiTaller ==reserva.getCodiTaller())));
	}
	
	public Reserva copia() {
		Reserva reserva = new Reserva(codiReserva, usuari, codiTaller, satisfaccio);
		return reserva;
	}
	@Override
    public String toString() {
		String aux = "";
        aux = aux+"\n\tCodi Reserva: " + codiReserva;
		aux = aux+"\n\tUsuari: " + usuari;
		aux = aux+"\n\tCodi Taller: " + codiTaller;
		if (this.getSatisfaccio() != -1)
		{
			aux = aux+"\n\tSatisfacció: " + satisfaccio +"\n";
		}
		return aux;
    }
}
