package SubClas_Activitat;

import java.util.UUID;

import Classes.*; import Llistes_classes.LlistaReservas;
import Llistes_classes.LlistaUsuari;

public class Taller extends Activitat{
	private int horaInici;
    private int duracio;
    private int capacitat;
    private LlistaReservas llistaReservas;
    private int placesDisponibles;
    private float sumaPuntuacions;
    private int numPersonesPuntuades;
    private Usuari[] llistaUsuarisInscrits;
    private static int numUsersInscrits=0;

	/**
 	 Constructor que inicialitza un Taller amb les següents dades.
 	*
 	* @param nom Nom del Taller.
 	* @param lloc Lloc del Taller.
 	* @param codiPostal Codi postal del Taller.
 	* @param dia Dia en què es realitzarà el Taller.
 	* @param entitat Entitat organitzadora del Taller.
 	* @param horaInici Hora d'inici del Taller.
 	* @param duracio Duració del Taller en hores.
 	* @param capacitat Capacitat màxima de participants al Taller.
 	*/
    public Taller(String nom, String lloc, int codiPostal, int dia, Entitat entitat,
                  int horaInici, int duracio, int capacitat) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.horaInici = horaInici;
        this.duracio = duracio;
        this.capacitat = capacitat;
        this.llistaReservas = new LlistaReservas(capacitat);
        this.placesDisponibles = capacitat - numUsersInscrits;
        this.llistaUsuarisInscrits = new Usuari[50];
    }
	/**
	* Getter del número d'usuaris inscrits
	*/
    public int getnumUsersInscrits() {
		return numUsersInscrits;
	}
	
	/**
	* Getter de les places disponibles
	*/
    public int getPlacesDisponibles() {
		return placesDisponibles;
	}
	/**
	* Setter de les places disponibles
	*/
	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}
	/**
	* Getter de la suma de puntuacions
	*/
	public float getSumaPuntuacions() {
		return sumaPuntuacions;
	}
	/**
	* Setter de la suma de puntuacions
	*/
	public void setSumaPuntuacions(float sumaPuntuacions) {
		this.sumaPuntuacions = sumaPuntuacions;
	}
	/**
	* Getter del número de persones puntuades 
	*/
	public int getNumPersonesPuntuades() {
		return numPersonesPuntuades;
	}
	/**
	* Setter del número de persones puntuades 
	*/
	public void setNumPersonesPuntuades(int numPersonesPuntuades) {
		this.numPersonesPuntuades = numPersonesPuntuades;
	}
	/**
 	* Registra una valoració per a l'activitat.
 	*
 	* @param valoracio La valoració a registrar per l'activitat.
 	*/
    public void registrarValoracion(int valoracion) {
    	sumaPuntuacions += valoracion;
        numPersonesPuntuades++;
    }
	/**	
	* Getter de la hora d'inici
	*/
	public int getHoraInici() {
		return horaInici;
	}
	/**	
	* Setter de la hora d'inici
	*/
	public void setHoraInici(int horaInici) {
		this.horaInici = horaInici;
	}
	/**	
	* Getter de la duracio
	*/
	public int getDuracio() {
		return duracio;
	}
	/**	
	* Setter de la duracio
	*/
	public void setDuracio(int duracio) {
		this.duracio = duracio;
	}
	/**	
	* Getter de la capacitat
	*/
	public int getCapacitat() {
		return capacitat;
	}
	/**	
	* Setter de la capacitat
	*/
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	/**
 	* Inscriu un usuari a l'activitat.
	*
	* @param usuari
	*/
	public void inscriureUsuari(Usuari usuari) {
		if(numUsersInscrits < llistaUsuarisInscrits.length) {
			llistaUsuarisInscrits[numUsersInscrits++] = usuari;
		}
	}
	/**	
	 * Getter dels usuaris inscrits
	 * @return llista d'usuaris
	 */
	public LlistaUsuari getUsuarisInscrits()
	{
		int i = 0;
		LlistaUsuari llista = new LlistaUsuari(50);
		while (i < llistaUsuarisInscrits.length)
		{
			llista.afegirUsuari(llistaUsuarisInscrits[i]);
		}
		return llista;
	}
	/**
 	* Verifica si un usuari està inscrit a l'activitat.
 	*
 	* @param usuari 
 	* @return Cert si l'usuari està inscrit a l'activitat, fals si no.
 	*/
	public Boolean usuariInscrit(Usuari usuari) {
		boolean userInscrit = false;
	    int i = 0;

	    // Mientras no se haya llegado al final de la lista y el usuario no esté inscrito
	    while (i < llistaUsuarisInscrits.length && !userInscrit) {
	        // Comparar el alias del usuario actual con el alias del usuario proporcionado
	        if (llistaUsuarisInscrits[i].getAlies().equals(usuari.getAlies())) {
	            userInscrit = true;
	        }

	        i++; // Incrementar el índice para pasar al siguiente usuario en la lista
	    }

	    return userInscrit;
	}
	
	/**
 	* Mètode que fa uan reserva indicant l'usuari i la seva satisfaccio
	 * 
 	* @param usuari Usuari que fa la reserva
 	* @param satisfaccio Satisfaccio que es vol establir.
	* @return Retorna la reserva realitzada
 	*/
	public Reserva ferReserva(Usuari usuari, int satisfaccio) {
		if((usuariInscrit(usuari)) == false){
			inscriureUsuari(usuari);
		}
		Reserva novaReserva=null;
		if (placesDisponibles > 0) {
            placesDisponibles--;
            novaReserva = new Reserva(generarCodiReserva(), usuari, getCodi(), satisfaccio);
            llistaReservas.afegirReserva(novaReserva);
            
        } else {
            System.out.println("No hi ha places disponibles per a aquest taller.");
          
        }
        return novaReserva;
    }
	/**
 	* Realitza una reserva per a un usuari en l'activitat.
 	*
 	* @param usuari 
 	* @param satisfaccio 
 	* @return La nova reserva creada, o null si no es pot fer la reserva.
 	*/
	public String generarCodiReserva() {
		return UUID.randomUUID().toString();
	}
	/**
	* Rep i acumula una valoració per a l'activitat.
 	*
	* @param valoracio La valoració a ser rebuda i acumulada per a l'activitat.
 	*/
    public void rebreValoracio(float valoracio) {
        sumaPuntuacions += valoracio;
        numPersonesPuntuades++;
    }
	/**
 	* Obté una cadena que representa els atributs específics d'una activitat de tipus Taller.
 	*
 	* @return Un string  que conté els atributs específics del Taller: hora d'inici, duració i capacitat.
 	*/
	public String getFills()
    {
        return (horaInici + ";" + duracio + ";" + capacitat);
    }
	/**
 	* 
 	*
 	* @return * @return Un string que representa els atributs de la classe Xerrada amb informació sobre cada atribut.
 	*/
    @Override
    public String toString() {
		String aux = super.toString();
		aux = aux+"\n\tHora inici: " + horaInici;
		aux = aux+"\n\tDuració: " + duracio;
		aux = aux+"\n\tCapacitat: " + capacitat;
        return aux;
    }
}
