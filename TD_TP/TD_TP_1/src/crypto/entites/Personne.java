/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.entites;

import crypto.algorithmes.chiffrement.Algorithme;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.exceptions.ExceptionAlgorithmeNonDefini;

/**
 *
 * @author asus
 */
public class Personne{
    
    private String nom;
    private Algorithme algorithme;
    private Cles clesPrivees;
    
    public Personne(String nom){
        this.nom = nom;
    }

    //Get & Set de NOM
    public String getNom() {
        return nom;
    }

    //Get & Set de Algorithme
    public Algorithme getAlgorithme() {
        return this.algorithme;
    }

    public void setAlgorithme(Algorithme algorithme) {
        this.algorithme = algorithme;
    }

    //Get & Set de CLES PRIVEES
    public Cles getClesPrivees() {
        return clesPrivees;
    }

    public void setClesPrivees(Cles clesPrivees) {
        this.clesPrivees = clesPrivees;
    }
    
    
    public Message chiffrer(Message message, Cles clesPubliques){
        
        Message m = null;
        
        try{
            m = this.algorithme.chiffrer(message, clesPubliques, clesPrivees);
        }
        catch(Exception e){
            
            ExceptionAlgorithmeNonDefini excep = new ExceptionAlgorithmeNonDefini("Algorithme non defini");
            excep.gerer();
        }
        
        return m;
        
    }
    
    public Message dechiffrer(Message message, Cles clesPubliques){
        
        Message m = null;
        
        try{
            m = this.algorithme.dechiffrer(message, clesPubliques, clesPrivees);
        }
        catch(Exception e){
            
            ExceptionAlgorithmeNonDefini excep = new ExceptionAlgorithmeNonDefini("Algorithme non defini");
            excep.gerer();
        }
        
        return m;
        
    }
    
    
}
