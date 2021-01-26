/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.cles;

import crypto.exceptions.ExceptionConversionImpossible;

/**
 *
 * @author asus
 */
public class CleInteger implements Cle{
    
    private int cle;
    
    public CleInteger(int cle){
        this.cle = cle;
    }

    @Override
    public String asString() throws ExceptionConversionImpossible {
        String res = "";
        
        try{
            res = Integer.toString(this.cle);
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en chaine de caractères");
        }
        
        return res;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        int res = 0;
        
        try{
            res = this.cle;
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en entier");
        }
        
        return res;
    }
}
