/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class GestionBase {
    // Réponse du serveur sous forme d'un tableau de string
    private ArrayList<String> array = new ArrayList<>();
    
    
    // Objets utilisés pour la connexion locale et distante
    private Connexion co;
    private static SSHTunnel ssh;
    
    // Variables sur la connexion
    private String login;
    private String mdp;
    

    /**
     *
     */
    public GestionBase(String _login, String _mdp) {
        login = _login;
        mdp = _mdp;
    }
    
    public GestionBase(String _login, String _mdp, String _mdpSQL) {
        login = _login;
        mdp = _mdp;
    }

    public void connexionLocale(HubGraph hub) throws InterruptedException {

        System.out.println("Connexion à la base de donnée locale...");

        try
		{
            co = new Connexion("Hopital", login, mdp);
        }
		catch (SQLException | ClassNotFoundException ex)
		{
            System.out.println("Erreur: " + ex);
			JOptionPane.showMessageDialog(hub, "Une erreur de connexion est survenue, L'application va fermer. Veuillez réessayer", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Connecté!");
    }

    public void connexionDistance(HubGraph hub) throws InterruptedException {
        System.out.println("Connexion à la base de donnée distante...");

        try
		{
            co = new Connexion(login, mdp);
        }
		catch (SQLException |ClassNotFoundException ex)
		{
			System.out.println("Erreur: " + ex);
			JOptionPane.showMessageDialog(hub, "Une erreur de connexion est survenue, L'application va fermer. Veuillez réessayer", "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
		System.out.println("Connecté!");
    }



    public boolean rechercheInformation(String command) {
        try {
            array = co.remplirChampsRequete(command);
        } catch (SQLException ex) {
            System.out.println("Erreur rechercheInformation(): " + ex);
            return false;
        }
        return true;
    }

    public void afficherInformations() {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }

        array.clear();
    }
	
	public void effacerResultat()
	{
		array.clear();
	}
	
	public ArrayList<String> getArray()
	{
		return array;
	}
    
    public String afficherNuméro() {
        String max = null;
        int maxint = 0;
        for (int i = 0; i < array.size(); i++) {
            max=(array.get(i));
           
        }
        
        array.clear();
       
        return max;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void executerRequete(String requeteMaj) throws SQLException
	{
		co.executeUpdate(requeteMaj);   
    }
}
