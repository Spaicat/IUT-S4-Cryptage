/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.exceptions;

/**
 * Classe abstraite représentant les exceptions
 * @author Antonia
 */
public abstract class ExceptionCryptographie extends Exception{
    private String nom;
    private String message;
    
    public ExceptionCryptographie(String m, String n){
        this.nom = n;
        this.message = m;
    }
    
    /**
     * Gere le message d'erreur en affichant le message d'erreur
     */
    public void gerer(){
        //Message d'erreur
        System.err.println(this.nom + " : " + this.message);
        
        this.printStackTrace(System.err);
    }
}
