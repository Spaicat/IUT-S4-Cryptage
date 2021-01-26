/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.messages;

import crypto.exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class MessageString implements Message {
    private String message;
    
    public MessageString(String message) {
        this.message = message;
    }
    
    /**
     * Renvoie le message sous forme d’une chaine de caractère
     * @return le message à envoyer
     */
    @Override
    public String asString() {
        String result = "";
        try {
            result = this.message;
        }
        catch (Exception e) {
            ExceptionConversionImpossible excep = new ExceptionConversionImpossible("Conversion Impossible en String");
            excep.gerer();
        }
        return result;
    }

    /**
     * Renvoie le message sous forme d’un entier
     * @return le message à envoyer
     */
    @Override
    public Integer asInteger() {
        int result = 0;
        try {
            result = Integer.parseInt(message);
        }
        catch (ExceptionConversionImpossible ex) {
            ex.gerer();
        }
        return result;
    }
    
    public ArrayList<Integer> getListAsciiCode() {
        return null;
    }
    
}
