package towercraftdefense.bo.environnement;

import towercraftdefense.jeu.Partie;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Chemin extends Gobject{
    private int longueur;
    private ArrayList<Point> listPoint;

    public Chemin(int longueur) {
        super(0, 0, 0, 0);
        this.longueur = longueur;
    }
    
    public Chemin(int longueur, ArrayList<Point> listPoint, int x, int y, int height, int width) {
        super(x, y, height, width);
        this.longueur = longueur;
        this.listPoint = listPoint;
    }

    
     
}
