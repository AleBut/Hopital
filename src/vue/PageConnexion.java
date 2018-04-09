/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author solene
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solene
 */
public class PageConnexion extends JFrame implements ActionListener {

    private JPanel container; // panneau
    private JButton bouton = new JButton("Connexion");
    //private JButton boutonGandalf = new JButton("Connexion à distance");
    Font font = new Font("Arial", Font.BOLD, 24);

    private JLabel titre = new JLabel("Bienvenue !");
    private JLabel espace1 = new JLabel("");

    private JLabel label = new JLabel("Login :      ");
    private JTextField login = new JTextField("");

    private JLabel label2 = new JLabel("Mot de passe : ");
    private JPasswordField mdp = new JPasswordField("");

  

    private JLabel label4 = new JLabel("Mot de passe SQL-ECE : ");
    private JPasswordField mdp2 = new JPasswordField("");

    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton locale = new JRadioButton("Connexion locale", true);
    private JRadioButton distance = new JRadioButton("Connexion à distance", false);

    private JLabel image = new JLabel(new ImageIcon("C:\\Users\\solene\\Desktop\\Hopital-master\\images\\Cad.png"));

    public PageConnexion() { // constructeur
        setTitle("Hopital");
        setSize(500, 500);
        container = new JPanel(); // instancier le panneau

        titre.setFont(font);

        container.setBackground(Color.white);

        JPanel t = new JPanel();
        t.setLayout(new BoxLayout(t, BoxLayout.LINE_AXIS));

        t.add(titre);

        JPanel log = new JPanel();
        log.setBackground(Color.white);
        log.add(label);
        log.add(login);
        login.setPreferredSize(new Dimension(200, 24));

        JPanel m = new JPanel();
        m.setBackground(Color.white);
        m.add(label2);
        m.add(mdp);
        mdp.setPreferredSize(new Dimension(170, 24));

        
        
        JPanel m2 = new JPanel();
        m2.setBackground(Color.white);
        m2.add(label4);
        m2.add(mdp2);
        mdp2.setPreferredSize(new Dimension(117, 24));

        bouton.addActionListener(this);
        // boutonGandalf.addActionListener(this);
        locale.setBackground(Color.white);
        distance.setBackground(Color.white);
        bg.add(locale);
        bg.add(distance);

        Box v = Box.createVerticalBox();

        v.add(titre);
        v.add(espace1);
        v.add(log);
        v.add(m);
        v.add(espace1);
        
        v.add(m2);
        v.add(locale);
        v.add(distance);
        v.add(bouton);

        // v.add(boutonGandalf);
        //  GestionBase bdd = new GestionBase(login.getText(), mdp.getText());
        container.add(v);
        container.add(image);
        getContentPane().add(container);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if ((source == bouton) && (locale.isSelected() == true)) {
            

                GestionBase bdd = new GestionBase(login.getText(), mdp.getText());
            
            try {
                bdd.testConnexionLocale();
            } catch (InterruptedException ex) {
                Logger.getLogger(PageConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            
            
        } else if ((source == bouton) && (distance.isSelected() == true)) {
            
            GestionBase bdd = new GestionBase(login.getText(), mdp.getText());
            try {
                bdd.testConnexionDistance(mdp2.getText());
            } catch (InterruptedException ex) {
                Logger.getLogger(PageConnexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PageConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }

    }

}
