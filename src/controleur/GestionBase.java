/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author A
 */
public class GestionBase {
    private ArrayList<String> array = new ArrayList<>();
    private Connexion co;
    
    /**
     *
     */
    public GestionBase()
    {   
        System.out.println("Connexion à la base de donnée locale...");
        try {
            co = new Connexion("Hopital", "root", "");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erreur: " + ex);
            System.exit(1);
        }
        System.out.println("Connecté!");
    }
    
    public boolean rechercheInformation(String command)
    {
        try {
            array = co.remplirChampsRequete(command);
        } catch (SQLException ex) {
            System.out.println("Erreur rechercheInformation(): " + ex);
            return false;
        }
        return true;
    }
    
    public void afficherInformations()
    {
        for(int i=0; i<array.size(); i++)
            System.out.print(array.get(i));
        
        array.clear();
    }
}
