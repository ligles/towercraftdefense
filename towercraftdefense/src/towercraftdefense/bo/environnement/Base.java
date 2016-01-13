package towercraftdefense.bo.environnement;

import java.awt.Image;
import java.io.IOException;
import towercraftdefense.bo.biosphere.Ouvrier;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.environnement.Ressource;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Base extends Gobject {
    Ressource ressources;
    ArrayList<Ouvrier> ouvriers;

    public Base(Ressource ressources, int x, int y, int height, int width) {
        super(x, y, height, width);
        this.ressources = ressources;
        this.ouvriers = new ArrayList<Ouvrier>();
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("base.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
