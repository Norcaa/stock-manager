package controller;

import felvetel.Felvetel;
import felvetel.Termek;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FelvetelController {

    @FXML
    public TextField nev1;
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
        if (termekszam == 1) {
            nev1.setVisible(true);
            db1.setVisible(true);
        } else if (termekszam == 2) {
            nev2.setVisible(true);
            db2.setVisible(true);
        } else if (termekszam == 3) {
            nev3.setVisible(true);
            db3.setVisible(true);
        } else if (termekszam == 4) {
            nev4.setVisible(true);
            db4.setVisible(true);
        } else if (termekszam == 5) {
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

    Termek termek = new Termek();

    @FXML
    public void rendeles_felvetele(ActionEvent actionEvent) throws IOException {

        if (vevo.getText().isEmpty() || ev.getText().isEmpty() || honap.getText().isEmpty() || nap.getText().isEmpty() || !nev1.isVisible() || nev1.getText().isEmpty()) {
            String ErrorMes = "Hiba! Nem adott meg minden értéket!";
            label.setText(ErrorMes);
            System.out.println(ErrorMes);
        } else {
            boolean correct = isCorrectProduct();
            if (!correct) {
                label.setText("Hiba!\n Az alábbi termékek elérhetőek:" + Termek.getAll());
                System.out.println("Hiba! Helytelen formátum!");
            } else {
                System.out.println("Sikeres megadás!");
                int num = setNumber();
                System.out.println(num);

                Felvetel.felvetel(vevo.getText(), num, Integer.parseInt(ev.getText()), Integer.parseInt(honap.getText()), Integer.parseInt(nap.getText()));
                Felvetel.item(nev1.getText(), nev2.getText(), nev3.getText(), nev4.getText(), nev5.getText());

                System.out.println("RENDELÉS FELVÉVE!");
                vissza_akcio(actionEvent);
            }
        }

        //Felvetel.felvetel();

    }

    private int setNumber() {
        int num = 0;
        if (db1.getText().isEmpty()) {
            db1.setText("1");
        }
        num = num + Integer.parseInt(db1.getText());
        if (db2.isVisible()){
            if (db2.getText().isEmpty()){
                db2.setText("1");
            }
            num = num + Integer.parseInt(db2.getText());
        }
        if (db3.isVisible()){
            if (db3.getText().isEmpty()){
                db3.setText("1");
            }
            num = num + Integer.parseInt(db3.getText());
        }
        if (db4.isVisible()){
            if (db4.getText().isEmpty()){
                db4.setText("1");
            }
            num = num + Integer.parseInt(db3.getText());
        }
        if (db5.isVisible()){
            if (db5.getText().isEmpty()){
                db5.setText("1");
            }
            num = num + Integer.parseInt(db3.getText());
        }

        return num;
    }

    private Boolean isCorrectProduct() {
        if (isCorrect(nev1.getText())) { // NÉV 1 HELYES-E
            if (nev2.isVisible()) { // NÉV 2 LÁTHATÓ-E
                if (isCorrect(nev2.getText())) { // NÉV 2 HELYES-E
                    if (nev3.isVisible()) { // NÉV 3 LÁTHATÓ-E
                        if (isCorrect(nev3.getText())) { // NÉV 3 HELYES-E
                            if (nev4.isVisible()){ // NÉV 4 LÁTHATÓ-E
                                if (isCorrect(nev4.getText())) {
                                    if (nev5.isVisible()){ // NÉV 4 LÁTHATÓ-E
                                        if (isCorrect(nev5.getText())) {
                                            return true;
                                        } else { return false; }
                                    } else { return true; }
                                } else { return false; }
                            } else { return true; }
                        } else { return false; }
                    } else { return true; }
                } else { return false; }
            } else { return true; }
        } else { return false; }
    }


    private Boolean isCorrect(String text) {
        return text.equalsIgnoreCase("virágos") || (text.equalsIgnoreCase("autós")) ||
                (text.equalsIgnoreCase("harry potter")) || (text.equalsIgnoreCase("star wars"));
    }

    public void labeltext(MouseEvent mouseEvent) {
        label.setText("");
    }
    
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

    /*
    @FXML
    public void initialize() {
        Termek termek = new Termek();
        ChoiceBox nev1 = new ChoiceBox(FXCollections.observableArrayList(Termek.getAll()));
        //nev1.setItems((ObservableList) Termek.getAll());
    }
    */
}
