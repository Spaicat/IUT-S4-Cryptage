/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.Cle;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.exceptions.ExceptionConversionImpossible;
import crypto.exceptions.ExceptionCryptographie;
import static java.lang.Math.ceil;

/**
 *
 * @author asus
 */
public class AlgorithmeTransposition implements Algorithme{

    @Override
    public String getNom() {
        return "Transposition";
    }
    
    /**
     * 
     * @param message
     * @param cle
     * @return le tableau remplie avec les caracteres
     * @throws ExceptionConversionImpossible 
     */
    private char[][] remplirTableauChiffrement(Message message,Cle cle)throws ExceptionConversionImpossible{
       
        //Initilisation tableau ligne
        int tailleTableauX = cle.asString().length();
        
        //Init taille message
        int tailleMsg = message.asString().length();
        
        //Init index du message
        int i = 0;
        
        //Connaitre le nombre de ligne
        //On arrondit au rang supérieur 
        double calcul = (double)tailleMsg / tailleTableauX;
        int tailleTableauY = (int)ceil(calcul);
     
        
        char [][] tab = new char[tailleTableauY][tailleTableauX];
              
            //ligne
            for(int y = 0;y < tailleTableauY;y++){
                //colonne
                for(int x = 0;x < tailleTableauX;x++){
                    
                    char temp = 'x';
                    
                    //On verifie que i est bien inférieur à la taille du message
                    if(i < tailleMsg)
                    {
                        temp = message.asString().charAt(i);
                    }
                    //on met le caractère dans le tableau
                    tab[y][x] = temp;
                    i++;    
                        
                }
            }

        return tab;
             
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
