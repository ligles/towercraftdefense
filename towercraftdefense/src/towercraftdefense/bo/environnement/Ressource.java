package towercraftdefense.bo.environnement;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ressource extends Gobject {

    private int nbRessources;
    
    public Ressource(int x, int y, int height, int width, Image img) {
        super(x, y, height, width);
        this.nbRessources = nbRessources;
    }

    public Ressource(int nbRessources) {
        super(0, 0, 0, 0);
        this.nbRessources = nbRessources;
    }

     
}
