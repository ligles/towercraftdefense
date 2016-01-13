package towercraftdefense.environnement;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class Gobject {
    private int x;
    private int y;
    private int height;
    private int width;

    public Gobject(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
}
