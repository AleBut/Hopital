/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;

import javax.swing.JPanel;

/**
 *
 * @author Alexis Butin
 */
public class PageStatistique extends JPanel {    
    // Connexion vers la base de donnée
    private GestionBase BDD;
	
	/**
	 * Crée un JPanel pour afficher le reporting
	 * @param _BDD Base de donnée
	 */
    public PageStatistique(GestionBase _BDD)
    {   
        // Base de donnée
        BDD = _BDD;
        
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
    }
    
	/**
	 * Construis graphiquement la page
	 */
     private void constructionGraphique()
    {
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
