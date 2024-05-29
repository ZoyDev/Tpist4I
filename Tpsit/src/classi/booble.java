package classi;

import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class booble {
	public static void main(String[] args) {  
        int arr[] =new int[1000];
        System.out.println("Array Before Bubble Sort");  
        for(int i=0; i < arr.length; i++){  
               arr[i]=(int)(Math.random()*1000)+1;
        }  
        System.out.println();  
          
        bubbleSort(arr);//sorting array elements using bubble sort  
         
        System.out.println("Array After Bubble Sort");  
        for(int i=0; i < arr.length; i++){  
                System.out.print(arr[i] + " ");  
        } 
        
      
	}  
	
        static void bubbleSort(int[] arr) { 
            Date currentDate = new Date();
            int n = arr.length;  
            int temp = 0;  
             for(int i=0; i < n; i++){  
                     for(int j=1; j < (n-i); j++){  
                              if(arr[j-1] > arr[j]){  
                                     //swap elements  
                                     temp = arr[j-1];  
                                     arr[j-1] = arr[j];  
                                     arr[j] = temp;  
                             }  
                              
                     }  
             }
             Date currentDate1 = new Date();
             System.out.println("Ci mette: "+(currentDate1.getTime()-currentDate.getTime())+" millisecondi");
            }  
}
    
    
 