/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import java.util.ArrayList;
import towercraftdefense.bo.Entite;
import towercraftdefense.views.Fenetre;


/**
 *
 * @author ligles
 */
public class EntiteManager {
    private static ArrayList<Entite> entites = new ArrayList<>();
    

    
    public static void init(){
        
        entites.add(new Entite(50, 50, 60, 60,1,1));
        entites.add(new Entite(120, 120, 60, 60,1,3));
        entites.add(new Entite(180, 160, 60, 60,2,6));
      
        
        
        
    }
    public static void gestionMouvemenent(){
        
            
        
        for (Entite entite : getClone()) {
            
            
            if(entite.getMvtx() > 0 ){
                
                if(entite.x + entite.width + entite.getMvtx() < UIManager.getFenetre().panneau1.getWidth()){
                    entite.x += entite.getMvtx();
                }else{
                    entite.setMvtx(entite.getMvtx() * -1);
                    entite.x += entite.getMvtx();
                    
                }
            }else if (entite.getMvtx() < 0){
                
                if(entite.x +entite.getMvtx() > 0){
                    entite.x += entite.getMvtx();
                }else{
                    entite.setMvtx( -(entite.getMvtx()));
                    entite.x += entite.getMvtx();
                    
                }
                
            }
                  
            if(entite.getMvty()> 0 ){
                
                if(entite.y + entite.height + entite.getMvty() < UIManager.getFenetre().panneau1.getHeight()){
                    entite.y += entite.getMvty();
                }else{
                    entite.setMvty(-(entite.getMvty()));
                    entite.y += entite.getMvty(); 
                    
                }
            }else if (entite.getMvty() < 0 ){
                
                if(entite.y + entite.getMvty() > 0){
                    entite.y += entite.getMvty();
                }else{
                    entite.setMvty(-(entite.getMvty()));
                    entite.y += entite.getMvty(); 
                    
                }
                
            }
            
            
            
            
            
        }
        
    }
    
    public static ArrayList<Entite> getClone(){
        
        return (ArrayList<Entite>) entites.clone();
    }
    
}
