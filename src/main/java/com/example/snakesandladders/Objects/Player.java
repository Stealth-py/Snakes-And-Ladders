package com.example.snakesandladders.Objects;

public class Player {
    private int type;            //1 or 2
    private Tile tile;
    private boolean turn;        //true or false

    Player(int type){
        this.type = type;
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

    public int getType(){
        return this.type;
    }
    public Tile getTile(){
        return this.tile;
    }
    public boolean getTurn(){
        return this.turn;
    }
}
