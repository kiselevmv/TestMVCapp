package testmvcapp.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package controller;


// import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import testmvcapp.view.GameView;
import testmvcapp.model.GameModel;
import testmvcapp.model.TileType;

public class GameController {
    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        view.setOnKeyPressed(this::handleKeyPress);
        view.setFocusTraversable(true);
        updateView();
    }

    private void handleKeyPress(KeyEvent event) {
        System.out.println("Key pressed");
    // private void handleKeyPress(Scene scene) {
        // Простая логика: движение игрока на одну клетку
        int r = -1, c = -1;

        for (int row = 0; row < model.getRows(); row++)
            for (int col = 0; col < model.getCols(); col++)
                if (model.getTile(row, col) == TileType.PLAYER) {
                    r = row;
                    c = col;
                }

        if (r == -1) return;

        int newR = r, newC = c;
        
        if (event.getCode() == KeyCode.UP) newR--;
        if (event.getCode() == KeyCode.DOWN) newR++;
        if (event.getCode() == KeyCode.LEFT) newC--;
        if (event.getCode() == KeyCode.RIGHT) newC++;;
        /*
        KeyCode key = event.getCode();
        if (key == KeyCode.UP) newR--;
        if (key == KeyCode.DOWN) newR++;
        if (key == KeyCode.LEFT) newC--;
        if (key == KeyCode.RIGHT) newC++;*/

        if (isInBounds(newR, newC) && model.getTile(newR, newC) == TileType.EMPTY) {
            model.setTile(r, c, TileType.EMPTY);
            model.setTile(newR, newC, TileType.PLAYER);
            updateView();
        }
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < model.getRows() && col >= 0 && col < model.getCols();
    }

    private void updateView() {
        view.updateAll(getModelGrid());
    }

    private TileType[][] getModelGrid() {
        TileType[][] grid = new TileType[model.getRows()][model.getCols()];
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                grid[r][c] = model.getTile(r, c);
        return grid;
    }
}