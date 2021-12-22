package com.example.snakesandladders.Objects;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.GameController;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class ObjectController {
    private GameController gameController;
    private gameBoard gameboard;
    private Tile[] boardTiles;

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
        if(!(currPlayer.getHasGottenOut())){
            if(roll==1){
                currPlayer.setHasGottenOut(true);
            }
        }

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(e -> {
            int newPos = getNewPosition(roll);
            Tile newTile = this.boardTiles[newPos-1];
            Tile updatedTile = gameboard.getUpdatedTile(newTile);
            int updatedPos = updatedTile.getTileNumber();
            int[] coords = gameboard.getBoardCoordinates(updatedPos);
            gameController.movePiece(coords[0], coords[1]);

            if(updatedPos==100){
                pauseTransition.stop();
            }else{
                swapTurns();
                gameController.enableDiceRollButton();
            }
        });
        pauseTransition.play();
    }

    public int getNewPosition(int roll){
        Player currPlayer = gameboard.currentPlayer();
        Tile currTile = currPlayer.getTile();
        if(currTile==null){
            currPlayer.setTile(boardTiles[roll-1]);
            return roll;
        }
        int currTileNo = currTile.getTileNumber();
        int finalTileNo = currTileNo + roll;
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
