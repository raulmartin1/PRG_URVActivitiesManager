package Llistes_classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;
import java.util.StringTokenizer;

import Classes.Usuari;

public class LlistaUsuari {
    private Usuari[] llista;
    private int numUsuaris;
    
    public LlistaUsuari (int num) {
        llista = new Usuari[num];
        numUsuaris = 0;
    }

    public int getNumUsuaris() {
        return (numUsuaris);
    }
    
    public void afegirUsuari(Usuari u) {
        boolean trobat = false;
        if (numUsuaris<llista.length)
        {
            for(int i=0; i < numUsuaris && !trobat; i++)
            {
                if (llista[i].esIgual(u))
                {
                    trobat = true;
                }
            }
            if (!trobat)
            {
                llista[numUsuaris] = u.copia();
                numUsuaris++;
            }
        }
    }

    public void afegirUsuariReserva(Usuari u) {
        boolean trobat = false;
        if (numUsuaris<llista.length)
        {
            for(int i=0; i < numUsuaris && !trobat; i++)
            {
                if (llista[i].esIgual(u))
                {
                    trobat = true;
                }
            }
            if (!trobat)
            {
                llista[numUsuaris] = u.copia();
                llista[numUsuaris].usuariInscrit();
                numUsuaris++;
            }
        }
    }

    public boolean UsuariIgual(String nom, String correu, int codip) {
        boolean trobat = false;
        for (int i=0; i< numUsuaris; i++){
            if(llista[i].getAlies().equalsIgnoreCase(nom) && llista[i].getCorreuElectronic().equalsIgnoreCase(correu) && llista[i].getCodiPostal()==(codip)){
                trobat=true;
            }
        }
        return trobat;
    }

    public Usuari usuariExistent (String nom, String correu, int codiPostal){
       Usuari usuari= null;
        boolean trobat=false;
        int i=0;
        for (i=0; i< numUsuaris && trobat==false; i++) {
            if ((llista[i].getAlies().equalsIgnoreCase(nom)) && (llista[i].getCorreuElectronic().equalsIgnoreCase(correu)) 
            && (llista[i].getCodiPostal()==codiPostal)) {
                trobat =true;
                usuari=llista[i];
            }
        } 
        return usuari;

    }

    public void apuntarUsuaris(Usuari usuari) {
        boolean trobat = false;
        for(int i=0; i< numUsuaris && trobat==false; i++){
            if(llista[i].esIgual(usuari)) {
                if(llista[i].getNumTalleres() != usuari.getNumTalleres()) {
                    llista[i].setNumTalleres(usuari.getNumTalleres());
                    trobat=true;
                }
            }
        }
    }

    public Usuari usuariMesInscrit() {
        Usuari usuari = llista[0];

        if (numUsuaris==0) {
            return null;
        }
        
        for(int i=1; i<numUsuaris;i++) {
            if (llista[i].getNumTalleres()>usuari.getNumTalleres()) {
                usuari=llista[i].copia();
            }
        }

        return usuari;
    }

    public boolean aliesIgual(String nom) {
        boolean trobat = false;
        for (int i=0; i< numUsuaris; i++){
            if(llista[i].getAlies().equalsIgnoreCase(nom)){
                trobat=true;
            }
        }
        return trobat;
    }
    public void LlegirFitxer()
    {
        try {
            BufferedReader f = new BufferedReader(new FileReader("usuaris.txt"));
            String linea;
            linea = f.readLine();
            while(linea != null)
            {
                StringTokenizer coma = new StringTokenizer(linea,";");
                String alias = coma.nextToken();
                String correu = coma.nextToken();
                int codi_postal = Integer.parseInt(coma.nextToken());
                Usuari usuari = new Usuari(alias,correu,codi_postal);
                this.afegirUsuari(usuari);

                linea = f.readLine();
            }
            f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch (IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
    }

    public void EscriureFitxer()
    {
        try {
            BufferedWriter f = new BufferedWriter(new FileWriter("usuaris.txt"));
            for (int i=0; i<numUsuaris; i++)
            {
                f.write(llista[i].getAlies() + ";" + llista[i].getCorreuElectronic() + ";" + llista[i].getCodiPostal() + "\n");
            }
            f.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch (IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
    }

    public String toString() {
        String aux = "Llista d'usuaris:\n";
        for (int i = 0; i < numUsuaris; i++) {
            aux = aux + "\tUsuari " + (i + 1) + " : " + llista [i] +"\n";
        }   
        return aux;
    }
   
}
