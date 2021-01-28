/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.generateurdecles;

import crypto.donnees.cles.CleInteger;
import crypto.donnees.cles.Cles;
import java.util.Random;

/**
 *
 * @author Antonia, Thibault
 */
public class GenerateurDeClesCesar {
    
    //Attribut
    private Cles cles;
        
    /**
     * 
     * @return null car il n'y a pas de clé publique dans ces algo
     */
    public Cles genererClePublique(){
        return null;
    }
    
    /**
     * 
     * @return un attribut de type Cles (liste de clés privées)
     */
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
