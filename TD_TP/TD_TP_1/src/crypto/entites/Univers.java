/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.entites;

import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
import java.util.HashMap;

/**
 *
 * @author asus
 */
public class Univers {
    private HashMap<String, Cles> listeClesPubliques;
    private HashMap<String, Message> listeMessagesPublics;
    private static Univers instance = new Univers();
    
    private Univers() {
        this.listeClesPubliques = new HashMap<String, Cles>();
        this.listeMessagesPublics = new HashMap<String, Message>();
    }
    
    public static Univers get() {
        return instance;
    }
    
    public static void addCles(String identifiant, Cles cles) {
        instance.listeClesPubliques.put(identifiant, cles);
    }
    
    public static Cles getCles(String identifiant) {
        return instance.listeClesPubliques.get(identifiant);
    }
    
    public static void addMessage(String identifiant, Message message) {
        instance.listeMessagesPublics.put(identifiant, message);
    }
    
    public static Message getMessage(String identifiant) {
        return instance.listeMessagesPublics.get(identifiant);
    }
}
