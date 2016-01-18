/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.awt.Color;
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
    
    // Construction de l'entite selon le plan donné
    public void construct(){
        if(plan.size() > 1)
        {
            Zone nzone = zones.get(0);
            for(Direction direction : plan)
            {
                nzone = nzone.getZone(direction);
                zones.add(nzone);
            }
            
            for(Zone zone : zones)
            {
                if(this.x > zone.x)
                {
                    this.x -= Zone.size;
                    this.width += Zone.size;
                }
                if(this.y > zone.y)
                {
                    this.y -= Zone.size;
                    this.height += Zone.size;
                }
                if(this.x + this.width < zone.x + Zone.size)
                    this.width += Zone.size;
                if(this.y + this.height < zone.y + Zone.size)
                    this.height += Zone.size;
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
        //g.drawRect((int)x, (int)y, (int)width, (int)height); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);    
    }
}
