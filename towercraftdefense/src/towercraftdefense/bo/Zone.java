/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Optional;
import towercraftdefense.bo.biosphere.Personnage;
import towercraftdefense.enumeration.Direction;
import towercraftdefense.enumeration.Style;
import towercraftdefense.manager.ZoneManager;
import towercraftdefense.interfaces.IDrawable;
import towercraftdefense.interfaces.IObservable;
import towercraftdefense.observers.Observer;
import towercraftdefense.observers.Repainter;
import towercraftdefense.ressources.Ressource;

/**
 *
 * @author ligles
 */
public class Zone extends Rectangle2D.Double implements IDrawable, IObservable{
    
    public boolean isWalkable;
    public boolean isBuildable;
    public boolean isFarmable;
    public boolean isFree;
    private int maxPersonnages;
    private Style style;
    private Style defaultStyle;
    Image img;
    private ArrayList<Observer> observers;
    private ArrayList<Personnage> personnages;
    
    public static int size = 20;

    public Zone(double x, double y,boolean isFree ,boolean isFarmable,boolean isBuildable, boolean isWalkable) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = isFree;
        this.isBuildable = isBuildable;
        this.isFarmable = isFarmable;
        this.isWalkable = isWalkable;
        this.maxPersonnages = 3;
        this.style = Style.Normal;
        this.defaultStyle = Style.Normal;
        this.observers = new ArrayList<>();
        this.personnages = new ArrayList<>();
        addObserver(new Repainter());
        this.img = Ressource.loadImage("zone_grass.png");
    }
      
    
    public Zone(double x, double y) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = true;
        this.isBuildable = false;
        this.isFarmable = false;
        this.isWalkable = true; 
        this.maxPersonnages = 3;
        this.style = Style.Normal;
        this.defaultStyle = Style.Normal;
        this.observers = new ArrayList<>();
        this.personnages = new ArrayList<>();
        this.addObserver(new Repainter());
        this.img = Ressource.loadImage("zone_grass.png");
    }
    
    public boolean populate(Personnage personnage){
        boolean populated = false;
        if(personnage != null && personnages.size() <= maxPersonnages){
            int nbrPerso = personnages.size();
            int placement = Zone.size/(nbrPerso+1);
            this.personnages.add(personnage);
            for(int i = 1 ; i < personnages.size()+1 ; i ++){
                personnage.setX(this.x + i*placement);
                personnage.setY(this.y + Zone.size/2);
            }
            populated = true;
        }
        return populated;
    }
    
    public Zone getZone(Direction d){
        Optional<Zone> optional;
        Zone zone = null;
        final Zone cible;
        
        if(null != d){
            switch (d) {
            case Actuel:
                return this;
            case Haut:
                cible = new Zone(x, y - Zone.size);
                break;
            case Bas:
                cible = new Zone(x, y + Zone.size);
                break;
            case Droite:
               cible = new Zone(x + Zone.size, y);
                break;
            case Gauche:
                cible = new Zone(x - Zone.size, y);
                break;
            default:
                cible = null;
                break;
            }
        }
        else
            cible = null;
        
        if(cible != null)
        {    
            optional = ZoneManager.zones.stream()
                            .filter(z -> z.equals(cible))
                            .findFirst();
            
            if(optional.isPresent())
                zone = optional.get();
        }
        return zone;
    }


    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
        if(null != style)
            switch (style) {
            case Normal:
                this.img = Ressource.loadImage("zone_grass.png");
                this.defaultStyle = Style.Normal;
                break;
            case Highlight:
                this.img = Ressource.loadImage("zone_highlight.png");
                break;
            case Chemin:
                this.img = Ressource.loadImage("zone_chemin.png");
                this.defaultStyle = Style.Chemin;
                break;
            case Default:
                this.setStyle(defaultStyle);
                break;
            default:
                break;
        }
        notifyObserver();
    }
    
    public static int size(int size){
        return Zone.size * size;
    }
    
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect((int)x, (int)y, Zone.size, Zone.size);
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zone other = (Zone) obj;
        if (this.x != other.x) {
            return false;
        }
        else if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach((obs) -> {
            obs.update(this);
        });
    }
}
