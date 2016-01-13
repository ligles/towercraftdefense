package towercraftdefense.bo.environnement;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Fleche extends Projectile {

    private int angle;

    public Fleche(int angle, int degats, int x, int y, int height, int width, Image img) {
        super(degats, x, y, height, width, img);
        this.angle = angle;
    }
 
    
}
