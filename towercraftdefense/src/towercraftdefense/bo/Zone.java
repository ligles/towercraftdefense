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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.enumeration.Direction;
import towercraftdefense.enumeration.Style;
import towercraftdefense.manager.ZoneManager;
import towercraftdefense.interfaces.IDrawable;
import towercraftdefense.interfaces.IObservable;
import towercraftdefense.observers.Observer;
import towercraftdefense.observers.Repainter;

/**
 *
 * @author ligles
 */
public class Zone extends Rectangle2D.Double implements IDrawable, IObservable{
    
    public boolean isWalkable;
    public boolean isBuildable;
    public boolean isFarmable;
    public boolean isFree;
    private Style style;
    Image img;
    private ArrayList<Observer> observers;
    
    public static int size = 20;

    public Zone(double x, double y,boolean isFree ,boolean isFarmable,boolean isBuildable, boolean isWalkable) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = isFree;
        this.isBuildable = isBuildable;
        this.isFarmable = isFarmable;
        this.isWalkable = isWalkable;
        this.style = Style.Normal;
        this.observers = new ArrayList<>();
        addObserver(new Repainter());
        loadImage("zone.png");
    }
      
    
    public Zone(double x, double y) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = true;
        this.isBuildable = false;
        this.isFarmable = false;
        this.isWalkable = true; 
        this.style = Style.Normal;
        this.observers = new ArrayList<>();
        addObserver(new Repainter());
        loadImage("zone.png");
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
    
    public void loadImage(String imgName){
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource(imgName));
        } catch (IOException ex) {
            Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
        if(style == Style.Normal)
            loadImage("zone.png");
        else if(style == Style.Highlight)
            loadImage("zone_highlight.png");
        notifyObserver();
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
