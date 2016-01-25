/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import towercraftdefense.jeu.Partie;
import towercraftdefense.manager.OuvrierManager;
import towercraftdefense.manager.PartieManager;
import towercraftdefense.manager.StructureManager;
import towercraftdefense.manager.UIManager;
import towercraftdefense.manager.ZoneManager;
import towercraftdefense.threads.GameThread;


/**
 *
 * @author ligles
 */
public class Towercraftdefense {
    private static final JFrame fenetre = UIManager.getFenetre();
    private static boolean isStarted = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UIManager.init();
        
        // Lancement du thread de rafraichissement du canvas
        GameThread.init();
        // Initialisation du gestionnaire de parties
        PartieManager.init(); 
        
        //test    
        ZoneManager.init();  
        StructureManager.init();
        OuvrierManager.init();
        
    }
    
    public static void start(){
        PartieManager.start();
        GameThread.start(); 
        
        UIManager.getFenetre().map.repaint();
        isStarted = true;
    }
    
    public static void stop(){
        if(isStarted)
            GameThread.stop();
    }
}
