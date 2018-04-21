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
public class Docteur extends Employe {
    private String specialite;
	private String directeurService;
	
	public Docteur(int d_numéro, String d_nom, String d_prénom, String d_adresse, String d_telephone, String d_specialite){
        super(d_numéro, d_nom, d_prénom, d_adresse, d_telephone);
        specialite=d_specialite;
		directeurService = "";
    }
    
    public Docteur(int d_numéro, String d_nom, String d_prénom, String d_adresse, String d_telephone, String d_specialite, String d_directeurService){
        super(d_numéro, d_nom, d_prénom, d_adresse, d_telephone);
        specialite=d_specialite;
		directeurService = d_directeurService;
    }
    
    /**getter de num docteur*/
    public int getNum(){
        return super.numero;
    }
    
    /**getter de nom docteur*/
    public String getNom(){
        return super.nom;
    }
    
    /**getter de prenom docteur*/
    public String getPrenom(){
        return super.prenom;
    }
    
    /**getter de adresse docteur*/
    public String getAdresse(){
        return super.adresse;
    }
    
    /**getter du tel docteur*/
    public String getTel(){
        return super.telephone;
    }
    
    /**getter de specialite docteur*/
    public String getSpécialité(){
        return specialite;
    }
	
	/* getter du service dirigé docteur*/
	public String getDirecteurService() {
		return directeurService;
	}
}
