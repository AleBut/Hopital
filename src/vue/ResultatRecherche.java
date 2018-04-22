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
 * @author Alexis Butin et Benoit Prat
 */
public class ResultatRecherche extends JPanel {
	// Connexion vers la base de donnée
	private GestionBase BDD;
	
	private JTable tableau;
	
        /**
	 * Construis le resultat de la recherche
         * @param _BDD La base de donnée BDD
	 */

	public ResultatRecherche(GestionBase _BDD)
	{
		BDD = _BDD;
		
		this.setBackground(Color.white);
	}
        
        /**
	 * Met à jour l'interface graphique
         * @param entete correspond au nom des éléments de la requete à afficher
         * ex : nom, prenom, adresse, etc
	 */
	
	public void raffraichir(String entete[])
	{
		this.removeAll();
		
		Object[][] donnees = getDonnees(BDD, entete);
		
		tableau = new JTable(donnees, entete);
		
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Attribue l'espace de chaque colonne
		for(int i=0; i<entete.length; i++)
		{
			if("Adresse".equals(entete[i]))
				tableau.getColumnModel().getColumn(i).setPreferredWidth(250);
			else if("Nom du service".equals(entete[i]))
				tableau.getColumnModel().getColumn(i).setPreferredWidth(180);
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
        
        /**
	 * Traduit le resultat de la requete sql en objet à afficher
         * @param entete correspond au nom des éléments de la requete à afficher
         * @param _BDD La base de donnée BDD
	 */
	
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
        
        /**
	 * On convertit la chaine resultat en tableau de string des différents éléments
         * @param machaine correspond à la chaine à convertir
         * @param nbreElement est le nombre d'élément de la chaine
	 */
	
	public String[] conversion(String machaine, int nbreElement)
	{
        String retour[] = new String [nbreElement];
		String buffer;
        
        int x=0;
        
        /// On connait la taille d'avance car ça correspond au nombre d'element selectionné 
        ///Cad entete.length
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
