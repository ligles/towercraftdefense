/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import towercraftdefense.interfaces.Idrawable;

import java.awt.Graphics2D;
import java.awt.Image;


import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.enumeration.Direction;

/**
 *
 * @author ligles
 */
public class Entite extends Rectangle2D.Double implements Idrawable {
        public Image img;
    
    // gestion des zones        
    private ArrayList<Zone> zones;
    private ArrayList<Direction> plan;
    
    public Entite(double coordx, double coordy, double width, double height) {
        super(coordx, coordy, width, height);
    }

    public Entite(Zone zone, ArrayList<Direction> plan) {
        super(zone.x, zone.y, zone.width, zone.height);
        this.zones = new ArrayList<>();
        zones.add(zone);
        this.plan = plan;
        this.construct();
    }
    
    public void construct(){
        if(plan.size() > 1)
        {
            Zone nzone = zones.get(0);
            int xSave = 0, ySave = 0;
            for(Direction direction : plan)
            {
                nzone = nzone.getZone(direction);
                zones.add(nzone);
                if(xSave < nzone.x && nzone.x > this.x)
                {
                    this.width += nzone.width;
                    this.x -= Zone.size;
                    xSave = nzone.x;
                }
                
                if(ySave < nzone.y && nzone.y > this.y)
                {
                    this.height += nzone.height;
                    this.y += Zone.size;
                    ySave = nzone.y;
                }
                
            }
            
            for(Zone zone : zones)
            {
                if(zone.x < this.x)
                    this.x = zone.x;
                if(zone.y < this.y)
                    this.y = zone.y;
            }
        }
    }
    
    public double getCoordx() {
        return this.x;
    }

    public void setCoordx(double coordx) {
        this.x = coordx;
    }

    public double getCoordy() {
        return this.y;
    }

    public void setCoordy(double coordy) {
        this.y = coordy;
    }
     
    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.red);
        //g.fillRect((int)x, (int)y, 20, 20); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);    
    }
}
