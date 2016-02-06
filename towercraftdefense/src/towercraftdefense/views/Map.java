/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.views;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import towercraftdefense.manager.EntiteMobileManager;
import towercraftdefense.manager.EntiteManager;
import towercraftdefense.manager.ZoneManager;
/**
 *
 * @author ligles
 */
public class Map extends JPanel {
    public Map(){ 
        super(true);    
   }
   @Override
    public void paintComponent(Graphics g) {
       
        Graphics2D g2 = (Graphics2D) g;
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        if(ZoneManager.getClone() != null) {
            ZoneManager.getClone().stream().forEach((zone) -> {
                zone.draw(g2);
            });
        }
        
        if(EntiteManager.getClone() != null) {
            EntiteManager.getClone().stream().forEach((structure) -> {
                structure.draw(g2);
            });
        }
        
        if(EntiteMobileManager.getClone() != null) {
            EntiteMobileManager.getClone().stream().forEach((entite) -> {
                entite.draw(g2);
            }); 
        }
    }
    
    
    
}
