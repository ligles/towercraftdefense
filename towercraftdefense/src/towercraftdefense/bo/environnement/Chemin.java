package towercraftdefense.bo.environnement;

import towercraftdefense.jeu.Partie;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.manager.ZoneManager;
import static towercraftdefense.manager.ZoneManager.zonesChemin;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Chemin extends Entite{
    private int longueur;
    private ArrayList<Point> listPoint;

    public Chemin(int longueur) {
        super(0, 0, 0, 0);
        this.longueur = longueur;
    }
    
    public Chemin(Plan plan){
        super(plan);
    }
    
    
    public boolean discover() {  
        plan.generate();
        boolean discoverable = plan.way();
        if(discoverable){
            this.x = plan.getZones().get(0).x;
            this.y = plan.getZones().get(0).y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        
        return discoverable;       
    }

     
    
    public static boolean validWay(Plan plan){
        boolean avaible = true;
        plan.generate();
        if(plan.getZones() != null && plan.getZones().size() > 0){
            for(Zone zone : plan.getZones()){
                if(zone != null){
                    Zone zoneMap = ZoneManager.getZone((int)zone.x, (int)zone.y);
                    if(zoneMap == null || !zoneMap.isFree)
                        avaible = false;
                }
                else avaible = false;
            }
        }
        else
            avaible = false;
        return avaible;
        
    }
   
    public static Zone getCheminZone() {
        Zone cheminZone;
        ArrayList<Zone> cheminZones = ZoneManager.zonesChemin();

        cheminZone = cheminZones.get(30);
        
        return cheminZone;
    }

     
}
