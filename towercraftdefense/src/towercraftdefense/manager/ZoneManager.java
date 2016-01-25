/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.sql.rowset.Predicate;
import towercraftdefense.bo.Zone;
import towercraftdefense.jeu.Configuration;

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
        zones.stream().forEach((Zone zone) -> {
            int saveX = 0, saveY = 0;
            if(saveX < UIManager.getFenetre().getSize().width)
            {
                zone = new Zone(saveX, saveY, true, true, false,false);
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
    
    /**
     *
     * @param p
     * @return
     */
    public static Zone getAleaZone(){
        ArrayList<Zone> pZones = new ArrayList<>();
        
        // Récupération des zones située à droite de l'écran
        zones.stream()
                .forEach((zone) -> {
            pZones.add(zone);
        });
        
        return pZones.get(new Random().nextInt(pZones.size()));
    }
    
    // Retourne une zone de la map ou l'on peut construire une base
    public static Zone aleaBaseZone() {
        Zone aleaZone;
        ArrayList<Zone> baseZones = new ArrayList<>();
        List<Zone> baseValidZones;
        
        // Récupération des zones située à droite de l'écran
        zones.stream().filter((zone) -> (zone.x > 2*UIManager.getFenetre().getWidth()/3)).forEach((zone) -> {
            baseZones.add(zone);
        });
        
        // Vérification si la zone trouvée peut bien acceuillir la base
        baseValidZones = baseZones.stream()
                .filter(zone -> Configuration.validConstruct(zone, Configuration.baseStructure()))
                .collect(Collectors.toList());
        
        aleaZone = baseValidZones.get(new Random().nextInt(baseValidZones.size()));
        
        return aleaZone;
    }
    
    public static Zone getBaseZone() {
        Zone baseZone;
        ArrayList<Zone> baseZones = new ArrayList<>();
        List<Zone> baseValidZones;
        
        // Récupération des zones située à droite de l'écran
        zones.stream().filter((zone) -> (zone.x > 2*UIManager.getFenetre().getWidth()/3)).forEach((zone) -> {
            baseZones.add(zone);
        });
        
        // Vérification si la zone trouvée peut bien acceuillir la base
        baseValidZones = baseZones.stream()
                .filter(zone -> Configuration.validConstruct(zone, Configuration.baseStructure()))
                .collect(Collectors.toList());
        
        baseZone = baseValidZones.get(150);
        
        return baseZone;
    }
    
    public static ArrayList<Zone> getClone(){
        ArrayList<Zone> clone = null;
        if(zones != null)
            clone = (ArrayList<Zone>) zones.clone();
        
        return clone;
    }

    
}
