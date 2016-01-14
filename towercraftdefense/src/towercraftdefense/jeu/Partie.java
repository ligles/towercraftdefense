package towercraftdefense.jeu;

import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.bo.environnement.Chemin;
import towercraftdefense.bo.environnement.Tour;
import towercraftdefense.bo.biosphere.Personnage;

import java.util.ArrayList;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.environnement.Structure;
import towercraftdefense.enumeration.Direction;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Partie {
    ArrayList<Personnage> personnages;
    ArrayList<Ressource> ressources;
    ArrayList<Tour> tours;
    Joueur joueur;
    Base base;
    Chemin chemin;

    public Partie(Joueur joueur) {
        this.joueur = joueur;
    }
    
    public void init(){
        this.personnages = new ArrayList<Personnage>();
        this.ressources = new ArrayList<Ressource>();
        this.tours = new ArrayList<Tour>();
        Zone zoneBase = new Zone(200, 520);
        this.base = new Base(new Ressource(200),zoneBase, Configuration.baseStructure());
        this.chemin = new Chemin(15);
    }
    
    public void charger(){
        
    }
    
    public void sauvegarder(){
        
    }
    
    public ArrayList<Structure> getStructures()
    {
        ArrayList<Structure> structures = new ArrayList<>();
        structures.add(this.base);
        for(Tour tour : this.tours)
            structures.add(tour);
        return structures;
    }
}
