/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.algorithmes.chiffrement.algorithmeTransposition;

/**
 *
 * @author asus
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
     * 
     * @return 
     */
    public char getCaractere() {
        return caractere;
    }

    /**
     * 
     * @param caractere 
     */
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    /**
     * 
     * @return 
     */
    public int getPosition() {
        return position;
    }

    /***
     * 
     * @param position 
     */
    public void setPosition(int position) {
        this.position = position;
    }
    
  
}
