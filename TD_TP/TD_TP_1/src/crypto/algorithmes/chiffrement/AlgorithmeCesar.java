/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageASCII;
import crypto.donnees.messages.MessageString;
import crypto.exceptions.ExceptionCryptographie;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class AlgorithmeCesar implements Algorithme{

    @Override
    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        
        ArrayList<Integer> msgFinale = new ArrayList<Integer>();
        int chiffrage = 32; 
        
        for(int i = 0; i < message.getListAsciiCode().size();i++){
            
            //Code ASCII du caractere
            int codeASCII = message.getListAsciiCode().get(i);
            
            //Valeur de la clé PV
            int clePV = clesPrivees.getCle("cleCesar").asInteger();
            
            //On verifie si c un espace
            if(codeASCII != 32){
                
                int res = codeASCII + clePV;
                
                //Majuscule
                if(codeASCII > 65 && codeASCII < 90){
                    //si ça dépasse Z
                    if(res < 90){
                        
                        res -= 90;
                        res += 96;
                        
                        chiffrage = res + clePV;
                    }
                    else{
                        chiffrage = codeASCII + clePV;
                    }
                }
                //Minuscule
                else if(codeASCII > 97 && codeASCII < 122){
                    //Si ça dépasse z 
                    if(res < 122){
                        
                        res -= 122;
                        res += 96;
                        
                        chiffrage = res + clePV;
                    }
                    else{
                        chiffrage = codeASCII + clePV;
                    }
                }
                    
                
            }
            
            //Changement de l'ancien caractere par le nouveau
            //message.getListAsciiCode().set(i, chiffrage); 
            msgFinale.add(chiffrage);
                                  
        }
        //On remet le msg en String
        Message msg = new MessageASCII(msgFinale);
        message = new MessageString(msg.asString());
            
        return message;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        
         ArrayList<Integer> msgFinale = new ArrayList<Integer>();
        int chiffrage = 0; 
        
        for(int i = 0; i < message.getListAsciiCode().size();i++){
            
            //Code ASCII du caractere
            int codeASCII = message.getListAsciiCode().get(i);
            
            //Valeur de la clé PV
            int clePV = clesPrivees.getCle("cleCesar").asInteger();
            
            if(codeASCII != 0){
                chiffrage = codeASCII - clePV;
            }
            
            //Changement de l'ancien caractere par le nouveau
            //message.getListAsciiCode().set(i, chiffrage); 
            msgFinale.add(chiffrage);
                                  
        }
        //On remet le msg en String
        Message msg = new MessageASCII(msgFinale);
        message = new MessageString(msg.asString());
            
        return message;
    }
    
}
