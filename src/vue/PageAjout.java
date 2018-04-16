/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author solene
 */
public class PageAjout extends JPanel implements ActionListener {

    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;

    // Connexion vers la base de donnée
    private GestionBase BDD;

    // container
    private JPanel container;

    //JLabel
    private JLabel no;
    private JLabel pre;
    private JLabel numérotel;
    private JLabel adr;
    private JLabel mal;
    private JLabel mut;

    //combobox sur le type de maladie du patient pour l'affecter à un service
    private JComboBox maladie;

    //combobox sur la mutuelle
    private JComboBox mutuelle;

    //Zones de texte: nom, prénom, adresse, numero de tel
    private JTextField nom;
    private JTextField prénom;
    private JTextField adresse;
    private JFormattedTextField tel;
    
    // Chargement de l'image
    private JLabel image;
    

    //bouton ajouter patient
    private JButton bouton;

    public PageAjout(HubGraph _hub, GestionBase _BDD) throws ParseException {
        // Hub graphique
        hub = _hub;

        // Base de donnée
        BDD = _BDD;

        // Container
        container = new JPanel();
        container.setLayout(null);
        /*
            LA SUITE DE TON CODE POUR INITIALISER LES ATTRIBUTS ICI
         */
        adr = new JLabel("Adresse :");
        no = new JLabel("Nom :");
        pre = new JLabel("Prénom :");
        numérotel = new JLabel("Numéro de tel. :");
        mal = new JLabel("Serivice affecté : ");
        mut = new JLabel("Mutuelle : ");

        //Creéation des combobox
        maladie = new JComboBox();
        maladie.addItem("REA");
        maladie.addItem("CHG");
        maladie.addItem("CAR");

        mutuelle = new JComboBox();
        mutuelle.addItem("MNAM");
        mutuelle.addItem("LMDE");
        mutuelle.addItem("MNH");
        mutuelle.addItem("MAAF");
        mutuelle.addItem("MGEN");
        mutuelle.addItem("MMA");
        mutuelle.addItem("CNAMTS");
        mutuelle.addItem("CCVRP");
        mutuelle.addItem("MNFTC");
        mutuelle.addItem("MAS");
        mutuelle.addItem("AG2R");
        mutuelle.addItem("MGSP");
        mutuelle.addItem("LMDE");
        mutuelle.addItem("MGSP");

        //création des zones de texte
        nom = new JTextField("");
        prénom = new JTextField("");
        adresse = new JTextField("");

        //Format téléphonique
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
        tel = new JFormattedTextField(format);
        
        //image
        image = new JLabel(new ImageIcon("images\\form.png"));
        //Creéation du bouton
        bouton = new JButton("Ajouter");

        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();

        // PageConnexion renvoit ici le container à HubGraph
        this.setSize(1000, 650);
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);

    }

    private void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Formulaire : ");
        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        //panel contenant le titre
        JPanel t = new JPanel();
        t.add(titre);
        this.setLayout(null);

        this.add(t);
        t.setVisible(true);
        t.setBounds(420, 0, 180, 30);
        t.setBackground(Color.white);

        //label nom placé dans un panel     
        JPanel pan = new JPanel();
        no.setFont(new Font("Arial", Font.BOLD, 15));
        pan.add(no);

        //label prénom placé dans un panel
        JPanel pan2 = new JPanel();
        pre.setFont(new Font("Arial", Font.BOLD, 15));
        pan2.add(pre);

        //label numéro de tel placé dans un panel
        JPanel pan3 = new JPanel();
        numérotel.setFont(new Font("Arial", Font.BOLD, 15));
        pan3.add(numérotel);

        //label numéro de adresse placé dans un panel
        JPanel pan4 = new JPanel();
        adr.setFont(new Font("Arial", Font.BOLD, 15));
        pan4.add(adr);

        //label service placé dans un planel
        JPanel pan5 = new JPanel();
        mal.setFont(new Font("Arial", Font.BOLD, 15));
        pan5.add(mal);

        //label mutuelle placé dans un planel
        JPanel pan6 = new JPanel();
        mut.setFont(new Font("Arial", Font.BOLD, 15));
        pan6.add(mut);
        
        //label mutuelle placé dans un planel
        JPanel pan7 = new JPanel();
        pan7.add(image);

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

        //placer label adresse de tel sur la page
        this.add(pan4);
        pan4.setVisible(true);
        pan4.setBounds(120, 300, 70, 40);
        pan4.setBackground(Color.white);

        //placer label service concernée par la maladie
        this.add(pan5);
        pan5.setVisible(true);
        pan5.setBounds(560, 310, 120, 40);
        pan5.setBackground(Color.white);

        //placer label mutuelle 
        this.add(pan6);
        pan6.setVisible(true);
        pan6.setBounds(560, 200, 80, 40);
        pan6.setBackground(Color.white);
        
        //placer label image
        this.add(pan7);
        pan7.setVisible(true);
        pan7.setBounds(0, 350, 400, 400);
        pan7.setBackground(Color.white);

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

        //Combobox maladie
        this.add(maladie);
        maladie.setVisible(true);
        maladie.setBounds(700, 312, 70, 25);

        //Combobox mutuelle
        this.add(mutuelle);
        mutuelle.setVisible(true);
        mutuelle.setBounds(650, 202, 80, 25);
        
        

        //placer bouton
        this.add(bouton);
        bouton.setVisible(true);
        bouton.setBounds(440, 450, 120, 80);
        bouton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == bouton) {

            //test pour vérifier que tous les champs sont remplis
            if (("".equals(nom.getText())) || ("".equals(prénom.getText())) || ("".equals(tel.getText())) || ("".equals(adresse.getText()))) {
                
                JOptionPane.showMessageDialog(this,"Un champ est vide.","Erreur",JOptionPane.WARNING_MESSAGE);

            }

        }

    }

}
