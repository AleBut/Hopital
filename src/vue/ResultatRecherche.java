/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class ResultatRecherche extends JPanel {
	// Connexion vers la base de donnée
	private GestionBase BDD;
	
	private String tabArgument[];
	
	private JScrollPane ascenseur;

	public ResultatRecherche(GestionBase _BDD)
	{
		BDD = _BDD;
		
		ascenseur = new JScrollPane(this);
		ascenseur.setPreferredSize(this.getPreferredSize());
		
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public void raffraichir(String tabArgument[])
	{
		this.removeAll();
		
		int grilleTaille = tabArgument.length;
		ArrayList<String> table = new ArrayList<>(BDD.getArray());
		
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(1, grilleTaille));
		for(int i=0; i<grilleTaille; i++)
			container.add(new JLabel(tabArgument[i]));
		
		Box miseEnForme = Box.createVerticalBox();
		miseEnForme.add(container);
		
		for(int i=0; i<table.size(); i++)
		{
			// On prend une ligne contenant la réponse
			String reponse = table.get(i);
			
			miseEnForme.add(new JLabel(reponse));
		}
		
		BDD.effacerResultat();
		
		
		this.setVisible(false);
		this.add(miseEnForme);
		this.setVisible(true);
			
		//BDD.afficherInformations();
	}

}
