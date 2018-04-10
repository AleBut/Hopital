/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.HubGraph;
import java.sql.SQLException;

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
