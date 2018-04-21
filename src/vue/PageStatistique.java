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
        //this.setBackground(Color.gray); // Définir la couleur de l'arrière plan
        this.setLayout(null);
		
		JPanel camembert = new Camembert("Origine des patients", BDD);
		JPanel graphique = new GraphiqueLineaire("Arrivée des malades en fonction du temps", BDD);
		JPanel diagramme = new DiagrammeBaton("Répartition des ressources par service", BDD);
		
		camembert.setBounds(0, 0, 490, 590);
		graphique.setBounds(494, 0, 492, 295);
		diagramme.setBounds(494, 295, 492, 295);
		
		this.add(camembert);
		this.add(graphique);
		this.add(diagramme);
		
        
    }
}
