/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import crypto.protocoles.Protocole;
import crypto.protocoles.ProtocoleTransposition;

/**
 *
 * @author asus
 */
public class Crypto_nite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Protocole proto = new ProtocoleTransposition();
        proto.executer();
    }
    
}
