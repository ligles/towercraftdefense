/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo;


import java.awt.Graphics2D;
import java.awt.Image;


import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import towercraftdefense.bo.environnement.Plan;
import towercraftdefense.observers.Observer;
import towercraftdefense.interfaces.IDrawable;
import towercraftdefense.interfaces.IObservable;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.observers.Repainter;

/**
 *
 * @author ligles
 */
public class Entite extends Rectangle2D.Double implements IDrawable, IObservable {
        public Image img;
    
    // gestion des zones        
    private ArrayList<Zone> zones;
    protected Plan plan;
    
    public Entite(double coordx, double coordy, double width, double height) {
        super(coordx, coordy, width, height);
        this.addObserver(new Repainter());
        this.notifyObserver();
    }

    public Entite(Plan plan) {
        super();
        this.zones = new ArrayList<>();
        this.plan = plan;                                                   
        this.addObserver(new Repainter());
    }
    
    public boolean create(){
        EntiteManager.entites.add(this);
        return true;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        notifyObserver();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        notifyObserver();
    }
    
    
    
    public double getCoordx() {
        return this.x;
    }

    public void setCoordx(double coordx) {
        this.x = coordx;
        notifyObserver();
    }

    public double getCoordy() {
        return this.y;
    }

    public void setCoordy(double coordy) {
        this.y = coordy;
        notifyObserver();
    }
    
    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        notifyObserver();
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObserver();
    }
     
    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.red);
        //g.drawRect((int)x, (int)y, (int)width, (int)height); 
        g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);    
    }

    
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObserver() {
        observers.stream().forEach((obs) -> {
            obs.update(this);
        });
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }
}
