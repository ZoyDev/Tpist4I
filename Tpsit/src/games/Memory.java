package games;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Memory extends Application{
	boolean posso=true;
	Pane area=new Pane();
	Pane home=new Pane();
	Button[][] caselle = new Button[4][5];
	String[][] path = new String[4][5];
	int[][] nascondi=new int[4][5];
	int turno=0;
	Timeline timer,timer2;
	boolean turnoX=true;
	int puntiX=0,puntiO=0;
	int vittorieX=0,vittorieO=0;
	boolean trovato=false;
	int h,m,s;
	Label tempo=new Label("00:00:00");
	Rectangle overlay=new Rectangle(800,800);
	Rectangle rName=new Rectangle(200,200);
	TextField tName=new TextField();
	Button bName=new Button("Insert Your Nick");
	String name="";
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) {
		
		tName.setPromptText("Insert Your NickName");
		Button restart=new Button("Restart");
		Rectangle bg=new Rectangle(800,800);
		bg.setFill(Color.LIGHTBLUE);
		restart.setStyle("-fx-background-color: lightgreen;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color:black;");
		area.getChildren().add(bg);
		area.getChildren().add(tempo);
		restart.setFont(new Font("Poppins", 15));
		tempo.setFont(new Font("Poppins", 35));
		restart.setTextFill(Color.WHITE);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		area.getChildren().add(grid);
		grid.setLayoutY(150);
		area.getChildren().add(restart);
		restart.setLayoutX(350);
		restart.setPrefSize(80,20);
		area.getChildren().add(overlay);
		area.getChildren().add(rName);
		area.getChildren().add(tName);
		area.getChildren().add(bName);

		overlay.setFill(Color.BLACK);
		overlay.setOpacity(0.5);
		tName.setLayoutX(325);
		tName.setLayoutY(350);
		bName.setLayoutX(348);
		bName.setLayoutY(410);
		rName.setX(300);
		rName.setY(300);
		rName.setFill(Color.PURPLE);
		int numeri[]= new int [20];
		for(int i=0;i<(numeri.length/2);i++) {
			numeri[i]=i;
			numeri[19-i]=i;
		}
		for(int i=numeri.length-1;i>0;i--) {
			int n=(int) (Math.random()*(numeri.length));
			int temp = numeri[i];
			numeri[i] = numeri[n];
			numeri[n] = temp;
		}
		int scorri=0;
		for (int i = 0; i < 4; i++) {
			for (int c = 0; c< 5; c++) {
				nascondi[i][c]=numeri[scorri];
				scorri++;
			}
		}

		for (int righe = 0; righe < 4; righe++) {
			for (int colonne = 0; colonne < 5; colonne++) {
				Button button = new Button();
				button.setPrefSize(150, 150);
				caselle[righe][colonne]=button;
				grid.add(button, colonne, righe);
				button.setId(""+nascondi[righe][colonne]);
				button.setOnAction(e->click(button));
				String  c="games/"+button.getId()+".png";
				path[righe][colonne]=c;
				caselle[righe][colonne].setStyle("-fx-background-color: violet;-fx-border-color: blue;-fx-background-radius:30px;-fx-border-radius:30px;");
			}
		}
		timer=new Timeline(new KeyFrame(Duration.seconds(0.25),e -> clean()));timer.setCycleCount(Timeline.INDEFINITE);
		Timeline timer1=new Timeline(new KeyFrame(Duration.seconds(0.2),e -> {
			try {
				controlloWin();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}));timer1.setCycleCount(Timeline.INDEFINITE);
		//timer1.play();
		timer2=new Timeline(new KeyFrame(Duration.seconds(1),e -> timer()));timer2.setCycleCount(Timeline.INDEFINITE);
		restart.setOnAction(e->reset());
		Scene scene = new Scene(area,800,800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tris Game");
		primaryStage.show();
		bName.setOnAction(e->name());
	}
	public void name() {
		name=tName.getText();
		area.getChildren().remove(overlay);
		area.getChildren().remove(rName);
		area.getChildren().remove(tName);
		area.getChildren().remove(bName);
		timer2.play();	

	}
	public void timer() {
		s++;
		if(s>=60) {
			s=0;
			m=1;
		}
		if(m>=60) {
			m=0;
			h=1;
		}
		if(s<10 && m<10) {
			tempo.setText("0"+h+":0"+m+":0"+s);
		}else {
			if(s<10) {
				tempo.setText("0"+h+":"+m+":0"+s);
			}else {
				if(m<10) {
					tempo.setText("0"+h+":0"+m+":"+s);
				}
			}
		}
	}
	public void scrivi() throws IOException {		
		String user = System.getProperty("user.name");
		FileReader contaAccount = new FileReader("/Users/"+user+"/Documents/record.txt");
		BufferedReader lettoreDiRighe = new BufferedReader(contaAccount);
		String nick[]= new String[3];
		int record[]=new int[3];
		for(int i=0;i<3;i++) {
			nick[i]=lettoreDiRighe.readLine();
			record[i]=Integer.parseInt(lettoreDiRighe.readLine());
		}
		
		FileWriter flussoCaratteri = new FileWriter("/Users/"+user+"/Documents/record.txt");
		System.out.println(tempo.getText());
		flussoCaratteri.write(name+"\n"+tempo.getText()+"\n");
		flussoCaratteri.close();
		timer2.stop();
		s=0;h=0;m=0;
		tempo.setText("0"+h+":0"+m+":"+"0"+s);

	}
	public void reset() {
		for (int i = 0; i < 4; i++) {
			for (int c = 0; c< 5; c++) {
				caselle[i][c].setId(""+nascondi[i][c]);
				caselle[i][c].setText("");
				caselle[i][c].setGraphic(null);
				caselle[i][c].setStyle("-fx-background-color: violet;-fx-border-color: blue;-fx-background-radius:30px;-fx-border-radius:30px;");
			}
		}
	}
	public void controlloWin() throws IOException {
		boolean win=true;
		for (int i = 0; i < 4; i++) {
			for (int x = 0; x< 5; x++) {
				if(caselle[i][x].getText().equals("")) {
					win=false;
				}
			}
		}
		if(win) {
			scrivi();
			win=false;
			for (int i = 0; i < 4; i++) {
				for (int x = 0; x< 5; x++) {
					caselle[i][x].setStyle("-fx-background-color: green;-fx-background-radius:30px;-fx-border-radius:30px;");
				}
			}

		}
	}
	public void clean() {
		pulisci(caselle);
		timer.stop();
		posso=!posso;
	}
	public void assegna(Button [][]caselle) {
		for (int i = 0; i < 4; i++) {
			for (int x = 0; x< 5; x++) {
				if(!caselle[i][x].getText().equals("")){
					Image img = new Image(path[i][x]);
					ImageView viwe=new ImageView(img);
					viwe.setFitHeight(100);
					viwe.setFitWidth(100);
					caselle[i][x].setGraphic(viwe);
					caselle[i][x].setTextFill(null);
				}
			}
		}
	}
	private void click(Button b) {
		if(b.getText().equals("") && posso) {
			if(turno==0) {
				b.setText(b.getId());
				assegna(caselle);
			}else {
				if(turno==1) {
					posso=false;
					b.setText(b.getId());
					controlloGiusto();
					try {
						controlloWin();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					timer.play();
					assegna(caselle);

				}else {
					pulisci(caselle);
					turno=0;
					b.setText(b.getId());
					assegna(caselle);

				}

			}
		}
		turno++;


	}
	//al secondo click controlllo ugualoianza
	public void pulisci(Button [][]x) {
		for (int i = 0; i < 4; i++) {
			for (int c = 0; c< 5; c++) {
				if(!caselle[i][c].getId().equals("G")) {
					caselle[i][c].setText("");
					caselle[i][c].setGraphic(null);
				}
			}
		}
	}

	public void controlloGiusto() {
		int c=50,r=50,c1=50,r1=50;
		for (int i = 0; i < 4; i++) {
			for (int x = 0; x< 5; x++) {
				if(!caselle[i][x].getText().equals("") && !caselle[i][x].getId().equals("G")) {
					if(c==50) {
						c=x;
						r=i;
					}else {
						c1=x;
						r1=i;
					}
				}
			}
		}
		if(caselle[r][c].getText().equals(caselle[r1][c1].getText())){
			caselle[r][c].setId("G");
			caselle[r1][c1].setId("G");
			caselle[r][c].setStyle("-fx-background-color: MediumSeaGreen;-fx-border-radius:30px;-fx-background-radius:30px;-fx-border-color: blue;");
			caselle[r1][c1].setStyle("-fx-background-color: MediumSeaGreen;-fx-border-radius:30px;-fx-background-radius:30px;-fx-border-color: blue;");

		}
	}
}