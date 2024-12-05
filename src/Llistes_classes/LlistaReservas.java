package Llistes_classes;
import Classes.Reserva;
import SubClas_Activitat.Taller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class LlistaReservas implements Serializable{
	private static final long serialVersionUID = 1L;
    private Reserva[] llistaReserves;
    private int numReserves;
    int dim;
    public LlistaReservas(int dim) {
    	llistaReserves = new Reserva[dim];
    	numReserves = 0;
    }

    // Métode per afegir una reserva a la llista
    public void afegirReserva(Reserva reserva) {
    	if (numReserves < llistaReserves.length) {
            if(reservaIgual(reserva)==false)
            {
                llistaReserves[numReserves++] = reserva.copia();
                reserva.getUsuari().usuariInscrit();
                //llistaReserves[numReserves]=reserva.copia();
                //numReserves++;
            }
            else{
                System.out.println("La reserva ja existeix");
            }
        } 
    }

    public int quantesReservesTaller (String codit){
        int cont = 0;
        for (int x=0; x<getNumReserves() && llistaReserves[x] != null; x++) {
            if ((llistaReserves[x].getCodiTaller().equalsIgnoreCase(codit))) cont++;
        }
    return cont;
    }

    public int getNumReserves (){
        return numReserves;
    }

    public Reserva getReserva(int i){
        return llistaReserves[i];
    }

    // Métode per mostrar les reserves
    public void mostrarReserves() {
        for (Reserva reserva : llistaReserves) {
            System.out.println(reserva);
        }
    }

    public LlistaUsuari mostrarUsuarisTaller(Taller t)
    {
        LlistaUsuari usuaris = new LlistaUsuari(numReserves);
        for (int i = 0; i < numReserves; i++)
        {
            if (llistaReserves[i].getCodiTaller().equalsIgnoreCase(t.getCodi()))
            {
                usuaris.afegirUsuari(llistaReserves[i].getUsuari());
            }
        }
        return usuaris;
    }

    public void RegistrarNota(String nomUsuari, String codiTaller, int nota) {

		for(int i=0; i<numReserves; i++) {
    
			if ((llistaReserves[i].getUsuari().getAlies()).equals(nomUsuari) && (llistaReserves[i].getCodiTaller()).equals(codiTaller)) {
				llistaReserves[i].setSatisfaccio(nota);
                //System.out.println(llistaReserves[i].getSatisfaccio());   //Prova de funcionament
			}
		}
	}

    public boolean reservaIgual(Reserva reserva) {
        boolean trobat=false;
        for(int i=0; i<numReserves && trobat ==false; i++) {
            if(llistaReserves[i].esIgual(reserva)==true) {
                trobat=true;
            }
        }
        return trobat;
    }

    public  void LlegirFitxer() 
    {
        try {
            ObjectInputStream f = new  ObjectInputStream(new FileInputStream("reserves.ser"));
            while (true)
            {
                try {
                    Object obj = f.readObject();

                    if (obj instanceof Reserva)
                    {
                        Reserva reserva = (Reserva) obj;
                        this.afegirReserva(reserva);
                    }
                }
                catch (IOException e){
                    break;
                }
            }
            f.close();
        }
        
        catch (IOException e) {
            System.out.println("Error  en l'arxiu d'entrada.");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error, no es troba  la classe LlistaReserva."+e);
            e.printStackTrace();
        }
    }

    public void EscriureFitxer()
    {
        try {
            ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("reserves.ser"));
            for (int i=0; i < numReserves; i++)
            {
                f.writeObject(llistaReserves[i]);
            }
            f.close();
        }

        catch (IOException e) {
            System.out.println("Error en l'arxiu de sortida");
        }
    }

    public String toString() {
        String aux = "Llista de reserves:\n";
        for (int i = 0; i < numReserves; i++) {
            if(llistaReserves != null)
            {
                aux = aux + "Reserva " + (i + 1) + " : " + llistaReserves [i];
            }
        }
        return aux;
    }

}
