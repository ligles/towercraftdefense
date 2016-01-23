/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import towercraftdefense.views.Fenetre;

/**
 *
 * @author ligles
 */
public class UIManager {
    private static Fenetre fenetre; 
    
    public static Fenetre getFenetre(){
        if(fenetre == null){
            
            fenetre = new Fenetre();
        }
        
        return fenetre;
    }

    public static void recalculateMap() {
        ZoneManager.init();
        StructureManager.init();
    }
    
    
}
