package controller;

import felvetel.Felvetel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import raktar.Raktar;
import raktar.RaktarRepository;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class KezeloController {

    @FXML
    public void felvetel_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("TERMÉK FELVÉTELE");
        // Felvetel.felvetel();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/felvetel.fxml"));
        Parent root = fxmlLoader.load();

        fxmlLoader.<FelvetelController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void keszlet_akcio(javafx.event.ActionEvent actionEvent) {
        RaktarRepository raktar = new RaktarRepository();
        System.out.println(raktar.getAll());
    }

    @FXML
    private javafx.scene.control.Button kilepes;

    @FXML
    public void kilepes_akcio(javafx.event.ActionEvent actionEvent) {
        System.out.println("KILÉPÉS");
        Stage stage = (Stage) kilepes.getScene().getWindow();
        stage.close();
    }
}
