/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.observers;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import towercraftdefense.manager.UIManager;

/**
 *
 * @author mehdi
 */
public class Repainter extends Observer {

    @Override
    public void update(Object obj) {
        Rectangle2D.Double entite;
        if(obj != null && obj instanceof Rectangle2D.Double){
            entite = (Rectangle2D.Double) obj;
            Rectangle rectangle = new Rectangle(entite.getBounds());
            rectangle.height += 20;
            rectangle.width += 20;
            rectangle.x -= 10;
            rectangle.y -= 10;
            UIManager.getFenetre().map.repaint(rectangle);
        }
    }
    
}
