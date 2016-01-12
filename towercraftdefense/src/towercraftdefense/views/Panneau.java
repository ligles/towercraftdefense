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
import towercraftdefense.manager.EntiteManager;

/**
 *
 * @author ligles
 */
public class Panneau extends JPanel {
    Entite entite;
    public Panneau(){ 
        super(true);
        entite = new Entite(50, 50, 25, 60);
        
   }
   @Override
    public void paintComponent(Graphics g) {
       
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
       for(Entite entite : EntiteManager.getClone()){
           
           entite.draw(g2);
           
        
       }
        
        
    }
    
    
    
}
