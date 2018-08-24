/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author 2110432
 */
public class DataRecollector {
    
    public MyLinkedList readTxt(String direction){
        
        // Read an online document and convert to MyLinkedList Class
        
        MyLinkedList numbers=null;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            MyLinkedList temp = new MyLinkedList();
            String bfRead;
            while( (bfRead = bf.readLine())!=null){
                temp.addNode(Integer.parseInt(bfRead));                
            }
            numbers = temp;
            
        }catch(Exception e){
            System.err.println("No se ha encontrado el archivo");
                
        }
        return numbers;
    }
    
    public MyLinkedList readWebInfo(String data){
        MyLinkedList temp = new MyLinkedList();
        System.out.println(data);
        String[] dataNumbers= data.split(" ");
        
        for(int i=0; i<dataNumbers.length;i++){
            temp.addNode(Float.parseFloat(dataNumbers[i]));
            System.out.println(Float.parseFloat(dataNumbers[i]));
        }        
        return temp;
    }
    
}
