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



/**
 *
 * @author solene
 */
public class PageConnexion extends JFrame implements ActionListener {
    private JPanel container ; // panneau
    private JButton bouton=new JButton("Connexion");
    Font font = new Font("Arial",Font.BOLD,24);

    private JLabel titre = new JLabel("Bienvenue !");
    private JLabel espace1 = new JLabel("");
    private JLabel label = new JLabel("Login :      ");
    private JTextField login= new JTextField("");
    
    private JLabel label2 = new JLabel("Mot de passe : ");
    private JTextField mdp= new JTextField("");
    
    private JLabel image = new JLabel( new ImageIcon( "C:\\Users\\solene\\Desktop\\Hopital-master\\images\\Cad.png"));
    
    public PageConnexion () { // constructeur
        setTitle ("Hopital");
        setSize (500, 500);
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
        login.setPreferredSize( new Dimension( 200, 24 ) );
        
        JPanel m = new JPanel();
        m.setBackground(Color.white);
        m.add(label2);
        m.add(mdp);
        mdp.setPreferredSize( new Dimension( 170, 24 ) );
        
        bouton.addActionListener(this);
        
        
         Box v = Box.createVerticalBox();
         
         v.add(titre);
         v.add(espace1);         
         v.add(log);
         v.add(m);
         v.add (espace1);
         v.add(bouton);
         
        GestionBase bdd = new GestionBase(login.getText(),mdp.getText());
         container.add(v);
         container.add(image);
         getContentPane().add(container); 
         
         
         
         
         
    }
    
    @Override
    public  void    actionPerformed(ActionEvent e)
    {
        Object  source=e.getSource();
        
        if  (source==bouton)
        {
            GestionBase bdd = new GestionBase(login.getText(),mdp.getText());
            bdd.testConnexion();
            this.dispose();
        }
    }

    
  
     
    
    
}


