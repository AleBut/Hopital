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
public class Patient {
    /**attributs*/
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String mutuelle;
    private String date;
	private String service;
    
    /**
	 * Premier constructeur du patient
	 * @param m_numéro Numéro ID
	 * @param m_nom Nom
	 * @param m_prénom Prénom
	 * @param m_adresse Adresse
	 * @param m_telephone Téléphone
	 * @param m_mutuelle Mutuelle
	 * @param m_date Date
	 * @param m_service Service
	 */
    public Patient(int m_numéro, String m_nom, String m_prénom, String m_adresse, String m_telephone, String m_mutuelle, String m_date, String m_service){
        numero=m_numéro;
        nom=m_nom;
        prenom=m_prénom;
        adresse=m_adresse;
        telephone=m_telephone;
        mutuelle=m_mutuelle;
        date=m_date;
        service = m_service;
    }
	
	/**
	 * Deuxième constructeur du patient
	 * @param m_numéro Numéro ID
	 * @param m_nom Nom
	 * @param m_prénom Prénom
	 * @param m_adresse Adresse
	 * @param m_telephone Téléphone
	 * @param m_mutuelle Mutuelle
	 * @param m_date Date
	 */
	public Patient(int m_numéro, String m_nom, String m_prénom, String m_adresse, String m_telephone, String m_mutuelle, String m_date){
        numero=m_numéro;
        nom=m_nom;
        prenom=m_prénom;
        adresse=m_adresse;
        telephone=m_telephone;
        mutuelle=m_mutuelle;
        date=m_date;
        service = "";
    }
	
	
    /**getter de num malade*/
    public int getNum(){
        return numero;
    }
    
    /**getter de nom malade*/
    public String getNom(){
        return nom;
    }
    
    /**getter de prenom malade*/
    public String getPrenom(){
        return prenom;
    }
    
    /**getter de adresse malade*/
    public String getAdresse(){
        return adresse;
    }
    
    /**getter du tel malade*/
    public String getTel(){
        return telephone;
    }
    
    /**getter de mutuelle malade*/
    public String getMutuelle(){
        return mutuelle;
    }
    
    /**getter de date malade*/
    public String getDate(){
        return date;
    }
	
	/**getter du service du malade*/
	public String getService(){
		return service;
	}
}
