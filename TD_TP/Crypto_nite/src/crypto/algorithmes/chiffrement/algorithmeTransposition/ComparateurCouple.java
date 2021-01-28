/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement.algorithmeTransposition;

import java.util.Comparator;

/**
 *
 * @author Antonia, Thibault
 */
public class ComparateurCouple implements Comparator<Couple>{

    /**
     * Compare deux couples pour les trier 
     * @param c1 couple 1
     * @param c2 couple 2
     * @return 
     */
    @Override
    public int compare(Couple c1, Couple c2) {
        
        int res = 0;
        
        //Caracteres
        char charC1 = c1.getCaractere(); //Couple 1
        char charC2 = c2.getCaractere(); //Couple 2
        
        //Position
        int posC1 = c1.getPosition(); //Couple 1
        int posC2 = c2.getPosition(); //Couple 2
        
        //Si le char de couple 1 est plus petit que char couple 2
        if(charC1 != charC2)
        {
            res = (int)charC1 - (int)charC2;
        }      
        //Si égal on vérifie la position
        else{
            //différence des positions
            res = posC1 - posC2;
        }
        return res;
                
    }
    
}
