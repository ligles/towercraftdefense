package towercraftdefense.environnement;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ressource extends Gobject {
    towercraftdefense.bo.Ressource ressources;

    public Ressource(int x, int y, int height, int width, towercraftdefense.bo.Ressource ressources) {
        super(x, y, height, width);
        this.ressources = ressources;
    }
}
