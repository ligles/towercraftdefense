package towercraftdefense.bo.environnement;

import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.EntiteMobile;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.biosphere.Monstre;
import towercraftdefense.interfaces.ICiblate;
import towercraftdefense.manager.EntiteMobileManager;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Tour extends Structure implements ICiblate{
    private int portee;
    private int speedFire;
    private static float cout;
    private boolean survey;
    private Monstre cible;
    Thread surveyor;

    public Tour(Plan plan)
    {
        super(plan);
        this.img = towercraftdefense.ressources.Ressource.loadImage("tour.png");
        this.portee = Zone.size(10);
        this.speedFire = 2000;
    }   

    public void fire(){
        Fleche fleche = new Fleche((int)this.x, (int)this.y);
        fleche.create();
        fleche.go((int)(cible.x+cible.width/2), (int)(cible.y+cible.height/2));
    }
    
    @Override
    public void ciblate(){
        int lastDistance = portee;
        for(EntiteMobile entiteMobile : EntiteMobileManager.entiteMobiles){
            if(entiteMobile instanceof Monstre){
                int distanceX = (int)entiteMobile.x - (int)this.x;
                int distanceY = (int)entiteMobile.y - (int)this.y;
                int distance = Math.abs(distanceX) + Math.abs(distanceY);
                if(distance < portee && distance < lastDistance){
                    lock(entiteMobile);
                    lastDistance = distance;
                }
            }
        }

    }

    @Override
    public void lock(Entite entite) {
        if(entite instanceof Monstre)
            cible = (Monstre) entite;
    }

    @Override
    public void survey() {
        survey = true;
        surveyor = new Thread(() -> {
            while(survey){
                try {
                    Thread.sleep(speedFire);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(cible == null)
                    ciblate();
                else if(cible.isDie())
                    cible = null;
                else
                    fire();
            }
        });
        
        surveyor.start();
    }
    
    
}
