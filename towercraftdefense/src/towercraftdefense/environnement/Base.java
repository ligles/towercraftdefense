package towercraftdefense.environnement;

import towercraftdefense.biosphere.Ouvrier;

import java.util.ArrayList;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Base extends Gobject {
    towercraftdefense.bo.Ressource ressources;
    ArrayList<Ouvrier> ouvriers;

    public Base(int x, int y, int height, int width) {
        super(x, y, height, width);
    }
}
