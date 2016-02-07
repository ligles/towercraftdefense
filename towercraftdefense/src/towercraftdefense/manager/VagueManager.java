/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.bo.biosphere.Monstre;

/**
 *
 * @author mehdi
 */
public class VagueManager {
    public static ArrayList<Thread> threads;
    private static boolean started = false;   
    private static boolean stop = false;  
    
    public static void init() {
        threads = new ArrayList<>();
        createVague(10, 2);
    }
    
    public static void createVague(int waitingSec, int nbrMonstres){
        threads.add(new Thread(() -> {
            try {
                Thread.sleep(waitingSec);
            } catch (InterruptedException ex) {
                Logger.getLogger(VagueManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0 ; i < nbrMonstres ; i++){
                Monstre monstre = new Monstre(PartieManager.partie.getChemin().getDebut(), 50, 10);
                PartieManager.partie.createPersonnage(monstre);
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

    
    public static boolean isStarted() {
        return started;
    }
    
}
