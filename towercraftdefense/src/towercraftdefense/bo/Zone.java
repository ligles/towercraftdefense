/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import towercraftdefense.enumeration.Direction;
import towercraftdefense.interfaces.Idrawable;
import towercraftdefense.manager.ZoneManager;

/**
 *
 * @author ligles
 */
public class Zone extends Rectangle implements Idrawable{
    
    boolean isWalkable;
    boolean isBuildable;
    boolean isFarmable;
    boolean isFree;
    
    public static int size = 20;

    public Zone(int x, int y,boolean isFree ,boolean isFarmable,boolean isBuildable, boolean isWalkable) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = isFree;
        this.isBuildable = isBuildable;
        this.isFarmable = isFarmable;
        this.isWalkable = isWalkable; 
    }
    
    public Zone(int x, int y) {
        super(x, y, Zone.size, Zone.size);
        this.isFree = true;
        this.isBuildable = false;
        this.isFarmable = false;
        this.isWalkable = true; 
    }
    
    public Zone getZone(Direction d){
        Object obj = null;
        Zone zone = null;
        if(null != d)
            switch (d) {
            case Actuel:
                return this;
            case Haut:
                obj = ZoneManager.zones.stream()
                        .filter(z -> z.equals(new Zone(x, y - Zone.size)))
                        .findFirst().get();
            case Bas:
                obj = ZoneManager.zones.stream()
                        .filter(z -> z.equals(new Zone(x, y + Zone.size)))
                        .findFirst().get();
            case Droite:
                obj = ZoneManager.zones.stream()
                        .filter(z -> z.equals(new Zone(x + Zone.size, y)))
                        .findFirst().get();
            case Gauche:
                obj = ZoneManager.zones.stream()
                        .filter(z -> z.equals(new Zone(x - Zone.size, y)))
                        .findFirst().get();
            }
        if(obj instanceof Zone)
            zone = (Zone) obj;   
        
        return zone;
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Zone.size, Zone.size);
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
    
    
    
    
    
}
