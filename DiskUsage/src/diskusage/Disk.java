/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskusage;

/**
 *
 * @author jelle
 */
public class Disk {
    private String naam;
    private int percentUsed;
    
    public Disk(String nm, int pu) {
        naam = nm;
        percentUsed = pu;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public int getPercentUsed() {
        return percentUsed;
    }
    
    public String toString() {
        return naam + " " + percentUsed;
    }
}
