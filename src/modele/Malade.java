/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;



/**
 *
 * @author Alex1
 */
public class Malade {
    /**attributs*/
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String mutuelle;
    private String date;
    
    /**constructeur de Malade*/
    public Malade(int m_numéro, String m_nom, String m_prénom, String m_adresse, String m_telephone, String m_mutuelle, String m_date){
        numero=m_numéro;
        nom=m_nom;
        prenom=m_prénom;
        adresse=m_adresse;
        telephone=m_telephone;
        mutuelle=m_mutuelle;
        date=m_date;
        
        
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
}
