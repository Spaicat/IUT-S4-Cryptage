/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;

/**
 *
 * @author asus
 */
public interface Algorithme {
    String nom = "";
    
    public String getNom();
    public void setNom();
    
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees);
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees);
}
