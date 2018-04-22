/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alex1
 */
public class PageRecherche extends JPanel {
    
    
         /**
	 * Déclaration des variables
	 */
    
    // Connexion vers la base de donnée
    private GestionBase BDD;
    
    // Cocher les éléments souhaités
    private JCheckBox personnel[];
    
    private JCheckBox all;

    // Recherche texte
    private JTextField rechercheTexte;
    
    // Aide é la recherche
    private JComboBox volet;
    
    // Bouton de validation de la recherche
    private JButton valider;
	
	// Resultat recherche
	private ResultatRecherche resultat;

    // SQL Stuff
    private int tailleTab;
    
    private String select;
    private String sql[];
    private String from;
    private String where;
    private String whereInit;
    
    private String recherche;
    
    /**
	 * On construit la page recherche
         * @param _BDD La base de donnée BDD
         * @param tabArgument est la liste des attributs concernant la recherche
         * @param s est le string de SELECT par défaut
         * @param f est le string de FROM par défaut
         * @param w est le string de WHERE par défaut
	 */
    

    public PageRecherche(GestionBase _BDD, String tabArgument [], String s [], String f, String w) {
        
		// Base de donnée
        BDD = _BDD;
		
		tailleTab = tabArgument.length;
        
        // Checkbox
        personnel = new JCheckBox[tailleTab];
        for(int i=0;i<tailleTab;i++)
        { 
            personnel[i] = new JCheckBox();
            personnel[i].setText(tabArgument [i]);
        }
        
        all = new JCheckBox("Tous les elements");
        all.addActionListener(new PageRecherche.ToutCocher());
        
        
        
        // Recherche texte
        rechercheTexte = new JTextField("");
        
        
        volet = new JComboBox(tabArgument);
        
        // Valider
        valider = new JButton("Rechercher");
        valider.addActionListener(new PageRecherche.ValiderRecherche());
		
		// Resultat recherche
		resultat = new ResultatRecherche(BDD);
		
		// SQL
        select="SELECT ";
        from=f;
        where=w;
        whereInit=w;
        recherche="";
        
        sql=s;

        // Construction graphique de la fenetre dans le Jpanel container.
        constructionGraphique();
        
    }
    
    /**
	 * On affiche sur le pannel les différents éléments de la page recherche
         
	 */
    
     private void constructionGraphique()
    {
		// Layout null car on veut disposer les éléments comme on veut
		this.setLayout(null);
		
		// Options de recherche pour les utilisateurs
        Box miseEnForme = Box.createVerticalBox();
		
		JLabel titre = new JLabel("Elements souhaités: ");
		titre.setFont(new Font("Arial", Font.BOLD, 15));
		
		miseEnForme.add(new JLabel(" "));
		miseEnForme.add(titre);
		miseEnForme.add(new JLabel(" "));
                
		miseEnForme.add(all);
		
        for(int i=0; i<tailleTab; i++)
			miseEnForme.add(personnel[i]);
		
		JPanel p1 = new JPanel();
		p1.add(miseEnForme);
		p1.setBounds(0, 0, 200, 590);
		
		
		// Zone de texte pour la recherche
		rechercheTexte.setPreferredSize(new Dimension(200, 24));
		
		
        // Panneau incluant la zone de recherche, le volet et le bouton valider
        JPanel p2 = new JPanel();
        p2.add(rechercheTexte);
        p2.add(volet);
        p2.add(valider);
		p2.setBounds(200, 0, 800, 40);
		

		resultat.setBounds(200, 40, 800, 550); 
        
        this.setBackground(Color.black); // Définir la couleur de l'arriére plan
        this.add(p1);
        this.add(p2);
		this.add(resultat);   
    }
     
    class ValiderRecherche implements ActionListener //Redéfinition de la méthode actionPerformed()
	{
        
          /**
	 * Lance la recherche correspondante
	 * @param e L'action event si l'utilisateur clique sur le bouton de recherche
	 */
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			String testAdresse="";
			for(int i=0;i<tailleTab;i++)
			{
				if(personnel[i].isSelected())
				 select=select+sql[i]+", ";
			}

			String champ ="";

			if(!rechercheTexte.getText().equals(""))
			{
				for(int i=0;i<tailleTab;i++)
				{
					if(volet.getSelectedItem().toString()==personnel[i].getText())
					{
						champ=sql[i];
						testAdresse=personnel[i].getText();
					}
				}
			}

			if(!champ.equals(""))
			{   
				if(testAdresse=="Adresse")
				{
					if(where=="")
						where="WHERE "+champ+" LIKE '%"+ rechercheTexte.getText()+"%'";
					else
						where=where+" AND "+champ+" LIKE '%"+ rechercheTexte.getText()+"%'";
				}
				else
				{       
					if(where=="")
						where="WHERE "+champ+" LIKE '"+ rechercheTexte.getText()+"'";
					else
						where=where+" AND "+champ+" LIKE '"+ rechercheTexte.getText()+"'";
                                
				}
			}

			if(select.charAt(select.length()-2)==',')
				select=select.substring(0,select.length()-2)+" ";

			recherche = select + from + where;

			//System.out.println("la requete sql associé est : " + recherche);

			BDD.rechercheInformation(recherche);
			
			// Espace création
			
			// Combien de charactéristique sélectionnés? 
			int compteur = 0;
			
			for(int i=0;i<tailleTab;i++)
			{
				if(personnel[i].isSelected())
					compteur++;
			}
			
			// On remplit le tableau avec les éléments sélectionnés.
			String tabSelection[] = new String[compteur];
			
			// On remplit le tableau avec le nom des champs sélectionnés
			compteur = 0;
			for(int i=0; i<tailleTab; i++)
			{
				if(personnel[i].isSelected())
				{
					tabSelection[compteur] = personnel[i].getText();
					compteur++;
				}
					
			}
			
			// Actualise l'image
			resultat.raffraichir(tabSelection);


			select="SELECT ";
			where=whereInit;
		}
	}
    
    class ToutCocher implements ActionListener //Redéfinition de la méthode actionPerformed()
    {
        
        /**
	 * Coche ou décoche tous les éléments de la liste
	 * @param e L'action event si l'utilisateur clique sur le bouton de recherche
	 */
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(all.isSelected()==true)
			{
				for(int i=0;i<tailleTab;i++)
				{ 
					personnel[i].setSelected(true);
				}

			}

			else
			{
				for(int i=0;i<tailleTab;i++)
				{ 
					personnel[i].setSelected(false);

				}
			}
		}
    }
}