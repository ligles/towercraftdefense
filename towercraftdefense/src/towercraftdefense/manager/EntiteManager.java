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
 * @author SDOUGAMEHDI
 */
public class EntiteManager {
    public static ArrayList<Entite> entites; 
    public static void init()
    {
        entites = new ArrayList<>(); 
        
    }
    
   public static void animate(){
       
   }
    
    public static ArrayList<Entite> getClone(){
        ArrayList<Entite> clone = null;
        if(entites != null)
            clone = (ArrayList<Entite>) entites.clone();
        
        return clone;
    }
}
