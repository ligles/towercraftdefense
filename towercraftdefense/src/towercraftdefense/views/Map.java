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
import towercraftdefense.bo.Entite;
import towercraftdefense.bo.Zone;
import towercraftdefense.bo.environnement.Structure;
import towercraftdefense.manager.OuvrierManager;
import towercraftdefense.manager.StructureManager;
import towercraftdefense.manager.ZoneManager;
/**
 *
 * @author ligles
 */
public class Map extends JPanel {
    Entite entite;
    Zone zone;
    public Map(){ 
        super(true);
     
   }
   @Override
    public void paintComponent(Graphics g) {
       
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
       for(Entite entite : OuvrierManager.getClone()){
           
           entite.draw(g2);
           
        
       }
       for(Zone zone : ZoneManager.getClone()){
           
            zone.draw(g2);
       }
       
       for(Structure structure : StructureManager.getClone())
           structure.draw(g2);
       
        
    }
    
    
    
}
