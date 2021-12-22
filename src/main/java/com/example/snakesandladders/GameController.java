package com.example.snakesandladders;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.Objects.ObjectController;
import com.example.snakesandladders.Objects.Player;
import com.example.snakesandladders.NewGame;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
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

    @FXML
    private ImageView diceArrow;

    private gameBoard gameboard;
    private ObjectController objectController;

    public GameController(){
        initializeGameBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(diceArrow);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setByY(20);
        translateTransition.setByY(-20);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }

    private void initializeGameBoard(){
        gameboard = new gameBoard();
        objectController = new ObjectController(this, gameboard);
    }

    @FXML
    protected void setDiceRollButton() throws IOException, InterruptedException {
        Player currPlayer = gameboard.currentPlayer();
        if(currPlayer.getType()==1){
            player2Label.setStyle("-fx-border-width: 0");
            player1Label.setStyle("-fx-border-color: linear-gradient(to left, #cc9900 -14%, #ffff99 139%);");
        }else{
            player1Label.setStyle("-fx-border-width: 0");
            player2Label.setStyle("-fx-border-color: linear-gradient(to left, #cc9900 -14%, #ffff99 139%);");
        }
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

    public void startNewGame() throws IOException {
        NewGame newGame;

        Stage curstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GameController.class.getResource("New.fxml"));
        Parent root = fxmlLoader.load();
        newGame = fxmlLoader.<NewGame>getController();
        newGame.setPlayers(gameboard.otherPlayer(), gameboard.currentPlayer());

        curstage.setTitle("Game Over");
        curstage.setScene(new Scene(root));
        curstage.show();
        curstage.setAlwaysOnTop(true);
    }

//    public void helper(){
//        if(NewGame.goAgain){
//            try{
//                boardGrid.getChildren().remove(bluePiece);
//                boardGrid.getChildren().remove(greenPiece);
//            }finally {
//                System.out.println("hi");
//            }
//        }else{
//            System.exit(0);
//        }
//    }

    public ImageView getCurrentPiece(){
        Player currPlayer = gameboard.currentPlayer();
        if(currPlayer.getType()==1){
            return bluePiece;
        }
        return greenPiece;
    }

    public void movePiece(int c, int r) {
        ImageView currPiece = getCurrentPiece();
        GridPane.setHalignment(currPiece, HPos.CENTER);
        try{
            boardGrid.getChildren().remove(currPiece);
        }finally {
            System.out.println("hmm");
        }
        boardGrid.add(currPiece, c, r);
    }
}
