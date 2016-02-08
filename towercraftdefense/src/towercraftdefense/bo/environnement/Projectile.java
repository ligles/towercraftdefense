package towercraftdefense.bo.environnement;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.EntiteMobile;
import towercraftdefense.bo.biosphere.Personnage;
import towercraftdefense.interfaces.ICiblate;
import towercraftdefense.manager.EntiteMobileManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class Projectile extends EntiteMobile implements ICiblate{
    
    private int degats;

    public Projectile(int x, int y) {
        super(x, y);
    }

    @Override
    public void arrived() {
        super.arrived();
        if(cible instanceof Personnage)
            ((Personnage)cible).inflict(degats);
        
        EntiteMobileManager.entiteMobiles.remove(this);
        notifyObserver();
    }
}
