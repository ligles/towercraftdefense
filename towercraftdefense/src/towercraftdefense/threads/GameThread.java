/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.manager.OuvrierManager;
import towercraftdefense.manager.UIManager;
import towercraftdefense.manager.ZoneManager;

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
                    RefreshMap();
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
        
        OuvrierManager manager = new OuvrierManager();
        manager.gestionMouvemenent();
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     private static void RefreshMap() {
        
        ZoneManager manager = new ZoneManager();
        manager.update();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

