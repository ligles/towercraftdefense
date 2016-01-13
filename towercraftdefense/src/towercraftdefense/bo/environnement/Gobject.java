package towercraftdefense.bo.environnement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import towercraftdefense.interfaces.Idrawable;
import towercraftdefense.manager.UIManager;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public abstract class Gobject extends Rectangle2D.Double implements Idrawable{
    private int x;
    private int y;
    private int height;
    private int width;
    Image img;

    public Gobject(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
 @Override
    public void draw(Graphics2D g) {
         g.setColor(Color.red);
         
         if(this.img != null)
            g.drawImage(img, (int)x,(int)y,(int)width,(int)height,null);
    }
    
    
}
