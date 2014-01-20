/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundrobin;

/**
 *
 * @author jelle
 */
public class Koppels {
    private String naam;
    private Kandidaat kandidaat1;
    private Kandidaat kandidaat2;
    
    public Koppels(String nm, Kandidaat k1, Kandidaat k2) {
        naam = nm;
        kandidaat1 = k1;
        kandidaat2 = k2;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public Kandidaat getKandidaat1() {
        return kandidaat1;
    }
    
    public Kandidaat getKandidaat2() {
        return kandidaat2;
    }
}
