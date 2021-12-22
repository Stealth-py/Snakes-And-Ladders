package com.example.snakesandladders.Board;

import com.example.snakesandladders.Objects.Player;
import com.example.snakesandladders.Objects.Tile;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Random;

public class gameBoard {
    private static final int rows = 10;
    private static final int cols = 10;
    private static final int tiles = 100;
    private static final int winTileNumber = 100;

    private Player player1, player2;
    private HashMap<Integer, Integer> snakesPos;
    private HashMap<Integer, Integer> laddersPos;
    private Tile[] boardTiles;

    public gameBoard(){
        initializeSnakes();
        initializeLadders();
        initializeTiles();
        player1 = new Player(1);
        player1.setTurn(true);
        player2 = new Player(2);
    }

    public Tile[] getBoardTiles(){
        return this.boardTiles;
    }

    public Player getPlayer1(){
        return this.player1;
    }

    public Player getPlayer2(){
        return this.player2;
    }

    private void initializeTiles(){
        boardTiles = new Tile[tiles];
        int j = 0;

        for(int i = 0; i<tiles; i++){
            if(snakesPos.containsKey(i+1)){
                boardTiles[i] = new Tile(2, i+1);
            }else if(laddersPos.containsKey(i+1)){
                boardTiles[i] = new Tile(1, i+1);
            }else{
                boardTiles[i] = new Tile(0, i+1);
            }
        }
    }

    private void initializeSnakes(){
        snakesPos = new HashMap<>();

        snakesPos.put(99, 78);
        snakesPos.put(96, 65);
        snakesPos.put(94, 48);
        snakesPos.put(90, 49);
        snakesPos.put(81, 63);
        snakesPos.put(66, 47);
        snakesPos.put(57, 19);
        snakesPos.put(43, 22);
        snakesPos.put(36, 14);
        snakesPos.put(11, 9);
    }

    private void initializeLadders(){
        laddersPos = new HashMap<>();

        laddersPos.put(4, 26);
        laddersPos.put(8, 51);
        laddersPos.put(28, 46);
        laddersPos.put(39, 60);
        laddersPos.put(44, 80);
        laddersPos.put(52, 68);
        laddersPos.put(64, 85);
        laddersPos.put(69, 93);
        laddersPos.put(71, 92);
        laddersPos.put(84, 98);
    }

    public Tile getUpdatedTile(Tile currTile){
        Tile newTile = currTile;
        int tileType = currTile.getTileType();
        int tileNum = currTile.getTileNumber();

        if(tileType==2){
            newTile = boardTiles[snakesPos.get(tileNum)-1];
        }else if(tileType==1){
            newTile = boardTiles[laddersPos.get(tileNum)-1];
        }
        return newTile;
    }

    public int diceRoll(){
        return new Random().nextInt(6)+1;
    }

    public Player currentPlayer(){
        if(player1.getTurn()){
            return player1;
        }
        return player2;
    }

    public boolean ifWon(){
        Player p = currentPlayer();
        return p.getTile().getTileNumber() == winTileNumber;
    }

    public int[] getBoardCoordinates(int x){
        int[] coords = new int[2];
        int r = x/rows;
        int c = x%10;
        if(r%2==1){
            c = cols-1-x%10;
        }
        coords[0] = c;
        coords[1] = rows-1-r;
        System.out.println(coords[0] +"-"+ coords[1]);
        return coords;
    }
}
