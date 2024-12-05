package SubClas_Activitat;
import Classes.Activitat; import Classes.Entitat;

public class Xerrada extends Activitat {
    private String personaXerrada;

    public Xerrada (String nom, String lloc, int codiPostal, int dia, Entitat entitat, String personaXerrada) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.personaXerrada=personaXerrada;
    }

    public String getPersonaXarrada() {
        return personaXerrada;
    }

    public void setPersonaXarrada(String nouNom) {
        this.personaXerrada=nouNom;
    }

    public String getFills()
    {
        return ("0;" + personaXerrada);
    }

    @Override
    public String toString() {
        String aux = super.toString();
        aux = aux+"\n\tPersona xerrada: " + personaXerrada;
        return aux;
    }
}  
