package controller;

import felvetel.Felvetel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.tinylog.Logger;
import raktar.Raktar;
import raktar.RaktarRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaktarController {

    @FXML public Label viragos;
    @FXML public Label autos;
    @FXML public Label harrypotter;
    @FXML public Label starwars;
    @FXML public Label spiral;
    @FXML public Label page;
    @FXML public Label kicsi;
    @FXML public Label nagy;
    @FXML public Label doboz;
    @FXML public Label csomagolo;
    @FXML public Label matrica;
    @FXML public Label koszon;
    @FXML public Label nevjegy;
    @FXML public Label viragosmenny;
    @FXML public Label autosmenny;
    @FXML public Label harrymenny;
    @FXML public Label stmenny;
    @FXML public Label spiralmenny;
    @FXML public Label pagemenny;
    @FXML public Label kicsimenny;
    @FXML public Label nagymenny;
    @FXML public Label dobozmenny;
    @FXML public Label csommenny;
    @FXML public Label matricamenny;
    @FXML public Label koszonmenny;
    @FXML public Label nevjegymenny;
    @FXML public Label date1;
    @FXML public Label date2;
    @FXML public Label date3;
    @FXML public Label date4;
    @FXML public Label date5;
    @FXML public Label date6;
    @FXML public Label date7;
    @FXML public Label date8;
    @FXML public Label date9;
    @FXML public Label date10;
    @FXML public Label date11;
    @FXML public Label date12;
    @FXML public Label date13;

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

    @FXML
    public void initialize() {
        new RaktarRepository();
        List<Raktar> raktar = RaktarRepository.getAll();
        new Felvetel();
        List<Integer> kellekek = Felvetel.getAll();

        Logger.info("A levonandó értékek: " + kellekek);

        viragos.setText(raktar.get(0).getName());
        autos.setText(raktar.get(1).getName());
        harrypotter.setText(raktar.get(2).getName());
        starwars.setText(raktar.get(3).getName());
        spiral.setText(raktar.get(4).getName());
        page.setText(raktar.get(5).getName());
        kicsi.setText(raktar.get(6).getName());
        nagy.setText(raktar.get(7).getName());
        doboz.setText(raktar.get(8).getName());
        csomagolo.setText(raktar.get(9).getName());
        matrica.setText(raktar.get(10).getName());
        koszon.setText(raktar.get(11).getName());
        nevjegy.setText(raktar.get(12).getName());

        viragosmenny.setText(String.valueOf(raktar.get(0).getAvailable() - kellekek.get(0)));
        autosmenny.setText(String.valueOf(raktar.get(1).getAvailable() - kellekek.get(1)));
        harrymenny.setText(String.valueOf(raktar.get(2).getAvailable() - kellekek.get(2)));
        stmenny.setText(String.valueOf(raktar.get(3).getAvailable() - kellekek.get(3)));
        spiralmenny.setText(String.valueOf(raktar.get(4).getAvailable() - kellekek.get(4)));
        pagemenny.setText(String.valueOf(raktar.get(5).getAvailable() - kellekek.get(5)));
        kicsimenny.setText(String.valueOf(raktar.get(6).getAvailable() - kellekek.get(6)));
        nagymenny.setText(String.valueOf(raktar.get(7).getAvailable() - kellekek.get(7)));
        dobozmenny.setText(String.valueOf(raktar.get(8).getAvailable() - kellekek.get(8)));
        csommenny.setText(String.valueOf(raktar.get(9).getAvailable() - kellekek.get(9)));
        matricamenny.setText(String.valueOf(raktar.get(10).getAvailable() - kellekek.get(10)));
        koszonmenny.setText(String.valueOf(raktar.get(11).getAvailable() - kellekek.get(11)));
        nevjegymenny.setText(String.valueOf(raktar.get(12).getAvailable() - kellekek.get(12)));

        for (int i = 0; i < raktar.size(); i++) {
            if (kellekek.get(i) != 0) {
                Map <String, String> newdate = new HashMap<String, String>();
                newdate.put("year", Felvetel.getDate().get(0));
                newdate.put("month", Felvetel.getDate().get(1));
                newdate.put("day", Felvetel.getDate().get(2));
                raktar.get(i).setLastuse(newdate);
            }
        }

        date1.setText(raktar.get(0).getLastuse().get("year") + " - " + raktar.get(0).getLastuse().get("month")
                + " - " + raktar.get(0).getLastuse().get("day"));
        date2.setText(raktar.get(1).getLastuse().get("year") + " - " + raktar.get(1).getLastuse().get("month")
                + " - " + raktar.get(1).getLastuse().get("day"));
        date3.setText(raktar.get(2).getLastuse().get("year") + " - " + raktar.get(2).getLastuse().get("month")
                + " - " + raktar.get(2).getLastuse().get("day"));
        date4.setText(raktar.get(3).getLastuse().get("year") + " - " + raktar.get(3).getLastuse().get("month")
                + " - " + raktar.get(3).getLastuse().get("day"));
        date5.setText(raktar.get(4).getLastuse().get("year") + " - " + raktar.get(4).getLastuse().get("month")
                + " - " + raktar.get(4).getLastuse().get("day"));
        date6.setText(raktar.get(5).getLastuse().get("year") + " - " + raktar.get(5).getLastuse().get("month")
                + " - " + raktar.get(5).getLastuse().get("day"));
        date7.setText(raktar.get(6).getLastuse().get("year") + " - " + raktar.get(6).getLastuse().get("month")
                + " - " + raktar.get(6).getLastuse().get("day"));
        date8.setText(raktar.get(7).getLastuse().get("year") + " - " + raktar.get(7).getLastuse().get("month")
                + " - " + raktar.get(7).getLastuse().get("day"));
        date9.setText(raktar.get(8).getLastuse().get("year") + " - " + raktar.get(8).getLastuse().get("month")
                + " - " + raktar.get(8).getLastuse().get("day"));
        date10.setText(raktar.get(9).getLastuse().get("year") + " - " + raktar.get(9).getLastuse().get("month")
                + " - " + raktar.get(9).getLastuse().get("day"));
        date11.setText(raktar.get(10).getLastuse().get("year") + " - " + raktar.get(10).getLastuse().get("month")
                + " - " + raktar.get(10).getLastuse().get("day"));
        date12.setText(raktar.get(11).getLastuse().get("year") + " - " + raktar.get(11).getLastuse().get("month")
                + " - " + raktar.get(11).getLastuse().get("day"));
        date13.setText(raktar.get(12).getLastuse().get("year") + " - " + raktar.get(12).getLastuse().get("month")
                + " - " + raktar.get(12).getLastuse().get("day"));



        Logger.info("Adatbázis betöltve");
    }


}
