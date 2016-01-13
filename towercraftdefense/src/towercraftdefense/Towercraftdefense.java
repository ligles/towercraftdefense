/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense;

import towercraftdefense.manager.EntiteManager;
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
        EntiteManager.init();
        ZoneManager.init();
       
        UIManager.getFenetre().setVisible(true);
        
        GameThread.LaunchRepaintThread();
        //test
    }
    
}
