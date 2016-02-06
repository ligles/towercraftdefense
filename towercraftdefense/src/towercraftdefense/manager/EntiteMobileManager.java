/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import towercraftdefense.bo.EntiteMobile;

import towercraftdefense.bo.biosphere.Ouvrier;

/**
 *
 * @author ligles
 */
public class EntiteMobileManager {
    private static ArrayList<EntiteMobile> ouvriers;
    

    
    public static void init(){
        ouvriers = new ArrayList<>();
        
        ouvriers.add(new Ouvrier(150, 170, 60, 60, 10, 45));
        ouvriers.add(new Ouvrier(120, 120, 60, 60, 12, 25));
        ouvriers.add(new Ouvrier(200, 260, 60, 60, 25, 40));
    }
    
    public static void gestionMouvemenent(){
        ouvriers.stream().forEach((ouvrier) -> {
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
    
    
    
    
    public static ArrayList<Ouvrier> getClone(){
        ArrayList<Ouvrier> clone = null;
        if(ouvriers != null)
            clone = (ArrayList<Ouvrier>) ouvriers.clone();
        
        return clone;
    }
    
}
