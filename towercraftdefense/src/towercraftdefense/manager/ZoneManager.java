/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import towercraftdefense.bo.Zone;

/**
 *
 * @author ligles
 */
public class ZoneManager {
    private static ArrayList<Zone> zones = new ArrayList<>();
    

    
    public static void init(){
        // dessine les zones
        
        zones.add(new Zone(0, 0, 20, 20));
        zones.add(new Zone(20, 0, 20, 20));
        zones.add(new Zone(40, 0, 20, 20));
        zones.add(new Zone(60, 0, 20, 20));
        zones.add(new Zone(80, 0, 20, 20));
        
        zones.add(new Zone(0, 20, 20, 20));
        zones.add(new Zone(20, 20, 20, 20));
        zones.add(new Zone(40, 20, 20, 20));
        zones.add(new Zone(60, 20, 20, 20));
        zones.add(new Zone(80, 20, 20, 20));
        
        
        
    }
   
    
    
   
    
    
    public static ArrayList<Zone> getClone(){
        
        return (ArrayList<Zone>) zones.clone();
    }
    
}
