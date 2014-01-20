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
public class Lijsten {
    private ArrayList<Kandidaat> kandidaten;
    private ArrayList<Koppels> koppels;
    private ArrayList<Koppels> verbodenKoppels;
    
    public Lijsten() {
        kandidaten = new ArrayList<Kandidaat>();
        koppels = new ArrayList<Koppels>();
        verbodenKoppels = new ArrayList<Koppels>();
    }
    
    public boolean kanKoppelGebruiken(Koppels k1, Koppels k2) {
        return false;
    }
    
    public void resetKoppels() {
        koppels = new ArrayList<Koppels>();
    }
}
