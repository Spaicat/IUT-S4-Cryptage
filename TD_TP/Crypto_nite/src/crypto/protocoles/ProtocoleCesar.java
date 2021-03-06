/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.protocoles;

import crypto.algorithmes.chiffrement.AlgorithmeCesar;
import crypto.algorithmes.generateurdecles.GenerateurDeClesCesar;
import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import crypto.donnees.messages.MessageString;
import crypto.entites.Personne;
import crypto.entites.Univers;
import crypto.exceptions.ExceptionCryptographie;

/**
 *
 * @author Thibault, Antonia
 */
public class ProtocoleCesar implements Protocole{

    /**
     * execute le protocole modelisant l'échange du message, cryptage et décryptage
     */
    @Override
    public void executer() {
        //On crée Alice et Bob
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");
        
        //On donne à Alice et à Bob deux algorithmes de transposition
        alice.setAlgorithme(new AlgorithmeCesar());
        bob.setAlgorithme(new AlgorithmeCesar());
        
        //On génère une clé privée aléatoire que l’on donne à Alice et à Bob
        GenerateurDeClesCesar clePriveeAleatoire = new GenerateurDeClesCesar();
        Cles cles = clePriveeAleatoire.genererClePrivee();
        alice.setClesPrivees(cles);
        bob.setClesPrivees(cles);
        
        //On se fixe un message clair (non chiffré)
        String message = "Bonjour, j'aime les mathématiques";
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
