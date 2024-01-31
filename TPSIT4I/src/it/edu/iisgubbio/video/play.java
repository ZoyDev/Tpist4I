package it.edu.iisgubbio.video;

import java.io.File;

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
       Video v=new Video(6,3600);
       v.add(300);
       v.add(60);
       v.add(30);
       v.add(120);
       v.add(100);
       v.add(200);
       v.esegui();
    }  
    public static void main(String[] args) {  
        launch(args);  
    }  
      
}  
