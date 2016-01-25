/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;


import java.awt.Graphics2D;
import java.awt.Image;


import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import towercraftdefense.observers.Observer;
import towercraftdefense.enumeration.Direction;
import towercraftdefense.interfaces.IDrawable;
import towercraftdefense.interfaces.IObservable;
import towercraftdefense.observers.Repainter;

/**
 *
 * @author ligles
 */
public class Entite extends Rectangle2D.Double implements IDrawable, IObservable {
        public Image img;
    
    // gestion des zones        
    private ArrayList<Zone> zones;
    private ArrayList<Direction> plan;
    
    public Entite(double coordx, double coordy, double width, double height) {
        super(coordx, coordy, width, height);
        this.addObserver(new Repainter());
        this.notifyObserver();
    }

    public Entite(Zone zone, ArrayList<Direction> plan) {
        super(zone.x, zone.y, zone.width, zone.height);
        this.zones = new ArrayList<>();
        zones.add(zone);
        this.plan = plan;
        this.construct();                                                           
        this.addObserver(new Repainter());
        this.notifyObserver();
    }
    
    // Construction de l'entite selon le plan donné
    protected void construct(){
        // Construction seulement s'il y a plan de plusieurs zones
        if(plan.size() > 1)
        {
            // Lecture du plan et récupération de la liste des zones constituant l'entite
            Zone nzone = zones.get(0);
            for(Direction direction : plan)
            {                
                nzone = nzone.getZone(direction);
                nzone.isFree = false;
                zones.add(nzone);
            }
            
            zones.stream().map((zone) -> {
                if(this.x > zone.x)
                {
                    this.x -= Zone.size;
                    this.width += Zone.size;
                }
                return zone;
            }).map((zone) -> {
                if(this.y > zone.y)
                {
                    this.y -= Zone.size;
                    this.height += Zone.size;
                }
                return zone;
            }).map((zone) -> {
                if(this.x + this.width < zone.x + Zone.size)
                    this.width += Zone.size;
                return zone;
            }).filter((zone) -> (this.y + this.height < zone.y + Zone.size)).forEach((_item) -> {
                this.height += Zone.size;
            });
        }
        this.addObserver(new Repainter());
        this.notifyObserver();
    }
    
    public double getCoordx() {
        return this.x;
    }

    public void setCoordx(double coordx) {
        this.x = coordx;
        notifyObserver();
    }

    public double getCoordy() {
        return this.y;
    }

    public void setCoordy(double coordy) {
        this.y = coordy;
        notifyObserver();
    }
    
    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        notifyObserver();
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObserver();
    }
     
    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.red);
        //g.drawRect((int)x, (int)y, (int)width, (int)height); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);    
    }

    
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObserver() {
        observers.stream().forEach((obs) -> {
            obs.update(this);
        });
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }
}
