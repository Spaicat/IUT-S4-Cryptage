/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.generateurdecles;

import crypto.donnees.cles.Cles;

/**
 *
 * @author asus
 */
public interface GenerateurDeCles {
    
    public Cles genererClePublique();
    
    public Cles genererClePrivee();
    
}
