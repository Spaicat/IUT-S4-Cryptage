/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.CleString;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageASCII;
import crypto.donnees.messages.MessageString;
import crypto.exceptions.ExceptionChiffrementImpossible;
import crypto.exceptions.ExceptionCryptographie;
import java.util.ArrayList;

/**
 *
 * @author Antonia, Thibault
 */
public class AlgorithmeVigenere implements Algorithme {

    @Override
    public String getNom() {
        return "Vigenere";
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
        //Notre message qui sera chiffrer
        ArrayList<Integer> msgFinale = new ArrayList<Integer>();
            
        try {
            /*---Replique clé---*/
            //On récupère la chaine de caractères qui correspond à la clé
            String clesRepliqueString = clesPrivees.getCle("cleVigenere").asString();

            //On réplique la clé pour que sa tailler dépasse la taille du message
            while (clesRepliqueString.length() < message.asString().length()) {
                clesRepliqueString += clesPrivees.getCle("cleVigenere").asString();
            }
            //On crée la réplique de la clé
            Cles clesReplique = new Cles();
            clesReplique.addCle("cleVigenere", new CleString(clesRepliqueString));


            /*---Chiffrement message---*/
            //On convertit notre message en majuscule
            String messageUpper = message.asString().toUpperCase();

            //Pour chaque caractère de notre message
            for (int i = 0; i < messageUpper.length(); i++) {
                //On prends le code ASCII du caractère du message et du caractère de la clé
                int msgCharASCII = (int)messageUpper.charAt(i);
                int cleCharASCII = (int)clesRepliqueString.charAt(i);

                //Le caractère sous forme chiffrer
                int charChiffrer = msgCharASCII;
                //On vérifie que c'est une majuscule sinon on ne chiffre pas le caractère
                if (msgCharASCII >= 65 && msgCharASCII <= 90) {
                    //On part de notre code du char du message en ajoutant le code de la clé du message
                    //(tout ça modulo 26 pour repartir à A quand on dépasse)
                    //et on ajoute 65 pour reconvertir en ASCII
                    charChiffrer = ((msgCharASCII-65) + (cleCharASCII-65))%26 + 65;
                }
                //On ajoute notre caractère à la chaine finale
                msgFinale.add(charChiffrer);
            }
        }
        catch (Exception e){
            throw new ExceptionChiffrementImpossible("Chiffrement Impossible");
        }
        
        Message msgChiffrerASII = new MessageASCII(msgFinale);
        MessageString msgChiffrer = new MessageString(msgChiffrerASII.asString());
        return msgChiffrer;
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
        //Notre message qui sera déchiffrer
        ArrayList<Integer> msgFinale = new ArrayList<Integer>();

        try {
            /*---Replique clé---*/
            //On récupère la chaine de caractères qui correspond à la clé
            String clesRepliqueString = clesPrivees.getCle("cleVigenere").asString();

            //On réplique la clé pour que sa tailler dépasse la taille du message
            while (clesRepliqueString.length() < message.asString().length()) {
                clesRepliqueString += clesPrivees.getCle("cleVigenere").asString();
            }
            //On crée la réplique de la clé
            Cles clesReplique = new Cles();
            clesReplique.addCle("cleVigenere", new CleString(clesRepliqueString));


            /*---Déchiffrement message---*/
            //On convertit notre message en majuscule (au cas où)
            String messageUpper = message.asString().toUpperCase();

            //Pour chaque caractère de notre message
            for (int i = 0; i < messageUpper.length(); i++) {
                //On prends le code ASCII du caractère du message et du caractère de la clé
                int msgCharASCII = (int)messageUpper.charAt(i);
                int cleCharASCII = (int)clesRepliqueString.charAt(i);

                //Le caractère sous forme déchiffrer
                int charDechiffrer = msgCharASCII;
                //On vérifie que c'est une majuscule sinon on ne déchiffre pas le caractère
                if (msgCharASCII >= 65 && msgCharASCII <= 90) {
                    //On part de notre code du char du message chiffré en soustrayant le code de la clé du message
                    //(Si c'est dans le négatif on ajoute 26 pour repartir à Z)
                    //et on ajoute 65 pour reconvertir en ASCII
                    int posChar = ((msgCharASCII-65) - (cleCharASCII-65));
                    if (posChar < 0) posChar += 26;
                    charDechiffrer = posChar + 65;
                }
                //On ajoute notre caractère à la chaine finale
                msgFinale.add(charDechiffrer);
            }
        }
        catch (Exception e){
            throw new ExceptionChiffrementImpossible("Déchiffrement Impossible");
        }
        
        Message msgChiffrerASII = new MessageASCII(msgFinale);
        MessageString msgChiffrer = new MessageString(msgChiffrerASII.asString());
        return msgChiffrer;
    }
    
}
