/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import javax.swing.JPanel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



/**
 *
 * @author 
 */
public class Camembert extends JPanel {


    public Camembert(String titre) {
        JFreeChart diagramme = createChart(createDataset(), titre);
        
        diagramme.setPadding(new RectangleInsets(6, 12, 4, 4)); // Overlay 3D blanc
        
        ChartPanel pan = new ChartPanel(diagramme, false);
        
        pan.setMouseWheelEnabled(true); // Permet de faire tourner le diagramme
        pan.setPreferredSize(new Dimension(325, 325)); // Dimension
        this.add(pan);
    }

    /**
     *Creer des valeurs
     * 
     * @return mesValeurs
     */
    private static PieDataset createDataset() {
        DefaultPieDataset mesValeurs = new DefaultPieDataset();
        
        //initialisation des valeurs
        mesValeurs.setValue("Dept A", new Double(70));
        mesValeurs.setValue("Dept B", new Double(10));
        mesValeurs.setValue("Dept C", new Double(5));
        mesValeurs.setValue("Dept D", new Double(12));
        mesValeurs.setValue("Dept E", new Double(3));
        return mesValeurs;
    }

    /**
     * Cree un diagramme
     *
     * @param mesValeurs
     *
     * @return monDiagramme
     */
    private static JFreeChart createChart(PieDataset mesValeurs, String nom) {

        JFreeChart monDiagramme = ChartFactory.createPieChart(nom, mesValeurs,false,true,false);

        // customise the title position and font
        TextTitle titre = monDiagramme.getTitle();

        PiePlot tracer = (PiePlot) monDiagramme.getPlot();
        tracer.setBackgroundPaint(null);
        tracer.setOutlineVisible(false);

        // use gradients and white borders for the section colours
        tracer.setSectionPaint("Dept A", createGradientPaint(new Color(200, 200, 255), Color.BLUE));
        tracer.setSectionPaint("Dept B", createGradientPaint(new Color(255, 200, 200), Color.RED));
        tracer.setSectionPaint("Dept C", createGradientPaint(new Color(200, 255, 200), Color.GREEN));
        tracer.setSectionPaint("Dept D", createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
        
        
        tracer.setDefaultSectionOutlinePaint(Color.WHITE);
        tracer.setSectionPaint("Dept E", createGradientPaint(new Color(200,200,255), Color.CYAN));
        
        tracer.setSectionOutlinesVisible(true);
        tracer.setDefaultSectionOutlineStroke(new BasicStroke(2.0f));

        tracer.setLabelFont(new Font("Courier New", Font.BOLD, 20));
        tracer.setLabelLinkStroke(new BasicStroke(2.0f));
        
        return monDiagramme;

    }

    /**
     * Methode permettant de creer des gradients de couleur
     * 
     * @param c1  couleur 1
     * @param c2  couleur 2
     * 
     * @return gradient radial
     */
    private static RadialGradientPaint createGradientPaint(Color c1, Color c2) {
        Point2D center = new Point2D.Float(0, 0);
        float radius = 200;
        float[] dist = {0.0f, 1.0f};
        return new RadialGradientPaint(center, radius, dist,
                new Color[] {c1, c2});
    }
}

