package com.example.snakesandladders.Objects;

import com.example.snakesandladders.Board.gameBoard;
import com.example.snakesandladders.GameController;

public class ObjectController {
    private GameController gameController;
    private gameBoard gameboard;

    public ObjectController(GameController gameController, gameBoard gameboard){
        this.gameboard = gameboard;
        this.gameController = gameController;
    }

    public void moveAfterDiceRoll(){
        int roll = gameboard.diceRoll();
        gameController.changeDiceImage(roll);
        gameController.disableDiceRollButton();

        int newPos = getNewPosition(roll);
        int[] coords = gameboard.getBoardCoordinates(newPos);
        gameController.movePiece(coords[0], coords[1]);

        swapTurns();
        gameController.enableDiceRollButton();
    }

    public int getNewPosition(int roll){
        Player currPlayer = gameboard.currentPlayer();
        Tile[] boardTiles = gameboard.getBoardTiles();
        Tile currTile = currPlayer.getTile();
        if(currTile==null){
            currPlayer.setTile(boardTiles[roll-1]);
            return roll;
        }
        int currTileNo = currTile.getTileNumber();
        int finalTileNo = currTileNo + roll;
        currPlayer.setTile(boardTiles[finalTileNo-1]);
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
