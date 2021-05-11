package controller;

import felvetel.Felvetel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FelvetelController {

    @FXML
    public Button hozzaadas;
    public TextField vevo;
    public TextField ev;
    public TextField honap;
    public TextField nap;
    public TextField termekekszama;

    @FXML
    public void felvetel(javafx.event.ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/felvetel.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<FelvetelController>getController();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
    }

    @FXML
    public void hozzaadas(javafx.event.ActionEvent actionEvent){
        hozzaadas.setDisable(false);
    }

    public TextField termeknev;
    public TextField darabszam;

    public void termek_hozzaadasa(javafx.event.ActionEvent actionEvent) throws IOException {
        String termek = vevo.getText();

        for (int i = 1; i < Integer.parseInt(termekekszama.getText()); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/termek.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<FelvetelController>getController();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    public void vissza_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("VISSZA");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<KezeloController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
