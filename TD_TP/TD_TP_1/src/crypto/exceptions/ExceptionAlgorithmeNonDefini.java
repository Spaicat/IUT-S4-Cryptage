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
public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie{
    
    public ExceptionAlgorithmeNonDefini(String m, String n) {
        super(m, n);
        
        n = "Erreur Algorithme non défini";
        m = "L'algorithme n'est pas défini";
        
    }
    
    
 
}
