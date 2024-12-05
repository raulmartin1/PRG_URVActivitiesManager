package SubClas_Activitat;
import Classes.Activitat;import Classes.Entitat;

public class Visita extends Activitat{
	private boolean audioguia;
    private boolean adaptadaCecs;

    public Visita(String nom, String lloc, int codiPostal, int dia, Entitat entitat,
            boolean audioguia, boolean adaptadaCecs) {
    	super(nom, lloc, codiPostal, dia, entitat);
    	this.audioguia = audioguia;
    	this.adaptadaCecs = adaptadaCecs;
    }
    
    public boolean isAudioguia() {
		return audioguia;
	}

	public void setAudioguia(boolean audioguia) {
		this.audioguia = audioguia;
	}

	public boolean isAdaptadaCecs() {
		return adaptadaCecs;
	}

	public void setAdaptadaCecs(boolean adaptadaCecs) {
		this.adaptadaCecs = adaptadaCecs;
	}

	public String getFills()
    {
        return (audioguia + ";" + adaptadaCecs);
    }
	
	@Override
    public String toString() {
        String aux = super.toString();
		aux = aux+"\n\tAudioguia : " + audioguia;
		aux = aux+"\n\tAdaptada per cecs: " + adaptadaCecs;
        return aux;
    }
}
