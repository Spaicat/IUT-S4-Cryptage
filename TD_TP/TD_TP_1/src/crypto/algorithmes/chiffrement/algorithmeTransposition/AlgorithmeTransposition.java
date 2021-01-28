/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement.algorithmeTransposition;

import crypto.algorithmes.chiffrement.Algorithme;
import crypto.algorithmes.chiffrement.algorithmeTransposition.ComparateurCouple;
import crypto.algorithmes.chiffrement.algorithmeTransposition.Couple;
import crypto.donnees.cles.Cle;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageString;
import crypto.exceptions.ExceptionAlgorithmeNonDefini;
import crypto.exceptions.ExceptionConversionImpossible;
import crypto.exceptions.ExceptionCryptographie;
import static java.lang.Math.ceil;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Antonia, Thibault
 */
public class AlgorithmeTransposition implements Algorithme{

    SecureRandom generateur;
    
    /**
     * 
     * @return le nom de l'algorithme de cryptage
     */
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
       
        ByteBuffer b = ByteBuffer.allocate(4) ;
        b.putInt((cle.asString()+message.asString()).hashCode()) ;
        this.generateur = new SecureRandom (b.array()) ;

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
                    
                    //Choisit une valeur aléatoire et elle s'ajoutera au tableau que si i > tailleMsg
                    char temp = bourrage();
                    
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
    
    /**
     * Pour combler les cellules vides
     * @return un caractere au hasard
     */
    private char bourrage(){
       
        //String avec toutes les lettres
        String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefeghijklmnopqrstuvwxyz";
        
        //On choisit une position au hasard
        int randomPos = generateur.nextInt(allLetters.length());
        
        //On récupère le caractere à la position indiquée
        char randomChar = allLetters.charAt(randomPos);
        
        return randomChar;
    }
    /**
     * 
     * @param cle
     * @return la liste créant l'ordre 
     * @throws ExceptionConversionImpossible 
     */
    private ArrayList<Integer> getOrdreColonne(Cle cle) throws ExceptionConversionImpossible{
        //Notre liste qui comportera notre nouvel ordre
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        //Notre liste de couple
        ArrayList<Couple> listCouple = new ArrayList<Couple>();

        //On recup le mot sous forme d'un string
        String cleOrdre = cle.asString();
        
        //On crée les couples
        for(int i = 0;i < cleOrdre.length();i++){
            
            listCouple.add(new Couple(cleOrdre.charAt(i),i));
        }
        
        //On trie 
        Collections.sort(listCouple,new ComparateurCouple());

        //On met la position dans la list avec notre nouvel ordre
        for(Couple c : listCouple) {
            list.add(c.getPosition());
        }    
        
        return list;
    }

    /**
     * 
     * @param message
     * @param clesPubliques = null
     * @param clesPrivees
     * @return le message chiffré
     * @throws ExceptionCryptographie 
     */
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        
        try{
            //Notre index de l'ordre pour la lecture des colonnes
            int j = 0;
            
            //Init du msg final
            String msgFinal = "";
            
            //Clé privée
            Cle clePV = clesPrivees.getCle("cleTransposition");
            
            //On remplie le tableau
            char[][] tab = remplirTableauChiffrement(message, clePV);

            //On recupere dans une variable la liste de l'ordre
            ArrayList<Integer> listOrdre = this.getOrdreColonne(clePV);
            
            //colonne
            for(int k = 0;k < listOrdre.size();k++){
                //ligne
                for(int i = 0;i < tab.length;i++){
                    //On lit l'ordre
                    j = listOrdre.get(k);
                    
                    //On recupere le caractere
                    char c = tab[i][j];
                    
                    //On reconstitue le msg
                    msgFinal += c;                    
                }
            }
            
            //On remet le msg en String
            message = new MessageString(msgFinal);
            
        }catch(Exception e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
        return message;
    }

    /**
     * 
     * @param message
     * @param clesPubliques = null
     * @param clesPrivees
     * @return le message déchiffré
     * @throws ExceptionCryptographie 
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
      
        try{
            /*INDEX*/
            //Init index du message
            int indexMsg = 0;
            
            //Init du msg final
            String msgFinal = "";
            
            /*Recuperation de donnes dans des variables*/
            //Clé privée
            Cle clePV = clesPrivees.getCle("cleTransposition");
            
            //Ordre
            ArrayList<Integer> listOrdre = this.getOrdreColonne(clePV);
            
            //Init taille message
            int tailleMsg = message.asString().length();
            
            /*Initialisation des lignes et colonnes*/
            //Ligne
            int tailleTableauX = clePV.asString().length();

            //Colonne
            double calcul = (double)tailleMsg / tailleTableauX;
            int tailleTableauY = (int)ceil(calcul);
                    
            //On remplie le tableau
            char[][] tab = new char[tailleTableauY][tailleTableauX];      
            
            /*On remplit le tableau*/
            //colonne
            for(int k = 0;k < listOrdre.size();k++){
                //ligne
                for(int i = 0;i < tab.length;i++){
                    //On lit l'ordre
                    int j = listOrdre.get(k);
                    
                    //remplit les cases vides
                    char temp = 'x';
                    
                    //On verifie que l'index est bien inférieur à la taille du message
                    if(indexMsg < tailleMsg)
                    {
                        temp = message.asString().charAt(indexMsg);
                    }
                    //on met le caractère dans le tableau
                    tab[i][j] = temp;
                    indexMsg++;       
                }
            }
            
            /*On recupere le message*/
            for(int y = 0;y < tailleTableauY;y++){
                //colonne
                for(int x = 0;x < tailleTableauX;x++){
                    
                    //On recupere le caractere
                    char c = tab[y][x];
                    
                    //On reconstitue le msg
                    msgFinal += c;  
                                            
                }
            }
            //On remet le msg en String
            message = new MessageString(msgFinal);
            
        }catch(Exception e){
            throw new ExceptionAlgorithmeNonDefini("Algorithme non defini");
        }
                
        return message;
    }
    
}
