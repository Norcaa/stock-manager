package felvetel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import raktar.Raktar;
import raktar.RaktarRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Felvetel {

    public static int viragos;
    public static int autos;
    public static int harry;
    public static int starwars;
    public static int spiral;
    public static int page;
    public static int kicsi;
    public static int nagy;
    public static int doboz;
    public static int csomagolo;
    public static int matrica;
    public static int koszono;
    public static int nevjegy;

    public Felvetel() {
        new RaktarRepository();
        List<Raktar> raktar = RaktarRepository.getAll();

        System.out.println("hahah");
        /*
        viragos = raktar.get(0).getAvailable();
        autos = raktar.get(1).getAvailable();
        harry = raktar.get(2).getAvailable();
        starwars= raktar.get(3).getAvailable();
        spiral = raktar.get(4).getAvailable();
        page = raktar.get(5).getAvailable();
        kicsi= raktar.get(6).getAvailable();
        nagy = raktar.get(7).getAvailable();
        doboz = raktar.get(8).getAvailable();
        csomagolo = raktar.get(9).getAvailable();
        matrica = raktar.get(10).getAvailable();
        koszono = raktar.get(11).getAvailable();
        nevjegy = raktar.get(12).getAvailable();
        */
    }

    public static void hozzaadas(String vevo, int termekszam, int ev, int honap, int nap){
        // vevő:
        String who = vevo;
        // csomagolás:
        Felvetel.pack(termekszam);
        // dátum:
        String stdatum = ev + "-" + honap + "-" + nap;
        LocalDate datum = LocalDate.parse(stdatum, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
    }

    public static void item(String termeknev, int num){
        if (termeknev.equalsIgnoreCase("virágos")){
            viragos = viragos + (1*num);
        } else if (termeknev.equalsIgnoreCase("autós")){
            autos = autos + (1*num);
        } else if (termeknev.equalsIgnoreCase("harry potter")) {
            harry = harry + (1*num);
        } else if (termeknev.equalsIgnoreCase("star wars")){
            starwars = starwars + (1*num);
        }
        System.out.println("Füzet hozzáadva!");
    }

    public static void pack(int num){
        if (num == 1){
            kicsi++;
            System.out.println("Kis boríték hozzáadva!");
        } else if (num == 2){
            nagy++;
            System.out.println("Nagy boríték hozzáadva!");
        } else {
            System.out.println("Doboz hozzáadva!");
            doboz++;
        }
        System.out.println("Csomagolópapír hozzáadva!");
        csomagolo++;
        System.out.println("Matrica hozzáadva!");
        matrica++;
        System.out.println("Köszönőkártya hozzáadva!");
        koszono++;
        System.out.println("Névjegykártya hozzáadva!");
        nevjegy++;
    }
    
    public static List<Integer> getAll(){
        List<Integer> stock = new ArrayList<Integer>(12);

        System.out.println(harry);

        stock.add(viragos);
        stock.add(autos);
        stock.add(harry);
        stock.add(starwars);
        stock.add(spiral);
        stock.add(page);
        stock.add(viragos);
        stock.add(kicsi);
        stock.add(nagy);
        stock.add(doboz);
        stock.add(csomagolo);
        stock.add(matrica);
        stock.add(koszono);
        stock.add(nevjegy);

        return stock;
    }
}
