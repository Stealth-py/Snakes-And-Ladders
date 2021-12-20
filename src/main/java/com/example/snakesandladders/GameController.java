package com.example.snakesandladders.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label playerTurnLabel;

    @FXML
    private Label diceRolledLabel;

    @FXML
    private Button diceRollButton;

    @FXML
    protected void setDiceRollButton() {
        diceRollButton.setText("Roll dice for Player 1");
        playerTurnLabel.setText("Current Turn: Player 1");
    }
}
