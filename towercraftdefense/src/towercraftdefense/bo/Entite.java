/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import interfaces.Idrawable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ligles
 */
public class Entite extends Rectangle implements Idrawable {

    private double mvtx;
    private double mvty;
    public Image img;

    public double getMvtx() {
        return mvtx;
    }

    public void setMvtx(double mvtx) {
        this.mvtx = mvtx;
    }

    public double getMvty() {
        return mvty;
    }

    public void setMvty(double mvty) {
        this.mvty = mvty;
    }

   
   
    
     public Entite(int i, int i1, int width, int height) {
        super(i, i1, width, height);
        
    }

    
    
    public Entite(int i, int i1, int width, int height, double mvtx, double mvty) {
        super(i, i1, width, height);
        
            this.mvtx = mvtx;
            this.mvty = mvty;
        try {
            img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource("smile.png"));
        } catch (IOException ex) {
            Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public void draw(Graphics2D g) {
         g.setColor(Color.red);
         
         g.drawImage(img, x,y,width,height,null);
        
        
    }
    
    
    
}
