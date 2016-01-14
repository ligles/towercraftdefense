/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.jeu;

import java.util.ArrayList;
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
        
        return plan;
    }
}
