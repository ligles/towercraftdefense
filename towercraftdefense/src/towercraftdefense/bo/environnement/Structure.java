package towercraftdefense.bo.environnement;

import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class  Structure extends Entite {

    public Structure(Plan plan) {
        super(plan);
    }
    
    
    public boolean construct() {
        plan.generate();
        boolean constructed = plan.build();
        if(constructed){
            this.x = plan.getZones().get(0).x;
            this.y = plan.getZones().get(0).y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        return constructed;
    }
    
        
    public static boolean validBuild(Plan plan){   
        boolean buildable = true;
        plan.generate();
        if(plan.getZones() != null && plan.getZones().size() > 0){
            for(Zone zone : plan.getZones()){
                if(zone != null){
                    Zone zoneMap = ZoneManager.getZone((int)zone.x, (int)zone.y);
                    if(zoneMap == null || !zoneMap.isFree || !zoneMap.isBuildable)
                        buildable = false;
                }
                else buildable = false;
            }
        }
        else
            buildable = false;
        return buildable;
    }
}
