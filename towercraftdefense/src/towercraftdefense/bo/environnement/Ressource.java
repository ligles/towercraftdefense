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
        this.img = towercraftdefense.ressources.Ressource.loadImage("ressource.png");
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
