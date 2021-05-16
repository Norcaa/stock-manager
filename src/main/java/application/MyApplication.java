package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Az alkalmazás elindításáért felelős osztály.
 */
public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/view.fxml"));
        stage.setTitle("Raktárkezelő");
        stage.getIcons().add(new Image(String.valueOf(MyApplication.class.getResource("/pictures/icon.png"))));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
