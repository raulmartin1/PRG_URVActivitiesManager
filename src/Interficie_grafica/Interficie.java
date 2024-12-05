package Interficie_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Llistes_classes.*;

public class Interficie extends JFrame {
    private static  final long serialVersionUID=1L;
    private JPanel panellBotons = new JPanel();
    private JPanel panellBotonsEspecifics = new JPanel();
    private JTextArea misatge;
    private JButton button;
    private JCheckBox bTaller = new JCheckBox("Taller");
    private JCheckBox bVisita = new JCheckBox("Visita");
    private JCheckBox bXerrada = new JCheckBox("Xerrada");

    public Interficie (String titol){
        super(titol);
        this.setLocation(100, 200);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(15,15));
        panellBotonsEspecifics.setLayout(new FlowLayout());
        panellBotons.setLayout(new GridLayout(2, 5, 15, 15));

        misatge = new JTextArea(" ",10, 20);
        misatge.setSize(this.getWidth(), 300);
        misatge.setText("");
        JScrollPane scrollPane = new JScrollPane(misatge);
        
        for (int i = 1; i <= 10; i++) {
            button = new JButton("Día " + i);
            button.setBackground(Color.GRAY);   
            button.addActionListener(new AccioDelBoto(i, misatge));
            panellBotons.add(button);
        }
        
        panellBotonsEspecifics.add(bTaller);
        panellBotonsEspecifics.add(bVisita);
        panellBotonsEspecifics.add(bXerrada);
        this.add(panellBotons, BorderLayout.NORTH);
        this.add(panellBotonsEspecifics, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.SOUTH);
        setVisible(true);
    }

    private class AccioDelBoto implements ActionListener {
        private int dia;
        private JTextArea info;
        
        public AccioDelBoto (int dia, JTextArea misatge) {
            this.dia = dia;
            this.info = misatge;
        }

        public void actionPerformed(ActionEvent e) {
            LlistaActivitat llista_activitats = new LlistaActivitat(50);
            llista_activitats.LlegirFitxer();
            boolean tal=false; boolean vis=false; boolean xer = false;
            info.append("Activitats dia "+dia+ ":\n");
            if(bTaller.isSelected()){
                info.append("Tallers=>\n" + llista_activitats.getActivitatsDia(dia).getLlistaTallers());
                tal=true;
            } 
            if(bVisita.isSelected())
            {
                
                info.append("Visites=>\n" +llista_activitats.getActivitatsDia(dia).getLlistaVisitas());
                vis=true;
            }              
            if(bXerrada.isSelected())
            {
                info.append("Xerrades=>\n" + llista_activitats.getActivitatsDia(dia).getLlistaXerradas());  
                xer=true;
            }
            if(tal==false && vis==false && xer==false)
            {
                info.append("" + llista_activitats.getActivitatsDia(dia));
            }
         }   
    }

    public static void main(String[] args) 
    {
        new Interficie("PRACTICA 3");
    }
    
}



























/*public class Interficie extends JFrame {
    public Interficie (String titol)
    {
        super(titol);
        this.setLocation(100, 200);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void main(String[] args) {
        new Interficie("PRACTICA");
        iniContingutInterficie();
    }

    public void iniContingutInterficie(){
        this.setLayout(new FlowLayout());
        this.add(new JButton("Opcio 1"));
        this.add(new JButton("Opcio 2"));
        this.add(new JButton("Opcio 3"));
        this.add(new JButton("Opcio 4"));
        this.add(new JButton("Opcio 5"));
        this.add(new JButton("Opcio 6"));
        this.add(new JButton("Opcio 7"));
        this.add(new JButton("Opcio 8"));
        this.add(new JButton("Opcio 9"));
        this.add(new JButton("Opcio 10"));
    }
}*/


