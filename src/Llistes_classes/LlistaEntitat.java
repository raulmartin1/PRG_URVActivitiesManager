package Llistes_classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Classes.Entitat;

public class LlistaEntitat {
    private Entitat[] llistaEntitats;
    private int numEntitats;
    
    public LlistaEntitat(int num) {
    	llistaEntitats = new Entitat[num];
    	numEntitats = 0;
    }

    // Métode per afegir una Entitat a la llista
    public void afegirEntitat(Entitat e) {
    	if (numEntitats<llistaEntitats.length)
        {
            llistaEntitats[numEntitats] = e.copia();
            numEntitats++;
        }
    }

    // Métode per mostrar les Entitats
    public void mostrarEntitats() {
        for (Entitat entitat : llistaEntitats) {
            System.out.println(entitat);
        }
    }

    // Métode per obtenir el numero d'Entitats
    public int getNumEntitats() {
        return (numEntitats);
    }

    public void LlegirFitxer()
    {
        try 
        {
            BufferedReader f = new BufferedReader(new FileReader("entitats.txt"));
            String linea;
            linea = f.readLine();
            while(linea != null)
            {
                StringTokenizer coma = new StringTokenizer(linea,";");
                String nom = coma.nextToken();
                int telefon = Integer.parseInt(coma.nextToken());
                String correu = coma.nextToken();
                Entitat entitat = new Entitat(nom,telefon,correu);
                this.afegirEntitat(entitat);

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
            BufferedWriter f = new BufferedWriter(new FileWriter("entitats.txt"));
            for (int i=0; i<numEntitats; i++)
            {
                f.write(llistaEntitats[i].getNom() + ";" + llistaEntitats[i].getTelefon() + ";" + llistaEntitats[i].getCorreu() + "\n");
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
        String aux = "Llista de Entitats:\n";
        for (int i = 0; i < numEntitats; i++) {
            aux = aux + "\tEntitat " + (i + 1) + " : " + llistaEntitats [i] +"\n";
        }
        return aux;
    }

}

