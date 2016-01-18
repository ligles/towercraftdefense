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
        if(null != d)
            switch (d) {
            case Actuel:
                return this;
            case Haut:
                return new Zone(x, y - Zone.size);
            case Bas:
                return new Zone(x, y + Zone.size);
            case Droite:
                return new Zone(x + Zone.size, y);
            case Gauche:
                return new Zone(x - Zone.size, y);
            default:
                return null;
        }
        else 
            return null;
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.yellow);
        g.drawRect(x, y, Zone.size, Zone.size);
    }
    
    
    
    
    
}
