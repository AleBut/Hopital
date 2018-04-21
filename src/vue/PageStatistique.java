/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author Alex1
 */
public class PageStatistique extends JPanel {    
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
        this.setLayout(new GridLayout(1,2));
		
		// Box de mise en forme
        Box miseEnForme = Box.createVerticalBox();
		miseEnForme.add(new GraphiqueLineaire("Arrivée des malades en fonction du temps", BDD));
		miseEnForme.add(new DiagrammeBaton("Répartition des ressources par service", BDD));
        
        this.add(new Camembert("Origine des patients", BDD));
        this.add(miseEnForme);
    }
}
