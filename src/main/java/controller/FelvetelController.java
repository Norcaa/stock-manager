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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class FelvetelController {

    @FXML public TextField vevo;
    @FXML public TextField ev;
    @FXML public TextField honap;
    @FXML public TextField nap;
    @FXML public TextField nev1;
    @FXML public TextField nev2;
    @FXML public TextField nev3;
    @FXML public TextField nev4;
    @FXML public TextField db1;
    @FXML public TextField db2;
    @FXML public TextField db3;
    @FXML public TextField db4;
    @FXML public Label label;
    @FXML public Rectangle errorback;

    private int termekszam = 1;

    private final Termek termek = new Termek();
    private final Felvetel fevetel = new Felvetel();

    @FXML
    public void termek_hozzaadasa(javafx.event.ActionEvent actionEvent) throws IOException {
        if (termekszam == 1) {
            nev1.setVisible(true);
            db1.setVisible(true);
            termekszam++;
        } else if (termekszam == 2) {
            nev2.setVisible(true);
            db2.setVisible(true);
            termekszam++;
        } else if (termekszam == 3) {
            nev3.setVisible(true);
            db3.setVisible(true);
            termekszam++;
        } else if (termekszam == 4) {
            nev4.setVisible(true);
            db4.setVisible(true);
        }
        Logger.info("Termék ablak hozzáadva");
    }

    @FXML
    public void termek_torlese(javafx.event.ActionEvent actionEvent) throws IOException {
        if (termekszam == 4) {
            nev4.setVisible(false);
            db4.setVisible(false);
            termekszam--;
        } else if (termekszam == 3) {
            nev3.setVisible(false);
            db3.setVisible(false);
            termekszam--;
        } else if (termekszam == 2) {
            nev2.setVisible(false);
            db2.setVisible(false);
            termekszam--;
        }
        Logger.info("Termék ablak törölve");
    }

    @FXML
    public void rendeles_felvetele(ActionEvent actionEvent) {
        try {
            boolean correct = isCorrectProduct();
            boolean validdate = isValidDate();
            if (!correct) {
                label.setText("Hiba! \nAz alábbi termékek elérhetőek:\n     "
                        + Termek.getAll().get(0) + "\n     " + Termek.getAll().get(1)+ "\n     "
                        + Termek.getAll().get(2) + "\n     " + Termek.getAll().get(3));
                Logger.error("Hiba! Helytelen formátum!");
            } else if (!validdate) {
                String ErrorMes = "Érvénytelen dátum!";
                label.setText(ErrorMes);
                Logger.error(ErrorMes);
            } else {
                Logger.info("Sikeres megadás");
                felvetel();
                Logger.info("RENDELÉS FELVÉVE");
                vissza_akcio(actionEvent);
            }
        }  catch (Exception e) {
            String ErrorMes = "Hiba! Érvénytelen értéket adott meg!";
            errorback.setVisible(true);
            label.setText(ErrorMes);
            Logger.error(ErrorMes);
        }
    }

    private void felvetel() {
        int num = calculate();
        Felvetel.hozzaadas(vevo.getText(), num, Integer.parseInt(ev.getText()),
                Integer.parseInt(honap.getText()), Integer.parseInt(nap.getText()));
        Felvetel.item(nev1.getText(), Integer.parseInt(db1.getText()));
        if (!(nev2.getText().isEmpty())) {
            Felvetel.item(nev2.getText(), Integer.parseInt(db2.getText()));
            if (!(nev3.getText().isEmpty())) {
                Felvetel.item(nev3.getText(), Integer.parseInt(db3.getText()));
                if (!(nev3.getText().isEmpty())) {
                    Felvetel.item(nev3.getText(), Integer.parseInt(db4.getText()));
                }
            }
        }
    }

    private boolean isValidDate() {
        try {
            String stdatum = ev.getText() + "-" + honap.getText() + "-" + nap.getText();
            LocalDate datum = LocalDate.parse(stdatum, DateTimeFormatter
                    .ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
            if (datum.compareTo(LocalDate.now()) <= 0) {
                return true;
            } else { return false; }
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    private int calculate() {
        return setNumber(db1) + setNumber(db2) + setNumber(db3) + setNumber(db4);
    }

    private int setNumber(TextField num) {
        if (num.isVisible()){
            if (num.getText().isEmpty()) {
                num.setText("1");
                return 1;
            } else { return Integer.parseInt(num.getText()); }
        } return 0;
    }

    private Boolean isCorrectProduct() {
        if (isCorrect(nev1.getText())) {
            if (nev2.isVisible()) {
                if (isCorrect(nev2.getText())) {
                    if (nev3.isVisible()) {
                        if (isCorrect(nev3.getText())) {
                            if (nev4.isVisible()) {
                                if (isCorrect(nev4.getText())) {
                                    return true;
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
                (text.equalsIgnoreCase("harry potter")) || (text.equalsIgnoreCase("star wars")) ||
                text.equalsIgnoreCase("virágos füzet") || (text.equalsIgnoreCase("autós füzet")) ||
                (text.equalsIgnoreCase("harry potter füzet")) || (text.equalsIgnoreCase("star wars füzet"));
    }

    public void errortext(MouseEvent mouseEvent) {
        errorback.setVisible(false);
        label.setText("");
    }

    @FXML
    public void vissza_akcio(javafx.event.ActionEvent actionEvent) throws IOException {
        Logger.trace("Vissza a kezelőfelületre");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<KezeloController>getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
