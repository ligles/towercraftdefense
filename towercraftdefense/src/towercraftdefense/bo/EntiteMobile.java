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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.interfaces.IDrawable;

/**
 *
 * @author ligles
 */
public class EntiteMobile extends Entite {

    
    private double vitesse;
    private double angle;

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
        notifyObserver();
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        notifyObserver();
    }
    
    
    public EntiteMobile(double coordx, double coordy, double width, double height, double vitesse, double angle) {
         super(coordx, coordy, width, height);
        
         this.vitesse = vitesse;
         this.angle = angle;
         try {
            img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("smile.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    
}
