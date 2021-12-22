package com.example.snakesandladders;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.Objects.ObjectController;
import com.example.snakesandladders.Objects.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

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
    private ImageView diceImage;

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
        System.out.println(currPlayer.getType());
    }

    public void disableDiceRollButton(){
        diceRollButton.setDisable(true);
    }

    public void enableDiceRollButton(){
        diceRollButton.setDisable(false);
    }

    public ImageView getCurrentButton(){
        Player currPlayer = gameboard.currentPlayer();
        if(currPlayer.getType()==1){
            return bluePiece;
        }
        return greenPiece;
    }

    public void movePiece(int r, int c){
        ImageView currButton = getCurrentButton();
        currButton.setVisible(false);
    }
}
