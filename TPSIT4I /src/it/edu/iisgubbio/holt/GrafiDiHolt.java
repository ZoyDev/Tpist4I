package it.edu.iisgubbio.holt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GrafiDiHolt extends Application{
	Button test = new Button("Esegui"); 
	Button riduc = new Button("Riducibile?"); 

	TextField input=new TextField();
	Grafi grafo= new Grafi(3,3);
	Label output= new Label("");
	public void start(Stage finestra){
		for(int i=0;i<grafo.processi;i++) {
			output.setText(output.getText()+grafo.grafo[0][i]+" "+grafo.grafo[1][i]+" "+grafo.grafo[2][i]+"\n");
		}
		test.setOnAction(e->esegui());
		riduc.setOnAction(e->riduci());
		GridPane principale = new GridPane();
		principale.add(input, 0, 0);
		principale.add(riduc,0,1,2,1);
		principale.add(test,0,2,2,1);
		principale.add(output,0,3,2,1);

		principale.setPadding(new Insets(6, 6, 6, 6));
		principale.setHgap(5); 
		principale.setVgap(5);
		Scene scena = new Scene(principale);

		finestra.setTitle("Area");
		finestra.setScene(scena);
		finestra.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	public void isRiducibile() {
		System.out.println(grafo.isRiducibile());
	}
	public void riduci() {
		grafo.riduci();
		output.setText("");
		for(int i=0;i<grafo.processi;i++) {
			output.setText(output.getText()+grafo.grafo[0][i]+" "+grafo.grafo[1][i]+" "+grafo.grafo[2][i]+"\n");
		}
	}
	public void esegui() {
		output.setText("");
		String istruzioni[]= input.getText().split(" ");
		grafo.in((Integer.parseInt(istruzioni[0])-1),(Integer.parseInt(istruzioni[2])-1));
		for(int i=0;i<grafo.processi;i++) {
			output.setText(output.getText()+grafo.grafo[0][i]+" "+grafo.grafo[1][i]+" "+grafo.grafo[2][i]+"\n");
		}
	}
}
