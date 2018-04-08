/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import vue.*;
import javax.swing.*;

/**
 *
 * @author Alex1
 * 
 */
public class Hopital {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
    private static PageConnexion fen = new PageConnexion (); 
   
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        fen.setVisible (true);
        
        
       
       
       /** bdd.rechercheInformation("SELECT nom, prenom FROM employe WHERE numero < 10");
        
       /* System.out.println("Employe dont le numero < 10: ");
        
        bdd.afficherInformations();*/
    }
    
}
