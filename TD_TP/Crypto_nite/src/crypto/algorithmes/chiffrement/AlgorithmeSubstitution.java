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
        
        //Message crypté
        String messageCrypte = "";
            
        try{
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
            
            
            //On chiffre le message
            for (int i = 0; i < tailleMsg; i++)
            {
                char c = message.asString().charAt(i);
                if((int)c >= 65 || (int)c < 90){
                    int j = 0;
                    boolean sortie = false;
                    while (j < 26 && !sortie)
                    {
                        if (tabAlpha[j] == message.asString().charAt(i))
                        {
                            charCrypte[i] = tabCle[j];
                            c = charCrypte[i];
                            sortie = true;
                        }
                        j++;
                    }
                }
                messageCrypte += c;
            }
        }
        catch(Exception e){
            throw new ExceptionAlgorithmeNonDefini("Algorithme non defini");
        }
            
            message = new MessageString(messageCrypte);
              
 
        
        return message;
        
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        
        //Message crypté
        String messageCrypte = "";
            
        try{
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
            
            
            //On chiffre le message
            for (int i = 0; i < tailleMsg; i++)
            {
                char c = message.asString().charAt(i);
                if((int)c < 65 || (int)c > 90){
                    messageCrypte += c;
                } 
                else{
                    for (int j = 0; j < 26; j++)
                    {
                        if (tabCle[j] == message.asString().charAt(i))
                        {
                            charCrypte[i] = tabAlpha[j];
                            c = charCrypte[i];
                            messageCrypte += c;
                        }

                    }
                }
                
            }
        }
        catch(Exception e){
            throw new ExceptionAlgorithmeNonDefini("Algorithme non defini");
        }
            
            message = new MessageString(messageCrypte);
              
 
        
        return message;
        
    }
    
}
