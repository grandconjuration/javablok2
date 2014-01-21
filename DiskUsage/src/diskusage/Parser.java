/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskusage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelle
 */
public class Parser {
    private static ArrayList<Disk> disks = new ArrayList<Disk>();
    
    public static boolean parseOutput(String output) {
        
        try {
            BufferedReader br = new BufferedReader(new StringReader(output));
            
            while (true) {

                String naam = "";
                int percentUsed = 0;
                
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                //System.out.println(line);
                
                Scanner sc = new Scanner(line);
                sc.useDelimiter("\\s* \\s*");
                
                int i = 0;
                boolean doLine = true; 
                
                while (sc.hasNext()) {
                    i++;
                    String s = sc.next();
                    if(i == 1 && s == "Filesystem") {
                        doLine = false;
                    }
                    
                    if(doLine) {
                        if(i == 1) {
                            naam = s;
                        }else if(i == 5) {
                            percentUsed = Integer.parseInt(s);
                        }
                    }
                }
                sc.close(); 
                
                Disk disk = new Disk(naam, percentUsed);
                disks.add(disk);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());

        }
        return false;
    }
    
    public static ArrayList<Disk> getDisks() {
        return disks;
    }
}
