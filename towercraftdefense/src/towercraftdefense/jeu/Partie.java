package towercraftdefense.jeu;

import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.bo.environnement.Chemin;
import towercraftdefense.bo.environnement.Tour;
import towercraftdefense.bo.biosphere.Personnage;

import java.util.ArrayList;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Partie {
    ArrayList<Personnage> personnages;
    ArrayList<Ressource> ressources;
    ArrayList<Tour> tours;
    Base base;
    Chemin chemin;

    public Partie() {
        this.personnages = new ArrayList<Personnage>();
        this.ressources = new ArrayList<Ressource>();
        this.tours = new ArrayList<Tour>();
        this.base = new Base(new Ressource(200), 0, 0, 0, 0);
        this.chemin = new Chemin(15);
    }
    
    
}
