/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.interfaces;

import towercraftdefense.bo.Zone;

/**
 *
 * @author SDOUGAMEHDI
 */
public interface IMovable {
    public void avancer();
    public void reculer();
    public Zone aDroite();
    public Zone aGauche();
}
