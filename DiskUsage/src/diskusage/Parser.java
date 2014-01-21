/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskusage;

import java.util.ArrayList;

/**
 *
 * @author jelle
 */
public class Parser {
    private static ArrayList<Disk> disks = new ArrayList<Disk>();
    
    public static boolean parseOutput(String output) {
        return false;
    }
    
    public static ArrayList<Disk> getDisks() {
        return disks;
    }
}
