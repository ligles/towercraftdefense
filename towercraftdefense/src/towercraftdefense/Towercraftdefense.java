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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        configScreen();
        // Lancement du thread de rafraichissement du canvas
        GameThread.LaunchRepaintThread();
        
        
        Partie p = PartieManager.init();
        ZoneManager.init();  
        StructureManager.init();
        OuvrierManager.init();  
       
        //test
        p.init();
    }
    
    /* Configuration de la fenêtre avant initialisation du jeu */
    private static void configScreen() {
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
    
}
