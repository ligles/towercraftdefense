package towercraftdefense.bo.biosphere;

import java.awt.Image;
import towercraftdefense.bo.EntiteMobile;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Personnage extends EntiteMobile {
    
    private int health;
    private int damage;
  
    public Personnage(double coordx, double coordy, double width, double height, double vitesse, double angle, int health) {
        super(coordx, coordy, width, height, vitesse, angle);
        this.health = health;
    }

    public Personnage(double coordx, double coordy, double width, double height, double vitesse, double angle, int health, int damage ) {
        super(coordx, coordy, width, height, vitesse, angle);
        this.health = health;
        this.damage = damage;
    }
}
    
  
    
   
