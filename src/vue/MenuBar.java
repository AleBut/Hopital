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
			private JMenuItem malade;
			private JMenuItem employe;
        private JMenuItem modification;
        private JMenuItem suppression;
    
    private JMenu recherche;
        private JMenu personnel;
            private JMenuItem employe2;
            private JMenuItem docteur;
            private JMenuItem infirmiere;
        private JMenuItem patient;
        private JMenuItem service;
    
    private JMenuItem statistique;
    
    private JMenuItem deconnexion;
    
    public MenuBar()
    {   
         maj = new JMenu("Màj des données");
            insertion = new JMenu("Insertion");
				 employe = new JMenuItem("Employé");
				 malade = new JMenuItem("Malade");
            modification = new JMenuItem("Modification");
            suppression = new JMenuItem("Suppression");
         
         recherche = new JMenu("Recherche");
            personnel = new JMenu("Personnel");
                employe2 = new JMenuItem("Employée");
                docteur = new JMenuItem("Docteur");
                infirmiere = new JMenuItem("Infirmière");
            patient = new JMenuItem("Patient");
            service = new JMenuItem("Service");
        
         statistique = new JMenuItem("Statistique");
         
         deconnexion = new JMenuItem("Deconnexion");
         
         // Construction du menu graphique
         constructionGraphique();
    }
    
     private void constructionGraphique()
    {
		insertion.add(employe);
		insertion.add(malade);
		
        maj.add(insertion);
        maj.addSeparator();
        maj.add(modification);
        maj.addSeparator();
        maj.add(suppression);
        
        personnel.add(employe2);
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
     
     public JMenuItem getInsertionEmploye() { return employe; }
	 
	 public JMenuItem getInsertionMalade() { return malade; }

     public JMenuItem getModification() { return modification; }
     
     public JMenuItem getSuppression() { return suppression; }
     
     public JMenuItem getRecherchePersonnelEmploye() { return employe2; }
     
     public JMenuItem getRecherchePersonnelDocteur() { return docteur; }
     
     public JMenuItem getRecherchePersonnelInfirmiere() { return infirmiere; }
     
     public JMenuItem getRecherchePatient() { return patient; }
     
     public JMenuItem getRechercheService() { return service; }

     public JMenuItem getStatistique() { return statistique; }
     
     public JMenuItem getDeconnexion() { return deconnexion; }
}