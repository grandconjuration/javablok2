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
    private Koppels kandidaat1;
    private Koppels kandidaat2;
    
    public Koppels(String nm, Koppels k1, Koppels k2) {
        naam = nm;
        kandidaat1 = k1;
        kandidaat2 = k2;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public Koppels getKandidaat1() {
        return kandidaat1;
    }
    
    public Koppels getKandidaat2() {
        return kandidaat2;
    }
}
