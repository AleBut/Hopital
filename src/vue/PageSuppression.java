/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import controleur.HubGraph;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author solene
 */
public class PageSuppression extends JPanel implements ActionListener {

    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;

    // Connexion vers la base de donnée
    private GestionBase BDD;

    // container
    private JPanel container;

    //combobox sur le type de personne à supprimer
    private JComboBox typePersonne;

    //combobox sur infoIdentification
    private JComboBox info;

    //Jlabel
    private JLabel NumNom;
    private JLabel type;
    private JLabel infolabel;
    private JLabel pren;

    //JTextfield
    private JTextField nomID;
    private JTextField prénom;

    private JButton bouton;

    // Chargement de l'image
    private JLabel image;
    
    /**
	 * Crée un JPanel pour supprimer une personne de la BDD
	 * @param _BDD Base de donnée 
	 * @param _hub Hub graphique lançant les différentes pages
	 * @throws ParseException Exceptions
	 */

    public PageSuppression(HubGraph _hub, GestionBase _BDD) throws ParseException {
        // Hub graphique
        hub = _hub;

        // Base de donnée
        BDD = _BDD;

        // Container
        container = new JPanel();
        container.setLayout(null);
		
		// JLabels
        pren = new JLabel("Prénom :");
        infolabel = new JLabel("Séléctionner les informations de recherche : ");
        NumNom = new JLabel("Numéro d'identification ou Nom :");
        type = new JLabel("Type de personnes à retirer : ");

        //Création des combobox
        typePersonne = new JComboBox();
        typePersonne.addItem("Docteur");
        typePersonne.addItem("Infirmier");
        typePersonne.addItem("Patient");

        //Création des combobox
        info = new JComboBox();
        info.addItem("ID");
        info.addItem("Nom Prénom");

        //création bouton 
        bouton = new JButton("Supprimer");

        //création des zones de texte
        nomID = new JTextField("");
        prénom = new JTextField("");

        //image
        image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/suppression.png")));

        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();

        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);

    }

    /**
	 * Construis graphiquement la page 
     */
    private void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Gestionnaire de suppression : ");
        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
		
        //panel contenant le titre
        JPanel t = new JPanel();
        t.add(titre);
        this.setLayout(null);

        this.add(t);
        t.setVisible(true);
        t.setBounds(310, 0, 350, 50);
        t.setBackground(Color.white);

        //label type personne placé dans un panel 
        JPanel pan1 = new JPanel();
        type.setFont(new Font("Arial", Font.BOLD, 15));
        pan1.add(type);

        //label type info placé dans un panel 
        JPanel pan2 = new JPanel();
        infolabel.setFont(new Font("Arial", Font.BOLD, 15));
        pan2.add(infolabel);

        //label contenant combobox info placé dans un panel 
        JPanel pan3 = new JPanel();
        info.setBackground(Color.white);
        pan3.add(info);

        //label contenant combobox typepersonne placé dans un panel 
        JPanel pan4 = new JPanel();
        typePersonne.setBackground(Color.white);
        pan4.add(typePersonne);

        //label type info placé dans un panel 
        JPanel pan5 = new JPanel();
        NumNom.setFont(new Font("Arial", Font.BOLD, 15));
        pan5.add(NumNom);

        //label prénom placé dans un panel 
        JPanel pan6 = new JPanel();
        pren.setFont(new Font("Arial", Font.BOLD, 15));
        pan6.add(pren);

        //label mutuelle placé dans un planel
        JPanel pan7 = new JPanel();
        pan7.add(image);

        //Placer label type personne
        this.add(pan1);
        pan1.setVisible(true);
        pan1.setBounds(120, 100, 220, 40);
        pan1.setBackground(Color.white);

        //placer label type info sur la page
        this.add(pan2);
        pan2.setVisible(true);
        pan2.setBounds(120, 200, 320, 40);
        pan2.setBackground(Color.white);

        //placer label contenant combobox info sur la page
        this.add(pan3);
        pan3.setVisible(true);
        pan3.setBounds(465, 195, 110, 40);
        pan3.setBackground(Color.white);

        //placer label contenant combobox typepersonne sur la page
        this.add(pan4);
        pan4.setVisible(true);
        pan4.setBounds(350, 95, 100, 30);
        pan4.setBackground(Color.white);

        //placer label contenant texte type info texte sur la page
        this.add(pan5);
        pan5.setVisible(true);
        pan5.setBounds(110, 300, 250, 30);
        pan5.setBackground(Color.white);

        //placer label contenant texte prénom texte sur la page
        this.add(pan6);
        pan6.setVisible(true);
        pan6.setBounds(100, 400, 100, 30);
        pan6.setBackground(Color.white);

        //placer champ texte nom-ID
        this.add(nomID);
        nomID.setVisible(true);
        nomID.setBounds(370, 302, 120, 25);

        //placer champ prénom
        this.add(prénom);
        prénom.setVisible(true);
        prénom.setBounds(200, 402, 120, 25);

        //placer label image
        this.add(pan7);
        pan7.setVisible(true);
        pan7.setBounds(600, 150, 400, 400);
        pan7.setBackground(Color.white);

        //placer bouton
        this.add(bouton);
        bouton.setVisible(true);
        bouton.setBounds(440, 450, 120, 80);
        bouton.addActionListener(this);

    }
    
    /**
	 * Vérifie que les arguments entrés par l'utilisateur sont valides
	 * @param ae L'action event si l'utilisateur clique sur le bouton de validation
	 */
    @Override
    public void actionPerformed(ActionEvent ae)
	{
        Object source = ae.getSource();
         //si on appuie sur le bouton...
        if (source == bouton) {
            //si la personne sélectionnée est de type patient...
            if (typePersonne.getSelectedItem() == "Patient") {
                //si on le cherche par numéro d'identification...
                if (info.getSelectedItem() == "ID") {
                    //test pour vérifier que tous les champs sont remplis
                    if (("".equals(nomID.getText())))
					{
                        JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);
                    }
                    //recherche du patient dans la table malade
                    String lecture1;
                    String lecture2;
                    String Information1;
                    String Information2;

                    lecture1 = "SELECT (nom_malade) FROM malade WHERE numero_m = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture1);
                    Information1 = BDD.afficherNuméro();
                    lecture2 = "SELECT (prenom_malade) FROM malade WHERE numero_m = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    
                    //si information non présente dans la table
                    if ((Information1 == null) || (Information2 == null)) {
                        //message 
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //sinon, si malade trouvé, demande de confirmation avec les infos du patient
                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le patient " + Information1 + " " + Information2 + " ID n°" + nomID.getText() + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        
                        //si bouton no cliqué, retour au menu
                        if (choix == JOptionPane.NO_OPTION) {
                            hub.launchPageMenu(BDD);
                            //sinon si oui cliqué, suppression puis retour au menu
                        } else if (choix == JOptionPane.YES_OPTION) {
                            //requete de suppression
                            String SuppressionMalade;
                            SuppressionMalade = "DELETE FROM malade WHERE numero_m = '" + nomID.getText() + "';";

                            try {
                                //execution requete
                                BDD.executerRequete(SuppressionMalade);
                                //message de fin
                                JOptionPane.showMessageDialog(this, "Le patient a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //retour au menu
                            hub.launchPageMenu(BDD);
                        }
                    }

                }
                //si on a choisi de chercher le patient par son nom et prénom...
                if (info.getSelectedItem() == "Nom Prénom") {
                    //test pour vérifier que tous les champs sont remplis
                    if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {
                        //message
                        JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                    } else {
                        //on cherche si le patient existe
                        String lecture1;
                        String lecture2;
                        String Information1;
                        String Information2;

                        lecture1 = "SELECT (numero_m) FROM malade WHERE nom_malade = '" + nomID.getText() + "' AND prenom_malade = '" + prénom.getText() + "';";
                        BDD.rechercheInformation(lecture1);
                        Information1 = BDD.afficherNuméro();
                        //s'il n existe pas
                        if (Information1 == null) {
                            //message 
                            JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //s'il existe, demande de confirmation à l'utilisateur de supprimer ce patient précis
                            int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le patient " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1 + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            
                            //si bouton no cliqué
                            if (choix == JOptionPane.NO_OPTION) {
                                //lancer menu
                                hub.launchPageMenu(BDD);
                                //sinon si bouton oui cliqué
                            } else if (choix == JOptionPane.YES_OPTION) {
                                //requête de suppresion
                                String SuppressionMalade;
                                SuppressionMalade = "DELETE FROM malade WHERE nom_malade = '" + nomID.getText() + "' AND prenom_malade = '" + prénom.getText() + "';";

                                try {
                                    //execution requête
                                    BDD.executerRequete(SuppressionMalade);
                                    JOptionPane.showMessageDialog(this, "Le patient a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                                } catch (SQLException ex) {
                                    Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                //lancer menu
                                hub.launchPageMenu(BDD);
                            }
                        }
                    }
                }

            }

        }
        //si personne à supprimer est un docteur
        if (typePersonne.getSelectedItem() == "Docteur") {
            //si on choisit de le supprimer par son numéro d'identification
            if (info.getSelectedItem() == "ID") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText()))) {

                    JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                }
                //on cherche les infos (nom prenom) du docteur correspondan au numéro si elles existent
                String lecture1;
                String lecture2;
                String lecture3;
                String Information1;
                String Information2;
                String Information3;

                lecture1 = "SELECT (numero) FROM docteur WHERE numero = '" + nomID.getText() + "';";
                BDD.rechercheInformation(lecture1);
                Information1 = BDD.afficherNuméro();
                
                //si le docteur n'est pas trouvable
                if ((Information1 == null)) {
                    //message informant que celui-ci n'existe pas
                    JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas docteur.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                } else {
                    //si le docteur existe on cherches son nom et prenom
                    lecture2 = "SELECT (nom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    lecture3 = "SELECT (prenom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture3);
                    Information3 = BDD.afficherNuméro();
                    
                    //message demandant confirmation pour supprimer ce docteur précis
                    int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le docteur " + Information2 + " " + Information3 + " ID n°" + nomID.getText() + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                    //si bouton non cliqué
                    if (choix == JOptionPane.NO_OPTION) {
                        //retour au menu
                        hub.launchPageMenu(BDD);
                        //sinon si bouton oui cliqué
                    } else if (choix == JOptionPane.YES_OPTION) {
                        //requetes de suppresions dans les tables employés et docteurs
                        String SuppressionDocteur;
                        SuppressionDocteur = "DELETE FROM docteur WHERE numero = '" + nomID.getText() + "';";
                        String SuppressionEmploye;
                        SuppressionEmploye = "DELETE FROM employe WHERE numero_e = '" + nomID.getText() + "';";

                        try {
                            //execution des requets
                            BDD.executerRequete(SuppressionDocteur);
                            BDD.executerRequete(SuppressionEmploye);
                            //message confirmation finale
                            JOptionPane.showMessageDialog(this, "Le docteur a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //retour menu
                        hub.launchPageMenu(BDD);
                    }
                }

            }
            //si on choisit de chercher le docteur par son nom et prénom
            if (info.getSelectedItem() == "Nom Prénom") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {

                    JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                } else {
                    //on cherche si le docteur existe et n'est pas infirmier
                    String lecture1;
                    String lecture2;
                    String Information1;
                    String Information2;

                    lecture1 = "SELECT (numero_e) FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";
                    BDD.rechercheInformation(lecture1);
                    Information1 = BDD.afficherNuméro();
                    
                    lecture2 = "SELECT (numero) FROM docteur WHERE  numero = '" +Information1 + "' ;";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    
                    //si aucun employe n'a ce nom et prenom ou que le numéro d'identification correspondant n est pas dans la table docteur
                    if ((Information1 == null) || (Information2 == null)) {
                        //message
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas docteur.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //sinon message de deamnde de confirmation
                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le docteur " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1 + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        
                        //si clique sur non
                        if (choix == JOptionPane.NO_OPTION) {
                            //retour au menu
                            hub.launchPageMenu(BDD);
                         //si clique sur oui
                        } else if (choix == JOptionPane.YES_OPTION) {
                            //requete de suppression sur les 2 tables
                            String SuppressionDocteur;
                            SuppressionDocteur = "DELETE FROM docteur WHERE numero = '" + Information1 + "';";

                            String SuppressionEmploye;
                            SuppressionEmploye = "DELETE FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";

                            try {
                                //executions des requetes
                                BDD.executerRequete(SuppressionDocteur);
                                BDD.executerRequete(SuppressionEmploye);
                                //message de confirmation
                                JOptionPane.showMessageDialog(this, "Le docteur a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //retour menu
                            hub.launchPageMenu(BDD);
                        }
                    }
                }
            }

        }
        
        //si la personne choisie à supprimer est infirmier
        if (typePersonne.getSelectedItem() == "Infirmier") {
            //si on le cherche par le numero d'identification
            if (info.getSelectedItem() == "ID") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText()))) {

                    JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                }
                //verification que le numero saisi est dans la table infirmier
                String lecture1;
                String lecture2;
                String lecture3;
                String Information1;
                String Information2;
                String Information3;

                lecture1 = "SELECT (numero) FROM infirmier WHERE numero = '" + nomID.getText() + "';";
                BDD.rechercheInformation(lecture1);
                Information1 = BDD.afficherNuméro();
                
                //si le numero n est pas la
                if ((Information1 == null)) {
                    //message
                    JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas infirmier.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                } else {
                    //sinon si le numero est present on recupere nom et prenom de cet infirmier
                    lecture2 = "SELECT (nom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    lecture3 = "SELECT (prenom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture3);
                    Information3 = BDD.afficherNuméro();
                    
                    //demande de confirmation d'effacer cet infirmier précis
                    int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer l'infirmier " + Information2 + " " + Information3 + " ID n°" + nomID.getText() + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                    //i clique sur non
                    if (choix == JOptionPane.NO_OPTION) {
                        //retour menu
                        hub.launchPageMenu(BDD);
                      //si clique sur oui
                    } else if (choix == JOptionPane.YES_OPTION) {
                        //requetes de suppression dans les tables infirmier et employe
                        String SuppressionInfirmier;
                        SuppressionInfirmier = "DELETE FROM infirmier WHERE numero = '" + nomID.getText() + "';";
                        String SuppressionEmploye;
                        SuppressionEmploye = "DELETE FROM employe WHERE numero_e = '" + nomID.getText() + "';";

                        try {
                            //executions des requetes
                            BDD.executerRequete(SuppressionInfirmier);
                            BDD.executerRequete(SuppressionEmploye);
                            //message de confirmation
                            JOptionPane.showMessageDialog(this, "L'infirmier a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //retour au menu
                        hub.launchPageMenu(BDD);
                    }
                }

            }
            
            //si on cherche l'infirmier par son nom et prénom
            if (info.getSelectedItem() == "Nom Prénom") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {

                    JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                } else {
                    //on vérifie que cet employe existe et si c'est bien un infirmier en cherchant son numero dans la table infirmier
                    String lecture1;
                    String lecture2;
                    String Information1;
                    String Information2;

                    lecture1 = "SELECT (numero_e) FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";
                    BDD.rechercheInformation(lecture1);
                    Information1 = BDD.afficherNuméro();
                    
                    lecture2 = "SELECT (numero) FROM infirmier WHERE  numero = '" +Information1 + "' ;";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    //si on ne trouve pas le nom et prenom ou si on ne trouve pas le numero
                    if ((Information1 == null) || (Information2 == null)) {
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas infirmier.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //sinon on demande confirmation
                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer l'infirmier " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1 + " ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        //si on clique sur non
                        if (choix == JOptionPane.NO_OPTION) {
                            //retour menu
                            hub.launchPageMenu(BDD);
                            //si on clique sur oui
                        } else if (choix == JOptionPane.YES_OPTION) {
                            //requetes de suppression
                            String SuppressionInfirmier;
                            SuppressionInfirmier = "DELETE FROM infirmier WHERE numero = '" + Information1 + "';";

                            String SuppressionEmploye;
                            SuppressionEmploye = "DELETE FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";

                            try {
                                //executions des requetes
                                BDD.executerRequete(SuppressionInfirmier);
                                BDD.executerRequete(SuppressionEmploye);
                                JOptionPane.showMessageDialog(this, "L'infirmier a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //retour menu
                            hub.launchPageMenu(BDD);
                        }
                    }
                }
            }

        }
    }
}

        


