/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.exceptions;

/**
 *
 * @author asus
 */
public class ExceptionConversionImpossible extends ExceptionCryptographie{
    
    public ExceptionConversionImpossible(String m) {
        super("Conversion impossible", m);
    }
}
