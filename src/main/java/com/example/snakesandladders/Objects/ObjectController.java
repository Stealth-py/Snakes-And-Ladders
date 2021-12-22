package com.example.snakesandladders.Objects;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.GameController;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.io.IOException;

public class ObjectController {
    private GameController gameController;
    private gameBoard gameboard;
    private Tile[] boardTiles;
    private boolean flag = false;

    public ObjectController(GameController gameController, gameBoard gameboard){
        this.gameboard = gameboard;
        this.gameController = gameController;
        this.boardTiles = this.gameboard.getBoardTiles();
    }

    public void moveAfterDiceRoll(){
        int roll = gameboard.diceRoll();
        gameController.changeDiceImage(roll);
        gameController.disableDiceRollButton();

        Player currPlayer = gameboard.currentPlayer();

        if(!(currPlayer.getWon())){
            if(!(currPlayer.getHasGottenOut())){
                if(roll==1){
                    currPlayer.setHasGottenOut(true);
                    flag = true;
                }else{
                    gameController.enableDiceRollButton();
                    swapTurns();
                }
            }

            if(currPlayer.getHasGottenOut()){
                PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
                pauseTransition.setOnFinished(e -> {
                    int newPos = getNewPosition(roll);
                    Tile newTile = this.boardTiles[newPos-1];
                    Tile updatedTile = gameboard.getUpdatedTile(newTile);
                    currPlayer.setTile(updatedTile);
                    int updatedPos = updatedTile.getTileNumber();
                    int[] coords = gameboard.getBoardCoordinates(updatedPos);
                    gameController.movePiece(coords[0], coords[1]);
                    if(updatedPos==100){
                        currPlayer.setWon(true);
                        try {
                            gameController.newGameScreen();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        pauseTransition.stop();
                    }else{
                        swapTurns();
                        gameController.enableDiceRollButton();
                    }
                });
                pauseTransition.play();
            }
        }
    }

    public int getNewPosition(int roll){
        Player currPlayer = gameboard.currentPlayer();
        if(flag){
            flag = false;
            currPlayer.setTile(boardTiles[0]);
            return 1;
        }
        System.out.println(roll);
        Tile currTile = currPlayer.getTile();
        int currTileNo = currTile.getTileNumber();
        int finalTileNo = currTileNo + roll;
        if(finalTileNo>100){
            return currTileNo;
        }
        currPlayer.setTile(this.boardTiles[finalTileNo-1]);
        return finalTileNo;
    }

    public void swapTurns(){
        Player currPlayer = gameboard.currentPlayer();
        Player p1 = gameboard.getPlayer1();
        Player p2 = gameboard.getPlayer2();

        if(currPlayer==p1){
            p1.setTurn(false);
            p2.setTurn(true);
        }else{
            p1.setTurn(true);
            p2.setTurn(false);
        }
    }
}
