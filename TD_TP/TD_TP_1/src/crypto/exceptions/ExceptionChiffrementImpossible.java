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
public class ExceptionChiffrementImpossible extends ExceptionCryptographie{
    
    public ExceptionChiffrementImpossible(String m, String n) {
        super(m, n);
                 
        n = "Chiffrement impossible";
        m = "Les chiffrement est impossible";
    }
    
}
