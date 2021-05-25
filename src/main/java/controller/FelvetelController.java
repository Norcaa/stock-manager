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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.tinylog.Logger;
import raktar.Raktar;
import raktar.RaktarRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

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
    @FXML public Pane errormespane;

    private int termekszam = 0;

    private final Termek termek = new Termek();
    private final Felvetel fevetel = new Felvetel();

    @FXML
    public void termek_hozzaadasa(javafx.event.ActionEvent actionEvent) throws IOException {
        boolean stock = isStock();
        if (stock) {
            if (termekszam == 0) {
                nev1.setVisible(true);
                db1.setVisible(true);
                termekszam++;
            } else if (termekszam == 1) {
                nev2.setVisible(true);
                db2.setVisible(true);
                termekszam++;
            } else if (termekszam == 2) {
                nev3.setVisible(true);
                db3.setVisible(true);
                termekszam++;
            } else if (termekszam == 3) {
                nev4.setVisible(true);
                db4.setVisible(true);
                termekszam++;
            } else return;
            Logger.info("Termék ablak hozzáadva");
        }
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
        } else return;
        Logger.info("Termék ablak törölve");
    }

    @FXML
    public void rendeles_felvetele(ActionEvent actionEvent) {
        try {
            boolean correct = isCorrectProduct();
            boolean validdate = isValidDate();
            boolean correctnum = isCorrectNum();
            if (!correct) {
                label.setText("Hiba! \nAz alábbi termékek elérhetőek:\n"
                        + Termek.getAll().get(0) + "\n" + Termek.getAll().get(1)+ "\n"
                        + Termek.getAll().get(2) + "\n" + Termek.getAll().get(3));
                errorback.setVisible(true);
                errormespane.setDisable(false);
                Logger.error("Hiba! Helytelen formátum!");
            } else if (!validdate) {
                seterrortext("Érvénytelen dátum!");
            } else if (!correctnum) {
                seterrortext("Érvénytelen darabszám!");
            } else {
                Logger.info("Sikeres megadás");
                boolean correctFelvetel = felvetel();
                if (correctFelvetel) {
                    Logger.info("RENDELÉS FELVÉVE");
                    vissza_akcio(actionEvent);
                }
            }
        }  catch (Exception e) {
            String ErrorMes = "Hiba! Érvénytelen értéket adott meg!";
            seterrortext(ErrorMes);
            Logger.error(ErrorMes);
        }
    }

    @FXML
    private boolean felvetel() throws IOException {
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
        boolean possible = check();
        if (!possible) {
            seterrortext("Hiba!\nNincs elég kellék a megadott mennyiséghez!");
            Felvetel.setNull();
            return false;
        } else {
            return true;
        }
    }

    private static boolean check() {
        Logger.info("Raktárkészlet ellenőrzése");

        new RaktarRepository();
        List<Raktar> raktar = RaktarRepository.getAll();
        List<Integer> kellekek = Felvetel.getAll();

        for (int i = 0; i < kellekek.size(); i++) {
            if (raktar.get(i).getAvailable() < kellekek.get(i)) {
                Logger.info("A felhasználni kívánt mennyiség: " + kellekek.get(i));
                Logger.info("A raktárban levő mennyiség: " + raktar.get(i).getAvailable());
                return false;
            }
        }
        return true;
    }

    private boolean isStock() {
        Logger.info("Raktárkészlet ellenőrzése");
        new RaktarRepository();
        for (int i = 0; i < RaktarRepository.getAll().size(); i++){
            if (RaktarRepository.getAll().get(i).getAvailable() == 0) {
                seterrortext("Hiba! Túl kevés elérhető kellék!");
                return false;
            } else if (RaktarRepository.getAll().get(i).getAvailable() == 1) {
                label.setText("Az alábbi termékből már csak 1 db maradt:\n" + RaktarRepository.getAll().get(i).getName());
                errorback.setVisible(true);
                errormespane.setDisable(false);
                Logger.warn("Figyelem! Alacsony kellékszám!");
            }
        } return true;
    }

    private boolean isValidDate() {
        Logger.info("Dátum ellenőrzése");
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

    private boolean isCorrectNum() {
        Logger.info("Darabszám ellenőrzése");
        if (calculate() > 100) {
            return false;
        } else return correctNumber(Integer.parseInt(db1.getText())) && correctNumber(Integer.parseInt(db3.getText()))
                && correctNumber(Integer.parseInt(db2.getText())) && correctNumber(Integer.parseInt(db4.getText()));
    }

    private int calculate() {
        return setNumber(db1) + setNumber(db2) + setNumber(db3) + setNumber(db4);
    }

    private int setNumber(TextField num) {
        Logger.info("Darabszám beállítva");
        if (num.isVisible()){
            if (num.getText().isEmpty()) {
                num.setText("1");
                return 1;
            } else { return Integer.parseInt(num.getText()); }
        }
        num.setText("0");
        return 0;
    }

    private boolean correctNumber(int num) {
        return (num <= 100);
    }

    private Boolean isCorrectProduct() {
        Logger.info("Termékek ellenőrzése");
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

    public void seterrortext(String errormes) {
        errorback.setVisible(true);
        errormespane.setDisable(false);
        label.setText(errormes);
        Logger.error(errormes);
    }

    public void errortext(MouseEvent mouseEvent) {
        errorback.setVisible(false);
        errormespane.setDisable(true);
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
