/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;
import javafx.scene.chart.BarChart;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Alex1
 */
public class DiagrammeBaton extends JPanel {
    public DiagrammeBaton(String titre) {
        
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
        pan.setPreferredSize(new Dimension(300, 300)); // Dimension
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

      dataset.addValue( 1.0 , REA , malade );        
      dataset.addValue( 3.0 , REA , chambre );        
      dataset.addValue( 5.0 , REA , infirmier );          

      dataset.addValue( 5.0 , CHG , malade );        
      dataset.addValue( 6.0 , CHG , chambre );       
      dataset.addValue( 10.0 , CHG , infirmier );        

      dataset.addValue( 4.0 , CAR , malade );        
      dataset.addValue( 2.0 , CAR , chambre );        
      dataset.addValue( 3.0 , CAR , infirmier );                      

      return dataset; 
    }
}
