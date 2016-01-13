package towercraftdefense.environnement;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Projectile  extends Gobject{
    private int degats;

    public Projectile(int x, int y, int height, int width, int degats) {
        super(x, y, height, width);
        this.degats = degats;
    }
}
