package felvetel;

import java.util.ArrayList;
import java.util.List;

/**
 * A jelenleg elérhető termékek meghatározása és tárolása lista formátumban.
 */
public class Termek {

    /**
     * A lista létrehozása az elérhető termékek számával megegyező mérettel.
     */
    public static List<String> products = new ArrayList<String>(4);

    /**
     * A termékek neveinek meghatározása és hozzáadása a listához.
    */
    public Termek() {
        String autos = "Autós füzet";
        products.add(autos);
        String viragos = "Virágos füzet";
        products.add(viragos);
        String harrypotter = "Harry Potter füzet";
        products.add(harrypotter);
        String starwars = "Star Wars füzet";
        products.add(starwars);
    }

    /**
     * A termékek összegyűjtése egy listában.
     * @return lista, amely az elérhető termékek neveit sztringként tárolja.
     */
    public static List<String> getAll() {
        return products;
    }
}
