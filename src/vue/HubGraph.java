/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame {
    private PageConnexion PConnexion;
    private PageMenu PMenu;
    
    private PageRecherche PRecherche;
    private PageAjout PAjout;
    private PageStatistique PStatistique;
    
    private GestionBase BDD;
    
    public HubGraph()
    {
        PConnexion = new PageConnexion(this, BDD);
        launchWindows(PConnexion);
    }
    
    public void launchWindows(JPanel panneau)
    {
        this.setTitle("Hopital");
        this.setSize(1000, 650);
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
    
    public void launchPageMenu()
    {
        PMenu = new PageMenu(this, BDD);
        launchWindows(PMenu);
    }
    
    public void launchPageRecherche()
    {
        
    }
    
    public void launchPageAjout()
    {
        try {
            PAjout = new PageAjout(this, BDD);
            launchWindows(PAjout);
        } catch (ParseException ex) {
            Logger.getLogger(HubGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void launchPageStatistique()
    {
        
    }
}
