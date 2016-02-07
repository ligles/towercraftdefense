/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.bo.environnement;

import towercraftdefense.bo.Entite;

/**
 *
 * @author mehdi
 */
public class Decoration extends Entite{
    public Decoration(Plan plan) {
        super(plan);
        this.img = towercraftdefense.ressources.Ressource.loadImage("rocher.png");
    }
    
    @Override
    public boolean create() {
        super.create(); 

        plan.generate();
        boolean created = plan.apply(this);
        if(created){
            this.x = plan.getZones().get(0).x;
            this.y = plan.getZones().get(0).y;
            this.width = plan.getWidth();
            this.height = plan.getHeight();
            this.notifyObserver();
        }
        
        return created;
    }
}
