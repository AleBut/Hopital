/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.navigation.PageConnexion;
import java.sql.SQLException;
import vue.HubGraph;

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
    private static HubGraph hub;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        hub = new HubGraph();

    }

}
