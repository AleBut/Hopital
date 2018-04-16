/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Alex1
 */
public class PageStatistique extends JPanel implements ActionListener {    
    // Connexion vers la base de donnée
    private GestionBase BDD;

    public PageStatistique(GestionBase _BDD)
    {   
        // Base de donnée
        BDD = _BDD;
        
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
    }
    
     private void constructionGraphique()
    {
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan
        this.setLayout(new GridLayout(2,3));
        
        this.add(new Camembert("Test1"));
        this.add(new Camembert("Test2"));
        this.add(new Camembert("Test3"));
        this.add(new Camembert("Test4"));
        this.add(new Camembert("Test5"));
        this.add(new Camembert("Test6"));
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
    }
}
