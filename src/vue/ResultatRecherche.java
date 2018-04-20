/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Alex1
 */
public class ResultatRecherche extends JPanel {
	// Connexion vers la base de donnée
	private GestionBase BDD;
	
	private JTable tableau;
	

	public ResultatRecherche(GestionBase _BDD)
	{
		BDD = _BDD;
		
		this.setBackground(Color.white);
	}
	
	public void raffraichir(String entete[])
	{
		this.removeAll();
		
		Object[][] donnees = getDonnees(BDD, entete);
		
		tableau = new JTable(donnees, entete);
		
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Attribue l'espace de chaque colonne
		for(int i=0; i<entete.length; i++)
		{
			if(entete[i] == "Adresse")
				tableau.getColumnModel().getColumn(i).setPreferredWidth(250);
			else
				tableau.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
			
		
		this.setVisible(false);
		JScrollPane resultat;
		resultat = new JScrollPane(tableau);
		resultat.setPreferredSize(new Dimension(750, 525));
		this.add(resultat, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	private Object[][] getDonnees(GestionBase BDD, String entete[])
	{
		ArrayList<String> table = new ArrayList<>(BDD.getArray());
		BDD.effacerResultat();
		
		Object[][] donnees = new Object[table.size()][entete.length];
		
		for(int i=0; i<table.size(); i++)
		{
			String buffer[] = new String[entete.length];
			buffer = conversion(table.get(i), entete.length);
			
			for(int j=0; j<entete.length; j++)
			{
				String x = buffer[j];
				donnees[i][j] = x;
			}
		}
		
		return donnees;
	}
	
	public String[] conversion(String machaine, int nbreElement)
	{
        String retour[] = new String [nbreElement];
		String buffer;
        
        int x=0;
        
        /// On connait la taille d'avance car ça correspond au nombre d'element selectionné 
        int indice=0;
        
        
        for(int i=0;i<machaine.length();i++)
        {
            if(machaine.charAt(i)==',')
            {
				if(machaine.charAt(i+1)!=' ')
				{
					buffer = machaine.substring(x, i);
					retour[indice] = buffer;

					x = i + 1;
					indice++;
				}
            }
            
            if(i==machaine.length()-1)
            {
                buffer = machaine.substring(x, i + 1);
                retour[indice] = buffer;
                
				x = i + 1;
                indice++;
            }
        }
		return retour;
	}

}
