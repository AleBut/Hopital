/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import modele.Docteur;

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
import javax.swing.JCheckBox;
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
public class PageAjoutDocteur extends JPanel implements ActionListener {

    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;

    // Connexion vers la base de donnée
    private GestionBase BDD;

    // container
    private JPanel container;
    
    private Docteur docteur;
    

    //JLabel
    //communs aux 2 types
    private JLabel no;
    private JLabel prén;
    private JLabel adr;
    private JLabel téléphone;
    private JLabel serv;
    private JLabel spé;
    private JLabel dir;
   
    //combobox
    private JComboBox service;
    private JComboBox spécialité;
   
   
    private JCheckBox directeur;

    //JTextField
    private JTextField nom;
    private JTextField prénom;
    private JTextField adresse;
    private JFormattedTextField tel;
    


    //bouton ajouter un employé
    private JButton bouton;
    
    // Chargement de l'image
    private JLabel image;

    /**
	 * Crée un JPanel pour ajouter un docteur
	 * @param _BDD Base de donnée 
	 * @param _hub Hub graphique lançant les différentes pages
	 * @throws ParseException Exceptions
	 */
    public PageAjoutDocteur(HubGraph _hub, GestionBase _BDD) throws ParseException {
        // Hub graphique
        hub = _hub;

        // Base de donnée
        BDD = _BDD;
        
        //nouvel objet docteur
       

        // Container
        container = new JPanel();
        container.setLayout(null);

        /*Initialisation des attributs*/
        adr = new JLabel("Adresse :");
        no = new JLabel("Nom :");
        prén = new JLabel("Prénom :");
        téléphone = new JLabel("Numéro de tel. :");
        spé = new JLabel("Spécialité : ");
        serv = new JLabel("du service : ");
        dir= new JLabel("Directeur");
        //checkbox
       directeur =new JCheckBox("");
        
       //combobox
        //Creéation des combobox
        service = new JComboBox();
        service.addItem("REA");
        service.addItem("CHG");
        service.addItem("CAR");
        
        //Creéation des combobox
        spécialité = new JComboBox();
        spécialité.addItem("Anesthesiste");
        spécialité.addItem("Cardiologue");
        spécialité.addItem("Generaliste");
        spécialité.addItem("Orthopediste");
        spécialité.addItem("Pneumologue");
        spécialité.addItem("Traumatologue");
        spécialité.addItem("Radiologue");
        
        //texfield
        nom = new JTextField("");
        prénom = new JTextField("");
        adresse = new JTextField("");
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
        tel = new JFormattedTextField(format);
        
        
        //image
        image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/medecin.png")));
        
        //bouton 
          bouton=new JButton("Ajouter");
        
        //appel méthode pour afficher les composants
        constructionGraphique();
        
        

        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);

    }
    
    /**
	 * Construis graphiquement la page
    */
    public void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Recrutement Docteur : ");

        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        //panel contenant le titre
        JPanel t = new JPanel();
        t.add(titre);
        this.setLayout(null);
        this.add(t);
        t.setVisible(true);
        t.setBounds(300, 0, 410, 30);
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
        
        //label spécialité
        JPanel pan5 = new JPanel();
        spé.setFont(new Font("Arial", Font.BOLD, 15));
        pan5.add(spé);
        

        //label checkbox directeur
        JPanel pan6 = new JPanel();
        directeur.setBackground(Color.white);
        pan6.add(directeur);
        
        //label texte service
        JPanel pan7 = new JPanel();
        serv.setFont(new Font("Arial", Font.BOLD, 15));
        pan7.add(serv);
        
        //label contenant la combobox
        JPanel pan8 = new JPanel();
        service.setBackground(Color.white);
        pan8.add(service);
        
        //label contenant l'image
        JPanel pan9 = new JPanel();
        pan9.add(image);

        //label contenant la combobox
        JPanel pan10 = new JPanel();
        spécialité.setBackground(Color.white);
        pan10.add(spécialité);
        
        //label contenant la combobox
        JPanel pan11 = new JPanel();
        dir.setFont(new Font("Arial", Font.BOLD, 15));
        pan11.add(dir);
        
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
        pan4.setBounds(120, 300, 70, 40);
        pan4.setBackground(Color.white);
        
        //placer label spécialité de tel sur la page
        this.add(pan5);
        pan5.setVisible(true);
        pan5.setBounds(540, 300, 110, 40);
        pan5.setBackground(Color.white);
        
        //placer label contenant texte service
        this.add(pan7);
        pan7.setVisible(true);
        pan7.setBounds(700, 198, 120, 40);
        pan7.setBackground(Color.white);

        //placer label contenant checkbox
        this.add(pan6);
        pan6.setVisible(true);
        pan6.setBounds(570, 198, 20, 40);
        pan6.setBackground(Color.white);
        
        //placer label contenant combobox service
        this.add(pan8);
        pan8.setVisible(true);
        pan8.setBounds(800, 195, 110, 40);
        pan8.setBackground(Color.white);
        
        //placer label contenant directeur
        this.add(pan11);
        pan11.setVisible(true);
        pan11.setBounds(600, 198, 110, 40);
        pan11.setBackground(Color.white);
        
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
        
        //placer combobox spécialité
        this.add(pan10);
        pan10.setVisible(true);
        pan10.setBounds(630, 295, 160, 40);
        pan10.setBackground(Color.white);
        
        //placer label image
        this.add(pan9);
        pan9.setVisible(true);
        pan9.setBounds(0, 330, 400, 400);
        pan9.setBackground(Color.white);
        
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
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        //si on appuie sur le bouton...
        if (source == bouton) {

            //test pour vérifier que tous les champs sont remplis
            if (("".equals(nom.getText())) || ("".equals(prénom.getText())) || ("".equals(tel.getText())) || ("".equals(adresse.getText()))) {
                //message si non valide
                JOptionPane.showMessageDialog(this, "Un champ est vide.", "Erreur", JOptionPane.WARNING_MESSAGE);


            } else {
                //blinder nom et prénom de l 'employé car 2 personnes ne peuvent avoir ces 2 informations en communs
                  String blindageNom = "SELECT (nom_employe) FROM employe WHERE nom_employe= '"+nom.getText()+"';";
                BDD.rechercheInformation(blindageNom);
                String Information1 = BDD.afficherNuméro();
                String blindagePrenom = "SELECT (prenom_employe) FROM employe WHERE prenom_employe = '"+prénom.getText()+"';";
                BDD.rechercheInformation(blindagePrenom);
                String Information2 = BDD.afficherNuméro();
                
                //si aucun nom de famille ou prénom en commun OU nom de famille en commun mais pas prénom OU prénom en commun mais pas nom de famille = valide
                if ((Information1==null)&&(Information2==null)||(((null)!=Information1)&&((null)==Information2))||(((null)!=Information2)&&((null)==Information1)))
                {
                
                //on trouve le numero max d'identification de la tble employe et on affecte le num max + 1 à notre nouvel employe
                int numérofinal;
                String IDmax;
                IDmax = "SELECT MAX(numero_e) FROM employe;";
                BDD.rechercheInformation(IDmax);
                String IDnew = BDD.afficherNuméro();
                IDnew = IDnew.substring(0, IDnew.length() - 1);
                
                numérofinal = Integer.parseInt(IDnew)+1;
                
               
                //requete d'ajout du docteur dans la tablea docteur
                String requeteAjoutDocteur;
                
                docteur = new Docteur(numérofinal,nom.getText(),prénom.getText(),adresse.getText(),tel.getText(), (String) spécialité.getSelectedItem());
                requeteAjoutDocteur = "INSERT INTO docteur (numero, specialite) VALUES ('"+docteur.getNum()+"', '" + docteur.getSpécialité() + "');";
                //requete ajout employe dans la table employe
                String requeteAjoutEmploye;
                requeteAjoutEmploye = "INSERT INTO employe (numero_e, nom_employe, prenom_employe, adresse_employe, telephone_employe) VALUES ('"+docteur.getNum()+"', '" + docteur.getNom() + "', '" + docteur.getPrenom() + "', '" + docteur.getAdresse() + "', '" + docteur.getTel() + "');";
                
                
                System.out.println(requeteAjoutDocteur);
                System.out.println(requeteAjoutEmploye);
                
                try {
                    //execution des 2 requetes
                    BDD.executerRequete(requeteAjoutDocteur);
                    BDD.executerRequete(requeteAjoutEmploye);
                    JOptionPane.showMessageDialog(this, "Le docteur a bien été ajouté.", "Formulaire valide", JOptionPane.INFORMATION_MESSAGE);
                    
                      //si le docteur est directeur d'un service
                       if (directeur.isSelected()==true)
                    
                       {
                           //on ajoute +1 au nombre de directeur du service correspondant
                        String requeteAjoutDirecteur;
                        String nbdirecteur;
                        nbdirecteur = "SELECT directeur FROM service WHERE code = '"+service.getSelectedItem()+"';";
                        BDD.rechercheInformation(nbdirecteur);
                        System.out.println(service.getSelectedItem());
                        String nbnew = BDD.afficherNuméro();
                        nbnew = nbnew.substring(0, nbnew.length() - 1);
                        int nbfinal;
                        nbfinal = Integer.parseInt(nbnew)+1;
                        System.out.println(nbfinal);
                        //requete
                        requeteAjoutDirecteur="UPDATE service SET directeur = '"+nbfinal+"' WHERE code = '"+service.getSelectedItem()+"';";
                        //execution
                        BDD.executerRequete(requeteAjoutDirecteur);
                        
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(PageAjoutDocteur.class.getName()).log(Level.SEVERE, null, ex);
                }
                //lancement du menu
                hub.launchPageMenu(BDD);
            }
                //sinon si un employe possède le meme nom de famille et prenom, formulaire non valide
                else if ((((null)!=Information1)&&(((null)!=Information2)))){
                    JOptionPane.showMessageDialog(this, "Un employé possède déjà ce nom de famille et prénom.", "Formulaire non valide", JOptionPane.ERROR_MESSAGE);
                }
            }

        

    }

    }
}