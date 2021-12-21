package com.example.snakesandladders;

import com.example.snakesandladders.Board.gameBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameController {
    @FXML
    private Label player1Label;

    @FXML
    private Label player2Label;

    @FXML
    private Button diceRollButton;

    @FXML
    private ImageView bluePiece;

    @FXML
    private ImageView greenPiece;

    @FXML
    private GridPane boardGrid;

    @FXML
    protected void setDiceRollButton(){
        System.out.println("hi");
        player1Label.setStyle("-fx-background-color: #00FFFF;");
    }
}
