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
        image = new JLabel(new ImageIcon("images\\suppression.png"));

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

        if (source == bouton) {

            if (typePersonne.getSelectedItem() == "Patient") {
                if (info.getSelectedItem() == "ID") {
                    //test pour vérifier que tous les champs sont remplis
                    if (("".equals(nomID.getText())))
					{
                        JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);
                    }

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

                    if ((Information1 == null) || (Information2 == null)) {
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer le patient " + Information1 + " " + Information2 + " ID n°" + nomID.getText(), "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (choix == JOptionPane.NO_OPTION) {
                            hub.launchPageMenu(BDD);
                        } else if (choix == JOptionPane.YES_OPTION) {
                            String SuppressionMalade;
                            SuppressionMalade = "DELETE FROM malade WHERE numero_m = '" + nomID.getText() + "';";

                            try {
                                BDD.executerRequete(SuppressionMalade);
                                JOptionPane.showMessageDialog(this, "Le patient a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            hub.launchPageMenu(BDD);
                        }
                    }

                }

                if (info.getSelectedItem() == "Nom Prénom") {
                    //test pour vérifier que tous les champs sont remplis
                    if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {

                        JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                    } else {
                        String lecture1;
                        String lecture2;
                        String Information1;
                        String Information2;

                        lecture1 = "SELECT (numero_m) FROM malade WHERE nom_malade = '" + nomID.getText() + "' AND prenom_malade = '" + prénom.getText() + "';";
                        BDD.rechercheInformation(lecture1);
                        Information1 = BDD.afficherNuméro();
                        System.out.println(Information1);
                        if (Information1 == null) {
                            JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer le patient " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (choix == JOptionPane.NO_OPTION) {
                                hub.launchPageMenu(BDD);
                            } else if (choix == JOptionPane.YES_OPTION) {
                                String SuppressionMalade;
                                SuppressionMalade = "DELETE FROM malade WHERE nom_malade = '" + nomID.getText() + "' AND prenom_malade = '" + prénom.getText() + "';";

                                try {
                                    BDD.executerRequete(SuppressionMalade);
                                    JOptionPane.showMessageDialog(this, "Le patient a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                                } catch (SQLException ex) {
                                    Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                hub.launchPageMenu(BDD);
                            }
                        }
                    }
                }

            }

        }

        if (typePersonne.getSelectedItem() == "Docteur") {
            if (info.getSelectedItem() == "ID") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText()))) {

                    JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                }

                String lecture1;
                String lecture2;
                String lecture3;
                String Information1;
                String Information2;
                String Information3;

                lecture1 = "SELECT (numero) FROM docteur WHERE numero = '" + nomID.getText() + "';";
                BDD.rechercheInformation(lecture1);
                Information1 = BDD.afficherNuméro();

                if ((Information1 == null)) {
                    JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                } else {
                    lecture2 = "SELECT (nom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    lecture3 = "SELECT (prenom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture3);
                    Information3 = BDD.afficherNuméro();

                    int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer le docteur " + Information2 + " " + Information3 + " ID n°" + nomID.getText(), "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (choix == JOptionPane.NO_OPTION) {
                        hub.launchPageMenu(BDD);
                    } else if (choix == JOptionPane.YES_OPTION) {
                        String SuppressionDocteur;
                        SuppressionDocteur = "DELETE FROM docteur WHERE numero = '" + nomID.getText() + "';";
                        String SuppressionEmploye;
                        SuppressionEmploye = "DELETE FROM employe WHERE numero_e = '" + nomID.getText() + "';";

                        try {
                            BDD.executerRequete(SuppressionDocteur);
                            BDD.executerRequete(SuppressionEmploye);
                            JOptionPane.showMessageDialog(this, "Le docteur a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        hub.launchPageMenu(BDD);
                    }
                }

            }

            if (info.getSelectedItem() == "Nom Prénom") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {

                    JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                } else {
                    String lecture1;
                    String lecture2;
                    String Information1;
                    String Information2;

                    lecture1 = "SELECT (numero_e) FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";
                    BDD.rechercheInformation(lecture1);
                    Information1 = BDD.afficherNuméro();
                    System.out.println(Information1);
                    
                    lecture2 = "SELECT (numero) FROM docteur WHERE  numero = '" +Information1 + "' ;";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    System.out.println(Information2);
                    if ((Information1 == null) || (Information2 == null)) {
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas docteur.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {

                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer le docteur " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (choix == JOptionPane.NO_OPTION) {
                            hub.launchPageMenu(BDD);
                        } else if (choix == JOptionPane.YES_OPTION) {
                            String SuppressionDocteur;
                            SuppressionDocteur = "DELETE FROM docteur WHERE numero = '" + Information1 + "';";

                            String SuppressionEmploye;
                            SuppressionEmploye = "DELETE FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";

                            try {
                                BDD.executerRequete(SuppressionDocteur);
                                BDD.executerRequete(SuppressionEmploye);
                                JOptionPane.showMessageDialog(this, "Le docteur a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            hub.launchPageMenu(BDD);
                        }
                    }
                }
            }

        }
        if (typePersonne.getSelectedItem() == "Infirmier") {
            if (info.getSelectedItem() == "ID") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText()))) {

                    JOptionPane.showMessageDialog(this, "Le champ ID est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                }

                String lecture1;
                String lecture2;
                String lecture3;
                String Information1;
                String Information2;
                String Information3;

                lecture1 = "SELECT (numero) FROM infirmier WHERE numero = '" + nomID.getText() + "';";
                BDD.rechercheInformation(lecture1);
                Information1 = BDD.afficherNuméro();

                if ((Information1 == null)) {
                    JOptionPane.showMessageDialog(this, "La personne n'existe pas.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                } else {
                    lecture2 = "SELECT (nom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    lecture3 = "SELECT (prenom_employe) FROM employe WHERE numero_e = '" + nomID.getText() + "';";
                    BDD.rechercheInformation(lecture3);
                    Information3 = BDD.afficherNuméro();

                    int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer l'infirmier " + Information2 + " " + Information3 + " ID n°" + nomID.getText(), "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (choix == JOptionPane.NO_OPTION) {
                        hub.launchPageMenu(BDD);
                    } else if (choix == JOptionPane.YES_OPTION) {
                        String SuppressionInfirmier;
                        SuppressionInfirmier = "DELETE FROM infirmier WHERE numero = '" + nomID.getText() + "';";
                        String SuppressionEmploye;
                        SuppressionEmploye = "DELETE FROM employe WHERE numero_e = '" + nomID.getText() + "';";

                        try {
                            BDD.executerRequete(SuppressionInfirmier);
                            BDD.executerRequete(SuppressionEmploye);
                            JOptionPane.showMessageDialog(this, "L'infirmier a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        hub.launchPageMenu(BDD);
                    }
                }

            }

            if (info.getSelectedItem() == "Nom Prénom") {
                //test pour vérifier que tous les champs sont remplis
                if (("".equals(nomID.getText())) || ("".equals(prénom.getText()))) {

                    JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);

                } else {
                    String lecture1;
                    String lecture2;
                    String Information1;
                    String Information2;

                    lecture1 = "SELECT (numero_e) FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";
                    BDD.rechercheInformation(lecture1);
                    Information1 = BDD.afficherNuméro();
                    System.out.println(Information1);
                    
                    lecture2 = "SELECT (numero) FROM infirmier WHERE  numero = '" +Information1 + "' ;";
                    BDD.rechercheInformation(lecture2);
                    Information2 = BDD.afficherNuméro();
                    System.out.println(Information2);
                    if ((Information1 == null) || (Information2 == null)) {
                        JOptionPane.showMessageDialog(this, "La personne n'existe pas ou n'est pas infirmier.", "Introuvable", JOptionPane.WARNING_MESSAGE);
                    } else {

                        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimmer l'infirmier " + nomID.getText() + " " + prénom.getText() + " ID n°" + Information1, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (choix == JOptionPane.NO_OPTION) {
                            hub.launchPageMenu(BDD);
                        } else if (choix == JOptionPane.YES_OPTION) {
                            String SuppressionInfirmier;
                            SuppressionInfirmier = "DELETE FROM infirmier WHERE numero = '" + Information1 + "';";

                            String SuppressionEmploye;
                            SuppressionEmploye = "DELETE FROM employe WHERE nom_employe = '" + nomID.getText() + "' AND prenom_employe = '" + prénom.getText() + "';";

                            try {
                                BDD.executerRequete(SuppressionInfirmier);
                                BDD.executerRequete(SuppressionEmploye);
                                JOptionPane.showMessageDialog(this, "L'infirmier a bien été supprimé.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                Logger.getLogger(PageSuppression.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            hub.launchPageMenu(BDD);
                        }
                    }
                }
            }

        }
    }
}

        


