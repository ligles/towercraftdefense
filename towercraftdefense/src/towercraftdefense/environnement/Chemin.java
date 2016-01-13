package towercraftdefense.environnement;

import towercraftdefense.jeu.Partie;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Chemin extends Gobject{
    private int longueur;
    private ArrayList<Point> listPoint;

    public Chemin(int x, int y, int height, int width, int longueur) {
        super(x, y, height, width);
        this.longueur = longueur;
    }

    public Chemin(int x, int y, int height, int width, int longueur, ArrayList<Point> listPoint) {
        super(x, y, height, width);
        this.longueur = longueur;
        this.listPoint = listPoint;
    }
}
