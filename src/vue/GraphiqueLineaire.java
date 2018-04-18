/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;

import java.awt.Dimension;
import java.text.DateFormat;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.Day;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Alex1
 */
public class GraphiqueLineaire extends JPanel {
		
	// Base de donnée
	GestionBase BDD;
	
	public GraphiqueLineaire(String titre, GestionBase _BDD)
	{
		BDD = _BDD;
		
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
        pan.setMouseWheelEnabled(true); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(500, 295)); // Dimension
        this.add(pan);
	}
	
	private XYDataset createDataset( ) {
		TimeSeriesCollection dataset = new TimeSeriesCollection();

		TimeSeries series1 = new TimeSeries("Series1");
		series1.add(new Day(1, 1, 2017), 50);
		series1.add(new Day(2, 1, 2017), 40);
		series1.add(new Day(3, 1, 2017), 45);
		series1.add(new Day(4, 1, 2017), 30);
		series1.add(new Day(5, 1, 2017), 50);
		series1.add(new Day(6, 1, 2017), 45);
		series1.add(new Day(7, 1, 2017), 60);
		series1.add(new Day(8, 1, 2017), 45);
		series1.add(new Day(9, 1, 2017), 55);
		series1.add(new Day(10, 1, 2017), 48);
		series1.add(new Day(11, 1, 2017), 60);
		series1.add(new Day(12, 1, 2017), 45);
		series1.add(new Day(13, 1, 2017), 65);
		series1.add(new Day(14, 1, 2017), 45);
		series1.add(new Day(15, 1, 2017), 55);
		dataset.addSeries(series1);
    return dataset;
   }
}
