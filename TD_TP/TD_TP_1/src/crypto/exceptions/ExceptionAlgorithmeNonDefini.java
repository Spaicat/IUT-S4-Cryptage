/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.exceptions;

/**
 * Représente une exception d'un algorithme non défini
 * @author Thibault, Antonia
 */
public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie{
    public ExceptionAlgorithmeNonDefini(String m) {
        super("Erreur Algorithme non défini", m);
    }
}
