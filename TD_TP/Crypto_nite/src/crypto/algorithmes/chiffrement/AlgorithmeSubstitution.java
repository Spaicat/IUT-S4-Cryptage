/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement;

import crypto.donnees.cles.Cles;
import crypto.donnees.messages.Message;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
