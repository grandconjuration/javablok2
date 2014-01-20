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
    
    public boolean heeftKoppel(String em) {
        boolean r = false;
        for (Koppels c : verbodenKoppels) {
            if (c.getNaam().equals(em)) {
                r = true;
            }
        }
        return r;
    }
    
    public boolean heeftKandidaat(String em) {
        boolean r = false;
        for (Kandidaat c : kandidaten) {
            if (c.getNaam().equals(em)) {
                r = true;
            }
        }
        return r;
    }
    
    public boolean kanKoppelGebruiken(Kandidaat k1, Kandidaat k2) {
        boolean r = true;
        if(heeftKoppel(k1.getNaam() + "-" + k2.getNaam())) {
            r = false;
        }
        if(heeftKoppel(k2.getNaam() + "-" + k1.getNaam())) {
            r = false;
        }
        if(k1.getNaam().equals(k2.getNaam())) {
            r = false;
        }
        return r;
    }
    
    public void voegKoppelToe(Kandidaat k1, Kandidaat k2) {
        if (!kanKoppelGebruiken(k1, k2)) {
            Koppels koppel1 = new Koppels(k1.getNaam() + "-" + k2.getNaam(), k1, k2);
            Koppels koppel2 = new Koppels(k2.getNaam() + "-" + k1.getNaam(), k2, k1);
            
            verbodenKoppels.add(koppel1);
            verbodenKoppels.add(koppel2);
        }
    }
    
    public void voegKandidaatToe(Kandidaat k) {
        if (!heeftKandidaat(k.getNaam())) {
            kandidaten.add(k);
        }
    }
    
    public Koppels getKoppel(String em) {
        Koppels r = null;
        for (Koppels c : koppels) {
            if (c.getNaam().equals(em)) {
                r = c;
            }
        }
        return r;
    }
    
    public Kandidaat getKandidaat(String em) {
        Kandidaat r = null;
        for (Kandidaat c : kandidaten) {
            if (c.getNaam().equals(em)) {
                r = c;
            }
        }
        return r;
    }
    
    public ArrayList<Koppels> getKoppels() {
        return koppels;
    }
    
    public ArrayList<Kandidaat> getKandidaten() {
        return kandidaten;
    }
    
    public void resetKoppels() {
        koppels = new ArrayList<Koppels>();
    }
}
