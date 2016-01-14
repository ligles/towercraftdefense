package towercraftdefense.bo.environnement;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.enumeration.Direction;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Tour extends Structure {
    private int portee;
    private ArrayList<Fleche> fleches;
    private static float cout;

    public Tour(Zone zone, ArrayList<Direction> plan, int nbFleche)
    {
        super(zone, plan);
        fleches = new ArrayList<>(nbFleche);
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("base.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.construct();
    }

   
}
