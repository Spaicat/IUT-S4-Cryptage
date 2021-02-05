/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import crypto.protocoles.Protocole;
import crypto.protocoles.ProtocoleCesar;
import crypto.protocoles.ProtocoleTransposition;
import crypto.protocoles.ProtocoleVigenere;

/**
 * Main
 * @author Thibault, Antonia
 */
public class Crypto_nite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Algorithme de Cesar");
        Protocole protoC = new ProtocoleCesar();
        protoC.executer();
        
        System.out.println("\nAlgorithme de Transposition");
        Protocole protoT = new ProtocoleTransposition();
        protoT.executer();
        
        System.out.println("\nAlgorithme de Vigenère");
        Protocole protoV = new ProtocoleVigenere();
        protoV.executer();
    }
    
}
