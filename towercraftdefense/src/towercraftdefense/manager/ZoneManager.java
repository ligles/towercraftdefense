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
        getNbZone();
 
        
        zones.add(new Zone(1000, 20, true, true, false,false));
        zones.add(new Zone(1020, 20, true, true, false,false));
        zones.add(new Zone(1040, 20, true, true, false,false));
        zones.add(new Zone(1060, 20, true, true, false,false));
        zones.add(new Zone(1080, 20, true, true, false,false));
        
        zones.add(new Zone(1000, 40, true, true, false,false));
        zones.add(new Zone(1020, 40, true, true, false,false));
        zones.add(new Zone(1040, 40, true, true, false,false));
        zones.add(new Zone(1060, 40, true, true, false,false));
        zones.add(new Zone(1080, 40, true, true, false,false));
        
        zones.add(new Zone(1000, 60, true, true, false,false));
        zones.add(new Zone(1020, 60, true, true, false,false));
        zones.add(new Zone(1040, 60, true, true, false,false));
        zones.add(new Zone(1060, 60, true, true, false,false));
        zones.add(new Zone(1080, 60, true, true, false,false));
        
        // Base
        zones.add(new Zone(200, 520, true, true, false,false));
        zones.add(new Zone(200, 540, true, true, false,false));
        zones.add(new Zone(220, 520, true, true, false,false));
        zones.add(new Zone(220, 540, true, true, false,false));        
        
    }
   
    public static void getNbZone(){
        
       int x = UIManager.getFenetre().getWidth();
       int y = UIManager.getFenetre().getHeight();
        System.out.println("x= " + x + " y = "+ y);
        
    }
    
   
    public static void update(){
        // recolte
        
        
        
        
    }
    
    public static ArrayList<Zone> getClone(){
        
        return (ArrayList<Zone>) zones.clone();
    }
    
}
