package controller;

import felvetel.Felvetel;
import felvetel.Termek;
import felvetel.TermekRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import raktar.RaktarRepository;

import javax.sound.midi.SysexMessage;
import java.io.IOException;

public class FelvetelController {

    @FXML
    public ChoiceBox nev1;
    @FXML
    public TextField nev2;
    @FXML
    public TextField nev3;
    @FXML
    public TextField nev4;
    @FXML
    public TextField nev5;
    @FXML
    public TextField db1;
    @FXML
    public TextField db2;
    @FXML
    public TextField db3;
    @FXML
    public TextField db4;
    @FXML
    public TextField db5;
    private int termekszam = 1;

    public void termek_hozzaadasa(javafx.event.ActionEvent actionEvent) throws IOException {
        if (termekszam == 1){
            nev1.setVisible(true);
            db1.setVisible(true);
        } else if (termekszam == 2){
            nev2.setVisible(true);
            db2.setVisible(true);
        } else if (termekszam == 3){
            nev3.setVisible(true);
            db3.setVisible(true);
        } else if (termekszam == 4){
            nev4.setVisible(true);
            db4.setVisible(true);
         }else if (termekszam == 5){
            nev5.setVisible(true);
            db5.setVisible(true);
        }
        termekszam++;
    }

    // FELVÉTEL GOMB

    @FXML
    public TextField vevo;
    @FXML
    public TextField ev;
    @FXML
    public TextField honap;
    @FXML
    public TextField nap;
    @FXML
    public Label label;
    @FXML
    public void rendeles_felvetele(ActionEvent actionEvent) throws IOException {

        if (vevo.getText().equals("") || ev.getText().equals("") || honap.getText().equals("") || nap.getText().equals("")){
            String ErrorMes = "Hiba! Nem adott meg minden értéket!";
            label.setText(ErrorMes);
            System.out.println(ErrorMes);
            TermekRepository termek = new TermekRepository();
            System.out.println(TermekRepository.getAll());
        }
        else{
            System.out.println("RENDELÉS FELVÉVE!");
            vissza_akcio(actionEvent);
        }

        //Felvetel.felvetel();

    }

    public void labeltext(MouseEvent mouseEvent) {
        label.setText("");
    }

    // VISSZA
    @FXML
    public void vissza_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("Vissza a kezelőfelületre.");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<KezeloController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
