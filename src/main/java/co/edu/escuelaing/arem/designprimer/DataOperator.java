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
public class DataOperator {
    MyLinkedList data;
    
    DataOperator(MyLinkedList list) {
        data=list;
    }
    
    //Media calculada con LinkedList
    public float meanCalculator(){
        data.resetActualNode();
        float sum =0;
        for(int i=0; i<data.getLength();i++){
            sum+=data.getActualNode().getValue();
            data.setActualNode(data.getActualNode().getNextNode());
        }
        float mean = sum/data.getLength();
                
        return mean;
        
    }
    
    //Calculo de la desviación estándard
    public float standartDeviationCalculator(float mean){
        data.resetActualNode();
        float sum =0;
        for(int i=0; i<data.getLength();i++){
            float value=data.getActualNode().getValue()-mean;
            value=value*value;
            sum+=value;
            data.setActualNode(data.getActualNode().getNextNode());
        }
        float standartDeviation = (float)Math.sqrt(sum/(data.getLength()-1));                
        return standartDeviation;
        
    }
    
}
