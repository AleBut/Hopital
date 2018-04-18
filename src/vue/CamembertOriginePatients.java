/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Alex1
 */
public class CamembertOriginePatients extends Camembert {
	
	public CamembertOriginePatients(String titre, GestionBase BDD) {
		super(titre, BDD);
	}
	
	@Override
	public PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
		
		ArrayList<String> nomVille = new ArrayList<>();
		ArrayList<String> listeVilles = new ArrayList<>(getVilleRequete());

		// Supprimer les doublons, et mettre tout ça dans nomVille
		Set<String> hs = new HashSet<>();
		hs.addAll(listeVilles);
		nomVille.addAll(hs);
		
		// On déclare la taille du tableau contenant le nombre de patients dans chaque ville
		double nombrePatients[] = new double[nomVille.size()];
		for(int i=0; i<nombrePatients.length; i++)
			nombrePatients[i] = 0;
		
		// On remplit le nombre de répétition d'une ville
		for(int i=0; i<listeVilles.size(); i++)
		{
			for(int j=0; j<nomVille.size(); j++)
			{
				if(listeVilles.get(i).equals(nomVille.get(j)))
					nombrePatients[j] += 1;
			}
		}
		
		// Conversion du nombre de ville en pourcentage par rapport au nombre total de patients
		for(int i=0; i<nombrePatients.length; i++)
		{
			nombrePatients[i] = (nombrePatients[i] * 100) / (double) listeVilles.size();
		}
		
		for(int i=0; i<nomVille.size(); i++)
		{
			dataset.setValue(nomVille.get(i), nombrePatients[i]);
		}
		
        return dataset;
    }
	
	private ArrayList<String> getVilleRequete()
	{
		BDD.rechercheInformation("SELECT adresse_malade FROM malade");
		
		ArrayList<String> requete = new ArrayList<>(BDD.getArray());
		BDD.effacerResultat();
		
		int tailleVille;

		
		for(int i=0; i<requete.size(); i++)
		{
			tailleVille = 0;
			
			// Supprime le retour à la ligne à la fin de chaque ligne SQL
			requete.set(i, requete.get(i).substring(0, requete.get(i).length() - 1) );
			
			// Tant qu'on atteint pas l'espace qui précède le nom de la ville, on incrémente le compteur du nombre de char de la ville
			while(requete.get(i).charAt(requete.get(i).length() - tailleVille - 1) != ' ')
			{
				tailleVille++;
			}
			
			// On récupère seulement la ville, qui est le dernier élément de la requete renvoyée et dont on connait la taille en char
			requete.set(i, requete.get(i).substring(requete.get(i).length() - tailleVille));
		}
		
		return requete;
	}
}
