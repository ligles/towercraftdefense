/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.observers;

import towercraftdefense.bo.Entite;
import towercraftdefense.manager.UIManager;

/**
 *
 * @author mehdi
 */
public class Repainter extends Observer {

    @Override
    public void update(Object obj) {
        Entite entite;
        if(obj != null && obj instanceof Entite){
            entite = (Entite) obj;
            UIManager.getFenetre().map.repaint(entite.getBounds());
        }
    }
    
}
