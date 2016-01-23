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
    private static Partie partie;
    
    public static Partie init()
    {
        joueur = new Joueur("Testeur");
        partie = new Partie(joueur);
        return partie;
    }
    
    public static Partie start(){
        partie.init();
        return partie;
    }
}
