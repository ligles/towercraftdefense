/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;
import java.util.ArrayList;
import towercraftdefense.bo.Entite;

/**
 *
 * @author ligles
 */
public class EntiteManager {
    private static ArrayList<Entite> entites = new ArrayList<>();
    

    
    public static void init(){
        
        entites.add(new Entite(150, 170, 60, 60,1,45));
        entites.add(new Entite(120, 120, 60, 60,1.2,25));
        entites.add(new Entite(200, 260, 60, 60,2.5,40));
      
        
        
        
    }
    public void gestionMouvemenent(){
        
        for (Entite entite : getClone()) {
           updateTarget(entite);
           
            
        }
        
    }
    
    
    public void updateTarget(Entite entite)
        {
            
            
            double vitesse = entite.getVitesse();
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

            if (UIManager.getFenetre().map1.getHeight() != 0 && UIManager.getFenetre().map1.getWidth() != 0)
            {
                if (entite.getHeight()+entite.y > UIManager.getFenetre().map1.getHeight() || entite.y < 0)
                {
                    entite.setAngle(entite.getAngle() + 90);
                }
                if (entite.getWidth()+ entite.x > UIManager.getFenetre().map1.getWidth() || entite.x < 0)
                {
                    entite.setAngle(entite.getAngle() + 90);
                }
            }


        }
    
    
    
    
    public static ArrayList<Entite> getClone(){
        
        return (ArrayList<Entite>) entites.clone();
    }
    
}
