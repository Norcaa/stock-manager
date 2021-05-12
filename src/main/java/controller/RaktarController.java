package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import raktar.Raktar;
import raktar.RaktarRepository;

import java.io.IOException;
import java.util.List;

public class RaktarController {

    public void truth_akcio(ActionEvent actionEvent) {
        System.out.println(";");
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

    @FXML
    public void initialize() {
        new RaktarRepository();
        List<Raktar> raktar = RaktarRepository.getAll();

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

        viragosmenny.setText(String.valueOf(raktar.get(0).getAvailable()));
        autosmenny.setText(String.valueOf(raktar.get(1).getAvailable()));
        harrymenny.setText(String.valueOf(raktar.get(2).getAvailable()));
        stmenny.setText(String.valueOf(raktar.get(3).getAvailable()));
        spiralmenny.setText(String.valueOf(raktar.get(4).getAvailable()));
        pagemenny.setText(String.valueOf(raktar.get(5).getAvailable()));
        kicsimenny.setText(String.valueOf(raktar.get(6).getAvailable()));
        nagymenny.setText(String.valueOf(raktar.get(7).getAvailable()));
        dobozmenny.setText(String.valueOf(raktar.get(8).getAvailable()));
        csommenny.setText(String.valueOf(raktar.get(9).getAvailable()));
        matricamenny.setText(String.valueOf(raktar.get(10).getAvailable()));
        koszonmenny.setText(String.valueOf(raktar.get(11).getAvailable()));
        nevjegymenny.setText(String.valueOf(raktar.get(12).getAvailable()));
    }

}
