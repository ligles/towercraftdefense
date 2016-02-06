/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import java.util.Random;
import towercraftdefense.bo.Zone;
import towercraftdefense.enumeration.Style;

/**
 *
 * @author ligles
 */
public class ZoneManager {
    public static ArrayList<Zone> zones;
    private static final int nbrZonesX = 50;
    private static int nbrZonesY;
    private static int nbrZones;
  
    
    public static void init(){
        // dessine les zones
        zones = new ArrayList<>();
        Zone.size = UIManager.getFenetre().getSize().width/nbrZonesX;
        nbrZonesY = UIManager.getFenetre().getSize().height/Zone.size;
        nbrZones = nbrZonesX * nbrZonesY;   
        int saveX = 0, saveY = 0;
        // Création des zones dans tout le canvas
        for(int i = 0 ; i < nbrZones; i++)
        {
            if(saveX < UIManager.getFenetre().getSize().width)
            {
                zones.add(new Zone(saveX, saveY, true, false, false, false));
                saveX += Zone.size;
            }
            else
            {
                saveY = saveY + Zone.size;
                saveX = 0;
            }
        }
        
        zonesChemin().stream().forEach((zone) -> {
            zone.isWalkable = true;
        });
        zonesBase().stream().forEach((zone) -> {
            zone.isBuildable = true;
        });
        zonesCombat().stream().forEach((zone) -> {
            zone.isBuildable = true;
        });
        zonesRessource().stream().forEach((zone) -> {
            zone.isFarmable = true;
        });
    }

    public static void update(){
        zones.stream().forEach((Zone zone) -> {
            int saveX = 0, saveY = 0;
            if(saveX < UIManager.getFenetre().getSize().width)
            {
                zone = new Zone(saveX, saveY, true, true, true, true);
                saveX += Zone.size;
            }
            else
            {
                saveY += Zone.size;
                saveX = 0;
            }
        });
        UIManager.getFenetre().map.repaint();
    }
    
    public static Zone getZone(int x, int y){
        for (Zone zone : zones) {
            double maxX = zone.x + Zone.size;
            double maxY = zone.y + Zone.size;
            if(x >= zone.x && y >= zone.y && x < maxX && y < maxY)
                return zone;
        }
        
        return null;
    }
    
    public static int getNbrZonesX() {
        return nbrZonesX;
    }

    public static int getNbrZonesY() {
        return nbrZonesY;
    }

    public static int getNbrZones() {
        return nbrZones;
    }
    
    public static ArrayList<Zone> rangeZonesX(int startZone, int endZone){
        ArrayList<Zone> range = new ArrayList<>();
        
        // Récupération des zones située à droite de l'écran
        zones.stream().filter((zone) -> (zone.x >= Zone.size(startZone) && zone.x <= Zone.size(endZone))).forEach((zone) -> {
            range.add(zone);
        });
        
        return range;
    }
    
    /**
     *
     * @return
     */
    public static ArrayList<Zone> zonesBase(){
        // Entre les 30ieme et 40ieme zones sur l'axe des X
        return rangeZonesX(30, 40);
    }
    
    /**
     *
     * @return
     */
    public static ArrayList<Zone> zonesCombat(){
        // Entre les 10ieme et 30ieme zones sur l'axe des X
        return rangeZonesX(10, 30);
    }

    /**
     *
     * @return
     */
    public static ArrayList<Zone> zonesChemin(){
        // Entre les 30ieme et 40ieme zones sur l'axe des X
        return rangeZonesX(0, 1);
    }
    
    /**
     *
     * @return
     */
    public static ArrayList<Zone> zonesRessource(){
        // Entre les 30ieme et 40ieme zones sur l'axe des X
        return rangeZonesX(40, 50);
    }
    
           
    
    public static Zone getAleaZone(){
        return zones.get(new Random().nextInt(zones.size()));
    }
    
    public static Zone getAleaZone(ArrayList<Zone> range){
        return range.get(new Random().nextInt(range.size()));
    }
    
    public static ArrayList<Zone> getClone(){
        ArrayList<Zone> clone = null;
        if(zones != null)
            clone = (ArrayList<Zone>) zones.clone();
        
        return clone;
    }

    private static Zone lastHoverZone;
    public static void hoverZone(int x, int y) {
        Zone hoverZone = getZone(x, y);
        
        if(lastHoverZone != null && hoverZone != lastHoverZone)
            lastHoverZone.setStyle(Style.Default);
        if(hoverZone != null && hoverZone != lastHoverZone){
            hoverZone.setStyle(Style.Highlight);
            lastHoverZone = hoverZone;
        }
    }

    
}
