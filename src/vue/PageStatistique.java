/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Alex1
 */
public class PageStatistique extends JPanel implements ActionListener {
    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;
    
    // Connexion vers la base de donnée
    private GestionBase BDD;
    
    // container
    private JPanel container ;
    
    /*
        LA SUITE DE TES ATTRIBUTS ICI
    */
    
    
    
    public PageStatistique(GestionBase _BDD)
    {   
        // Base de donnée
        BDD = _BDD;
        
        // Container
        container = new JPanel();
        
        /*
            LA SUITE DE TON CODE POUR INITIALISER LES ATTRIBUTS ICI
        */
        
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
        
        // PageConnexion renvoit ici le container à HubGraph
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan
        this.add(container);
    }
    
     private void constructionGraphique()
    { /*
        Camembert C = new Camembert("Test");
        container.add(C); */
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
    }
}