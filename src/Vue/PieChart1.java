/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

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
 * @author valentingiot
 */
public class PieChart1 extends ApplicationFrame {

    /**
     * Constructeur par defaut
     *
     * @param titre  du frame
     */
    public PieChart1(String titre) {
        super(titre);
        setContentPane(createPanel());
    }

    /**
     *Creer des valeurs
     * 
     * @return les valeurs
     */
    private static PieDataset createDataset() {
        DefaultPieDataset mesValeurs = new DefaultPieDataset();
        mesValeurs.setValue("Dept A", new Double(70));
        mesValeurs.setValue("Dept B", new Double(10));
        mesValeurs.setValue("Dept C", new Double(5));
        mesValeurs.setValue("Dept D", new Double(15));
        return mesValeurs;
    }

    /**
     * Cree un diagramme
     *
     * @param mesValeurs  the dataset.
     *
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset mesValeurs) {

        JFreeChart monDiagramme = ChartFactory.createPieChart("Nombre de patients par departement",mesValeurs,false,true,false);

        // customise the title position and font
        TextTitle t = monDiagramme.getTitle();

        PiePlot plot = (PiePlot) monDiagramme.getPlot();
        plot.setBackgroundPaint(null);
        plot.setOutlineVisible(false);

        // use gradients and white borders for the section colours
        plot.setSectionPaint("Dept A", 
                createGradientPaint(new Color(200, 200, 255), Color.BLUE));
        plot.setSectionPaint("Dept B", 
                createGradientPaint(new Color(255, 200, 200), Color.RED));
        plot.setSectionPaint("Dept C", 
                createGradientPaint(new Color(200, 255, 200), Color.GREEN));
        plot.setSectionPaint("Dept D", 
                createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
        plot.setDefaultSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        plot.setDefaultSectionOutlineStroke(new BasicStroke(2.0f));

        plot.setLabelFont(new Font("Courier New", Font.BOLD, 20));
        plot.setLabelLinkStroke(new BasicStroke(2.0f));
        
        return monDiagramme;

    }

    /**
     * A utility method for creating gradient paints.
     * 
     * @param c1  color 1.
     * @param c2  color 2.
     * 
     * @return A radial gradient paint.
     */
    private static RadialGradientPaint createGradientPaint(Color c1, Color c2) {
        Point2D center = new Point2D.Float(0, 0);
        float radius = 200;
        float[] dist = {0.0f, 1.0f};
        return new RadialGradientPaint(center, radius, dist,
                new Color[] {c1, c2});
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createPanel() {
        JFreeChart chart = createChart(createDataset());
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart, false);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        PieChart1 demo = new PieChart1("JFreeChart: Pie Chart Demo 1");
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
