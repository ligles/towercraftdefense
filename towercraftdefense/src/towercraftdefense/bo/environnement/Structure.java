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

    @Override
    public boolean create() {
        super.create(); 

        plan.generate();
        boolean created = plan.apply(this);
        if(created){
            this.x = plan.getZones().get(0).x;
            this.y = plan.getZones().get(0).y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        
        return created;
    }
    
    
}
