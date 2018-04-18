/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import vue.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame implements ActionListener
{    
    // Base de donnÃ©e
    private GestionBase BDD;
    
    private MenuBar menu;
    
       public HubGraph()
    {         
         this.setTitle("Hopital");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
         
         menu = new MenuBar();
         
         menu.getInsertionDocteur().addActionListener(this);
         menu.getInsertionInfirmier().addActionListener(this);
         menu.getInsertionMalade().addActionListener(this);
         
         menu.getModification().addActionListener(this);
         menu.getSuppression().addActionListener(this);
        
         menu.getRecherchePersonnelEmploye().addActionListener(this);
         menu.getRecherchePersonnelDocteur().addActionListener(this);
         menu.getRecherchePersonnelInfirmier().addActionListener(this);
         
         menu.getRecherchePatient().addActionListener(this);
         menu.getRechercheService().addActionListener(this);
        
         menu.getStatistique().addActionListener(this);
         menu.getDeconnexion().addActionListener(this);
        
         // Lance la page de connexion
         launchPageConnexion();
    } 
    
    public void launchPageConnexion()
    {
         this.setVisible(false);
         this.setJMenuBar(null);
         this.setContentPane(new PageConnexion(this));
         //this.pack();
         this.setSize(500, 500);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageMenu(GestionBase _BDD)
    {
         BDD = _BDD;
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageMenu(BDD));
         //this.pack();
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelEmploye()
    {
        String tabArgument [];
        tabArgument = new String [5];
        
        String select [];
        select = new String [5];
        
        tabArgument[0]="Nom";
        tabArgument[1]="Prenom";
        tabArgument[2]="Numéro_Employe";
        tabArgument[3]="Telephone";
        tabArgument[4]="Adresse"; 
        
        select[0]="nom_employe";
        select[1]="prenom_employe";
        select[2]="numero_e";
        select[3]="telephone_employe";
        select[4]="adresse_employe"; 
        
        String f="FROM employe ";
        String w="";
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument, select, f,w ));
         //this.pack();
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelDocteur()
    {
        String tabArgument [];
        tabArgument = new String [6];
        
        String select [];
        select = new String [6];
        
        tabArgument[0]="Nom";
        tabArgument[1]="Prenom";
        tabArgument[2]="Numéro_Employe";
        tabArgument[3]="Telephone";
        tabArgument[4]="Adresse"; 
        tabArgument[5]="Specialite"; 
        
        select[0]="nom_employe";
        select[1]="prenom_employe";
        select[2]="numero_e";
        select[3]="telephone_employe";
        select[4]="adresse_employe"; 
        select[5]="specialite"; 
        
        String f="FROM employe, docteur ";
        String w="WHERE employe.numero_e=docteur.numero";
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         //this.pack();
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelInfirmiere()
    {
        String tabArgument [];
        tabArgument = new String [10];
        
        String select [];
        select = new String [10];
        
        tabArgument[0]="Nom";
        tabArgument[1]="Prenom";
        tabArgument[2]="Numéro_Employe";
        tabArgument[3]="Telephone";
        tabArgument[4]="Adresse"; 
        tabArgument[5]="Rotation"; 
        tabArgument[6]="Salaire"; 
        tabArgument[7]="Nom_Service"; 
        tabArgument[8]="Batiment_Service"; 
        tabArgument[9]="Directeur_Service";
        
        select[0]="nom_employe";
        select[1]="prenom_employe";
        select[2]="numero_e";
        select[3]="telephone_employe";
        select[4]="adresse_employe"; 
        select[5]="rotation"; 
        select[6]="salaire";
        select[7]="nom_service";
        select[8]="batiment";
        select[9]="directeur"; 
        
        
        String f="FROM employe, infirmier, service ";
        String w="WHERE employe.numero_e=infirmier.numero AND infirmier.code_service = service.code";
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         //this.pack();
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageAjout()
    {
         this.setVisible(false);
         this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageAjout(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
     public void launchPageAjoutDoc()
    {
         this.setVisible(false);
         this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageAjoutDocteur(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
     
      public void launchPageAjoutInf()
    {
         this.setVisible(false);
         this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageAjoutInfirmier(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageStatistique()
    {
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageStatistique(BDD));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object  source =e.getSource();
 
        if(source == menu.getInsertionDocteur())
            launchPageAjoutDoc();
		if(source == menu.getInsertionInfirmier())
            launchPageAjoutInf();
		if(source == menu.getInsertionMalade())
            launchPageAjout();
		
        if(source == menu.getModification())
            System.out.println("Modification");
        if(source == menu.getSuppression())
            System.out.println("Suppression");
        
        if(source == menu.getRecherchePersonnelEmploye())
            launchPageRecherchePersonnelEmploye();
        
        if(source == menu.getRecherchePersonnelDocteur())
            launchPageRecherchePersonnelDocteur();
        
        if(source == menu.getRecherchePersonnelInfirmier())
            launchPageRecherchePersonnelInfirmiere();
        
        if(source == menu.getRecherchePatient())
             System.out.println("Recherche Patient");
        if(source == menu.getRechercheService())
             System.out.println("Recherche Service");
        
        if(source == menu.getStatistique())
             launchPageStatistique();
        if(source == menu.getDeconnexion())
             launchPageConnexion();
    }
}
