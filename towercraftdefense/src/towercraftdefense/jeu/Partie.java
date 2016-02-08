package towercraftdefense.jeu;

import java.awt.Rectangle;
import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.bo.environnement.Chemin;
import towercraftdefense.bo.environnement.Tour;
import towercraftdefense.bo.biosphere.Personnage;

import java.util.ArrayList;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.biosphere.Ouvrier;
import towercraftdefense.bo.environnement.Decoration;
import towercraftdefense.bo.environnement.Plan;
import towercraftdefense.bo.environnement.Structure;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.manager.EntiteMobileManager;
import towercraftdefense.manager.ZoneManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Partie {
    int maxTour = 6, maxRessources = 4, maxDecorations = 6;
    ArrayList<Personnage> personnages;
    ArrayList<Ressource> ressources;
    ArrayList<Decoration> decorations;
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
        this.decorations = new ArrayList<>();
        createBase();
        createChemin();
        createRessources();
        createDecorations();
        createOuvrier();
    }
    
    public void createBase() {
        if(base == null) {
            Zone zoneBase = Base.getBaseZone();
            this.base = new Base(200, Plan.planBase(zoneBase));
            base.create();
        }
    }
    
    public void createTour(Zone zoneTour){
        if(tours.size() < maxTour){
            Tour tour = new Tour(Plan.planTour(zoneTour));
            if(tour.create()){
                tour.survey();
                this.tours.add(tour);
            }
        }
    }
    
    public void createOuvrier(){
        
        Zone  zoneBase = base.getPlan().getZones().get(0);
        
        if(zoneBase != null){
            Ouvrier ouvrier = new Ouvrier(zoneBase, 5);
            ouvrier.create();
           
            ouvrier.recolte();
        }
        
    }
    
        
    public void createPersonnage(Personnage personnage) {
        if(personnage.create()){
            personnages.add(personnage);
        }
    }
    
    
    public void createChemin(){
        Zone depart = Chemin.getCheminZone();
        Zone arrive = ZoneManager.getZone((int)this.base.x, (int)this.base.y);
        int longueur = 200;
        Plan planChemin = new Plan();
        Rectangle lastRectangle = new Rectangle((int)depart.x, (int)depart.y, Zone.size(15), Zone.size(2));
        
        for(int i = 0 ; i < 3 ; i++){
            planChemin.addRectangle(lastRectangle);
            if(i == 0)
            {
                int height = (int)arrive.y - (int)depart.y;
                int y = lastRectangle.y + lastRectangle.height;
                if(height < 0)
                    y += height;
                height = Math.abs(height);
                lastRectangle = new Rectangle(lastRectangle.x + lastRectangle.width, y, Zone.size(2), height);
            }
            else if (i == 1)
                lastRectangle = new Rectangle(lastRectangle.x + lastRectangle.width, lastRectangle.y, Zone.size(18), Zone.size(2));
            else
                lastRectangle = new Rectangle(lastRectangle.x + lastRectangle.width, lastRectangle.y + lastRectangle.height, Zone.size(18), Zone.size(2));
        }
        this.chemin = new Chemin(planChemin);
        chemin.create();
    }
    
    private void createRessources() {
        for(int i = 0 ; i < maxRessources ; i++){
            Zone zone = ZoneManager.getAleaZone(ZoneManager.zonesRessource());
            Ressource ressource = new Ressource(4000, Plan.planRessource(zone));
            while(!ressource.create())
            {
                zone = ZoneManager.getAleaZone(ZoneManager.zonesRessource());
                ressource = new Ressource(4000, Plan.planRessource(zone));
            }
            this.ressources.add(ressource);
        }
    }
    
    public void createDecorations(){
        if(decorations.size() < maxDecorations){
            for(int i = 0 ; i < maxDecorations ; i++){
                Zone zone = ZoneManager.getAleaZone();
                Decoration decoration = new Decoration(Plan.planDecoration(zone));
                decoration.create();
                decorations.add(decoration);
                EntiteManager.entites.add(decoration);
            }
        }
    }
    

    public void charger(){
        
    }
    
    public void sauvegarder(){
        
    }

    public Chemin getChemin() {
        return chemin;
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
