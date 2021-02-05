/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.generateurdecles;

import crypto.donnees.cles.CleString;
import crypto.donnees.cles.Cles;
import java.security.SecureRandom;

/**
 *
 * @author asus
 */
public class GenerateurDeClesVigenere implements GenerateurDeCles {
    
    //Attribut
    private int taille;
    
    public GenerateurDeClesVigenere(int taille){
        this.taille = taille;
    }

    /**
     * Il n'y a pas de clés publiques
     * @return null
     */
    @Override
    public Cles genererClePublique() {
        return null;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Cles genererClePrivee() {
        Cles cles = new Cles();
        SecureRandom random = new SecureRandom();
        
        String randomStr = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0; i < this.taille; i++) {
            int randPos = random.nextInt(chars.length());
            randomStr += chars.charAt(randPos);
        }
        cles.addCle("cleVigenere", new CleString(randomStr));
        return cles;
    }
    
}
