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
 * @author Thibault
 */
public class GenerateurDeClesTransposition implements GenerateurDeCles {
    private int taille;
    
    public GenerateurDeClesTransposition(int taille) {
        this.taille = taille;
    }
    
    /**
     * N'a pas de clé publique
     * @return donne null
     */
    @Override
    public Cles genererClePublique() {
        return null;
    }

    /**
     * Génère une unique CleString construite à partir d'une chaine de caractères aléatoire
     * @return l'objet de type cles composé de l'unique CleString
     */
    @Override
    public Cles genererClePrivee() {
        Cles cles = new Cles();
        SecureRandom random = new SecureRandom();
        
        String randomStr = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i=0; i < this.taille; i++) {
            int randPos = random.nextInt(chars.length());
            randomStr += chars.charAt(randPos);
        }
        cles.addCle("cleTransposition", new CleString(randomStr));
        return cles;
    }
    
}
