/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.threads;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.manager.OuvrierManager;
import towercraftdefense.manager.UIManager;

/**
 *
 * @author ligles
 */
public class GameThread {
    public static ArrayList<Thread> threads;
    
    public static void init() {
        threads = new ArrayList<>();
        threads.add(new Thread(() -> {
            while (threads.get(0).isAlive()) {
                Repaint();
            }
        }));
        
        threads.add(new Thread(() -> {
            while (threads.get(1).isAlive()) {
                Move();
            }
        }));
    }
    
    
    public static void start(){
        threads.stream().forEach((Thread thread) -> {
            if(!thread.isAlive())
                thread.start();
        });
    }

    public static void stop(){
        threads.stream().filter((thread) -> (thread.isAlive())).forEach((Thread thread) -> {
            try {
                thread.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private static void Repaint() {
        UIManager.getFenetre().map.repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    } 
    
    private static void Move() {
        OuvrierManager.gestionMouvemenent();
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

