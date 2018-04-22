/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import controleur.HubGraph;
import modele.Infirmier;

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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Alexis Butin
 */
public class PageModificationInfirmier extends JPanel implements ActionListener {
	// Infirmier
	private Infirmier inf;
	
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
    
   // ButtonGroup utilisé pour gérer les boutons radios
    private JComboBox rotation;
    


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
	
	/**
	 * Crée un JPanel pour modifier un infirmier
	 * @param _inf Objet infirmier contenant les informations de l'infirmier
	 * @param _BDD Base de donnée 
	 * @param _hub Hub graphique lançant les différentes pages
	 * @throws ParseException Exceptions
	 */
	public PageModificationInfirmier(Infirmier _inf, GestionBase _BDD, HubGraph _hub) throws ParseException
	{
		// Infirmier
		inf = _inf;
		
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
        rot = new JLabel("Rotation : ");
        serv = new JLabel("Service : ");
        salaire = new JLabel("Salaire : ");
        
        //combobox
        //Creéation des combobox
        service = new JComboBox();
        service.addItem(inf.getService());
		
		// On ajoute les services restants dans la combobox
		String tableService[] = {"REA", "CHG", "CAR"};
		for(String serviceAssigne : tableService)
		{
			if( !serviceAssigne.equals(inf.getService()) )
				service.addItem(serviceAssigne);
		}
        
        
        //rotation
        rotation= new JComboBox();
		rotation.addItem(inf.getRotation());
		
		if("JOUR".equals(inf.getRotation()))
			 rotation.addItem("NUIT");
		else
			 rotation.addItem("JOUR");

		
        nom = new JTextField(inf.getNom());
        prénom = new JTextField(inf.getPrenom());
        adresse = new JTextField(inf.getAdresse());
		
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
		tel = new JFormattedTextField(format);
		tel.setText(inf.getTel());
		
        MaskFormatter format2 = new MaskFormatter("####.##");
        sal = new JFormattedTextField(format2);
		sal.setText(inf.getSalaire());
        
        //image
        image = new JLabel(new ImageIcon("images\\infirmier.png"));
        
        //bouton 
          bouton=new JButton("Modifier");

        constructionGraphique();
        

        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);
	}
	
	/**
	 * Construis graphiquement la page
	 */
	public void constructionGraphique() {
        // Titre de bienvenue
        JLabel titre = new JLabel("Modification Infirmier : ");

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

        //label adresse placé dans un panel
        JPanel pan4 = new JPanel();
        adr.setFont(new Font("Arial", Font.BOLD, 15));
        pan4.add(adr);
        
        //label rotation placé dans un panel
        JPanel pan5 = new JPanel();
        rot.setFont(new Font("Arial", Font.BOLD, 15));
        pan5.add(rot);
        
        //label radiobutton rotation placé dans un panel
        JPanel pan6 = new JPanel();
        rotation.setBackground(Color.white);
        pan6.add(rotation);
        
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
        
        //label adresse placé dans un panel
        JPanel pan10 = new JPanel();
        salaire.setFont(new Font("Arial", Font.BOLD, 15));
        pan10.add(salaire);

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
        
        //placer label rotation texte sur la page
        this.add(pan5);
        pan5.setVisible(true);
        pan5.setBounds(570, 200, 70, 30);
        pan5.setBackground(Color.white);
        
        //placer combobox rotation
        this.add(pan6);
        pan6.setVisible(true);
        pan6.setBounds(590, 196, 170, 30);
        pan6.setBackground(Color.white);
        
        //placer label contenant texte service
        this.add(pan7);
        pan7.setVisible(true);
        pan7.setBounds(570, 300, 70, 40);
        pan7.setBackground(Color.white);

        
        //placer label contenant combobox
        this.add(pan8);
        pan8.setVisible(true);
        pan8.setBounds(620, 295, 110, 40);
        pan8.setBackground(Color.white);
        
        //placer label contenant texte salaire
        this.add(pan10);
        pan10.setVisible(true);
        pan10.setBounds(570, 400, 70, 40);
        pan10.setBackground(Color.white);

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
        
        //placer champ salaire
        this.add(sal);
        sal.setVisible(true);
        sal.setBounds(660, 402, 100, 25);
        
        //placer label image
        this.add(pan9);
        pan9.setVisible(true);
        pan9.setBounds(0, 340, 400, 400);
        pan9.setBackground(Color.white);
        
        //placer bouton
        this.add(bouton);
        bouton.setVisible(true);
        bouton.setBounds(440, 450, 120, 80);
        bouton.addActionListener(this);
    }
	
	/**
	 * Vérifie que les arguments entrés par l'utilisateurs sont valides
	 * @param e L'action event si l'utilisateur clique sur le bouton de validation
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		// Si l'utilisateur clique sur le bouton Modifier
		if (source == bouton)
		{
			// Changement dans la table employe
			if(!nom.getText().equals(inf.getNom()) || !prénom.getText().equals(inf.getPrenom()) || !adresse.getText().equals(inf.getAdresse()) || !tel.getText().equals(inf.getTel()))
			{
				try {
					BDD.executerRequete("UPDATE employe SET nom_employe = '" + nom.getText() + "', prenom_employe = '" + prénom.getText() + "', adresse_employe = '" + adresse.getText() + "', telephone_employe = '" + tel.getText() + "' WHERE numero_e = " + inf.getNum() + ";");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationInfirmier.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			
			// Changement dans la table infirmier
			if(!((String) service.getSelectedItem()).equals(inf.getService()) || !((String) rotation.getSelectedItem()).equals(inf.getRotation()) || !sal.getText().equals(inf.getSalaire()) )
			{
				try {
					BDD.executerRequete("UPDATE infirmier SET code_service = '" + (String) service.getSelectedItem() + "', rotation = '" + (String) rotation.getSelectedItem() + "', salaire = '" + sal.getText() + "' WHERE numero = " + inf.getNum() + ";");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				} 
			}
			hub.launchPageMenu(BDD); // On lance le menu
		}
	}
}
