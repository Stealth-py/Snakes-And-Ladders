package com.example.snakesandladders.Objects;

import com.example.snakesandladders.Board.gameBoard;

public class ObjectController {
    private gameBoard gameboard;

    public ObjectController(gameBoard gameboard){
        this.gameboard = gameboard;
    }

    public void moveAfterDiceRoll(){
        int roll = gameboard.diceRoll();
    }
}
