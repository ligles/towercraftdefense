/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.ressources;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ligles
 */
public class Ressource {

        
    Image img;
    
    public static Image loadImage(String imgname) {
        Image img = null;
        try {
           img = ImageIO.read(towercraftdefense.ressources.Ressource.class.getResource(imgname));
        } catch (IOException ex) {
            Logger.getLogger(Ressource.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return img;
    }
}
