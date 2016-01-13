package towercraftdefense.bo.environnement;

import java.awt.Image;
import towercraftdefense.bo.biosphere.Ouvrier;

import java.util.ArrayList;
import towercraftdefense.bo.environnement.Ressource;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Base extends Gobject {
    Ressource ressources;
    ArrayList<Ouvrier> ouvriers;

    public Base(Ressource ressources, ArrayList<Ouvrier> ouvriers, int x, int y, int height, int width, Image img) {
        super(x, y, height, width, img);
        this.ressources = ressources;
        this.ouvriers = ouvriers;
    }
}
