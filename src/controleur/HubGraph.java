/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import controleur.GestionBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import vue.MenuBar;
import vue.PageConnexion;
import vue.PageMenu;
import vue.PageStatistique;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame implements ActionListener
{    
    // Base de donnée
    private GestionBase BDD;
    
    private MenuBar menu = new MenuBar(this);
    
    public HubGraph()
    {         
         this.setTitle("Hopital");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
         this.setLocationRelativeTo(null); // Met la fenetre au milieu
         this.setVisible(true); // Rend la fenetre visible
         
        menu.getInsertion().addActionListener(this);
        menu.getModification().addActionListener(this);
        menu.getSuppression().addActionListener(this);
        menu.getInterrogation().addActionListener(this);
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
         this.setVisible(true);
    }
    
    public void launchPageRecherche()
    {
        
    }
    
    public void launchPageAjout()
    {
        
    }
    
    public void launchPageStatistique()
    {
         this.setVisible(false);
         this.setJMenuBar(menu);
         this.setContentPane(new PageStatistique(BDD));
         this.setSize(1000, 650);
         this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object  source =e.getSource();
 
        if(source == menu.getInsertion())
            System.out.println("Insertion");
        if(source == menu.getModification())
            System.out.println("Modification");
        if(source == menu.getSuppression())
            System.out.println("Suppression");
        if(source == menu.getInterrogation())
            System.out.println("Interrogation");
        if(source == menu.getStatistique())
             launchPageStatistique();
        if(source == menu.getDeconnexion())
             launchPageConnexion();
    }
}
