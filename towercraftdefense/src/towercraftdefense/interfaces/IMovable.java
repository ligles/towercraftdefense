/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.interfaces;

import java.awt.Point;

/**
 *
 * @author SDOUGAMEHDI
 */
public interface IMovable {
    void avancer();
    void arret();
    void go(int x, int y);
    void arrived();
}
