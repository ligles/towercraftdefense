package towercraftdefense.biosphere;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Ouvrier extends Personnage {

   public double xouvrier;
   public double youvrier;
   public Image imgouvrier;

    public Ouvrier(double xpersonnage, double ypersonnage, Image imgpersonnage) {
        super(xpersonnage, ypersonnage, imgpersonnage);
    }
   
    
    public double getXouvrier() {
        return xouvrier;
    }

    public void setXouvrier(double xouvrier) {
        this.xouvrier = xouvrier;
    }

    public double getYouvrier() {
        return youvrier;
    }

    public void setYouvrier(double youvrier) {
        this.youvrier = youvrier;
    }

    public Image getImgouvrier() {
        return imgouvrier;
    }

    public void setImgouvrier(Image imgouvrier) {
        this.imgouvrier = imgouvrier;
    }

    
    }
   

   
   
   

