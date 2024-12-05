package Classes;

public class Entitat {
	private String nom;
    private int telefon;
    private String correu;

    public Entitat(String nom, int telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public Entitat copia() {
        Entitat entitat=new Entitat(nom, telefon, correu);
        return entitat; 
    }
	
	@Override
    public String toString() {
		String aux = "";
		aux = aux+"\n\t\tNom: " + nom;
		aux = aux+"\n\t\tTelèfon: " + telefon;
		aux = aux+"\n\t\tCorreu: " + correu;
        return aux;
    }
}
