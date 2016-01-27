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

/**
 *
 * @author ligles
 */
public class GameThread {
    public static ArrayList<Thread> threads;
    private static boolean started = false;   
    private static boolean stop = false;  
    
    public static void init() {
        threads = new ArrayList<>();
        
        threads.add(new Thread(() -> {
            while (threads.get(0).isAlive()) {
                Move();
                if(stop){
                    try {
                        Thread.sleep(99999999);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }));
    }
    
    
    public static void start(){
        threads.stream().forEach((Thread thread) -> {
            if(!thread.isAlive())
            {
                thread.start();
                started = true;
            }
            else if(thread.isAlive())
            {
                thread.interrupt();
                started = true;
                stop = false;
            }
        });
    }

    public static void stop(){
        started = false;
        stop = true;
    }
    
    private static void Move() {
        OuvrierManager.gestionMouvemenent();
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            
            Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public static boolean isStarted() {
        return started;
    }
}

