/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;

import java.util.logging.Level;
import java.util.logging.Logger;
import towercraftdefense.interfaces.ICiblate;
import towercraftdefense.interfaces.IMovable;
import towercraftdefense.manager.EntiteMobileManager;

/**
 *
 * @author ligles
 */
public abstract class EntiteMobile extends Entite implements IMovable, ICiblate{

    
    protected int vitesse;
    protected int angle;
    protected boolean arret;
    protected Entite cible;
    
    public EntiteMobile(int x, int y) {
         super(x, y, 0, 0);
         arret = true;
    }    

    @Override
    public boolean create(){
        EntiteMobileManager.entiteMobiles.add(this);
        return true;
    }
    
    @Override
    public void avancer() {
        double speedx, speedy;
        double cosinusAngle, sinusAngle;
        
        cosinusAngle = Math.cos(Math.toRadians(this.angle));
        sinusAngle = Math.sin(Math.toRadians(this.angle));

        speedx = (this.vitesse / 10) * (cosinusAngle * Math.PI);
        speedy = (this.vitesse / 10) * (sinusAngle * Math.PI);

        this.x += speedx;
        this.y += speedy;
        
        notifyObserver();
    }
    
    
    @Override
    public void arret() {
        this.arret = true;
    }

    @Override
    public void go(int ciblex, int cibley) {
        this.arret = false;
        double nx = ciblex - this.x;
        double ny = cibley - this.y;
        this.angle = (int) ((180 / Math.PI) * (Math.atan2(ny, nx)));
        Thread deplacement = new Thread(new Runnable(){
            @Override
            public void run() {
                while(ciblex != x || cibley != y){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EntiteMobile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    avancer();
                }
                arrived();
            }
        });
        
        deplacement.start();
    }

    @Override
    public void arrived() {
        arret();
    }

    @Override
    public void ciblate() {
    }
 
    @Override
    public void lock(Entite entite) {
        cible = entite;
        double nx = cible.x - this.x;
        double ny = cible.y - this.y;
        this.angle = (int) ((180 / Math.PI) * (Math.atan2(ny, nx)));
    }

    @Override
    public void survey() {
        Thread surveyor = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EntiteMobile.class.getName()).log(Level.SEVERE, null, ex);
                }
                ciblate();
                if(cible != null)
                    avancer();
            }
        });
        
        surveyor.start();
    }
    
    

    // Inverse la direction en fonction de X
    public void changeSensX()
    {
        if (this.angle > 0)
            this.angle = (int)180 - this.angle;
        else
            this.angle = -(int)180 - this.angle;
    }

    // Inverse la direction en fonction de X
    public void changeSensY()
    {
        if (this.angle > 0)
            this.angle = (int)360 - this.angle;
        else
            this.angle = -(int)360 - this.angle;
    }

        
    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
        notifyObserver();
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
        notifyObserver();
    }

    
}
