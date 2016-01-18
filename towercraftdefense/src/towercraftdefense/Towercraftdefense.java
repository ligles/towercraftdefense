/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense;

import javax.swing.JFrame;
import towercraftdefense.jeu.Joueur;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Partie p = PartieManager.init();
        OuvrierManager.init();
        StructureManager.init(p);
        ZoneManager.init();
        
        UIManager.getFenetre().setExtendedState(JFrame.MAXIMIZED_BOTH);
        UIManager.getFenetre().setVisible(true);
        GameThread.LaunchRepaintThread();
        //test
    }
    
}
