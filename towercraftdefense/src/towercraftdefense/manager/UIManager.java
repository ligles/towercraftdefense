/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import towercraftdefense.Towercraftdefense;
import towercraftdefense.observers.Repainter;
import towercraftdefense.views.Fenetre;

/**
 *
 * @author ligles
 */
public class UIManager {
    private static Fenetre fenetre;
    
    public static void init(){
        fenetre = new Fenetre();
        // Maximisation
        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Pas de redimensionnement
        fenetre.setResizable(false);
        // Affichage de la fenêtre
        fenetre.setVisible(true);
        // Attente pour déssiner complétement la fenetre
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Towercraftdefense.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Fenetre getFenetre(){
        if(fenetre == null){
            
            fenetre = new Fenetre();
        }
        
        return fenetre;
    }

    public static void recalculateMap() {
        ZoneManager.update();
        EntiteManager.init();
    }
    
    
}
