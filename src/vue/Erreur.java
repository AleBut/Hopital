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
public class Erreur extends JFrame implements ActionListener{
    private JPanel container ; 
   
    Label texte = new Label("Une erreur de connexion est survenue, L'application va fermer. Veuillez réessayer");

    
    public Erreur(){
        setTitle ("erreur");
        container = new JPanel();
       
        //bouton.addActionListener(this);
        container.add(texte);
        getContentPane().add(container); 
        pack();
        
        
    }
    
            
    
    @Override
    public  void    actionPerformed(ActionEvent e)
    {
      /* Object  source=e.getSource();
        
        if  (source==bouton)
        {
            
            this.dispose();
            
        } */
        
    }
    
}
