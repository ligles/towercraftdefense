package towercraftdefense.bo.environnement;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Projectile  extends Gobject{
    private int degats;

    public Projectile(int degats, int x, int y, int height, int width, Image img) {
        super(x, y, height, width, img);
        this.degats = degats;
    }

    
}
