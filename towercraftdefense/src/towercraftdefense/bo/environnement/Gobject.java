package towercraftdefense.bo.environnement;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class Gobject {
    private int x;
    private int y;
    private int height;
    private int width;
    Image img;

    public Gobject(int x, int y, int height, int width, Image img) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.img = img;
    }

    
}
