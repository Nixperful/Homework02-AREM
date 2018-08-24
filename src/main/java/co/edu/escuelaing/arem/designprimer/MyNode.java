/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

/**
 *
 * @author Nicolás
 */
class MyNode {
    MyNode nextNode;
    float value;

    public MyNode(float value) {
        this.value = value;
    }

    public void setNextNode(MyNode nextNode) {
        this.nextNode = nextNode;
    }

    public float getValue() {
        return value;
    }

    public MyNode getNextNode() {
        return nextNode;
    }
    
    
    
}
