package towercraftdefense.bo.environnement;

import java.awt.Image;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ressource extends Entite {
    private int nbRessources;
    
    public Ressource(int x, int y, int height, int width, Image img) {
        super(x, y, height, width);
        this.nbRessources = nbRessources;
    }

    public Ressource(int nbRessources, Plan plan) {
        super(plan);
        this.nbRessources = nbRessources;
        towercraftdefense.ressources.Ressource.loadImage("ressource.jpg");
    }

    public boolean farm(){
        plan.generate();
        boolean farmable = plan.mine();
        if(farmable){
            this.x = plan.getZones().get(0).x;
            this.y = plan.getZones().get(0).y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        
        return farmable;
    }
    
    public static boolean validRessource(Plan plan){   
        boolean farmable = true;
        plan.generate();
        if(plan.getZones() != null && plan.getZones().size() > 0){
            for(Zone zone : plan.getZones()){
                if(zone != null){
                    Zone zoneMap = ZoneManager.getZone((int)zone.x, (int)zone.y);
                    if(zoneMap == null || !zoneMap.isFree)
                        farmable = false;
                }
                else farmable = false;
            }
        }
        else
            farmable = false;
        return farmable;
    }
}
