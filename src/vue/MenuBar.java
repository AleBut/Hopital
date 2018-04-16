/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.HubGraph;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Alex1
 */
public class MenuBar extends JMenuBar {
    private HubGraph hub;
    
    private JMenu maj;
    private JMenuItem insertion;
    private JMenuItem modification;
    private JMenuItem suppression;
    
    private JMenuItem interrogation;
    
    private JMenuItem statistique;
    
    private JMenuItem deconnexion;
    
    public MenuBar(HubGraph _hub)
    {
        hub = _hub;
        
         maj = new JMenu("Màj des données");
         insertion = new JMenuItem("Insertion");
         modification = new JMenuItem("Modification");
         suppression = new JMenuItem("Suppression");
         
         interrogation = new JMenuItem("Interrogation");
        
         statistique = new JMenuItem("Statistique");
         
         deconnexion = new JMenuItem("Deconnexion");
         
         // Construction du menu graphique
         constructionGraphique();
    }
    
     private void constructionGraphique()
    {
        maj.add(insertion);
        maj.addSeparator();
        maj.add(modification);
        maj.addSeparator();
        maj.add(suppression);
        
        this.add(maj);
        this.add(interrogation);
        this.add(statistique);
        this.add(deconnexion);

        this.setLayout(new GridLayout(1,4));
    }
     
     public JMenuItem getInsertion() { return insertion; }

     public JMenuItem getModification() { return modification; }
     
     public JMenuItem getSuppression() { return suppression; }
     
     public JMenuItem getInterrogation() { return interrogation; }

     public JMenuItem getStatistique() { return statistique; }
     
     public JMenuItem getDeconnexion() { return deconnexion; }
}
