/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import connexionBDD.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        
        ArrayList<String> array;
        System.out.println("Connexion à la base de donnée...");
        Connexion c = new Connexion("Hopital", "root", "");
        
        array = c.remplirChampsRequete("SELECT nom, prenom FROM employe WHERE numero < 10");
        
        System.out.println("Employe dont le numero de rue < 10: ");
        for(int i=0; i<array.size(); i++)
            System.out.print(array.get(i));
    }
    
}
