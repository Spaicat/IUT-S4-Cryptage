/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.donnees.messages;

import crypto.exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 *
 * @author Antonia, Thibault
 */
public interface Message {
    public String asString() throws ExceptionConversionImpossible;
    public Integer asInteger() throws ExceptionConversionImpossible;
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible;
}
