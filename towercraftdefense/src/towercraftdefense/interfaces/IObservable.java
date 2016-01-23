/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towercraftdefense.interfaces;

import towercraftdefense.observers.Observer;

/**
 *
 * @author mehdi
 */
public interface IObservable {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObserver();
}
