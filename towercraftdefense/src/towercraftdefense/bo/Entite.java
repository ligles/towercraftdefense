/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import towercraftdefense.interfaces.Idrawable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;


import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ligles
 */
public class Entite extends Rectangle2D.Double implements Idrawable {
    
    
    private double vitesse;
    private double angle;

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
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
    public Image img;

   
     public Entite(double coordx, double coordy, double width, double height) {
         super(coordx, coordy, width, height);
   
     }
     public Entite(double coordx, double coordy, double width, double height, double vitesse, double angle) {
         super(coordx, coordy, width, height);
        
         this.vitesse = vitesse;
         this.angle = angle;
         try {
            img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("smile.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
       
    }

    
    
   
    
    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.red);
        //g.fillRect((int)x, (int)y, 20, 20); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);
         
        
    }
    
    
    
}
