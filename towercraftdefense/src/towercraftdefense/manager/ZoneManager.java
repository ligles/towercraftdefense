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
    public static ArrayList<Zone> zones;
    private static final int nbrZonesX = 100;
    private static int nbrZonesY;
    private static int nbrZones;

    
    
    public static void init(){
        // dessine les zones
        zones = new ArrayList<>();
        Zone.size = UIManager.getFenetre().getSize().width/nbrZonesX;
        nbrZonesY = UIManager.getFenetre().getSize().height/Zone.size;
        nbrZones = nbrZonesX * nbrZonesY;
        
        int saveX = 0, saveY = 0;
        for(int i = 0 ; i < nbrZones; i++)
        {
            if(saveX < UIManager.getFenetre().getSize().width)
            {
                zones.add(new Zone(saveX, saveY, true, true, false,false));
                saveX += Zone.size;
            }
            else
            {
                saveY = saveY + Zone.size;
                saveX = 0;
            }
        }     
        
    }

    public static void update(){
        // recolte
        
        
        
        
    }
    
    public static ArrayList<Zone> getClone(){
        ArrayList<Zone> clone = null;
        if(zones != null)
            clone = (ArrayList<Zone>) zones.clone();
        
        return clone;
    }
    
}
