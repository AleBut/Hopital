/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



/**
 *
 * @author Alex1
 */
public class Camembert extends JPanel {
    public Camembert(String titre) {
        boolean montrerLegendes = true; 
        boolean toolTips = true;
        boolean urls = false;
        
        JFreeChart camembert = ChartFactory.createPieChart(titre, createDataset(),montrerLegendes, toolTips, urls);
        camembert.setPadding(new RectangleInsets(0, 0, 10, 0)); // Marge en haut, gauche, bas, droit
        
        PiePlot tracer = (PiePlot) camembert.getPlot();
        tracer.setBackgroundPaint(null); // Enlève l'arrière plan
        tracer.setOutlineVisible(false); // Enlève la ligne entourant le camembert
        
        ChartPanel pan = new ChartPanel(camembert);
        pan.setMouseWheelEnabled(true); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(300, 300)); // Dimension
        pan.setBackground(Color.white);
        this.add(pan);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        //initialisation des valeurs
        dataset.setValue("Dept A", new Double(70));
        dataset.setValue("Dept B", new Double(10));
        dataset.setValue("Dept C", new Double(5));
        dataset.setValue("Dept D", new Double(12));
        dataset.setValue("Dept E", new Double(3));
        return dataset;
    }
}