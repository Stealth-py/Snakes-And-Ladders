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
        objectController = new ObjectController(this, gameboard);
    }

    @FXML
    protected void setDiceRollButton(){
        objectController.moveAfterDiceRoll();
        Player currPlayer = gameboard.currentPlayer();
        movePiece(0, 9);
    }

    public void changeDiceImage(int roll){
        if(roll==1){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice1.png")));
        }else if(roll==2){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }else if(roll==3){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }else if(roll==4){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }else if(roll==5){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }else{
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }
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

    public void movePiece(int c, int r){
        try{
            boardGrid.getChildren().remove(bluePiece);
        }finally {
            boardGrid.add(bluePiece, c, r);
        }
    }
}
