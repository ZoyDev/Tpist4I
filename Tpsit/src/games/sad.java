package games;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sad extends Application {
    private boolean turnoX = true;
    private Button[][] caselle = new Button[3][3];
    private Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	Button play= new Button("Ricomincia");    	
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        for (int row = 0; row < 3; row++) {
        	 for (int col = 0; col < 3; col++) {
                 Button button = new Button();
                 button.setPrefSize(100, 100);
                 button.setOnAction(e -> {
                     if (button.getText().isEmpty()) {
                         if (turnoX) {
                             button.setText("X");
                             turnoX = !turnoX;
                             checkVittoria();
                      
                         }else {
                        	 button.setText("O");
                             turnoX = !turnoX;
                             checkVittoria();
                         }
                     }
                 });
                caselle[row][col] = button;
                grid.add(button, col, row);
            }
        }
        grid.add(play, 1, 3);
        Scene scene = new Scene(grid, 320, 320);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tris Game");
        primaryStage.show();
        play.setOnAction(e->ricomincia());
    }
    private void ricomincia(){
    		for(int i=0;i<3;i++) {
            	for(int c=0;c<3;c++) {
            		caselle[i][c].setText("");
            	}
            }
    	}

//    private void turnoAI() {
//        if (!turnoX) {
//            boolean mossaEffettuata = false;
//            while (!mossaEffettuata) {
//                int row = random.nextInt(3);
//                int col = random.nextInt(3);
//                Button button = caselle[row][col];
//                if (button.getText().isEmpty()) {
//                    button.setText("O");
//                    turnoX = true;
//                    checkVittoria();
//                    mossaEffettuata = true;
//                }
//            }
//        }
//    }

    private void checkVittoria() {
        String vincitore = "";
        for (int i = 0; i < 3; i++) {
            if (!caselle[i][0].getText().isEmpty()&& caselle[i][0].getText().equals(caselle[i][1].getText()) && caselle[i][1].getText().equals(caselle[i][2].getText())) {
                vincitore = caselle[i][0].getText();
                break;
            }
            if (!caselle[0][i].getText().isEmpty() && caselle[0][i].getText().equals(caselle[1][i].getText()) && caselle[1][i].getText().equals(caselle[2][i].getText())) {
                vincitore = caselle[0][i].getText();
                break;
            }
            
        }
        if (!caselle[0][0].getText().isEmpty() && caselle[0][0].getText().equals(caselle[1][1].getText()) && caselle[1][1].getText().equals(caselle[2][2].getText())) {
            vincitore = caselle[0][0].getText();
        }
        if (!caselle[2][0].getText().isEmpty() && caselle[2][0].getText().equals(caselle[1][1].getText()) && caselle[1][1].getText().equals(caselle[0][2].getText())) {
            vincitore = caselle[2][0].getText();
        }
        if (!vincitore.isEmpty()) {
            System.out.println("Vittoria di " + vincitore);
            for(int i=0;i<3;i++) {
            	for(int c=0;c<3;c++) {
            		caselle[i][c].setText("");
            	}
            }
           
        }
    }
}