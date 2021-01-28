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
 * @author Antonia, Thibault
 */
public class AlgorithmeCesar implements Algorithme{

    /**
     * 
     * @return le nom de l'algorithme
     */
    @Override
    public String getNom() {
        return "César";
    }

    /**
     * Chiffre le message
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return Le message chiffré
     * @throws ExceptionCryptographie 
     */
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        
        //Tableau de char
        ArrayList<Integer> msgFinale = new ArrayList<Integer>();
        
        //valeur ascii du char  (espace par defaut)
        int res = 0;
        
        for(int i = 0; i < message.getListAsciiCode().size();i++){
            
            //Code ASCII du caractere
            int codeASCII = message.getListAsciiCode().get(i);
            
            //Valeur de la clé PV
            int clePV = clesPrivees.getCle("cleCesar").asInteger();
            
            //On verifie si c un espace
            if(codeASCII > 48){
                
                res = codeASCII + clePV;
                
                //Majuscule
                if(codeASCII > 65 && codeASCII < 90){
                    //si ça dépasse Z
                    if(res > 90){
                        
                        res -= 90;
                        res += 64;
                        
                    }
                }
                //Minuscule
                else if(codeASCII > 97 && codeASCII <= 122){
                    //Si ça dépasse z 
                    if(res > 122){
                        
                        res -= 122;
                        res += 96;
                       
                    }
                } 
            }else{
                res = codeASCII;
            }
            
            
            //Changement de l'ancien caractere par le nouveau
            msgFinale.add(res);
                                  
        }
        //On remet le msg en String
        Message msg = new MessageASCII(msgFinale);
        message = new MessageString(msg.asString());
            
        return message;
    }

    /**
     * Dechiffre le message
     * @param message
     * @param clesPubliques
     * @param clesPrivees
     * @return Le message déchiffré
     * @throws ExceptionCryptographie 
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
          
        //Tableau de char
        ArrayList<Integer> msgFinale = new ArrayList<Integer>();
        
        //valeur ascii du char  (espace par defaut)
        int res = 0;
        
        for(int i = 0; i < message.getListAsciiCode().size();i++){
            
            //Code ASCII du caractere
            int codeASCII = message.getListAsciiCode().get(i);
            
            //Valeur de la clé PV
            int clePV = clesPrivees.getCle("cleCesar").asInteger();
            
            //On verifie si c un espace
            if(codeASCII > 65){
                
                res = codeASCII - clePV;
                
                //Majuscule
                if(codeASCII >= 65 && codeASCII <= 90){
                    //si ça dépasse Z
                    if(res < 65){
                        
                        res = 65 - res;
                        res = 91 - res;
                        
                    }
                }
                //Minuscule
                else if(codeASCII >= 97 && codeASCII <= 122){
                    //Si ça dépasse z 
                    if(res < 97){
                        
                        res = 97 - res; //+1 pour que la premiere lettre soit compté
                        res = 123 - res; //+1 pour que la derniere lettre soit compté
                       
                    }
                } 
            }else{
                res = codeASCII;
            }
            
            
            //Changement de l'ancien caractere par le nouveau
            msgFinale.add(res);
                                  
        }
        //On remet le msg en String
        Message msg = new MessageASCII(msgFinale);
        message = new MessageString(msg.asString());
            
        return message;
    }
    
}
