/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;

/**
 *
 * @author Alexis Butin, Benoit Prat, Solene Consten, Valentin Giot
 *
 */
public class Hopital {
    private static HubGraph hub;
	
	/**
	 * Execute le programme de démonstration
	* @param args the command line arguments
	* @throws java.sql.SQLException
	* @throws java.lang.ClassNotFoundException
	*/
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        hub = new HubGraph();

    }

}
