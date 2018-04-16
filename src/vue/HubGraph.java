/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame implements ActionListener
{
    // Différentes pages possible
    private PageConnexion PConnexion;
    private PageMenu PMenu;
    
    private PageRecherche PRecherche;
    private PageAjout PAjout;
    private PageStatistique PStatistique;
    
    // Base de donnée
    private GestionBase BDD;
    
    // Element de la barre du menu
    private JMenuBar menuBar;
    
    private JMenu maj;
    private JMenuItem insertion;
    private JMenuItem modification;
    private JMenuItem suppression;
    
    private JMenuItem interrogation;
    
    private JMenuItem statistique;
    
    private JMenuItem deconnexion;
    
    public HubGraph()
    {
        // Bar de menu
         menuBar = new JMenuBar();
         
         maj = new JMenu("Màj des données");
         insertion = new JMenuItem("Insertion");
         modification = new JMenuItem("Modification");
         suppression = new JMenuItem("Suppression");
         
         interrogation = new JMenuItem("Interrogation");
        
         statistique = new JMenuItem("Statistique");
         
         deconnexion = new JMenuItem("Deconnexion");
         
         // Construction du menu graphique
         constructionGraphique();
         
         this.setTitle("Hopital");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
         this.setLocationRelativeTo(null); // Met la fenetre au milieu
         this.setVisible(true); // Rend la fenetre visible
        
        // Lance la page de connexion
        launchPageConnexion();
    }
    
    private void constructionGraphique()
    {
        maj.add(insertion);
        maj.addSeparator();
        maj.add(modification);
        maj.addSeparator();
        maj.add(suppression);
        
        menuBar.add(maj);
        menuBar.add(interrogation);
        menuBar.add(statistique);
        menuBar.add(deconnexion);
        
        insertion.addActionListener((ActionListener) this);
        modification.addActionListener(this);
        suppression.addActionListener(this);
        
        menuBar.setLayout(new GridLayout(1,4));
        
        interrogation.addActionListener(this);
        statistique.addActionListener(this);
        deconnexion.addActionListener(this);
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
         this.setJMenuBar(menuBar);
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
        
        
         this.setVisible(false);
         this.setJMenuBar(menuBar);
        try {
            this.setContentPane(new PageAjout(this,BDD));
        } catch (ParseException ex) {
            Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
         //this.pack();
         this.setSize(1000, 650);
         this.setVisible(true);
    }
    
    public void launchPageStatistique()
    { /*
         this.setVisible(false);
         this.setJMenuBar(menuBar);
         this.setContentPane(new PageStatistique(BDD));
         this.setSize(1000, 650);
         this.setVisible(true); */
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object  source =e.getSource();
        
        if(source == insertion)
            launchPageAjout();
        if(source == modification)
            System.out.println("Modification");
        if(source == suppression)
            System.out.println("Suppression");
        if(source == interrogation)
            System.out.println("Interrogation");
        if(source == statistique)
             launchPageStatistique();
        if(source == deconnexion)
             launchPageConnexion();
    }
}
