/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import towercraftdefense.ressources.Ressource;

/**
 *
 * @author ligles
 */
public class EntiteMobile extends Entite {

    
    private double vitesse;
    private double angle;
    
    public EntiteMobile(int coordx, int coordy, int width, int height, int vitesse, int angle) {
         super(coordx, coordy, width, height);
        
         this.vitesse = vitesse;
         this.angle = angle;
         this.img = Ressource.loadImage("smile.png");
    }    
    
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

}
