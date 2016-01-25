/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.jeu;

import java.util.ArrayList;
import towercraftdefense.bo.Zone;
import towercraftdefense.enumeration.Direction;

/**
 *
 * @author SDOUGAMEHDI
 */
public class Configuration {
    public static ArrayList<Direction> baseStructure(){
        ArrayList<Direction> plan = new ArrayList<>();
        plan.add(Direction.Actuel);
        plan.add(Direction.Droite);
        plan.add(Direction.Bas);
        plan.add(Direction.Gauche);
        plan.add(Direction.Gauche);
        plan.add(Direction.Haut);        
        return plan;
    }
    
    public static boolean validConstruct(Zone actuel, ArrayList<Direction> plan){
        Zone nzone = actuel;
        for(Direction direction : plan)
        {
            nzone = nzone.getZone(direction);
            if(nzone == null || !nzone.isFree)
                return false;
        }
        return true;
    }
}
