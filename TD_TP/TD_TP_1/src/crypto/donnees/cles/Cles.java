/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.cles;

import java.util.HashMap;

/**
 *
 * @author asus
 */
public class Cles {
    
    private HashMap<String,Cle> listeCles;
    
    public Cles(){
        listeCles = new HashMap<String,Cle>();
    }
    
    public Cle getCle(String nom){
        
        return listeCles.get(nom);
    }
    
    public void addCle(String nom, Cle cle){
        
        this.listeCles.put(nom, cle);
    }
    
}
