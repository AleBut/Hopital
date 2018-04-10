/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author solene
 */
public class PageMenu extends JPanel implements ActionListener {
    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;
    
    // Connexion vers la base de donnée
    private GestionBase BDD;
    
    // container
    private JPanel container ;
    
    // Boutons utilisés pour rechercher
    private JButton rech;
    private JButton ajout;
    private JButton stats;

    
    public PageMenu(HubGraph _hub, GestionBase _BDD) { // constructeur
        // Hub graphique
        hub = _hub;
        
        // Base de donnée
        BDD = _BDD;
        
        // Container
        container = new JPanel();
        
        // Boutons
        rech = new JButton("Effectuer une recherche");
        ajout = new JButton("Ajouter un patient");
        stats  =new JButton("Statistiques de l'Hopital");
        
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
        
        // PageConnexion renvoit ici le container à HubGraph
        this.setSize(500, 500);
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan
        this.add(container);
    }
    
    private void constructionGraphique()
    {
        // Création du titre
        JLabel titre = new JLabel("Menu");
        titre.setFont(new Font("Arial",Font.BOLD,50));

        // Boutons
        rech.setPreferredSize( new Dimension( 200, 70 ) );
        ajout.setPreferredSize( new Dimension( 200, 70 ) );
        stats.setPreferredSize( new Dimension( 200, 70 ) );
        
        // Création du pannel de titre
        JPanel P_titre = new JPanel();
        P_titre.setBackground(Color.white);
        P_titre.add(titre);
        
        // Création du pannel du 1er bouton
        JPanel P_b1 = new JPanel();
        P_b1.setBackground(Color.white);
        P_b1.add(rech);
        P_b1.setPreferredSize( new Dimension( 200, 100 ) );
        
        // Création du pannel du 2ème bouton
        JPanel P_b2 = new JPanel();
        P_b2.setBackground(Color.white);
        P_b2.add(ajout);
        P_b2.setPreferredSize( new Dimension( 200, 100 ) );
        
        // Création du pannel du 3ème bouton
        JPanel P_b3 = new JPanel();
        P_b3.setBackground(Color.white);
        P_b3.add(stats);
        P_b3.setPreferredSize( new Dimension( 200, 100 ) );
        
        // Ajout des actions listener sur les boutons
        rech.addActionListener(this);
        ajout.addActionListener(this);
        stats.addActionListener(this);
        
        
        // Box de mise en forme
        Box miseEnForme = Box.createVerticalBox();
        miseEnForme.add(P_titre);
        miseEnForme.add(P_b1);
        miseEnForme.add(P_b2);
        miseEnForme.add(P_b3);
        
        // Container
        container.setBackground(Color.white);
        container.add(miseEnForme);
    }
    
    
    
    
    
    @Override
    public  void    actionPerformed(ActionEvent e)
    {
        Object  source=e.getSource();
        
        if  (source==rech)
        {
            System.out.println("Recherche");
            //hub.launchPageRecherche();
        }
        
        if  (source==ajout)
        {
            System.out.println("Ajout");
            //hub.launchPageAjout();
        }
        
        if  (source==stats)
        {
            System.out.println("Statistiques");
            //hub.launchPageStatistique();
        }
        
    }
}

