package Classes;

import java.io.Serializable;

public class Usuari implements Serializable {
    private String alies;
    private String correuElectronic;
    private int codiPostal;
    private int numTalleres;

    public Usuari (String alies, String correuElectronic, int codiPostal) {
        this.alies=alies;
        this.correuElectronic=correuElectronic;
        this.codiPostal=codiPostal;
    }
    
    public String getAlies() {
        return alies;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setAlies (String alies) {
        this.alies = alies;
    }

    public void setCorreuElectronic (String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public void setCodiPostal (int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public int getNumTalleres() {
        return numTalleres;
    }

    public void setNumTalleres(int numTalleres) {
        this.numTalleres = numTalleres;
    }

    public void usuariInscrit() {
        numTalleres++;
    }
    
    public String toString() {
        String aux= "";
        aux=aux+"\n\t\tAlies= "+alies;
        aux=aux+"\n\t\tCorreu electrònic= "+correuElectronic;
        aux=aux+"\n\t\tCodi Postal= "+codiPostal;
        return aux;
    }

	public Usuari copia() {
		Usuari usuari=new Usuari(alies, correuElectronic, codiPostal);
        return usuari; 
	}

    public boolean esIgual(Usuari u)
    {
        return (alies.equalsIgnoreCase(u.getAlies()) && correuElectronic.equalsIgnoreCase(u.getCorreuElectronic()) && codiPostal == u.getCodiPostal());
    }
}
