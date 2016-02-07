package towercraftdefense.bo.biosphere;

import towercraftdefense.bo.EntiteMobile;
import towercraftdefense.bo.Zone;
import towercraftdefense.interfaces.ICiblate;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class Personnage extends EntiteMobile implements ICiblate{
    
    private int health;
    private int damage;
    Zone zone;
    towercraftdefense.bo.Entite cible;
  
    public Personnage(Zone zone, int health) {
        super((int)zone.x, (int)zone.y);
        this.zone = zone;
        this.health = health;
        this.damage = 0;
    }

    public Personnage(Zone zone, int health, int damage) {
        super((int)zone.x, (int)zone.y);
        this.zone = zone;
        this.health = health;
        this.damage = damage;
    }

    public boolean create(){
        super.create();
        boolean isAlive = zone.populate(this);
        if(isAlive)
            notifyObserver();
        
        return isAlive;
    }
    
    public void inflict(int damage){
        this.health -= damage;
    }
    
    public boolean isDie(){
        return health <= 0;
    }

    @Override
    public void ciblate() {
        
    }

    @Override
    public void lock(towercraftdefense.bo.Entite entite) {
        cible = entite;
    }
    
    

}
    
  
    
   
