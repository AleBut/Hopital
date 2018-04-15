/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame implements ActionListener
{
    private PageConnexion PConnexion;
    private PageMenu PMenu;
    
    private PageRecherche PRecherche;
    private PageAjout PAjout;
    private PageStatistique PStatistique;
    
    private GestionBase BDD;
    
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
        
        interrogation.addActionListener(this);
        statistique.addActionListener(this);
        deconnexion.addActionListener(this);
    }
    
    public void launchWindows(JPanel panneau)
    {
        this.setTitle("Hopital");
        this.setSize(500, 500);
        this.setContentPane(panneau);
   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
        this.setLocationRelativeTo(null); // Met la fenetre au milieu
        this.setVisible(true); // Rend la fenetre visible 
    }
    
    public void launchPageConnexion()
    {
        PConnexion = new PageConnexion(this, BDD);
        launchWindows(PConnexion);
    }
    
    public void launchPageMenu(GestionBase _BDD)
    {
        BDD = _BDD;
        PMenu = new PageMenu(BDD);
        setJMenuBar(menuBar);
        launchWindows(PMenu);
    }
    
    public void launchPageRecherche()
    {
        
    }
    
    public void launchPageAjout()
    {
        
    }
    
    public void launchPageStatistique()
    {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object  source =e.getSource();
        
        if(source == insertion)
            System.out.println("Insertion");
        if(source == modification)
            System.out.println("Modification");
        if(source == suppression)
            System.out.println("Suppression");
        
        if(source == interrogation)
            System.out.println("Interrogation");
        if(source == statistique)
             System.out.println("Statistique");
        if(source == deconnexion)
             System.out.println("Deconnexion");
    }
}
