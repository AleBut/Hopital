/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author solene
 */
public class PageMenu extends JPanel {
    // Connexion vers la base de donnée
    private GestionBase BDD;
  
    public PageMenu(GestionBase _BDD) { // constructeur
         // Base de donnée
        BDD = _BDD;
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
    }
    
     private void constructionGraphique()
     {
		// Layout null car on veut disposer les éléments comme on veut
		this.setLayout(null);
		this.setBackground(Color.white); // Définir la couleur de l'arrière plan
		
        // Titre
        JLabel titre = new JLabel("Bienvenue,  " +  BDD.getLogin());
        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        
         // Image
        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/hopitalAnime.gif")));
		
		// Panel contenant le titre
		JPanel p1 = new JPanel();
		p1.add(titre);
		p1.setBounds(0, 50, 1000, 50);
		p1.setBackground(Color.white);
        
		// Panel contenant l'image
        JPanel p2 = new JPanel();
		p2.add(image);
		p2.setBounds(0, 100, 1000, 490);
		p2.setBackground(Color.white);
		
		// Ajout des panels
		this.add(p1);
		this.add(p2);
     }
}

