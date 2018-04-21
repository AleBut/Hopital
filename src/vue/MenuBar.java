/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
        private JMenu insertion;
			private JMenuItem patient;
			private JMenuItem docteur;
			private JMenuItem infirmier;
        private JMenuItem modification;
        private JMenuItem suppression;
    
    private JMenu recherche;
        private JMenu personnel;
            private JMenuItem employe;
            private JMenuItem docteur2;
            private JMenuItem infirmier2;
        private JMenuItem patient2;
        private JMenuItem service;
        
    
    private JMenuItem statistique;
    
    private JMenuItem deconnexion;
    
    public MenuBar()
    {   
         maj = new JMenu("Màj des données");
            insertion = new JMenu("Insertion");
				docteur = new JMenuItem("Docteur");
				infirmier = new JMenuItem("Infirmier");
				patient = new JMenuItem("Patient");
            modification = new JMenuItem("Modification");
            suppression = new JMenuItem("Suppression");
         
         recherche = new JMenu("Recherche");
            personnel = new JMenu("Personnel");
                employe = new JMenuItem("Employée");
                docteur2 = new JMenuItem("Docteur");
                infirmier2 = new JMenuItem("Infirmière");
            patient2 = new JMenuItem("Patient");
            service = new JMenuItem("Service");
            
        
         statistique = new JMenuItem("Statistique");
         
         deconnexion = new JMenuItem("Deconnexion");
         
         // Construction du menu graphique
         constructionGraphique();
    }
    
     private void constructionGraphique()
    {
		insertion.add(docteur);
		insertion.add(infirmier);
		insertion.addSeparator();
		insertion.add(patient);
		
        maj.add(insertion);
        maj.addSeparator();
        maj.add(modification);
        maj.addSeparator();
        maj.add(suppression);
        
        personnel.add(employe);
        personnel.add(docteur2);
        personnel.add(infirmier2);
        
        recherche.add(personnel);
        recherche.addSeparator();
        recherche.add(patient2);
        recherche.addSeparator();
        recherche.add(service);
        
        
        this.add(maj);
        this.add(recherche);
        this.add(statistique);
        this.add(deconnexion);

        this.setLayout(new GridLayout(1,4));
    }
     
     public JMenuItem getInsertionDocteur() { return docteur; }
	 
	 public JMenuItem getInsertionInfirmier() { return infirmier; }
	 
	 public JMenuItem getInsertionPatient() { return patient; }

     public JMenuItem getModification() { return modification; }
     
     public JMenuItem getSuppression() { return suppression; }
     
     public JMenuItem getRecherchePersonnelEmploye() { return employe; }
     
     public JMenuItem getRecherchePersonnelDocteur() { return docteur2; }
     
     public JMenuItem getRecherchePersonnelInfirmier() { return infirmier2; }
     
     public JMenuItem getRecherchePatient() { return patient2; }
     
     public JMenuItem getRechercheService() { return service; }
     

     public JMenuItem getStatistique() { return statistique; }
     
     public JMenuItem getDeconnexion() { return deconnexion; }
}