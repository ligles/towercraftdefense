package towercraftdefense.bo.environnement;

import java.io.IOException;
import towercraftdefense.bo.biosphere.Ouvrier;

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
public class Base extends Structure {
    
    Ressource ressources;
    ArrayList<Ouvrier> ouvriers;

    public Base(Ressource ressources, Zone zone, ArrayList<Direction> plan)
    {
        super(zone, plan);
        this.ressources = ressources;
        this.ouvriers = new ArrayList<>();
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("base.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
