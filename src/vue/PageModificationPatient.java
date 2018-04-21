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
import java.text.SimpleDateFormat;
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
import modele.Patient;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Alex1
 */
public class PageModificationPatient extends JPanel implements ActionListener {
	// Patient
	private Patient pat;
	
    // Lien vers le panneau gérant l'interface graphique
    private HubGraph hub;

    // Connexion vers la base de donnée
    private GestionBase BDD;

    //nouvel objet malade
    private Patient patient;

    // container
    private JPanel container;

    //JLabel
    private JLabel no;
    private JLabel pre;
    private JLabel numérotel;
    private JLabel adr;
    private JLabel mal;
    private JLabel mut;
    private JLabel dateArrivée;
   

    //combobox sur le type de maladie du patient pour l'affecter à un service
    private JComboBox maladie;

    //Zones de texte: nom, prénom, adresse, numero de tel
    private JTextField nom;
    private JTextField prénom;
    private JTextField adresse;
    private JFormattedTextField tel;
    private JTextField mutuelle;
    
    //date
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter;
    private JDatePickerImpl datePicker;
    private JDatePanelImpl datePanel;
     
    

    // Chargement de l'image
    private JLabel image;

    //bouton ajouter patient
    private JButton bouton;


	public PageModificationPatient(Patient _pat, GestionBase _BDD, HubGraph _hub) throws ParseException
	{
		// Patient
		pat = _pat;
		
		// Hub graphique
        hub = _hub;

        // Base de donnée
        BDD = _BDD;

        // Container
        container = new JPanel();
        container.setLayout(null);

        adr = new JLabel("Adresse :");
        no = new JLabel("Nom :");
        pre = new JLabel("Prénom :");
        numérotel = new JLabel("Numéro de tel. :");
        mal = new JLabel("Service affecté : ");
        mut = new JLabel("Mutuelle : ");
        dateArrivée= new JLabel("Date d'arrivée : ");
        
        //date
        UtilDateModel model=new UtilDateModel();
        datePanel=new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText(pat.getDate());

        //Création des combobox
        maladie = new JComboBox();
		maladie.addItem(pat.getService());
		
        // On ajoute les services restants dans la combobox
		String tableService[] = {"REA", "CHG", "CAR"};
		for(String serviceAssigne : tableService)
		{
			if( !serviceAssigne.equals(pat.getService()) )
				maladie.addItem(serviceAssigne);
		}

        //création des zones de texte
        nom = new JTextField(pat.getNom());
        prénom = new JTextField(pat.getPrenom());
        adresse = new JTextField(pat.getAdresse());
        mutuelle = new JTextField(pat.getMutuelle());
		
        //Format téléphonique
        MaskFormatter format = new MaskFormatter("## ## ## ## ##");
        tel = new JFormattedTextField(format);
		tel.setText(pat.getTel());
      
        //image
        image = new JLabel(new ImageIcon("images\\form.png"));
        //Creéation du bouton
        bouton = new JButton("Modifier");

        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();

        
         
        this.setBackground(Color.white); // Définir la couleur de l'arrière plan

        this.add(container);
	}
	
	public void constructionGraphique() {
		// Titre de bienvenue
        JLabel titre = new JLabel("Edition du formulaire : ");
        titre.setFont(new Font("Arial", Font.BOLD, 24)); // Attribuer la police au titre
        //panel contenant le titre
        JPanel t = new JPanel();
        t.add(titre);
        this.setLayout(null);

        this.add(t);
        t.setVisible(true);
        t.setBounds(350, 0, 300, 30);
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
        mal.setBackground(Color.white);
        mal.setFont(new Font("Arial", Font.BOLD, 15));
        pan5.add(mal);

        //label mutuelle placé dans un planel
        JPanel pan6 = new JPanel();
        mut.setFont(new Font("Arial", Font.BOLD, 15));
        pan6.add(mut);

        //label mutuelle placé dans un planel
        JPanel pan7 = new JPanel();
        pan7.add(image);
        
        //label mutuelle placé dans un planel
        JPanel pan8 = new JPanel();
        pan8.add(datePicker);
        
        //texte date d arrivée
        JPanel pan9 = new JPanel();
        dateArrivée.setFont(new Font("Arial", Font.BOLD, 15));
        pan9.add(dateArrivée);

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

        //placer label adresse  sur la page
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
        
        //placer label mutuelle 
        this.add(pan9);
        pan9.setVisible(true);
        pan9.setBounds(550, 400, 130, 40);
        pan9.setBackground(Color.white);

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
        
        //calendrier
        this.add(pan8);
        pan8.setVisible(true);
        pan8.setBounds(670, 396, 230, 50);
        pan8.setBackground(Color.white);

        //placer bouton
        this.add(bouton);
        bouton.setVisible(true);
        bouton.setBounds(440, 450, 120, 80);
        bouton.addActionListener(this);
    }
	
	
	@Override
    public void actionPerformed(ActionEvent e)
	{
        Object source = e.getSource();
		
		if (source == bouton)
		{
			// Changement dans la table malade
			if(!nom.getText().equals(pat.getNom()) || !prénom.getText().equals(pat.getPrenom()) || !adresse.getText().equals(pat.getAdresse()) || !tel.getText().equals(pat.getTel()) || !mutuelle.getText().equals(pat.getMutuelle()) || !datePicker.getJFormattedTextField().getText().equals(pat.getDate()))
			{
				try {
					BDD.executerRequete("UPDATE malade SET nom_malade = '" + nom.getText() + "', prenom_malade = '" + prénom.getText() + "', adresse_malade = '" + adresse.getText() + "', tel_malade = '" + tel.getText() + "', mutuelle = '" + (String) mutuelle.getText() + "', date_arrive = '" + datePicker.getJFormattedTextField().getText() + "' WHERE numero_m = " + pat.getNum() + ";");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationInfirmier.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			// Changement dans la table hospitalisation
			if(!((String)maladie.getSelectedItem()).equals(pat.getService()))
			{
				try {
					BDD.executerRequete("UPDATE hospitalisation SET code_service = '" + (String) maladie.getSelectedItem() + "' WHERE no_malade = '" + pat.getNum() + "';");
				} catch (SQLException ex) {
					Logger.getLogger(PageModificationDocteur.class.getName()).log(Level.SEVERE, null, ex);
				} 
			}
			hub.launchPageMenu(BDD);
		}
	}
}

