package felvetel;

import java.util.ArrayList;
import java.util.List;

public class Termek {

    public static List<String> products = new ArrayList<String>(4);

    public Termek(){
        String autos = "Autós füzet";
        products.add(autos);
        String viragos = "Virágos füzet";
        products.add(viragos);
        String harrypotter = "Harry Potter füzet";
        products.add(harrypotter);
        String starwars = "Star Wars füzet";
        products.add(starwars);
    }

    public static List<String> getAll() {
        return products;
    }
}
