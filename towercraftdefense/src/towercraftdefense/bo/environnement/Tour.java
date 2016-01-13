package towercraftdefense.bo.environnement;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Tour extends Gobject {
    private int portee;

    private static float cout;

    public Tour(int portee, int x, int y, int height, int width, Image img) {
        super(x, y, height, width, img);
        this.portee = portee;
    }

   
}
