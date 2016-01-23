/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import java.util.ArrayList;
import towercraftdefense.bo.environnement.Structure;

/**
 *
 * @author SDOUGAMEHDI
 */
public class StructureManager {
    public static ArrayList<Structure> structures; 
    public static void init()
    {
        structures = new ArrayList<>(); 
        
    }
    
   public static void animate(){
       
   }
    
    public static ArrayList<Structure> getClone(){
        ArrayList<Structure> clone = null;
        if(structures != null)
            clone = (ArrayList<Structure>) structures.clone();
        
        return clone;
    }
}
