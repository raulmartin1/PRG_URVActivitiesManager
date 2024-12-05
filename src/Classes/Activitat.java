package Classes;

public abstract class Activitat {
	private static int principiCodi = 100; // tots els codis comencen per 100
    private String codi;
	private String nom;
    private String lloc;
    private int codiPostal;
    private int dia;
    private Entitat entitat;


     /**
     * Constructor de la classe Activitat.
     *	
     * @param nom      		El nom de l'activitat.
     * @param lloc     		El lloc de l'activitat.
     * @param codiPostal2  	El codi postal de l'activitat.
     * @param dia      		El dia de l'activitat.
     * @param entitat2 		L' entitat de l'activitat.
     */
    public Activitat(String nom, String lloc, int codiPostal2, int dia, Entitat entitat2) {
		this.codi = generarCodi(entitat2);
		this.nom = nom;
		this.lloc = lloc;
		this.codiPostal = codiPostal2;
		this.dia = dia;
		this.entitat = entitat2;
	}
	
	public abstract String getFills();

	/**
 	* Getter del codi activitat
 	*/	
    public String getCodi() {
		return codi;
	}
	/**
 	* Setter del codi
 	*/
	public void setCodi(String codi) {
		this.codi = codi;
	}
	/**
 	* Getter del nom de l'activitat
 	*/	
	public String getNom() {
		return nom;
	}
	/**
 	* Setter del nom
 	*/
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
 	* Getter del lloc de l'activitat
 	*/	
	public String getLloc() {
		return lloc;
	}
	/**
 	* Setter del lloc
 	*/
	public void setLloc(String lloc) {
		this.lloc = lloc;
	}
	/**
 	* Getter del codi postal de l'activitat
 	*/	
	public int getCodiPostal() {
		return codiPostal;
	}
	/**
 	* Setter del codi postal
 	*/
	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}
	/**
 	* Getter del dia que es fa l'activitat
 	*/	
	public int getDia() {
		return dia;
	}
	/**
 	* Setter del dia
 	*/
	public void setDia(int dia) {
		this.dia = dia;
	}
	/**
 	* Getter de l'entitat enllaçada a l'activitat
 	*/	
	public Entitat getEntitat() {
		return entitat;
	}
	/**
 	* Getter que retorna si hi ha audiog 	*/	
	public boolean isAudioguia() {
		return false;
	}
	/**
 	* Setter boolea d'adaptació a cecs
	* retorna si hi ha adaptaciól
 	*/
	public boolean isAdaptadaCecs() {
		return false;
	}
	/**
 	* Setter de entitat
 	*/
	public void setEntitat(Entitat entitat) {
		this.entitat = entitat;
	}
	/**
 	* Genera un codi per a l'activitat
 	* return El codi de l'activitat
 	*/
	private static String generarCodi(Entitat dia2) {
        return dia2.getNom().substring(0, 3) + (principiCodi++); // D'aquesta manera agafa les tres primeres lletres del 
																						// nom de la entitat i despres fica un 100
	}
	
	
	@Override
    public String toString() {
		String aux = "";
		aux = aux+"\n\tCodi: " + codi;
		aux = aux+"\n\tNom: " + nom;
		aux = aux+"\n\tLloc: " + lloc;
		aux = aux+"\n\tCodi postal: " + codiPostal;
		aux = aux+"\n\tDia: " + dia;
		aux = aux+"\n\tEntitat: " + entitat;
        return aux;
    }

	
}
