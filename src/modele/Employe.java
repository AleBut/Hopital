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
public class Employe {
    // Attributs
    protected int numero;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    
    /**constructeur de employe*/
    public Employe(int e_numéro, String e_nom, String e_prénom, String e_adresse, String e_telephone){
        numero=e_numéro;
        nom=e_nom;
        prenom=e_prénom;
        adresse=e_adresse;
        telephone=e_telephone;
        
        
        
    }
    
    /**getter de num employe*/
    /*public int getNum(){
        return numero;
    }*/
    
    /**getter de nom employe*/
   /* public String getNom(){
        return nom;
    }*/
    
    /**getter de prenom employe*/
    /*public String getPrenom(){
        return prenom;
    }*/
    
    /**getter de adresse employe*/
    /*public String getAdresse(){
        return adresse;
    }*/
    
    /**getter du tel employe*/
    /*public String getTel(){
        return telephone;
    }*/
  
}
