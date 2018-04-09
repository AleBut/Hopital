/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.navigation;

/**
 *
 * @author solene
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.HubGraph;

/**
 *
 * @author solene
 */
public class PageConnexion extends JPanel implements ActionListener {
    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;
    
    // Connexion vers la base de donnée
    private GestionBase BDD;
    
    // container
    private JPanel container;
    
    // Zones de texte: login, mot de passe, et mot de passe MySQL
    private JTextField login;
    private JPasswordField mdp;
    private JPasswordField mdpSQL;
   
    // Boutons radios
    private JRadioButton locale;
    private JRadioButton distance;
    
    // ButtonGroup utilisé pour gérer les boutons radios
    private ButtonGroup boutonsGroupe;
    
    // Bouton de connexion
    private JButton bouton;
    
    // Image en bas du panneau de connexion
    private JLabel image;

    public PageConnexion(HubGraph _hub) { // constructeur
        // Hub graphique
        hub = _hub;
        
        // container
        container = new JPanel();
         
        // Création des zones de texte pour les mots de passes
        login = new JTextField("");
        mdp = new JPasswordField("");
        mdpSQL = new JPasswordField("");
        
        // Création des checkbox
        locale = new JRadioButton("Connexion locale", true);
        distance = new JRadioButton("Connexion à distance", false);
        
        // Création d'un groupe de bouttons
        boutonsGroupe = new ButtonGroup();
        
        // Création du bouton
        bouton = new JButton("Connexion");
       
        // Chargement de l'image
        image = new JLabel(new ImageIcon("images\\Cad.png"));
        
        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
        
        // PageConnexion renvoit ici le container à HubGraph
        this.add(container);
    }
    
    private void constructionGraphique()
    {
        // Titre de bienvenue
        JLabel titre = new JLabel("Bienvenue !");
        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        
        
        // Mise en forme des zones de texte pour les mots de passe
        login.setPreferredSize(new Dimension(200, 24));
        mdp.setPreferredSize(new Dimension(170, 24));
        mdpSQL.setPreferredSize(new Dimension(117, 24));
        
        
        // Création pannel Login
        JPanel P_login = new JPanel();
        P_login.setBackground(Color.white);
        P_login.add(new JLabel("Login :      "));
        P_login.add(login);
        
        // Création pannel Mdp
        JPanel P_mdp = new JPanel();
        P_mdp.setBackground(Color.white);
        P_mdp.add(new JLabel("Mot de passe : "));
        P_mdp.add(mdp);
       
        // Création pannel MDP SQL
        JPanel P_mdpSQL = new JPanel();
        P_mdpSQL.setBackground(Color.white);
        P_mdpSQL.add(new JLabel("Mot de passe SQL-ECE : "));
        P_mdpSQL.add(mdpSQL);

        // Mise en forme des checkbox
        locale.setBackground(Color.white);
        distance.setBackground(Color.white);
        
        // Ajout des radios dans le groupement de boutons
        boutonsGroupe.add(locale);
        boutonsGroupe.add(distance);
        
        // Ajout du listener sur le bouton
        bouton.addActionListener(this);
 
        Box miseEnForme = Box.createVerticalBox();
        miseEnForme.add(titre); // Ajout d'un titre de bienvenue
        miseEnForme.add(P_login); // Ajout du pannel login
        miseEnForme.add(P_mdp); // Ajout du pannel mot de passe
        miseEnForme.add(P_mdpSQL); // Ajout du pannel mot de passe SQL
        miseEnForme.add(locale); // Ajout du checkbox locale
        miseEnForme.add(distance); // Ajout du checkbox distance
        miseEnForme.add(bouton); // Ajout du bouton de connexion
        //miseEnForme.add(image); // Insertion d'une image */
        
        
        container.setBackground(Color.white); // Définir la couleur de l'arrière plan
        container.add(miseEnForme); // Ajout des boutons/interfaces mises en forme
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if ( (source == bouton) && locale.isSelected() )
        {
            BDD = new GestionBase(login.getText(), mdp.getText());
            try {
                BDD.connexionLocale();
            } catch (InterruptedException ex) {
                Logger.getLogger(PageConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            // LANCER MENU  
        }
        else if ((source == bouton) && (distance.isSelected() == true))
        {
            BDD = new GestionBase(login.getText(), mdp.getText(), mdpSQL.getText());
            try {
                BDD.connexionDistance();
            } catch (InterruptedException ex) {
                Logger.getLogger(PageConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            // LANCER MENU
        }
    }
}
