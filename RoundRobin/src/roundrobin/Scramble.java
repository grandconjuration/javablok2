/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundrobin;

import java.util.ArrayList;

/**
 *
 * @author jelle
 */
public class Scramble {
    public static void runGenerator() {
        ArrayList<Kandidaat> kandidaten = Lijsten.getKandidaten();
        
        int size = kandidaten.size();
        int done = 0;
        
        for (Kandidaat c : kandidaten) {
            
        }
    }
    
    public static boolean checkKoppels() {
        return false;
    }
}
