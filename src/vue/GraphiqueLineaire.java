/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;

import java.awt.Dimension;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Valentin et Alexis
 */
public class GraphiqueLineaire extends JPanel {
		
	// Base de donnée
	GestionBase BDD;
	
	/**
	 * Construis un diagramme dans un JPanel
	 * @param titre Titre attribué au graphique
	 * @param _BDD  Base de donnnée à partir de laquelle on récupère les informations
	 */
	public GraphiqueLineaire(String titre, GestionBase _BDD)
	{
		BDD = _BDD;
		
		// Variables
        boolean montrerLegendes = true; 
        boolean toolTips = true;
        boolean urls = false;
        String xaxis = "Nombre";
        String yaxis = "Jours"; 
		
		JFreeChart graphique = ChartFactory.createTimeSeriesChart(titre, yaxis, xaxis, createDataset(), montrerLegendes, toolTips, toolTips);
		graphique.setPadding(new RectangleInsets(0, 0, 10, 0)); // Marge en haut, gauche, bas, droit
		
		XYPlot plot = (XYPlot) graphique.getPlot();
        DateAxis domain = (DateAxis) plot.getDomainAxis();
        domain.setDateFormatOverride(DateFormat.getDateInstance());
		
		ChartPanel pan = new ChartPanel(graphique);
        pan.setMouseWheelEnabled(false); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(490, 295)); // Dimension
        this.add(pan);
	}
	
	/**
	 * Récupère les données à partir de la base de donnée
	 * @return Un ensemble de donnée exploitables par le graphisme
	 */
	private XYDataset createDataset( ) {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		ArrayList<String> dates = new ArrayList<>();
		ArrayList<String> listeDates = new ArrayList<>(getDate());
		TimeSeries malades = new TimeSeries("Malades");
		
		// Supprimer les doublons, et mettre tout ça dans dates
		Set<String> hs = new HashSet<>();
		hs.addAll(listeDates);
		dates.addAll(hs);
		
		// On déclare la taille du tableau contenant le nombre de patients arrivé à chaque date
		int nombrePatients[] = new int[dates.size()];
		for(int i=0; i<nombrePatients.length; i++)
			nombrePatients[i] = 0;
		
		// On remplit le nombre de répétition d'une date
		for(int i=0; i<listeDates.size(); i++)
		{
			for(int j=0; j<dates.size(); j++)
			{
				if(listeDates.get(i).equals(dates.get(j)))
					nombrePatients[j] += 1;
			}
		}
		
		// Reponse SQL au format AAAA-MM-DD, on décompose manuellement les jours, mois et ans
		for(int i=0; i<dates.size(); i++)
		{
			String jour = dates.get(i), mois = dates.get(i), ans = dates.get(i);
			
			jour = jour.substring(8);
			
			mois = mois.substring(5);
			mois = mois.substring(0, mois.length() - 3);
			
			ans = ans.substring(0, ans.length() - 6);
			
			malades.add(new Day(Integer.parseInt(jour), Integer.parseInt(mois), Integer.parseInt(ans)), nombrePatients[i]);
		}
		dataset.addSeries(malades);
		
    return dataset;
	}
	
	/**
	 * Récupère la date d'un patient arrivé à l'hopital
	 * @return la date en String au format AAAA-MM-DD
	 */
	private ArrayList<String> getDate()
	{
		BDD.rechercheInformation("SELECT date_arrive FROM malade");
		
		ArrayList<String> requete = new ArrayList<>(BDD.getArray());
		BDD.effacerResultat();
		
		// Supprime le retour à la ligne à la fin de chaque ligne SQL
		for(int i=0; i<requete.size(); i++)
		{
			requete.set(i, requete.get(i).substring(0, requete.get(i).length() - 1) );
		}
		
		return requete;
	}
}
