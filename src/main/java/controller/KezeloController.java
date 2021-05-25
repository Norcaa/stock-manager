package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;
import java.io.IOException;


public class KezeloController {

    @FXML
    private javafx.scene.control.Button kilepes;

    @FXML
    public void felvetel_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        Logger.trace("TERMÉK FELVÉTELE");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/felvetel.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<FelvetelController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void keszlet_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        Logger.trace("RAKTÁR BETÖLTÉSE");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/raktar.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<RaktarController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void kilepes_akcio(javafx.event.ActionEvent actionEvent) {
        Logger.trace("PROGRAM BEZÁRÁSA");
        Stage stage = (Stage) kilepes.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
    }

}
