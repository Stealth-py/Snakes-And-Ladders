package com.example.snakesandladders;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.Objects.ObjectController;
import com.example.snakesandladders.Objects.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {
    @FXML
    private Label player1Label;

    @FXML
    private Label player2Label;

    @FXML
    private Button diceRollButton;

    @FXML
    private Button bluePiece;

    @FXML
    private Button greenPiece;

    @FXML
    private GridPane boardGrid;

    private gameBoard gameboard;
    private ObjectController objectController;

    public GameController(){
        initializeGameBoard();
    }

    private void initializeGameBoard(){
        gameboard = new gameBoard();
        objectController = new ObjectController(gameboard);
    }

    @FXML
    protected void setDiceRollButton(){
        objectController.moveAfterDiceRoll();
        Player currPlayer = gameboard.currentPlayer();
    }
}
