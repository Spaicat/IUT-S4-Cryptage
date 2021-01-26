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
public class ExceptionCryptographie {
    
    private String nom;
    private String message;
    
    public ExceptionCryptographie(String m, String n){
        
        this.nom = n;
        this.message = m;
        
    }
    
    public void gerer(){
        
    }
       
    
}
