/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Alexis Butin et Solene Consten
 */
public class Employe {
    // Attributs
    protected int numero;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    
    /**
	 * Constructeur objet emp)ployé
	 * @param e_numéro Numéro ID
	 * @param e_nom Nom
	 * @param e_prénom Prenom
	 * @param e_adresse Adresse
	 * @param e_telephone Téléphone
	 */
    public Employe(int e_numéro, String e_nom, String e_prénom, String e_adresse, String e_telephone){
        numero=e_numéro;
        nom=e_nom;
        prenom=e_prénom;
        adresse=e_adresse;
        telephone=e_telephone;    
    }
}
