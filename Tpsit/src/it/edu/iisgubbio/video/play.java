package it.edu.iisgubbio.video;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage;  
public class play extends Application  {  
  
    @Override  
    public void start(Stage primaryStage) throws Exception {  
       
       FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/WorkSpaceTPSIT/Tpsit/src/it/edu/iisgubbio/video/tempi.csv");
       BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
       Player v=new Player(Integer.parseInt(lettoreDiRighe.readLine()),Integer.parseInt(lettoreDiRighe.readLine()));
       for(int i=0;i<v.tempi.length;i++) {
           v.add(Integer.parseInt(lettoreDiRighe.readLine()));
       }
       v.esegui();
       lettoreDiRighe.close();
       flussoCaratteri.close();
    }  
    public static void main(String[] args) {  
        launch(args);  
    }  
      
}  
