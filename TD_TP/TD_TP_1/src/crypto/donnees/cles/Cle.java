/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.cles;

import crypto.exceptions.ExceptionConversionImpossible;

/**
 * Interface representant une clé
 * @author Thibault, Antonia
 */
public interface Cle {
    public String asString() throws ExceptionConversionImpossible;
    
    public int asInteger() throws ExceptionConversionImpossible;
    
}
