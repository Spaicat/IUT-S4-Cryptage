/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.cles;

import crypto.exceptions.ExceptionConversionImpossible;

/**
 *
 * @author Thibault
 */
public class CleString implements Cle {
    private String cle;
    
    public CleString(String chaine){
        this.cle = chaine;
    }

    @Override
    public String asString() throws ExceptionConversionImpossible {
        String res = "";
        
        try{
            res = this.cle;
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en chaine de caractères");
        }
        
        return res;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Conversion Impossible en entier");
    }
    
}
