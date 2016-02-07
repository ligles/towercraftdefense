package towercraftdefense.bo.environnement;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Fleche extends Projectile {

    public Fleche(int x, int y) {
        super(x, y);
        this.height = 10;
        this.width = 10;
        this.vitesse = 30;
        this.img = towercraftdefense.ressources.Ressource.loadImage("fleche.png");
    }

    
}

