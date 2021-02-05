/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.Cle;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageString;
import crypto.exceptions.ExceptionAlgorithmeNonDefini;
import crypto.exceptions.ExceptionCryptographie;

/**
 *
 * @author Antonia, Thibault
 */
public class AlgorithmeSubstitution implements Algorithme{

    @Override
    public String getNom() {
        return "Algorithme Substitution";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
                  
   
            //Alphabet basique
            char[] tabAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            char[] tabCle = new char[26];
            
            //Alphabet permuté qui est notre clé
            Cle clePV = clesPrivees.getCle("cleSubstitution");
            
            for(int i = 0; i < tabCle.length;i++){
                tabCle[i] = clePV.asString().charAt(i);
            }
            
            //Init taille message
            int tailleMsg = message.asString().length();
            
            //Char crypté
            char[] charCrypte = new char[tailleMsg];
            
            //Message crypté
            String messageCrypte = "";
        
            //On chiffre le message
            for (int i = 0; i < tailleMsg; i++)
            {
                for (int j = 0; j < 26; j++)
                {
                    if (tabAlpha[j] == message.asString().charAt(i))
                    {
                        charCrypte[i] = tabCle[j];
                        char c = charCrypte[i];
                         messageCrypte += c;
                    }
                    
                }
            }
            
            message = new MessageString(messageCrypte);
              
 
        
        return message;
        
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
