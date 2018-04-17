/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.HubGraph;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Alex1
 */
public class MenuBar extends JMenuBar
{
    private JMenu maj;
        private JMenuItem insertion;
        private JMenuItem modification;
        private JMenuItem suppression;
    
    private JMenu recherche;
        private JMenu personnel;
            private JMenuItem employe;
            private JMenuItem docteur;
            private JMenuItem infirmiere;
        private JMenuItem patient;
        private JMenuItem service;
    
    private JMenuItem statistique;
    
    private JMenuItem deconnexion;
    
    public MenuBar()
    {   
         maj = new JMenu("MÃ j des donnÃ©es");
            insertion = new JMenuItem("Insertion");
            modification = new JMenuItem("Modification");
            suppression = new JMenuItem("Suppression");
         
         recherche = new JMenu("Recherche");
            personnel = new JMenu("Personnel");
                employe = new JMenuItem("EmployÃ©");
                docteur = new JMenuItem("Docteur");
                infirmiere = new JMenuItem("InfirmiÃ¨re");
            patient = new JMenuItem("Patient");
            service = new JMenuItem("Service");
        
         statistique = new JMenuItem("Statistique");
         
         deconnexion = new JMenuItem("Deconnexion");
         
         // Construction du menu graphique
         constructionGraphique();
    }
    
     private void constructionGraphique()
    {
        maj.add(insertion);
        maj.addSeparator();
        maj.add(modification);
        maj.addSeparator();
        maj.add(suppression);
        
        personnel.add(employe);
        personnel.add(docteur);
        personnel.add(infirmiere);
        
        recherche.add(personnel);
        recherche.addSeparator();
        recherche.add(patient);
        recherche.addSeparator();
        recherche.add(service);
        
        this.add(maj);
        this.add(recherche);
        this.add(statistique);
        this.add(deconnexion);

        this.setLayout(new GridLayout(1,4));
    }
     
     public JMenuItem getInsertion() { return insertion; }

     public JMenuItem getModification() { return modification; }
     
     public JMenuItem getSuppression() { return suppression; }
     
     public JMenuItem getRecherchePersonnelEmploye() { return employe; }
     
     public JMenuItem getRecherchePersonnelDocteur() { return docteur; }
     
     public JMenuItem getRecherchePersonnelInfirmiere() { return infirmiere; }
     
     public JMenuItem getRecherchePatient() { return patient; }
     
     public JMenuItem getRechercheService() { return service; }

     public JMenuItem getStatistique() { return statistique; }
     
     public JMenuItem getDeconnexion() { return deconnexion; }
}