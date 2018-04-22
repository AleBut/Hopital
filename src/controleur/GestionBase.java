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
 * @author Alexis Butin
 */
public class GestionBase {
    // Réponse du serveur sous forme d'un tableau de string
    private ArrayList<String> array = new ArrayList<>();
    
    
    // Objets utilisés pour la connexion locale et distante
    private Connexion co;
    
    // Variables sur la connexion
    private String login;
    private String mdp;
    

    /**
	 * Gère la base de donnée
	 * @param _login Identifiant de la base de donnée
	 * @param _mdp  Mot de passe de la base de donnée
	 */
    public GestionBase(String _login, String _mdp) {
        login = _login;
        mdp = _mdp;
    }

	/**
	 * Effectue une connexion locale
	 * @param hub HubGraphique utilisé pour le message d'erreur
	 * @throws InterruptedException Interruption
	 */
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
	
	/**
	 * Effectue une connexion distante
	 * @param hub HubGraphique utilisé pour le message d'erreur
	 * @throws InterruptedException Interruption
	 */
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


	/**
	 * Recherche une information
	 * @param command Requete SQL
	 */
    public void rechercheInformation(String command) {
        try {
            array = co.remplirChampsRequete(command);
        } catch (SQLException ex) {
            System.out.println("Erreur rechercheInformation(): " + ex);
        }
    }
	
	/**
	 * Affiche les informations de la requête puis les efface (debugging)
	 */
    public void afficherInformations() {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }

        array.clear();
    }
	
	/**
	 * Efface les résultats
	 */
	public void effacerResultat()
	{
		array.clear();
	}
	
	/**
	 * 
	 * @return Retourne le tableau des résultats de la requête SQL
	 */
	public ArrayList<String> getArray()
	{
		return array;
	}
    
	
    public String afficherNuméro() {
        String max = null;
        int maxint = 0;
        for (int i = 0; i < array.size(); i++)
		{
            max = array.get(i).substring(0, array.get(i).length() - 1);
        }
        
        this.effacerResultat();
       
		
        return max;
    }
    
	/**
	 * 
	 * @return Retourne l'identifiant
	 */
    public String getLogin() {
        return login;
    }
    
	/**
	 * Execute une requête SQL
	 * @param requeteMaj
	 * @throws SQLException 
	 */
    public void executerRequete(String requeteMaj) throws SQLException
	{
		co.executeUpdate(requeteMaj);   
    }
}
