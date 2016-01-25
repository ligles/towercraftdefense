package towercraftdefense.jeu;

import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.bo.environnement.Chemin;
import towercraftdefense.bo.environnement.Tour;
import towercraftdefense.bo.biosphere.Personnage;

import java.util.ArrayList;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.environnement.Structure;
import towercraftdefense.manager.StructureManager;
import towercraftdefense.manager.ZoneManager;

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
        this.personnages = new ArrayList<>();
        this.ressources = new ArrayList<>();
        this.tours = new ArrayList<>();
        createBase();
        createChemin();
    }
    
    public void createBase() {
        if(base == null) {
            Zone zoneBase = ZoneManager.getBaseZone();
            this.base = new Base(new Ressource(200), zoneBase, Configuration.baseStructure());
            StructureManager.structures.add(base);
        }
    }
    
    public void createTour(Zone zoneTour, Tour tour){
        this.tours.add(tour);
        StructureManager.structures.add(tour);
    }
    
    public void createChemin(){
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
        this.tours.stream().forEach((tour) -> {
            structures.add(tour);
        });
        return structures;
    }
}
