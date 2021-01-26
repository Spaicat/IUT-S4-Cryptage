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
    private static Univers instance;
    
    public Univers() {
        this.listeClesPubliques = new HashMap<String, Cles>();
        this.listeMessagesPublics = new HashMap<String, Message>();
    }
    
    public static Univers get() {
        
    }
}
