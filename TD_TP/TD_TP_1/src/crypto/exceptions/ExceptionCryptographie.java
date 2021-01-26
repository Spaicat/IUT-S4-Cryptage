/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.exceptions;

/**
 *
 * @author asus
 */
public abstract class ExceptionCryptographie extends Exception{
    
    private String nom;
    private String message;
    
    public ExceptionCryptographie(String m, String n){
        
        this.nom = n;
        this.message = m;
        
    }
    
    public void gerer(){
        
        //Message d'erreur
        System.err.println(this.nom + " : " + this.message);
        
        this.printStackTrace(System.err);
        
    }
       
    
}
