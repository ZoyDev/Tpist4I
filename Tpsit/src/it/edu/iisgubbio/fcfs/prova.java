package it.edu.iisgubbio.fcfs;

import javafx.application.Application;
import javafx.stage.Stage;

public class prova extends Application{
	fcfs scheduler= new fcfs(4);
	public void start(Stage finestra){	
		scheduler.add("0",5);
		scheduler.add("1",3);
		scheduler.add("2",9);
		scheduler.add("3",6);
		System.out.println("Il valore medio del tempo di attesa è: "+scheduler.calcola());
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}