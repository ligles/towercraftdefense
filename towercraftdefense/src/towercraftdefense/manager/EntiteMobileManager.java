/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import towercraftdefense.bo.EntiteMobile;


/**
 *
 * @author ligles
 */
public class EntiteMobileManager {
    public static ArrayList<EntiteMobile> entiteMobiles;
    

    
    public static void init(){
        entiteMobiles = new ArrayList<>();
    }
    
    public static void gestionMouvemenent(){
        entiteMobiles.stream().forEach((ouvrier) -> {
            updateTarget(ouvrier);
        });
        
    }
    
    
    public static void updateTarget(EntiteMobile entite)
    {

        double vitesse = entite.getVitesse()/10;
        double x = Math.cos(entite.getAngle() * (Math.PI / 180)) * vitesse; // donne la position x future en fonction de la vitesse
        double y = Math.sin(entite.getAngle() * (Math.PI / 180)) * vitesse; // donne la position y future en fonction de la vitesse
       /*
         Ce block permettra d'afficher le bon skin en fonction de la direction     
         if(x <0) {
            this.way = Entite._LEFT;
        }
        else{ this.way = Entite._RIGHT;}
        */
        //this.dx = x;
        entite.setCoordx((entite.getCoordx() + x));
       // this.dy = y;
        entite.setCoordy((entite.getCoordy() + y)); 

        if (UIManager.getFenetre().map.getHeight() != 0 && UIManager.getFenetre().map.getWidth() != 0)
        {
            if (entite.getHeight()+entite.y > UIManager.getFenetre().map.getHeight() || entite.y < 0)
            {
                entite.setAngle(entite.getAngle() + 90);
            }
            if (entite.getWidth()+ entite.x > UIManager.getFenetre().map.getWidth() || entite.x < 0)
            {
                entite.setAngle(entite.getAngle() + 90);
            }
        }


    }
    
    
    
    
    public static ArrayList<EntiteMobile> getClone(){
        ArrayList<EntiteMobile> clone = null;
        if(entiteMobiles != null)
            clone = (ArrayList<EntiteMobile>) entiteMobiles.clone();
        
        return clone;
    }
    
}
