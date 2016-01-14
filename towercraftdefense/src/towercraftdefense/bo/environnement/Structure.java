package towercraftdefense.bo.environnement;

import java.util.ArrayList;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.enumeration.Direction;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class  Structure extends Entite {

    public Structure(Zone zone, ArrayList<Direction> plan) {
        super(zone, plan);
    }
}
