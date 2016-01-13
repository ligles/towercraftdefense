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
    public Image img;
    
    // gestion des zones
    
    private List<Zone> zones;
    
    private List<Direction> plan; 
    
   
     public Entite(double coordx, double coordy, double width, double height) {
         super(coordx, coordy, width, height);
   
     }
     

    
    
   
    
    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.red);
        //g.fillRect((int)x, (int)y, 20, 20); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);
         
        
    }
    
    
    
}
