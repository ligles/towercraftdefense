package towercraftdefense.bo.environnement;

import java.awt.Image;
import java.util.List;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ressource extends Entite {

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
