/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import towercraftdefense.jeu.Joueur;
import towercraftdefense.jeu.Partie;

/**
 *
 * @author SDOUGAMEHDI
 */
public class PartieManager {
    private static Joueur joueur;
    private static boolean started = false;
    public static Partie partie;
    
    public static void init()
    {
        joueur = new Joueur("Testeur");
        partie = new Partie(joueur);
    }
    
    public static void start(){
        partie.init();
        VagueManager.start();
        started = true;
    }
    
    
    public static void stop() {
       VagueManager.stop();
    }

    public static boolean isStarted() {
        return started;
    }

}
