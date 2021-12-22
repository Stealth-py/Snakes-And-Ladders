package com.example.snakesandladders;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.Objects.ObjectController;
import com.example.snakesandladders.Objects.Player;
import com.example.snakesandladders.NewGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    @FXML
    private static Label player1Label;

    @FXML
    private static Label player2Label;

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
    }

    public void changeDiceImage(int roll){
        if(roll==1){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice1.png")));
        }else if(roll==2){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice2.png")));
        }else if(roll==3){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice3.png")));
        }else if(roll==4){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice4.png")));
        }else if(roll==5){
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice5.png")));
        }else{
            diceImage.setImage(new Image(getClass().getResourceAsStream("dice/Dice6.png")));
        }
    }

    public void disableDiceRollButton(){
        diceRollButton.setDisable(true);
    }

    public void enableDiceRollButton(){
        diceRollButton.setDisable(false);
    }

    public static void startNewGame() throws IOException {
        Stage curr = (Stage)player1Label.getScene().getWindow();
        curr.close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GameController.class.getResource("gameboard.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Snakes and Ladders");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public ImageView getCurrentPiece(){
        Player currPlayer = gameboard.currentPlayer();
        if(currPlayer.getType()==1){
            return bluePiece;
        }
        return greenPiece;
    }

    public void movePiece(int c, int r){
        ImageView currPiece = getCurrentPiece();
        GridPane.setHalignment(currPiece, HPos.CENTER);
        try{
            boardGrid.getChildren().remove(currPiece);
        }finally {
            System.out.println("hmm");
        }
        boardGrid.add(currPiece, c, r);
    }

    public void newGameScreen() throws IOException {
        Stage newGame = new Stage();
        Player winner = gameboard.currentPlayer();
        Player lost = gameboard.otherPlayer();

        NewGame.setPlayers(winner, lost);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("New.fxml"));
        Parent root = fxmlLoader.load();

        Scene newGameScene = new Scene(root);

        newGame.setTitle("Game Over!");
        newGame.setScene(newGameScene);
        newGame.show();
        newGame.setAlwaysOnTop(true);
    }
}
