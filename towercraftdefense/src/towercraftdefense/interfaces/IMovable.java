/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.interfaces;

import java.awt.Point;
import towercraftdefense.bo.Entite;

/**
 *
 * @author SDOUGAMEHDI
 */
public interface IMovable {
    void avancer();
    void arret();
    void go(Entite cible);
    void arrived();
}
