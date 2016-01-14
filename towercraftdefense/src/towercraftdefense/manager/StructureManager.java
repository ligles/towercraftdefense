/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.manager;

import java.util.ArrayList;
import towercraftdefense.bo.environnement.Base;
import towercraftdefense.bo.environnement.Ressource;
import towercraftdefense.bo.environnement.Structure;
import towercraftdefense.jeu.Configuration;
import towercraftdefense.jeu.Partie;

/**
 *
 * @author SDOUGAMEHDI
 */
public class StructureManager {
    public static ArrayList<Structure> structures = new ArrayList<>(); 
    public static void init(Partie p)
    {
        structures = p.getStructures();
    }
    
   public static void update(){
       
   }
    
    public static ArrayList<Structure> getClone(){
        
        return (ArrayList<Structure>) structures.clone();
    }
}
