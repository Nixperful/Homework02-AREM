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
class MyLinkedList {
    
    MyNode actualNode;
    MyNode lastNode;
    MyNode firstNode;
    Integer length;
    
    public MyLinkedList() {
        length=0;
        actualNode=null;
    }

    public void addNode(float value){
        
        MyNode newNode= new MyNode(value);
        if(length==0){
            actualNode=newNode;
            firstNode=newNode;
            lastNode=newNode;
            newNode.setNextNode(newNode);
        }
        else{
            lastNode.setNextNode(newNode);
            lastNode=newNode;
            newNode.setNextNode(firstNode);
        }  
        length+=1;
    }
    
    public void nextNode(){
        actualNode=actualNode.nextNode;
    }
    
    public MyNode getActualNode() {
        return actualNode;
    }
    
    public void resetActualNode(){
        actualNode=firstNode;
    }
    
    public void printLinkedList(){
        actualNode=firstNode;
        for(int i=0; i<length;i++){
            System.out.println(actualNode.getValue());
            actualNode=actualNode.getNextNode();
        }
    }

    public MyNode getFirstNode() {
        return firstNode;
    }

    public Integer getLength() {
        return length;
    }

    public void setActualNode(MyNode actualNode) {
        this.actualNode = actualNode;
    }
    
    
    
    
    
    
}
