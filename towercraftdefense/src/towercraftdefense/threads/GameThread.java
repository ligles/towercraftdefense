/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.manager.UIManager;

/**
 *
 * @author ligles
 */
public class GameThread {
    public static void LaunchRepaintThread(){
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {                    
                    
                    Repaint();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {                    
                    
                    Manage();
                }
            }
        }).start();
        
        
        
        
    }

    private static void Repaint() {
        UIManager.getFenetre().map1.repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    } 
    private static void Manage() {
        
        EntiteManager manager = new EntiteManager();
        manager.gestionMouvemenent();
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}

