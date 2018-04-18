/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Alex1
 */
public class DiagrammeBaton extends JPanel {
	
	// Base de donnée
	GestionBase BDD;
	
    public DiagrammeBaton(String titre, GestionBase _BDD) {
		
		BDD = _BDD;
        
        PlotOrientation orientation = PlotOrientation.VERTICAL; 
        boolean montrerLegendes = true; 
        boolean toolTips = true;
        boolean urls = false;
        String xaxis = "Service";
        String yaxis = "Nombre"; 
        
        JFreeChart barChart = ChartFactory.createBarChart(titre, xaxis, yaxis, createDataset(), orientation, montrerLegendes, toolTips, urls);
        barChart.setPadding(new RectangleInsets(0, 0, 10, 0)); // Marge en haut, gauche, bas, droit
        
        ChartPanel pan = new ChartPanel(barChart);
        pan.setMouseWheelEnabled(true); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(500, 295)); // Dimension
        this.add(pan);
    }

    private CategoryDataset createDataset() {
      String REA = "Reanimation et Traumatologie";        
      String CHG = "Chirurgie generale";        
      String CAR = "Cardiologie";
      
      String malade = "Malade"; // Obtenable via table hospitalisation    
      String infirmier = "Infirmiers"; // Obtenable via table Infirmier
      String chambre = "Chambres"; // Obtenable via table Chambre

      
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

      dataset.addValue( nombreSQL("hospitalisation", "REA"), REA , malade );        
      dataset.addValue( nombreSQL("chambre", "REA"), REA , chambre );        
      dataset.addValue( nombreSQL("infirmier", "REA"), REA , infirmier );          

      dataset.addValue( nombreSQL("hospitalisation", "CHG"), CHG , malade );        
      dataset.addValue(nombreSQL("chambre", "CHG"), CHG , chambre );       
      dataset.addValue( nombreSQL("infirmier", "CHG"), CHG , infirmier );        

      dataset.addValue( nombreSQL("hospitalisation", "CAR") , CAR , malade );        
      dataset.addValue( nombreSQL("chambre", "CHG"), CAR , chambre );        
      dataset.addValue( nombreSQL("infirmier", "CHG"), CAR , infirmier );                      

      return dataset; 
    }
	
	private int nombreSQL(String table, String service)
	{
		BDD.rechercheInformation("SELECT * FROM " + table + " WHERE code_service = '" + service + "'");
		
		int result = (BDD.getArray()).size();
		BDD.effacerResultat();
		
		return result;
	}
}
