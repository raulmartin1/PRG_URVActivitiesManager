package Consola;

import java.util.*;

import Classes.*;
import SubClas_Activitat.*;
import Llistes_classes.*;

public class Aplicacio {
    private static void mostrarLlistaUsuaris(LlistaUsuari llista) {
        System.out.println(llista.toString());
    }
    private static void mostrarLlistaActivitats(LlistaActivitat llista) {
        System.out.println(llista.toString());
    }
    private static void mostrarLlistaReserves(LlistaReservas llista) {
        System.out.println(llista.toString());
    }
    private static void mostrarLlistaEntitas(LlistaEntitat llista) {
        System.out.println(llista.toString());
    }

    static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args){
        LlistaActivitat llista_activitats = new LlistaActivitat(50);
        llista_activitats.LlegirFitxer();
        LlistaReservas llista_reserves = new LlistaReservas(50);
        llista_reserves.LlegirFitxer();
        LlistaEntitat llista_entitats = new LlistaEntitat(50);
        llista_entitats.LlegirFitxer();
        LlistaUsuari llista_usuaris = new LlistaUsuari(50);
        llista_usuaris.LlegirFitxer();

        int opcio;
        mostrarMenu();
        opcio = Integer.parseInt(teclat.nextLine());
        while(opcio != 15){
            switch (opcio) {
                case 1:
                    opcio1(llista_activitats, llista_reserves, llista_entitats, llista_usuaris);
                    break;
                case 2:
                    opcio2(llista_activitats);
                    break;
                case 3:
                    opcio3(llista_activitats);
                    break;
                case 4:
                    opcio4(llista_activitats, llista_reserves);
                    break;
                case 5:
                    opcio5(llista_activitats);
                    break;
                case 6:
                    opcio6(llista_usuaris, llista_activitats, llista_reserves);
                    break;
                case 7:
                    opcio7(llista_activitats, llista_reserves);
                    break;
                case 8:
                    opcio8(llista_usuaris);
                    break;
                case 9:
                    opcio9(llista_reserves);
                    break;
                case 10:
                    opcio10(llista_reserves);
                    break;
                case 11:
                    opcio11(llista_activitats, llista_reserves);
                    break;
                case 12:
                    opcio12(llista_activitats);
                    break;
                case 13:
                    opcio13(llista_activitats);
                    break;
                case 14:
                    opcio14(llista_activitats, llista_reserves);
                    break; 
            }
            mostrarMenu();
            opcio = Integer.parseInt(teclat.nextLine());
        }
        if (opcio == 15) 
        {
            opcio15(llista_activitats, llista_reserves, llista_entitats, llista_usuaris);
        }
    }

    public static void mostrarMenu(){
        System.out.println("1. Mostrar les dades de qualsevol llista.");
        System.out.println("2. Obtenir i mostrar la llista d'activitats que ofereix una entitat concreta.");
        System.out.println("3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
        System.out.println("4. Obtenir i mostrar la llista dels tallers que tenen places disponibles.");
        System.out.println("5. Afegir una nova activitat");
        System.out.println("6. Registrar la petició d'un usuari per reservar un taller.");
        System.out.println("7. Mostrar els usuaris que s'han apuntat a un taller.");
        System.out.println("8. Calcular l'usuari que s'ha apuntat a més tallers.");
        System.out.println("9. Registrar la nota que un usuari que s'ha apuntat a un taller li dona un cop s'ha fet.");
        System.out.println("10. Calcular la nota mitja que ha rebut un taller.");
        System.out.println("11. Quin és el taller que ha tingut més èxit? Ocupació més alta en proporció a les places que oferia.");
        System.out.println("12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
        System.out.println("13. Mostrar les dades de les xerrades que farà una persona concreta.");
        System.out.println("14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
        System.out.println("15. Sortir de l'aplicació.");
    }     

    public static void opcio1(LlistaActivitat llista_activitats, LlistaReservas llista_reserves, LlistaEntitat llista_entitats, LlistaUsuari llista_usuaris)
    {
        int opcio;
        System.out.println("Quin fitxer vols visualitzar? Activitats(1), reserves(2), entitats(3), usuaris(4). Si no vols cap fica 5.");
        opcio = Integer.parseInt(teclat.nextLine());
        while (opcio != 5){
            switch (opcio) {
                case 1:
                    mostrarLlistaActivitats(llista_activitats);
                    break;
                case 2:
                    mostrarLlistaReserves(llista_reserves);
                    break;
                case 3:
                    mostrarLlistaEntitas(llista_entitats);
                    break;
                case 4:
                    mostrarLlistaUsuaris(llista_usuaris);
                    break;
            }
            System.out.println("Quin fitxer vols visualitzar? Activitats(1), reserves(2), entitats(3), usuaris(4). Si no vols cap fica 5.");
            opcio = Integer.parseInt(teclat.nextLine());
        }
    }

    public static void opcio2(LlistaActivitat llistaActivitat) {
        System.out.println("Introdueix el nom de l'entitat: ");
        String nameEntitat = teclat.nextLine();
    
        boolean entitatTrobada = false;
    
        System.out.println("Llista d'Activitats de l'entitat " + nameEntitat + ":");
    
        Activitat[] activitats = llistaActivitat.getActivitats();
        for (int i = 0; i < activitats.length; i++) {
            Activitat activitat = activitats[i];
    
            if (activitat != null && activitat.getEntitat().getNom().equalsIgnoreCase(nameEntitat)) {
                if (!entitatTrobada) {
                    entitatTrobada = true;
                }
    
                System.out.println("Nom: " + activitat.getNom());
                System.out.println("Entitat: " + activitat.getEntitat().getNom());
                System.out.println("Dia: " + activitat.getDia() + "\n");
            }
        }
    
        if (!entitatTrobada) {
            System.out.println("No hi ha cap activitat per aquesta entitat.\n");
        }
    }

    public static void opcio3(LlistaActivitat llistaActivitat) {
        System.out.println("Introdueix el dia per mostrar les activitats:");
        int diaSeleccionat = Integer.parseInt(teclat.nextLine());

        boolean activitatsTrobades = false;

        System.out.println("Llista d'Activitats pel dia " + diaSeleccionat + ":");

        for (int i = 0; i < llistaActivitat.getActivitats().length; i++) {
            Activitat activitat = llistaActivitat.getActivitats()[i];
            
            if (activitat != null && activitat.getDia() == diaSeleccionat) {
                activitatsTrobades = true;

                System.out.println("Activitat " + (i + 1) + ":");
                System.out.println("Nom: " + activitat.getNom());
                System.out.println("Entitat: " + activitat.getEntitat().getNom());
                System.out.println("Dia: " + activitat.getDia());

                if (activitat instanceof Taller) {
                    System.out.println("Tipus d'activitat: Taller.\n");
                } else if (activitat instanceof Visita) {
                    System.out.println("Tipus d'activitat: Visita.\n");
                } else if (activitat instanceof Xerrada) {
                    System.out.println("Tipus d'activitat: Xerrada.\n");
                } else {
                    System.out.println("Tipus d'activitat desconegut.\n");
                }

            }
        }

        if (!activitatsTrobades) {
            System.out.println("No hi ha activitats per al dia " + diaSeleccionat + ".\n");
        }
    }

    public static void opcio4(LlistaActivitat llista_activitat, LlistaReservas llista_reserves){
        String coditaller;
        int cont = 0;
        int capacitat = 0;
        LlistaActivitat tallers_disponibles = new LlistaActivitat(llista_activitat.getNumActivitats());
        for (int i = 0; i<llista_activitat.getNumActivitats(); i++){
            if (llista_activitat.esTaller(i)){
                coditaller = llista_activitat.getTaller2(i).getCodi();
                capacitat = llista_activitat.getTaller2(i).getCapacitat();
                for (int x=0; x<llista_reserves.getNumReserves() && llista_reserves.getReserva(x) != null; x++) {
                    if ((llista_reserves.getReserva(x).getCodiTaller().equalsIgnoreCase(coditaller))) cont++;
    }
        if (cont<capacitat){
            tallers_disponibles.afegirActivitat(llista_activitat.getTaller2(i));
        }
    }
}
    mostrarLlistaActivitats(tallers_disponibles);

    }

    public static void opcio5(LlistaActivitat llista_activitat){
        Activitat act;

        System.out.println("Sera una Visita(1), una Xerrada(2) o un Taller(3).");
        int num = Integer.parseInt(teclat.nextLine());
        System.out.println("Escriu nom, lloc, codi postal, dia, entitat(nom, telefon, correu) separats per punt i coma.");
        String linea;
        String linea2;
        linea = teclat.nextLine();
        StringTokenizer coma = new StringTokenizer(linea,";");
        String nom = coma.nextToken();
        String lloc = coma.nextToken();
        int codi_postal = Integer.parseInt(coma.nextToken());
        int dia = Integer.parseInt(coma.nextToken());
        String nom_entitat = coma.nextToken();
        int telefon = Integer.parseInt(coma.nextToken());
        String correu = coma.nextToken();
        Entitat entitat = new Entitat(nom_entitat, telefon, correu);
        if (num == 1)
        {
            System.out.println("Al ser una visita escriu al final true o false per a l'audioguia i per l'adaptació per a cecs. Separats per punt i coma.");
            linea2 = teclat.nextLine();
            StringTokenizer coma2 = new StringTokenizer(linea2,";");
            boolean audioguia = Boolean.parseBoolean(coma2.nextToken());
            boolean adaptadaCecs = Boolean.parseBoolean(coma2.nextToken());
            act = new Visita(nom, lloc, codi_postal, dia, entitat, audioguia, adaptadaCecs);
            llista_activitat.afegirActivitat(act);
        }
        else if (num == 2)
        {
            System.out.println("Al ser xerrada escriu al final un 0 seguit del nom de la persona de la xerrada. Separats per punt i coma.");
            linea2 = teclat.nextLine();
            StringTokenizer coma2 = new StringTokenizer(linea2,";");
            String personaXerrada = coma2.nextToken();
            act = new Xerrada(nom, lloc, codi_postal, dia, entitat, personaXerrada);
            llista_activitat.afegirActivitat(act);
        }
        else if (num == 3)
        {
            System.out.println("Al ser un taller escriu al final la hora d'inici, la duaracio i la capacitat. Separats per punt i coma.");
            linea2 = teclat.nextLine();
            StringTokenizer coma2 = new StringTokenizer(linea2,";");
            int horaInici = Integer.parseInt(coma2.nextToken());
            int durada = Integer.parseInt(coma2.nextToken());
            int capacitat = Integer.parseInt(coma2.nextToken());
            act = new Taller(nom, lloc, codi_postal, dia, entitat, horaInici, durada, capacitat);
            llista_activitat.afegirActivitat(act);
        }
        else
        {
            System.out.println("Fica un numero correcte.");
        }
    }
    
    public static void opcio6(LlistaUsuari llista_usuaris, LlistaActivitat llista_activitats, LlistaReservas llista_reserves){
        int cont = 0;             
        System.out.println("Fes la teva reserva. Escriu el usuari(alias, correu, codi postal) i el codi taller separats per un punt i coma.");
        String linea = teclat.nextLine();
        StringTokenizer coma = new StringTokenizer(linea, ";");
        String alias = coma.nextToken();
        String correu = coma.nextToken();
        int codip = Integer.parseInt(coma.nextToken());
        String codit = coma.nextToken();
        int sat = -1;
        String codir = UUID.randomUUID().toString();
        Usuari usuari = null;
        Reserva reserva = null;
            if (llista_activitats.buscaCodi(codit)){
                cont = llista_reserves.quantesReservesTaller(codit);

                if (cont>=llista_activitats.getTaller(codit).getCapacitat()) System.out.println("No hi ha espai disponible a aquest taller.\n\n");
                
                else {
                    if (!llista_usuaris.UsuariIgual(alias, correu, codip)) {
                        usuari = new Usuari(alias, correu, codip);
                        llista_usuaris.afegirUsuariReserva(usuari);
                        System.out.println("Nou usuari introduit al sistema.");
                    }
                    else usuari=llista_usuaris.usuariExistent(alias, correu, codip);
                
                    reserva = new Reserva(codir, usuari, codit, sat);
                    llista_reserves.afegirReserva(reserva);
                    mostrarLlistaReserves(llista_reserves);
                }
            }
            else System.out.println("No hi cap taller que coincideixi amb aquest codi.\n\n");
    }
    public static void opcio7(LlistaActivitat llista_activitats, LlistaReservas llista_reserves)
    {
        System.out.println("Indica el codi del taller:");
        String codi = teclat.nextLine();
        Taller t = llista_activitats.getTaller(codi);
        System.out.println("\n" + llista_reserves.mostrarUsuarisTaller(t));
    }
    public static void opcio8(LlistaUsuari llista_usuaris){
        System.out.println("L'usuari que s'ha inscrit a mes tallers es:");
        System.out.println(llista_usuaris.usuariMesInscrit());
    }
    public static void opcio9(LlistaReservas llista_Reservas){
        System.out.println("Indica el nom de l'usuari:");
        String usuari = teclat.nextLine();
        System.out.println("Indica el codi del taller:");
        String codiTaller = teclat.nextLine();
        System.out.println("Indica la nota:");
        int nota = Integer.parseInt(teclat.nextLine());
        llista_Reservas.RegistrarNota(usuari, codiTaller, nota); 
    }
    public static void opcio10(LlistaReservas llista_reserves){
        float nota = 0;
        int cont = 0;
        System.out.println("Escriu el codi del taller del que vols calcular la nota mitja.");
        String codiTaller = teclat.nextLine();
        for (int i = 0; i<llista_reserves.getNumReserves(); i++){
            if (llista_reserves.getReserva(i).getCodiTaller().equalsIgnoreCase(codiTaller)){
                cont++;
                nota = nota + llista_reserves.getReserva(i).getSatisfaccio();
            }
        }
        nota = nota / cont;
        System.out.println("La nota mitja del taller amb codi " + codiTaller + " es " + nota+ ". \n");
    }

    public static void opcio11(LlistaActivitat llista_activitat, LlistaReservas llista_reserves){
        double exit = 0.00;
        double exitaux = 0.00;
        double cont, capacitat;
        String nom = "null";
        String codit = "null";
        for (int i = 0; i<llista_activitat.getNumActivitats(); i++){
                if (llista_activitat.esTaller(i)) {
                    capacitat = llista_activitat.getTaller2(i).getCapacitat();
                    codit = llista_activitat.getTaller2(i).getCodi();
                    cont = llista_reserves.quantesReservesTaller(codit);
                    exitaux = cont * 100 / capacitat;
                    if (exitaux>exit){
                        exit = exitaux;
                        nom = codit;
                }
            }
    }
    System.out.println("El taller amb codi " + nom + " ha tingut el major éxit amb una proporció del " + String.format("%.2f", exit) + " %.\n");
    }

    public static void opcio12(LlistaActivitat llistaActivitat){
        boolean audioguia;
        boolean adaptadaCecs;

        System.out.println("Escriu el nom de l'entitat");
        String nom = teclat.nextLine();

        System.out.println("\n Vols audioguia?");
        String audio = teclat.nextLine();
        if (audio.equalsIgnoreCase("no")) audioguia = false;
        else audioguia = true;
        System.out.println("\n Vols adaptacio?");
        String adapt = teclat.nextLine();
        if (adapt.equalsIgnoreCase("no")) adaptadaCecs = false;
        else adaptadaCecs = true;

        if (llistaActivitat.tenimVisites()) {
            if (!llistaActivitat.comprovacioAudAdapt(nom, audioguia, adaptadaCecs))
                System.out.println("No hi ha  visites amb aquests criteris.");
            else 
                System.out.println(llistaActivitat.visitesEnEntitat(nom, audioguia, adaptadaCecs));
                
            }
        else 
            System.out.println("La llista no te visites.");
        }
    public static void opcio13(LlistaActivitat llista_activitats){
        System.out.println("Indica la persona de qui vols la Xerrada.");
        String persona = teclat.nextLine();
        Xerrada x = llista_activitats.getXerrada(persona);
        System.out.println(x);
    }
    public static void opcio14(LlistaActivitat llista_activitats, LlistaReservas llista_reserves)
    {
        System.out.println("Indica el codi del taller:");
        String codi = teclat.nextLine();
        llista_activitats.eliminarTaller(codi);
        mostrarLlistaActivitats(llista_activitats);
    }  

    public static void opcio15(LlistaActivitat llista_activitats, LlistaReservas llista_reserves, LlistaEntitat llista_entitats, LlistaUsuari llista_usuaris)
    {
        int opcio;
        System.out.println("Quin fitxer vols guardar? Activitats(1), reserves(2), entitats(3), usuaris(4). Si no vols cap fica 5");
        opcio = Integer.parseInt(teclat.nextLine());
        while (opcio != 5){
            switch (opcio) {
                case 1:
                    llista_activitats.EscriureFitxer();
                    break;
                case 2:
                    llista_reserves.EscriureFitxer();
                    break;
                case 3:
                    llista_entitats.EscriureFitxer();
                    break;
                case 4:
                    llista_usuaris.EscriureFitxer();
                    break;
            }
            System.out.println("Vols guardar un altre fitxer? Activitats(1), reserves(2), entitats(3), usuaris(4). Si no vols cap fica 5");
            opcio = Integer.parseInt(teclat.nextLine());
        }
    }
}

