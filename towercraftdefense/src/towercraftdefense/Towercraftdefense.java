/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense;

import javax.swing.JFrame;
import towercraftdefense.manager.EntiteMobileManager;
import towercraftdefense.manager.PartieManager;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.manager.UIManager;
import towercraftdefense.manager.VagueManager;
import towercraftdefense.manager.ZoneManager;


/**
 *
 * @author ligles
 */
public class Towercraftdefense {
    private static final JFrame fenetre = UIManager.getFenetre();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UIManager.init();

        // Initialisation du gestionnaire de parties
        PartieManager.init();
        
        //test    
        ZoneManager.init();  
        EntiteManager.init();
        EntiteMobileManager.init();
        VagueManager.init();
        
    }
}
