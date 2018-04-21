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
import modele.Docteur;
import modele.Infirmier;
import modele.Patient;

import vue.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame implements ActionListener
{    
    // Base de donnée
    private GestionBase BDD;
    
    private MenuBar menu;
    
       public HubGraph()
    {         
         this.setTitle("Hopital");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
         
         menu = new MenuBar();
         
         menu.getInsertionDocteur().addActionListener(this);
		 menu.getInsertionInfirmier().addActionListener(this);
		 menu.getInsertionPatient().addActionListener(this);
		 
         menu.getModification().addActionListener(this);;
		 
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
        String tabArgument [] = {"Nom", "Prenom", "Numéro d'employé", "Téléphone", "Adresse"};
        String select [] = {"nom_employe", "prenom_employe", "numero_e", "telephone_employe", "adresse_employe"};
 
        String f="FROM employe ";
        String w="";
        
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument, select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelDocteur()
    {
		String tabArgument [] = {"Nom", "Prenom", "Numéro d'employé", "Téléphone", "Adresse", "Spécialité"};
        String select [] = {"nom_employe", "prenom_employe", "numero_e", "telephone_employe", "adresse_employe", "specialite"};
        
        String f="FROM employe, docteur ";
        String w="WHERE employe.numero_e=docteur.numero";
        
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelInfirmier()
    {
        String tabArgument [] = {"Nom", "Prenom", "Numéro d'employé", "Téléphone", "Adresse", "Rotation", "Salaire", "Nom du service", "Batiment du service", "Directeur du service"};
        String select [] = {"nom_employe", "prenom_employe", "numero_e", "telephone_employe", "adresse_employe", "rotation", "salaire", "nom_service", "batiment", "directeur"};
		
        String f="FROM employe, infirmier, service ";
        String w="WHERE employe.numero_e=infirmier.numero AND infirmier.code_service = service.code";
        
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRechercheMalade()
    {
        String tabArgument [] = {"Nom", "Prenom", "Numéro du patient", "Téléphone", "Adresse", "Mutuelle", "Date d'arrivée"};
        String select [] = {"nom_malade", "prenom_malade", "numero_m", "tel_malade", "adresse_malade", "mutuelle", "date_arrive"};
		
        String f="FROM malade ";
        String w="";
        
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRechercheService()
    {
        String tabArgument [] = {"Code", "Nom du Service", "Batiment", "Directeur"};
        String select [] = {"code", "nom_service", "batiment", "directeur"};
		
        String f="FROM service "; 
        String w="";
        
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    
    
    public void launchPageAjoutPatient()
    {
         this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageAjoutPatient(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
     public void launchPageAjoutDocteur()
    {
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
     
      public void launchPageAjoutInfirmier()
    {
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
	  
	  public void launchPageModification()
	  {
		 this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageModification(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true); 
	  }
	  
	  public void launchPageModificationDocteur(Docteur doc)
	  {
		 this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageModificationDocteur(doc, BDD, this));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true); 
	  }
	  
	  public void launchPageModificationInfirmier(Infirmier inf)
	  {
		 this.setJMenuBar(menu);
		try {
			this.setContentPane(new PageModificationInfirmier(inf, BDD, this));
		} catch (ParseException ex) {
			Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
		}
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true); 
	  }
	  
	  public void launchPageModificationPatient(Patient pat)
	  {
		 this.setJMenuBar(menu);
		try {
			this.setContentPane(new PageModificationPatient(pat, BDD, this));
		} catch (ParseException ex) {
			Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
		}
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true); 
	  }
      
      public void launchPageSuppression()
    {
         this.setJMenuBar(menu);
         try {
			this.setContentPane(new PageSuppression(this,BDD));
		 } catch (ParseException ex) {
           Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageStatistique()
    {
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
            launchPageAjoutDocteur();
        if(source == menu.getInsertionInfirmier())
            launchPageAjoutInfirmier();
        if(source == menu.getInsertionPatient())
            launchPageAjoutPatient();
		
        if(source == menu.getModification())
            launchPageModification();
		
        if(source == menu.getSuppression())
            launchPageSuppression();
        
        if(source == menu.getRecherchePersonnelEmploye())
            launchPageRecherchePersonnelEmploye();
        if(source == menu.getRecherchePersonnelDocteur())
            launchPageRecherchePersonnelDocteur();
        if(source == menu.getRecherchePersonnelInfirmier())
            launchPageRecherchePersonnelInfirmier();
        if(source == menu.getRecherchePatient())
             launchPageRechercheMalade();
        if(source == menu.getRechercheService())
             launchPageRechercheService();
        
        
        if(source == menu.getStatistique())
             launchPageStatistique();
		
        if(source == menu.getDeconnexion())
             launchPageConnexion();
    }
}
