/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmvcapp;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
// import com.javalessons.testmvcapp.TileType;

public class GameView extends GridPane {
    
private Image playerImg = new Image(getClass().getResourceAsStream("sprites/player.png"));
private Image wallImg = new Image(getClass().getResourceAsStream("sprites/wall.png"));
private Image goalImg = new Image(getClass().getResourceAsStream("sprites/goal.png"));
private Image emptyImg = new Image(getClass().getResourceAsStream("sprites/empty.png"));

    private final ImageView[][] cells;

    public GameView(int rows, int cols) {

        cells = new ImageView[rows][cols];
        setHgap(2);
        setVgap(2);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ImageView iv = new ImageView(emptyImg);
                iv.setFitWidth(32);
                iv.setFitHeight(32);
                cells[r][c] = iv;
                add(iv, c, r);
            }
        }
    }

    public void updateCell(int row, int col, TileType type) {
        Image img = switch (type) {
            case PLAYER -> playerImg;
            case WALL -> wallImg;
            case GOAL -> goalImg;
            default -> emptyImg;
        };
        cells[row][col].setImage(img);
    }

    public void updateAll(TileType[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                updateCell(r, c, grid[r][c]);
            }
        }
    }
}