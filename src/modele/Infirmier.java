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
public class Infirmier extends Employe {
    private String codeService;
    private String rotation;
    private String salaire;
    
    public Infirmier(int i_numéro, String i_nom, String i_prénom, String i_adresse, String i_telephone, String i_codeService, String i_rotation, String i_salaire){
        super(i_numéro, i_nom, i_prénom, i_adresse, i_telephone);
        codeService=i_codeService;
        rotation=i_rotation;
        salaire=i_salaire;
    }
    
    /**getter de num infirmier*/
    public int getNum(){
        return super.numero;
    }
    
    /**getter de nom infirmier*/
    public String getNom(){
        return super.nom;
    }
    
    /**getter de prenom infirmier*/
    public String getPrenom(){
        return super.prenom;
    }
    
    /**getter de adresse infirmier*/
    public String getAdresse(){
        return super.adresse;
    }
    
    /**getter du tel infirmier*/
    public String getTel(){
        return super.telephone;
    }
    
    /**getter de service infirmier*/
    public String getService(){
        return codeService;
    }
    
    /**getter de rotation infirmier*/
    public String getRotation(){
        return rotation;
    }
    
    /**getter de salaire infirmier*/
    public String getSalaire(){
        return salaire;
    }
}
