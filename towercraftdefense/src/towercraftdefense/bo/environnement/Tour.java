package towercraftdefense.bo.environnement;

import java.util.ArrayList;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Tour extends Structure {
    private int portee;
    private ArrayList<Fleche> fleches;
    private static float cout;

    public Tour(Plan plan, int nbFleche)
    {
        super(plan);
        fleches = new ArrayList<>(nbFleche);
        this.img = towercraftdefense.ressources.Ressource.loadImage("tour.png");
    }   
}
