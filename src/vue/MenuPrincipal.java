/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author solene
 */
public class MenuPrincipal extends JFrame implements ActionListener {
    private JPanel container ; // panneau
    private JButton rech=new JButton("Effectuer une recherche");
    private JButton ajout=new JButton("Ajouter un patient");
    private JButton stats=new JButton("Statistiques de l'Hopital");
    Font font = new Font("Arial",Font.BOLD,50);
    Font font2 = new Font("Arial",Font.BOLD,12);
    
    private JLabel titre = new JLabel("Menu");
    private JLabel conn = new JLabel("état : Connecté");
    
    public MenuPrincipal () { // constructeur
        setTitle ("Hopital-Menu");
        
        setSize (500, 500);
        container = new JPanel();
        
        
        titre.setFont(font);
        conn.setFont(font2);
        conn.setForeground(Color.green);
   
        container.setBackground(Color.white);
        
        rech.setPreferredSize( new Dimension( 200, 70 ) );
        ajout.setPreferredSize( new Dimension( 200, 70 ) );
        stats.setPreferredSize( new Dimension( 200, 70 ) );
        
        JPanel t = new JPanel();
        t.setBackground(Color.white);
        t.add(conn);
        t.add(titre);
        
        
        JPanel b1 = new JPanel();
        b1.setBackground(Color.white);
        b1.add(rech);
        b1.setPreferredSize( new Dimension( 200, 100 ) );
        
        
        JPanel b2 = new JPanel();
        b2.setBackground(Color.white);
        b2.add(ajout);
        b2.setPreferredSize( new Dimension( 200, 100 ) );
        
        
        JPanel b3 = new JPanel();
        b3.setBackground(Color.white);
        b3.add(stats);
        
       
        b3.setPreferredSize( new Dimension( 200, 100 ) );
        
        
        
        //bouton.addActionListener(this);
        
        
         Box v = Box.createVerticalBox();
        
         v.add(t);
         v.add(b1);
         v.add(b2);
         v.add(b3);
         
         container.add(v);
         getContentPane().add(container); 
    }
    
    
    
    
    
    @Override
    public  void    actionPerformed(ActionEvent e)
    {
        Object  source=e.getSource();
        
        if  (source==rech)
        {
            
        }
        
        if  (source==ajout)
        {
            
        }
        
        if  (source==stats)
        {
            
        }
        
    }
}
