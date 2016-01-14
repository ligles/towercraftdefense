/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import towercraftdefense.jeu.Joueur;
import towercraftdefense.jeu.Partie;
import towercraftdefense.threads.GameThread;

/**
 *
 * @author SDOUGAMEHDI
 */
public class PartieManager {
    private static Joueur joueur;
    private static Partie partie;
    
    public static Partie init()
    {
        joueur = new Joueur("Testeur");
        partie = new Partie(joueur);
        partie.init();
        return partie;
    }
}
