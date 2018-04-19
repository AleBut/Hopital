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
		 menu.getInsertionMalade().addActionListener(this);
		 
         menu.getModification().addActionListener(this);
         menu.getSuppression().addActionListener(this);
        
         menu.getRecherchePersonnelEmploye().addActionListener(this);
         menu.getRecherchePersonnelDocteur().addActionListener(this);
         menu.getRecherchePersonnelInfirmier().addActionListener(this);
         
         menu.getRecherchePatient().addActionListener(this);
         menu.getRechercheService().addActionListener(this);
         menu.getRechercheChambre().addActionListener(this);
        
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
        
         this.setVisible(false);
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
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRecherchePersonnelInfirmiere()
    {
        String tabArgument [] = {"Nom", "Prenom", "Numéro d'employé", "Téléphone", "Adresse", "Rotation", "Salaire", "Nom du service", "Batiment du service", "Directeur du service"};
        String select [] = {"nom_employe", "prenom_employe", "numero_e", "telephone_employe", "adresse_employe", "rotation", "salaire", "nom_service", "batiment", "directeur"};
		
        String f="FROM employe, infirmier, service ";
        String w="WHERE employe.numero_e=infirmier.numero AND infirmier.code_service = service.code";
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRechercheMalade()
    {
        String tabArgument [] = {"Nom", "Prenom", "Numéro du patient", "Téléphone", "Adresse", "Mutuelle", "Date d'arrivée","Numéro Docteur en charge", "Numéro de chambre","Lit"};
        String select [] = {"nom_malade", "prenom_malade", "numero_m", "tel_malade", "adresse_malade", "mutuelle", "date_arrive", "no_docteur", "no_chambre", "lit"};
		
        String f="FROM malade, hospitalisation, soigne ";
        String w="WHERE malade.numero_m=hospitalisation.no_malade AND soigne.no_malade=malade.numero_m";
        
         this.setVisible(false);
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
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
         this.setSize(1000, 650);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void launchPageRechercheChambre()
    {
        String tabArgument [] = {"Numéro de chambre", "Surveillant", "Nombre de lit", "Nom du service","Batiment"};
        String select [] = {"no_chambre", "surveillant", "nb_lits", "nom_service","batiment"};
		
        String f="FROM service,chambre "; 
        String w="WHERE service.code=chambre.code_service ";
        
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageRecherche(BDD,tabArgument,select, f,w ));
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
            launchPageAjout();
		if(source == menu.getInsertionInfirmier())
            System.out.println("Insertion infirmier");
		if(source == menu.getInsertionMalade())
            System.out.println("Insertion malade");
		
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
             launchPageRechercheMalade();
        if(source == menu.getRechercheService())
             launchPageRechercheService();
        
        if(source == menu.getRechercheChambre())
             launchPageRechercheChambre();
        
        if(source == menu.getStatistique())
             launchPageStatistique();
        if(source == menu.getDeconnexion())
             launchPageConnexion();
    }
}
