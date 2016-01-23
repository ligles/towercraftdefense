/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.observers.Observer;
import towercraftdefense.enumeration.Direction;
import towercraftdefense.manager.ZoneManager;
import towercraftdefense.interfaces.IDrawable;
import towercraftdefense.interfaces.IObservable;
import towercraftdefense.observers.Repainter;

/**
 *
 * @author ligles
 */
public class Zone extends Rectangle implements IDrawable, IObservable{
    
    boolean isWalkable;
    boolean isBuildable;
    boolean isFarmable;
    boolean isFree;
    Image img;
    
    public static int size = 20;

    public Zone(int x, int y,boolean isFree ,boolean isFarmable,boolean isBuildable, boolean isWalkable) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = isFree;
        this.isBuildable = isBuildable;
        this.isFarmable = isFarmable;
        this.isWalkable = isWalkable;
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("zone.png"));
        } catch (IOException ex) {
            Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addObserver(new Repainter());
        this.notifyObserver();
    }
      
    
    public Zone(int x, int y) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = true;
        this.isBuildable = false;
        this.isFarmable = false;
        this.isWalkable = true; 
        try {
            this.img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("zone.png"));
        } catch (IOException ex) {
            Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addObserver(new Repainter());
        this.notifyObserver();
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
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Zone.size, Zone.size);
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
