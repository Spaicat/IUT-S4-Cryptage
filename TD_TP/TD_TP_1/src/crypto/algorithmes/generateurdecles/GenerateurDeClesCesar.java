/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.generateurdecles;

import crypto.donnees.cles.Cle;
import crypto.donnees.cles.CleInteger;
import crypto.donnees.cles.Cles;
import java.util.Random;

/**
 *
 * @author asus
 */
public class GenerateurDeClesCesar {
    private Cles cles;
    
    public GenerateurDeClesCesar(){
        
    }
    
    //l'algorithme n'a pas de cle publique
    public Cles genererClePublique(){
        return null;
    }
    
    public Cles genererClePrivee(){
        if (this.cles == null) {
            Random random = new Random();
            int nbAleatoire = random.nextInt(25);
            
            this.cles = new Cles();
            this.cles.addCle("cleCesar", new CleInteger(nbAleatoire));
        }
        return this.cles;
    }
    
}