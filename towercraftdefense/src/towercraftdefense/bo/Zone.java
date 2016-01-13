/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import towercraftdefense.interfaces.Idrawable;

/**
 *
 * @author ligles
 */
public class Zone extends Rectangle implements Idrawable{
    
    boolean isWalkable;
    boolean isBuildable;
    boolean isFarmable;

    public Zone(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    
    

    @Override
    public void draw(Graphics2D g) {
        
        g.setColor(Color.yellow);
        g.drawRect(x, y, 20, 20);
    }
    
    
    
    
    
}
