package towercraftdefense.bo.environnement;

import java.awt.Image;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.EntiteMobile;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Projectile  extends EntiteMobile{
    
    private int degats;

    public Projectile(int coordx, int coordy, int width, int height, int vitesse, int angle) {
        super(coordx, coordy, width, height, vitesse, angle);
    }

    
    
}
