/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmvcapp.model;

public class GameModel {
    private final int rows;
    private final int cols;
    private final TileType[][] grid;

    public GameModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new TileType[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = TileType.EMPTY;

        grid[1][1] = TileType.PLAYER;
        grid[0][0] = TileType.GOAL;
    }

    public TileType getTile(int row, int col) {
        return grid[row][col];
    }

    public void setTile(int row, int col, TileType type) {
        grid[row][col] = type;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
}