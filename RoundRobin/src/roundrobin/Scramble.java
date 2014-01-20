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
        boolean r = true;
        ArrayList<Koppels> koppels = Lijsten.getKoppels();
        ArrayList<Koppels> verbodenKoppels = new ArrayList<Koppels>();
        
        for (Koppels c : koppels) {
            boolean collision = false;
            
            if(c.getKandidaat1().getNaam().equals(c.getKandidaat2().getNaam())) {
                r = false;
            }
            
            Koppels h1 = new Koppels(c.getKandidaat1().getNaam() + "-" + c.getKandidaat2().getNaam(), c.getKandidaat1(), c.getKandidaat2());
            Koppels h2 = new Koppels(c.getKandidaat2().getNaam() + "-" + c.getKandidaat1().getNaam(), c.getKandidaat2(), c.getKandidaat1());
            
            for (Koppels v : verbodenKoppels) {
                if (v.getNaam().equals(h1.getNaam())) {
                    r = false;
                    collision = true;
                }
                if (v.getNaam().equals(h2.getNaam())) {
                    r = false;
                    collision = true;
                }
            }
            if(!collision) {
                verbodenKoppels.add(h1);
                verbodenKoppels.add(h2);
            }
        }
        
        return r;
    }
}