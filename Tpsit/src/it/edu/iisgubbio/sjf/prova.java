package it.edu.iisgubbio.sjf;

import it.edu.iisgubbio.fcfs.fcfs;
import javafx.application.Application;
import javafx.stage.Stage;

public class prova extends Application{
	sjf scheduler= new sjf(4);
	public void start(Stage finestra){	
		scheduler.add("0",5);
		scheduler.add("1",3);
		scheduler.add("2",8);
		scheduler.add("3",7);
		System.out.println("Il valore medio del tempo di attesa è: "+scheduler.ordina());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
