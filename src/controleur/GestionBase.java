/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.ArrayList;
import vue.Erreur;
import vue.MenuPrincipal;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A
 */
public class GestionBase {

    private ArrayList<String> array = new ArrayList<>();
    private static SSHTunnel ssh;
    private Connexion co;
    private String login;
    private String mdp;

    private static MenuPrincipal menu = new MenuPrincipal();
    private static Erreur err = new Erreur();

    /**
     *
     */
    public GestionBase(String log, String psswd) {
        login = log;
        mdp = psswd;

    }

    public void testConnexionLocale() throws InterruptedException {

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
        menu.setVisible(true);

    }

    public void testConnexionDistance() throws InterruptedException, SQLException {
        System.out.println("Connexion à la base de donnée via le serveur Gandalf...");

        String login_BDD = login + "-rw";

        try {
            co = new Connexion(login, mdp, login_BDD, "lykxPmIU");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
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
