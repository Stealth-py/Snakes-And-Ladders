package com.example.snakesandladders.Objects;

public class Tile {
    private int tileType;            //0 for normal tile; 1 for ladder's foot; 2 for snake's head
    private int tileNumber;

    public Tile(int tileType, int tileNumber){
        this.tileType = tileType;
        this.tileNumber = tileNumber;
    }

    public void setTileType(int tileType){
        this.tileType = tileType;
    }
    public void setTileNumber(int newtileNumber){
        this.tileNumber = newtileNumber;
    }

    public int getTileType(){
        return this.tileType;
    }
    public int getTileNumber(){
        return this.tileNumber;
    }
}
