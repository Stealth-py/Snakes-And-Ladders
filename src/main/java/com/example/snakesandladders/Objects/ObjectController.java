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
    }
}
