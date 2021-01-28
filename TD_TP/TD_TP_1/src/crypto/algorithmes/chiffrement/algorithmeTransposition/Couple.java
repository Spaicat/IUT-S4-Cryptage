/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement.algorithmeTransposition;

/**
 *
 * @author Antonia, Thibault
 */
public class Couple {
    
    private char caractere;
    private int position;
    
    /**
     * Constructor
     * @param caractere
     * @param position 
     */
    public Couple(char caractere, int position){
        this.caractere = caractere;
        this.position = position;
    }

    /**
     * returne le caractere du couple
     * @return caractere
     */
    public char getCaractere() {
        return caractere;
    }

    /**
     * set le caractere du couple
     * @param caractere 
     */
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    /**
     * Retourne la position du couple
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /***
     * Set la position du couple
     * @param position 
     */
    public void setPosition(int position) {
        this.position = position;
    }
    
  
}
