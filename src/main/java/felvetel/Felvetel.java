package felvetel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import org.tinylog.Logger;

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
    }

    public static void hozzaadas(String vevo, int termekszam, int ev, int honap, int nap){
        String who = vevo;
        Logger.info("Vevő hozzáadva");

        Logger.info("Dátum hozzáadva");
        String stdatum = ev + "-" + honap + "-" + nap;
        LocalDate datum = LocalDate.parse(stdatum, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));

        Felvetel.pack(termekszam);
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
        Logger.info("Füzet hozzáadva");
    }

    public static void pack(int num){
        if (num == 1){
            kicsi++;
            Logger.info("Kis boríték hozzáadva");
        } else if (num == 2){
            nagy++;
            Logger.info("Nagy boríték hozzáadva");
        } else {
            doboz++;
            Logger.info("Doboz hozzáadva");
        }
        Logger.info("Csomagolópapír hozzáadva");
        csomagolo++;
        Logger.info("Matrica hozzáadva");
        matrica++;
        Logger.info("Köszönőkártya hozzáadva");
        koszono++;
        Logger.info("Névjegykártya hozzáadva");
        nevjegy++;
    }
    
    public static List<Integer> getAll(){
        List<Integer> stock = new ArrayList<Integer>(12);

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
