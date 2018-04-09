/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import vue.navigation.*;

import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class HubGraph extends JFrame {
    private PageConnexion PConnexion;
    private PageInterrogation PInterrogation;
    private PageMenu PMenu;
    private PageMàj PMàj;
    private PageReporting PReporting;
    
    public HubGraph()
    {
        PConnexion = new PageConnexion(this);
        launchWindows(PConnexion);
    }
    
    public void launchWindows(JPanel panneau)
    {
        setTitle("Hopital"); 
        
        this.setLayout(new BorderLayout()); // Aggrandit la fenetre en fonction de la taille des éléments à l'intérieur
        this.add(panneau, BorderLayout.CENTER);
        this.pack();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme la fenetre automatiquement
        this.setLocationRelativeTo(null); // Met la fenetre au milieu
        this.setVisible(true); // Rend la fenetre visible
    }
    
    public void launchPageConnexion()
    {
        PConnexion = new PageConnexion(this);
        launchWindows(PConnexion);
    }
    
    public void launchPageInterrogation()
    {
        
    }
    
    public void launchMenu()
    {
        
    }
    
    public void launchMàj()
    {
        
    }
    
    public void launchPageReporting()
    {
        
    }
}
