/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.ArrayList;
import vue.Erreur;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String mdpSQL;
    
    // Booléen utilisé pour empêcher l'utilisateur d'effectuer une connexion distance/locale s'il n'est pas autorisé
    private boolean localOnly;
    
    private static Erreur err = new Erreur();

    /**
     *
     */
    public GestionBase(String _login, String _mdp) {
        login = _login;
        mdp = _mdp;
        
        localOnly = true;
    }
    
    public GestionBase(String _login, String _mdp, String _mdpSQL) {
        login = _login;
        mdp = _mdp;
        mdpSQL = _mdpSQL;
        
        localOnly = false;
    }

    public boolean connexionLocale() throws InterruptedException {

        System.out.println("Connexion à la base de donnée locale...");

        try {
            co = new Connexion("Hopital", login, mdp);

        } catch (SQLException | ClassNotFoundException ex) {
            err.setVisible(true);
            Thread.sleep(5 * 1000);
            System.out.println("Erreur: " + ex);

            System.exit(1);
        }
        System.out.println("Connecté!");
        return true;
    }

    public void connexionDistance() throws InterruptedException {
        System.out.println("Connexion à la base de donnée via le serveur Gandalf...");

        try {
            co = new Connexion(login, mdp, (login + "-rw"), mdpSQL);
        } catch (SQLException |ClassNotFoundException ex) {
            Logger.getLogger(GestionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
