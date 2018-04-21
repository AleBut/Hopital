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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import modele.Docteur;

/**
 *
 * @author Alex1
 */
public class PageModificationDocteur extends JPanel implements ActionListener{
	// Docteur
	private Docteur doc;
	
    // Connexion vers la base de donnée
    private GestionBase BDD;

	// Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;
	
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
   
    //combobox
    private JComboBox service;
    private JComboBox spécialité;
   
   
    private JCheckBox directeur;

    //JTextField
    private JTextField nom;
    private JTextField prénom;
    private JTextField adresse;
    private JFormattedTextField tel;
    
    //bouton Modifier l'employé
    private JButton bouton;
    
    // Chargement de l'image
    private JLabel image;
	
	public PageModificationDocteur(Docteur _doc, GestionBase _BDD, HubGraph _hub) throws ParseException
	{
		//nouvel objet docteur
		doc = _doc;
		
		// Base de donnée
        BDD = _BDD;
		
		// Hub graphique
		hub = _hub;

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
        
        //checkbox
       directeur = new JCheckBox("Directeur");
        
       //combobox
        //Creéation des combobox
        service = new JComboBox();
        String tableService[] = {"REA", "CHG", "CAR"};
		
		// Si le docteur est directeur d'un service
		if(doc.getDirecteurService() != "")
		{
			directeur.setSelected(true);
			service.addItem(doc.getDirecteurService());
		}
		// On ajoute les services restants
		for(String serviceDirige : tableService)
		{
			if( serviceDirige != doc.getDirecteurService() )
				service.addItem(serviceDirige);
		}

        
        //Creéation des combobox, en affichant la spécialité du docteur actuel
        spécialité = new JComboBox();
		spécialité.addItem(doc.getSpécialité());
		
		String tableSpecialite[] = {"Anesthesiste", "Cardiologue", "Generaliste", "Orthopediste", "Pneumologue", "Traumatologue", "Radiologue" };
		for (String element : tableSpecialite)
		{
			if(element != doc.getSpécialité())
				spécialité.addItem(element);
		}

        
        //texfield
        nom = new JTextField(doc.getNom());
        prénom = new JTextField(doc.getPrenom());
        adresse = new JTextField(doc.getAdresse());
		
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
        tel = new JFormattedTextField(format);
		tel.setText(doc.getTel());
        
        
        //image
        image = new JLabel(new ImageIcon("images\\medecin.png"));
        
        //bouton 
          bouton=new JButton("Modifier");
		  
		constructionGraphique();
        
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan
        this.add(container);
	}
	
	public void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Modification Docteur : ");

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
        pan8.add(service);
        
        //label contenant l'image
        JPanel pan9 = new JPanel();
        pan9.add(image);

        //label contenant la combobox
        JPanel pan10 = new JPanel();
        spécialité.setBackground(Color.white);
        pan10.add(spécialité);
        
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
        pan7.setBounds(700, 200, 120, 40);
        pan7.setBackground(Color.white);

        //placer label contenant checkbox
        this.add(pan6);
        pan6.setVisible(true);
        pan6.setBounds(600, 198, 110, 40);
        pan6.setBackground(Color.white);
        
        //placer label contenant combobox service
        this.add(pan8);
        pan8.setVisible(true);
        pan8.setBounds(800, 195, 110, 40);
        pan8.setBackground(Color.white);
        
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
	
	@Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		if (source == bouton)
		{
			// Changement dans la table employe
			if(nom.getText() != doc.getNom() || prénom.getText() != doc.getPrenom() || adresse.getText() != doc.getAdresse() || tel.getText() != doc.getTel())
			{
				try {
					BDD.executerRequete("UPDATE employe SET nom_employe = '" + nom.getText() + "', prenom_employe = '" + prénom.getText() + "', adresse_employe = '" + adresse.getText() + "', telephone_employe = '" + tel.getText() + "' WHERE numero_e = " + doc.getNum() + ";");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			
			// Changement dans la table service
			// Si on supprime le poste de directeur
			if(!directeur.isSelected() && doc.getDirecteurService() != "")
			{
				try {
					BDD.executerRequete("UPDATE service SET directeur = '0' WHERE code = '" + doc.getDirecteurService() + "';");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			// Si on ajoute un poste de directeur
			else if(directeur.isSelected() && doc.getDirecteurService() == "")
			{
				try {
					BDD.executerRequete("UPDATE service SET directeur = '" + doc.getNum() + "' WHERE code = '" + service.getSelectedItem() + "';");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			// Si on modifie le service qu'il dirige
			else if( (directeur.isSelected()) && (service.getSelectedItem() != doc.getDirecteurService()) )
			{
				try {
					BDD.executerRequete("UPDATE service SET directeur = '0' WHERE code = '" + doc.getDirecteurService() + "';");
					BDD.executerRequete("UPDATE service SET directeur = '" + doc.getNum() + "' WHERE code = '" + service.getSelectedItem() + "';");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
				
			// Changement de specialite
			if(doc.getSpécialité() != (String) spécialité.getSelectedItem())
			{
				try {
					BDD.executerRequete("UPDATE docteur SET specialite = '" + (String) spécialité.getSelectedItem() + "' WHERE numero = " + doc.getNum() + ";");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		hub.launchPageMenu(BDD);
		}
	}
}
