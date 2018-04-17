/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

/**
 *
 * @author Alex1
 */
public class Histogramme extends JPanel {
    /**
     * Creates a new demo.
     *
     * @param titre  the frame title.
     */
    public Histogramme(String titre) {
        //JFreeChart histogramme = createChart(createDataset(), titre);
        
        PlotOrientation orientation = PlotOrientation.VERTICAL; 
        boolean show = false; 
        boolean toolTips = false;
        boolean urls = false;
        String xaxis = "number";
        String yaxis = "value"; 
        
        JFreeChart histogramme = ChartFactory.createHistogram( titre, xaxis, yaxis, createDataset(), orientation, show, toolTips, urls);
        histogramme.setPadding(new RectangleInsets(0, 0, 10, 0)); // Marge en haut, gauche, bas, droit
        
        ChartPanel pan = new ChartPanel(histogramme);
        pan.setMouseWheelEnabled(true); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(300, 300)); // Dimension
        this.add(pan);
    }

    /**
     * Creates a sample {@link HistogramDataset}.
     *
     * @return the dataset.
     */
    private static  HistogramDataset createDataset() {
        
        HistogramDataset dataset = new HistogramDataset();
        
        //dataset.setType(HistogramType.RELATIVE_FREQUENCY);
        
        double[] values = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
   

        dataset.addSeries("Nombre de malade ces 100 derniers jours", values, 10, 0.0, 10.0); // 10 = nombre de rectangle

        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset  a dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(IntervalXYDataset dataset, String titre) {
        JFreeChart chart = ChartFactory.createHistogram(titre, null, null, dataset, PlotOrientation.VERTICAL, true, true, true);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setForegroundAlpha(0.85f);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        // flat bars look best...
        renderer.setBarPainter(new StandardXYBarPainter());
        renderer.setShadowVisible(false);
        return chart;
    }
}