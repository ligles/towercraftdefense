package towercraftdefense.bo.biosphere;

import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.EntiteMobile;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Fleche;
import towercraftdefense.bo.environnement.Tour;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.manager.EntiteMobileManager;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.manager.PartieManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ouvrier extends Personnage{
    int nbRessource;
    int maxRessource;
    
    public Ouvrier(Zone zone, int health) {
        super(zone, health, 0);
        this.vitesse = 20;
        this.width = 5;
        this.height = 30;
        this.nbRessource = 0;
        this.maxRessource = 10;
        this.img = towercraftdefense.ressources.Ressource.loadImage("robot.png");
    }
    
    @Override
    public void survey() {
        survey = true;
        surveyor = new Thread(() -> {
            while(survey){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                }
                if((Ressource)cible == null)
                    ciblate();
                else if(((Ressource)cible).isSpent())
                    cible = null;
                else
                    recolte();
            }
        });
        
        surveyor.start();
    }
    
   @Override
    public void ciblate(){
        int lastDistance = 0;
        for(Entite entite : EntiteManager.entites){
            if(entite instanceof Ressource){
                int distanceX = (int)entite.x - (int)this.x;
                int distanceY = (int)entite.y - (int)this.y;
                int distance = Math.abs(distanceX) + Math.abs(distanceY);
                
                if( distance < lastDistance || lastDistance == 0){
                    lock(entite);
                    lastDistance = distance;
                }
            }
        }

    }
    
    @Override
    public void arrived(){
        
        if(cible instanceof Base){
            //TODO deverser ressources
            this.cible = null;
            recolte();
           
            
        }else if (cible instanceof Ressource) {
            
            exploit();
            
            
        }
        
    }
            
            
    public void recolte(){
    
        if(cible == null)
            ciblate();
        else if(((Ressource)cible).isSpent())
            cible = null;
        
        if (cible != null){
            this.go(cible);
        }   
    }
    
    public boolean isEmpty(){
        return nbRessource <= 0;
    }

    public boolean isFull(){
        return nbRessource >= maxRessource;
    }

    private void exploit() {
        
      
       Thread exploitor = new Thread(() -> {
            while(!isFull()){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ouvrier.class.getName()).log(Level.SEVERE, null, ex);
                }
                nbRessource = maxRessource; 
            }
            go(PartieManager.partie.getBase());

        });
        
       exploitor.start();
        
    }
}
