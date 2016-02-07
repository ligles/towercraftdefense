package towercraftdefense.bo.environnement;

import java.util.ArrayList;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Chemin extends Entite{
    private int longueur;
    private Zone debut, fin;

    public Chemin(Plan plan){
        super(plan);
    }     

    @Override
    public boolean create() {
        super.create(); 

        plan.generate();
        boolean created = plan.apply(this);
        if(created){
            this.debut = plan.getZones().get(10);
            this.x = debut.x;
            this.y = debut.y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        
        return created;
    }
   
    public static Zone getCheminZone() {
        Zone cheminZone;
        ArrayList<Zone> cheminZones = ZoneManager.zonesChemin();

        cheminZone = cheminZones.get(30);
        
        return cheminZone;
    }

    public Zone getDebut() {
        return debut;
    }

    public Zone getFin() {
        return fin;
    }

     
}
