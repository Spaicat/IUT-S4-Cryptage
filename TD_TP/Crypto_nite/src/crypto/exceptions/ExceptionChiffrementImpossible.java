/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.exceptions;

/**
 * Représente une exception d'un chiffrement impossible
 * @author Antonia
 */
public class ExceptionChiffrementImpossible extends ExceptionCryptographie{
    public ExceptionChiffrementImpossible(String m) {
        super("Chiffrement impossible", m);
    }
}
