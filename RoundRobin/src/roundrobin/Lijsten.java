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
    private static ArrayList<Kandidaat> kandidaten = new ArrayList<Kandidaat>();
    private static ArrayList<Koppel> koppels = new ArrayList<Koppel>();
    private static ArrayList<Koppel> verbodenKoppels = new ArrayList<Koppel>();
    
    public static boolean heeftKoppel(String em) {
        boolean r = false;
        for (Koppel c : verbodenKoppels) {
            if (c.getNaam().equals(em)) {
                r = true;
            }
        }
        return r;
    }
    
    public static boolean heeftKandidaat(String em) {
        boolean r = false;
        for (Kandidaat c : kandidaten) {
            if (c.getNaam().equals(em)) {
                r = true;
            }
        }
        return r;
    }
    
    public static boolean kanKoppelGebruiken(Kandidaat k1) {
        Kandidaat k2 = new Kandidaat("");
        return kanKoppelGebruiken(k1, k2);
    }
    
    public static boolean kanKoppelGebruiken(Kandidaat k1, Kandidaat k2) {
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
    
    public static boolean voegKoppelToe(Kandidaat k1) {
        Kandidaat k2 = new Kandidaat("");
        return voegKoppelToe(k1, k2);
    }
    
    public static boolean voegKoppelToe(Kandidaat k1, Kandidaat k2) {
        if (kanKoppelGebruiken(k1, k2)) {
            Koppel koppel1 = new Koppel(k1.getNaam() + "-" + k2.getNaam(), k1, k2);
            Koppel koppel2 = new Koppel(k2.getNaam() + "-" + k1.getNaam(), k2, k1);
            
            verbodenKoppels.add(koppel1);
            verbodenKoppels.add(koppel2);
            return true;
        }else{
            return false;
        }
    }
    
    public static void voegKandidaatToe(Kandidaat k) {
        if (!heeftKandidaat(k.getNaam())) {
            kandidaten.add(k);
        }
    }
    
    public static Koppel getKoppel(String em) {
        Koppel r = null;
        for (Koppel c : koppels) {
            if (c.getNaam().equals(em)) {
                r = c;
            }
        }
        return r;
    }
    
    public static Kandidaat getKandidaat(String em) {
        Kandidaat r = null;
        for (Kandidaat c : kandidaten) {
            if (c.getNaam().equals(em)) {
                r = c;
            }
        }
        return r;
    }
    
    public static ArrayList<Koppel> getKoppels() {
        return koppels;
    }
    
    public static ArrayList<Kandidaat> getKandidaten() {
        return kandidaten;
    }
    
    public static void resetKoppels() {
        koppels = new ArrayList<Koppel>();
    }
}
