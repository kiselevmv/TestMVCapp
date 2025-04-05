// src/MainApp.java

package testmvcapp;

// import controller.GameController;
// import com.javalessons.testmvcapp.GameController;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
// import model.GameModel;
// import model.TileType;
// import view.GameView;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("sprites/player.png");
        System.out.println("URL = " + url);
        GameModel model = new GameModel(5, 5);
        GameView view = new GameView(5, 5);
        new GameController(model, view);
        Scene scene = new Scene(view);
        view.requestFocus();

        primaryStage.setTitle("MVC Grid Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}