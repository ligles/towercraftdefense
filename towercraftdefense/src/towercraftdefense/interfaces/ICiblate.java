/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.interfaces;

import towercraftdefense.bo.Entite;

/**
 *
 * @author mehdi
 */
public interface ICiblate {
    public void ciblate();
    public void lock(Entite entite);
    public void survey();
}
