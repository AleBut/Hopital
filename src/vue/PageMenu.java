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
        // Titre
        JLabel titre = new JLabel("Bienvenue,  " +  BDD.getLogin());
        titre.setFont(new Font("Arial", Font.BOLD, 15)); // Attribuer la police au titre
        
         // Image
        JLabel image = new JLabel(new ImageIcon("images\\hopitalGroot.png"));
        
        Box miseEnForme = Box.createVerticalBox();
        miseEnForme.add(titre);
        miseEnForme.add(image);
        
        // Container
        JPanel container = new JPanel();
        container.setBackground(Color.white);
        container.add(miseEnForme);
        
        // PageMenu renvoit ici le container à HubGraph
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan
        this.add(container);
     }
}

