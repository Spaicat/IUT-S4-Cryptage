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
import crypto.exceptions.ExceptionChiffrementImpossible;

/**
 * Modelise une personne
 * @author Thibault, Antonia
 */
public class Personne {
    private String nom;
    private Algorithme algorithme;
    private Cles clesPrivees;
    
    public Personne(String nom){
        this.nom = nom;
    }

    //Get du nom de la personne
    public String getNom() {
        return nom;
    }

    //Get & Set de l'algorithme
    public Algorithme getAlgorithme() {
        return this.algorithme;
    }

    public void setAlgorithme(Algorithme algorithme) {
        this.algorithme = algorithme;
    }

    //Get & Set des clés privées
    public Cles getClesPrivees() {
        return clesPrivees;
    }

    public void setClesPrivees(Cles clesPrivees) {
        this.clesPrivees = clesPrivees;
    }
    
    /**
     * Chiffre le message avec les clés en utilisant l'algorithme de la personne
     * @param message le message à chiffrer
     * @param clesPubliques les clés permettant de chiffrer
     * @return Le message chiffré
     * @throws ExceptionAlgorithmeNonDefini
     * @throws ExceptionChiffrementImpossible
     */
    public Message chiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini, ExceptionChiffrementImpossible {
        
        Message m = null;
        
        if(this.algorithme == null) {
            throw new ExceptionAlgorithmeNonDefini("Algorithme non defini dans chiffrer");
        }
        try{
            m = this.algorithme.chiffrer(message, clesPubliques, clesPrivees);
        }
        catch(Exception e){
            throw new ExceptionChiffrementImpossible("Chiffrement impossible");
        }
        
        return m;
        
    }
    
    /**
     * Déchiffre le message avec les clés en utilisant l'algorithme de la personne
     * @param message le message à déchiffrer
     * @param clesPubliques les clés permettant de déchiffrer
     * @return Le message déchiffré
     * @throws ExceptionAlgorithmeNonDefini
     * @throws ExceptionChiffrementImpossible
     */
    public Message dechiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini, ExceptionChiffrementImpossible {
        
        Message m = null;
        
        if(this.algorithme == null) {
            throw new ExceptionAlgorithmeNonDefini("Algorithme non defini dans dechiffrer");
        }
        
        try{
            m = this.algorithme.dechiffrer(message, clesPubliques, clesPrivees);
        }
        catch(Exception e){
            throw new ExceptionChiffrementImpossible("Déchiffrement impossible");
        }
        
        return m;
        
    }
    
    
}
