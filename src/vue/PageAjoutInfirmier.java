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
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author solene
 */
public class PageAjoutInfirmier extends JPanel implements ActionListener {

    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;

    // Connexion vers la base de donnée
    private GestionBase BDD;

    // container
    private JPanel container;
    
   
    

    //JLabel
    //communs aux 2 types
    private JLabel no;
    private JLabel prén;
    private JLabel adr;
    private JLabel téléphone;
    private JLabel salaire;
    //commun à directeur et infirmier
    private JLabel serv;
    private JComboBox service;

    //infirmier:
    private JLabel rot;
    private JRadioButton nuit;
    private JRadioButton jour;
   // ButtonGroup utilisé pour gérer les boutons radios
    private ButtonGroup rotation;
    


    //JTextField
    private JTextField nom;
    private JTextField prénom;
    private JTextField adresse;
    private JFormattedTextField tel;
    private JFormattedTextField sal;
  
  
    // Chargement de l'image
    private JLabel image;

    //bouton ajouter un employé
    private JButton bouton;

    public PageAjoutInfirmier(HubGraph _hub, GestionBase _BDD) throws ParseException {
        // Hub graphique
        hub = _hub;

        // Base de donnée
        BDD = _BDD;

        // Container
        container = new JPanel();
        container.setLayout(null);

        /*Initialisation des attributs*/
        adr = new JLabel("Adresse :");
        no = new JLabel("Nom :");
        prén = new JLabel("Prénom :");
        téléphone = new JLabel("Numéro de tel. :");
        
        
        

        nom = new JTextField("");
        prénom = new JTextField("");
        adresse = new JTextField("");
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
        MaskFormatter format2 = new MaskFormatter("####.##");
        tel = new JFormattedTextField(format);
        sal = new JFormattedTextField(format2);
        
        //image
        image = new JLabel(new ImageIcon("images\\infirmier.png"));

        constructionGraphique();
        

        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);

    }

    public void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Recrutement Infirmier : ");

        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        //panel contenant le titre
        JPanel t = new JPanel();
        t.add(titre);
        this.setLayout(null);
        this.add(t);
        t.setVisible(true);
        t.setBounds(300, 0, 350, 30);
        t.setBackground(Color.white);

       

        //label nom placé dans un panel     
        JPanel pan = new JPanel();
        no.setFont(new Font("Arial", Font.BOLD, 15));
        pan.add(no);

        //label prénom placé dans un panel
        JPanel pan2 = new JPanel();
        prén.setFont(new Font("Arial", Font.BOLD, 15));
        pan2.add(prén);

        //label numéro de tel placé dans un panel
        JPanel pan3 = new JPanel();
        téléphone.setFont(new Font("Arial", Font.BOLD, 15));
        pan3.add(téléphone);

        //label numéro de adresse placé dans un panel
        JPanel pan4 = new JPanel();
        adr.setFont(new Font("Arial", Font.BOLD, 15));
        pan4.add(adr);
        
        //label contenant l'image
        JPanel pan9 = new JPanel();
        pan9.add(image);

        //Placer label nom
        this.add(pan);
        pan.setVisible(true);
        pan.setBounds(120, 100, 50, 40);
        pan.setBackground(Color.white);

        //placer label prénom sur la page
        this.add(pan2);
        pan2.setVisible(true);
        pan2.setBounds(560, 100, 70, 40);
        pan2.setBackground(Color.white);

        //placer label numero de tel sur la page
        this.add(pan3);
        pan3.setVisible(true);
        pan3.setBounds(120, 200, 110, 40);
        pan3.setBackground(Color.white);

        //placer label adresse sur la page
        this.add(pan4);
        pan4.setVisible(true);
        pan4.setBounds(120, 300, 70, 30);
        pan4.setBackground(Color.white);

        //placer champ texte nom
        this.add(nom);
        nom.setVisible(true);
        nom.setBounds(180, 102, 200, 25);

        //placer champ prénom
        this.add(prénom);
        prénom.setVisible(true);
        prénom.setBounds(650, 102, 200, 25);

        //placer champ téléphone
        this.add(tel);
        tel.setVisible(true);
        tel.setBounds(240, 202, 140, 25);

        //placer champ adresse
        this.add(adresse);
        adresse.setVisible(true);
        adresse.setBounds(200, 302, 250, 25);
        
        //placer label image
        this.add(pan9);
        pan9.setVisible(true);
        pan9.setBounds(0, 340, 400, 400);
        pan9.setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

       

    }

}
