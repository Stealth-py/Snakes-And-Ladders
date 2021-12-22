package com.example.snakesandladders.Objects;

import javafx.scene.control.Button;

public class Player {
    private int type;            //1 or 2
    private Tile tile;
    private boolean turn;        //true or false
    private boolean won;

    public Player(int type){
        this.type = type;
        this.turn = false;
        this.won = false;
    }

    public void setType(int type){
        this.type = type;
    }
    public void setTile(Tile newTile){
        this.tile = newTile;
    }
    public void setTurn(boolean tf){
        this.turn = tf;
    }
    public void setWon(boolean won){
        this.won = won;
    }

    public int getType(){
        return this.type;
    }
    public Tile getTile(){
        return this.tile;
    }
    public boolean getTurn(){
        return this.turn;
    }
    public boolean getWon(){
        return this.won;
    }
}
