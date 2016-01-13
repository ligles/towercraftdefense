package towercraftdefense.bo.biosphere;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Monstre extends Personnage{

    public double xmonstre;
    public double ymonste;
    public Image imgmonstre;

    public Monstre(double xpersonnage, double ypersonnage, Image imgpersonnage) {
        super(xpersonnage, ypersonnage, imgpersonnage);
    }
    

    public double getXmonstre() {
        return xmonstre;
    }

    public void setXmonstre(double xmonstre) {
        this.xmonstre = xmonstre;
    }

    public double getYmonste() {
        return ymonste;
    }

    public void setYmonste(double ymonste) {
        this.ymonste = ymonste;
    }

    public Image getImgmonstre() {
        return imgmonstre;
    }

    public void setImgmonstre(Image imgmonstre) {
        this.imgmonstre = imgmonstre;
    }
    
   
    
    
}
