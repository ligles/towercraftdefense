package towercraftdefense.biosphere;

import java.awt.Image;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Personnage {

    
  
    
    public double xpersonnage;
   public double ypersonnage;
   public Image imgpersonnage;
   
   public Personnage(double xpersonnage, double ypersonnage, Image imgpersonnage) {
        this.xpersonnage = xpersonnage;
        this.ypersonnage = ypersonnage;
        this.imgpersonnage = imgpersonnage;
    }
   
    public double getXpersonnage() {
        return xpersonnage;
    }

    public void setXpersonnage(double xpersonnage) {
        this.xpersonnage = xpersonnage;
    }

    public double getYpersonnage() {
        return ypersonnage;
    }

    public void setYpersonnage(double ypersonnage) {
        this.ypersonnage = ypersonnage;
    }

    public Image getImgpersonnage() {
        return imgpersonnage;
    }

    public void setImgpersonnage(Image imgpersonnage) {
        this.imgpersonnage = imgpersonnage;
    }
    
   
   
 
   
}
