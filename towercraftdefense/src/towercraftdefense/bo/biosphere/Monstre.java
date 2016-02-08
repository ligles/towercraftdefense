package towercraftdefense.bo.biosphere;

import towercraftdefense.bo.Zone;
import towercraftdefense.manager.PartieManager;
import towercraftdefense.ressources.Ressource;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Monstre extends Personnage {

    public Monstre(Zone zone, int health, int damage) {
        super(zone, health, damage);
        this.cible = PartieManager.partie.getBase();
        this.width = 20;
        this.height = 30;
        this.img = Ressource.loadImage("robot.png");
    }

   
}
