package com.example.snakesandladders;

import com.example.snakesandladders.Objects.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class NewGame {
    @FXML
    private static Label playerWon;

    @FXML
    private static Label playerLost;

    @FXML
    private Button exitButton;

    @FXML
    private Button playAgainButton;

    @FXML
    public void exitGame(){
        System.exit(0);
    }

    @FXML
    public void startNewGame() throws IOException {
        Stage stage = (Stage)playAgainButton.getScene().getWindow();
        stage.close();
        GameController.startNewGame();
    }

    public static void setPlayers(Player playerW, Player playerL){
        if(playerW.getType()==1){
            playerWon = new Label("PLAYER 1");
            playerLost = new Label("PLAYER 2");
        }else{
            playerLost = new Label("PLAYER 1");
            playerWon = new Label("PLAYER 2");
        }
    }
}
