package towercraftdefense.jeu;

import towercraftdefense.biosphere.Personnage;
import towercraftdefense.environnement.*;

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

    public Partie(ArrayList<Personnage> personnages, ArrayList<Ressource> ressources, ArrayList<Tour> tours, Base base, Chemin chemin) {
        this.personnages = personnages;
        this.ressources = ressources;
        this.tours = tours;
        this.base = base;
        this.chemin = chemin;
    }
}
