/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.GestionBase;
import java.util.ArrayList;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Alex1
 */
public class CamembertOriginePatients extends Camembert {
	
	public CamembertOriginePatients(String titre, GestionBase BDD) {
		super(titre, BDD);
	}
	
	@Override
	public PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        //initialisation des valeurs
        dataset.setValue("Dept B1", new Double(70));
        dataset.setValue("Dept B2", new Double(10));
        dataset.setValue("Dept B3", new Double(5));
        dataset.setValue("Dept D", new Double(12));
        dataset.setValue("Dept E", new Double(3));
        return dataset;
    }
	
	private ArrayList<String> getArray()
	{
		return null;
	}
	
}
