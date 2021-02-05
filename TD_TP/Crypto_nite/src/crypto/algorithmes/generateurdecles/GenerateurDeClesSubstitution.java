/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.generateurdecles;

import crypto.donnees.cles.CleString;
import crypto.donnees.cles.Cles;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author asus
 */
public class GenerateurDeClesSubstitution implements GenerateurDeCles{

    @Override
    /**
     * Il n'y a pas de clés publiques
     * @return null
     */
    public Cles genererClePublique(){
        return null;
    }

    /**
     * Génère la clé privée
     * @return la clé privée qui est l'alphabet permuté aléatoirement
     */
    @Override
    public Cles genererClePrivee() {
        String cleString = "";
        
        //Notre liste avec l'alphabet
        List<Character> chars = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        
        //On permute les lettres
        Collections.shuffle(chars);
        
        //On reforme la clé
        for(int i = 0; i< chars.size() ; i++){
            cleString += chars.get(i);
        }
        
        Cles cles = new Cles();
        cles.addCle("cleSubstitution", new CleString(cleString));
        
        return cles;
    }
    
}
