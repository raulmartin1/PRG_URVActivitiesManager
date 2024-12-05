package Llistes_classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Classes.Activitat;
import Classes.Entitat;
import SubClas_Activitat.*;

public class LlistaActivitat {
    private Activitat[] activitats;
    private int numActivitats;
    private int nElem;

    public LlistaActivitat(int dim) {
        activitats = new Activitat[dim];
        numActivitats = 0;
        nElem = 0;
    }


    public Activitat[] getActivitats() {
        return activitats;
    }

    public void afegirActivitat(Activitat activitat) {
        if (numActivitats < activitats.length) {
            activitats[numActivitats++] = activitat;
            nElem++;
        } else {
            System.out.println("No es pot afegir més activitats. Està ple.");
        }
    }
    public Xerrada getXerrada(String personaXerrada) {
        Xerrada xerrada = null;
        int i; 
        boolean trobat=false;
        for (i=0; i<numActivitats && trobat==false; i++) {
            if (activitats[i] instanceof Xerrada) {
                if(((Xerrada)activitats[i]).getPersonaXarrada().equals(personaXerrada)) {
                xerrada = (Xerrada) activitats[i];
                trobat = true;
                }   
            } 
        }
        return xerrada;
    }

    public Taller getTaller2(int i){
        return (Taller) activitats[i]; }
        

    public boolean esTaller(int i){
        if (activitats[i] instanceof Taller){
            return true;
        }
        else return false;
    }

    public boolean buscaCodi (String codit){
        boolean trobat = false;
        int i = 0;
        while (!trobat && i<getNumActivitats()){
            if (codit.equalsIgnoreCase(activitats[i].getCodi())) trobat = true;
            else i++;  
    }
    return trobat;
}

    public Taller getTaller(String codi)
    {
        int i;
        boolean trobat = false;
        for (i=0; i <numActivitats && !trobat; i++)
        {
            if(activitats[i].getCodi().equalsIgnoreCase(codi))
            {
                trobat = true;
            }
        }
        return (Taller) activitats[i-1];
    }

    public void eliminarTaller(String codi)
    {
        int i;
        boolean trobat = false;
        for (i=0; i <numActivitats && !trobat; i++)
        {
            if (activitats[i] instanceof Taller)
            {
                if (activitats[i].getCodi().equalsIgnoreCase(codi))
                {
                    if (((Taller) activitats[i]).getnumUsersInscrits() == 0)
                    {
                        trobat=true;
                    }
                }
            }
        }
        for (int j=i-1; j <numActivitats && trobat; j++)
        {
            activitats[j] = activitats[j+1];
        }
        if (trobat)
        {
            numActivitats--;
        }
    }

    /*public void mostrarActivitats() {
        if (numActivitats == 0) {
            System.out.println("No hi ha activitats disponibles.");
            return;
        }

        System.out.println("Llista d'Activitats:");
        for (int i = 0; i < numActivitats; i++) {
            System.out.println("Activitat " + (i + 1) + ":");
            System.out.println("Nom: " + activitats[i].getNom());
            System.out.println("Entitat: " + activitats[i].getEntitat().getNom());
            System.out.println("Dia: " + activitats[i].getDia());
            if (activitats[i] instanceof Taller) {
                System.out.println("Tipus d'activitat: Taller");
            } else if (activitats[i] instanceof Visita) {
                System.out.println("Tipus d'activitat: Visita");
            } else if (activitats[i] instanceof Xerrada) {
                System.out.println("Tipus d'activitat: Xerrada");
            } else {
                System.out.println("Tipus d'activitat desconegut");
            }
            System.out.println();  
        }
    }*/

    public void SobreescriureFitxer()
    {
        try
        {
            BufferedWriter f = new BufferedWriter(new FileWriter("activitats.txt"));
            for (int i=0; i<numActivitats;i++)
            {
                    f.write(activitats[i].toString());
                    f.newLine();
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

    public LlistaActivitat getActivitatsDia(int dia)
    {
        LlistaActivitat llista = new LlistaActivitat(50);

        for (int i=0; i < numActivitats; i++)
        {
            if (activitats[i].getDia() == dia)
            {
                llista.afegirActivitat(activitats[i]);
            }
        }
        return llista;
    }

    public LlistaActivitat getLlistaTallers(){
        LlistaActivitat llista = new LlistaActivitat(50);

        for (int i=0; i<numActivitats; i++)
        {
            if (activitats[i] instanceof Taller) 
            {
                llista.afegirActivitat(activitats[i]);
            }
        }
        return llista;
    }

    public LlistaActivitat getLlistaVisitas(){
        LlistaActivitat llista = new LlistaActivitat(50);

        for (int i=0; i<numActivitats; i++)
        {
            if (activitats[i] instanceof Visita) 
            {
                llista.afegirActivitat(activitats[i]);
            }
        }
        return llista;
    }

    public LlistaActivitat getLlistaXerradas(){
        LlistaActivitat llista = new LlistaActivitat(50);

        for (int i=0; i<numActivitats; i++)
        {
            if (activitats[i] instanceof Xerrada) 
            {
                llista.afegirActivitat(activitats[i]);
            }
        }
        return llista;
    }

    public LlistaActivitat visitesEnEntitat(String entitat, boolean audioguia, boolean adaptadaCecs){
        LlistaActivitat aux = new LlistaActivitat(nElem);
        for (int i = 0; i < nElem; i++){

            if (activitats[i] instanceof Visita){
                if (activitats[i].getEntitat().getNom().equalsIgnoreCase(entitat) && activitats[i].isAudioguia() == audioguia && activitats[i].isAdaptadaCecs() == adaptadaCecs)
                aux.afegirActivitat(activitats[i]);
                }
        }
            return aux;
    }
    public boolean comprovacioAudAdapt(String entitat, boolean audioguia, boolean adaptadaCecs){
        boolean trobat = false;
        for (int i = 0; i < nElem; i++){
        if (activitats[i].getEntitat().getNom().equalsIgnoreCase(entitat) && activitats[i].isAudioguia() == audioguia && activitats[i].isAdaptadaCecs() == adaptadaCecs)
                trobat = true; 
                }
                return trobat;
         }
            
                
    

    
        public boolean tenimVisites() {
            for (int i = 0; i < numActivitats; i++) {
                if (activitats[i] instanceof Visita) {
                    return true; 
                }
            }
            return false; 
        }
        
        public int getNumActivitats() {
            return numActivitats;
        }
        
    public void LlegirFitxer()
    {
        Activitat act;
        try 
        {
            BufferedReader f = new BufferedReader(new FileReader("activitats.txt"));
            String linea;
            linea = f.readLine();
            while(linea != null)
            {
                StringTokenizer coma = new StringTokenizer(linea,";");
                String nom = coma.nextToken();
                String lloc = coma.nextToken();
                int codi_postal = Integer.parseInt(coma.nextToken());
                int dia = Integer.parseInt(coma.nextToken());
                String nom_entitat = coma.nextToken();
                int telefon = Integer.parseInt(coma.nextToken());
                String correu = coma.nextToken();
                Entitat entitat = new Entitat(nom_entitat, telefon, correu);

                String siguiente = coma.nextToken();
                if (siguiente.equalsIgnoreCase("true") || siguiente.equalsIgnoreCase("false"))
                {
                    boolean audioguia = Boolean.parseBoolean(siguiente);
                    boolean adaptadaCecs = Boolean.parseBoolean(coma.nextToken());
                    act = new Visita(nom, lloc, codi_postal, dia, entitat, audioguia, adaptadaCecs);
                    this.afegirActivitat(act);
                } 
                else if (siguiente.equalsIgnoreCase("0")) 
                {  
                    String personaXerrada = coma.nextToken();
                    act = new Xerrada(nom, lloc, codi_postal, dia, entitat, personaXerrada);
                    this.afegirActivitat(act);
                }
                else
                {
                    int horaInici = Integer.parseInt(siguiente);
                    int durada = Integer.parseInt(coma.nextToken());
                    int capacitat = Integer.parseInt(coma.nextToken());
                    act = new Taller(nom, lloc, codi_postal, dia, entitat, horaInici, durada, capacitat);
                    this.afegirActivitat(act);
                }
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
        try{
            BufferedWriter f = new BufferedWriter(new FileWriter("activitats.txt"));
            for (int i=0; i < numActivitats; i++)
            {
                f.write(activitats[i].getNom() + ";" + activitats[i].getLloc() + ";" + activitats[i].getCodiPostal() + ";" + activitats[i].getDia() + ";" + activitats[i].getEntitat().getNom() + ";" + activitats[i].getEntitat().getTelefon() + ";" + activitats[i].getEntitat().getCorreu() + ";" + activitats[i].getFills() + "\n");
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
        String aux = "Llista de activitats:\n";
        for (int i = 0; i < numActivitats; i++) {
            aux = aux + "Activitat " + (i + 1) + " : " + activitats [i] +"\n";
        }   
        return aux;
    }
}
