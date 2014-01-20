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
        int todo = size;
        int done = 0;
        
        for (Kandidaat c : kandidaten) {
            if(todo < 2) {
                if(Lijsten.kanKoppelGebruiken(c)) {
                    if(Lijsten.voegKoppelToe(c)) {
                        todo--;
                        done++;
                    }
                }
            }else{
                boolean finished = false;
                for (Kandidaat k : kandidaten) {
                    if(!finished) {
                        if(Lijsten.kanKoppelGebruiken(c, k)) {
                            if(Lijsten.voegKoppelToe(c, k)) {
                                todo--;
                                done++;
                                finished = true;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static boolean checkKoppels() {
        return false;
    }
}
