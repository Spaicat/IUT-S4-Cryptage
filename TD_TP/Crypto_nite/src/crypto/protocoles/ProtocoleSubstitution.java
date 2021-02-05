/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.protocoles;


import crypto.algorithmes.chiffrement.AlgorithmeSubstitution;
import crypto.algorithmes.generateurdecles.GenerateurDeClesSubstitution;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageString;
import crypto.entites.Personne;
import crypto.entites.Univers;
import crypto.exceptions.ExceptionCryptographie;

/**
 *
 * @author Antonia, Thibault
 */
public class ProtocoleSubstitution implements Protocole{

    
    @Override
    public void executer() {
        //On crée Alice et Bob
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");
        
        //On donne à Alice et à Bob deux algorithmes de transposition
        alice.setAlgorithme(new AlgorithmeSubstitution());
        bob.setAlgorithme(new AlgorithmeSubstitution());
        
        //On génère une clé privée aléatoire que l’on donne à Alice et à Bob
        GenerateurDeClesSubstitution clePriveeAleatoire = new GenerateurDeClesSubstitution();
        Cles cles = clePriveeAleatoire.genererClePrivee();
        alice.setClesPrivees(cles);
        bob.setClesPrivees(cles);
        
        //On se fixe un message clair (non chiffré)
        String message = "BONJOUR, J'AIME LA CRYPTO";
        MessageString msgClair = new MessageString(message);
        
        try {
            //On le fait chiffrer par Alice et on le donne à l’Univers
            Message msgChiffrer = alice.chiffrer(msgClair, cles);
            Univers.addMessage("Message Alice", msgChiffrer);
            
            //Bob récupère le message depuis l’Univers et le décode
            Message msgRecup = Univers.getMessage("Message Alice");
            Message msgFinal = bob.dechiffrer(msgRecup,cles);
            
            System.out.println("*****Alice*****");
            System.out.println("Message Clair d'Alice : " + msgClair.asString());
            System.out.println("\nMessage chiffré par Alice : " + msgChiffrer.asString());
            System.out.println("\n*****Bob*****");
            System.out.println("Message a déchiffré par Bob : " + msgChiffrer.asString());
            System.out.println("\nMessage déchiffré par Bob : " + msgFinal.asString());
        }
        catch (ExceptionCryptographie e) {
            e.gerer();
        }
    }
    
}
